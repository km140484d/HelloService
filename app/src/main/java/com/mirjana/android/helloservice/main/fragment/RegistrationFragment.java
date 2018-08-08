package com.mirjana.android.helloservice.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.*;
import android.widget.*;

import com.mirjana.android.helloservice.R;
import com.mirjana.android.helloservice.main.MainActivity;
import com.mirjana.android.helloservice.bean.wrapper.*;
import com.mirjana.android.helloservice.retrofit.*;

import java.math.BigDecimal;

import retrofit2.*;

public class RegistrationFragment extends Fragment {

    private Button mRegisterSubmitButton;
    private EditText mEdNumberText;
    private EditText mMeterNumberText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);

        mEdNumberText = view.findViewById(R.id.editTextEDNumber);
        mMeterNumberText = view.findViewById(R.id.editTextMeterNumber);

        mRegisterSubmitButton = view.findViewById(R.id.buttonSubmitRegistration);
        mRegisterSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(mMeterNumberText.getText().toString().trim()) ||
                        TextUtils.isEmpty(mEdNumberText.getText().toString().trim())) {
                    if (TextUtils.isEmpty(mMeterNumberText.getText().toString().trim()))
                        mEdNumberText.setError("Field must not be empty.");
                    if (TextUtils.isEmpty(mEdNumberText.getText().toString().trim()))
                        mMeterNumberText.setError("Field must not be empty.");
                }else {
                    Call<KupacInfo> kupacInfo = RetrofitClient.getInstance().getApi().registracijaBrojila(
                            mEdNumberText.getText().toString().trim(),
                            new BigDecimal(mMeterNumberText.getText().toString().trim()));
                    kupacInfo.enqueue(new Callback<KupacInfo>() {
                        @Override
                        public void onResponse(Call<KupacInfo> call, Response<KupacInfo> response) {
                            KupacInfo wrapper = response.body();
                            if (wrapper != null) {
                                if (wrapper.getError().equals(Constants.BUYER_WITHOUT_ACCOUNT)) {
                                    Bundle bundle = new Bundle();
                                    bundle.putSerializable(MainActivity.kupacCreateKey, wrapper.getObject());
                                    ((MainActivity) getActivity()).setViewPager(MainActivity.NEW_ACCOUNT_FRAGMENT, bundle);
                                }else {
                                    if (wrapper.getError().equals(Constants.BUYER_INVALID))
                                        Toast.makeText(getContext(), R.string.buyer_invalid_message, Toast.LENGTH_LONG).show();
                                    else {
                                        Toast.makeText(getContext(),
                                                getString(R.string.buyer_has_account, wrapper.getObject().getNaziv()), Toast.LENGTH_LONG).show();
                                    }
                                }
                            }else
                                Toast.makeText(getContext(), "NULL REGISTRATION", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<KupacInfo> call, Throwable t) {
                            Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
        return view;
    }
}

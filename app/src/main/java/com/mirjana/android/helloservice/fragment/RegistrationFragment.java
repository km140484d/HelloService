package com.mirjana.android.helloservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.*;

import com.mirjana.android.helloservice.R;
import com.mirjana.android.helloservice.bean.*;
import com.mirjana.android.helloservice.retrofit.RetrofitClient;

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
                Call<Kupac> kupac = RetrofitClient.getInstance().getApi().registracijaBrojila(
                        mEdNumberText.getText().toString().trim(),
                        new BigDecimal(mMeterNumberText.getText().toString().trim()));
                kupac.enqueue(new Callback<Kupac>() {
                    @Override
                    public void onResponse(Call<Kupac> call, Response<Kupac> response) {

                    }

                    @Override
                    public void onFailure(Call<Kupac> call, Throwable t) {

                    }
                });

            }
        });
        return view;
    }
}

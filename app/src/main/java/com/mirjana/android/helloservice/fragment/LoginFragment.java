package com.mirjana.android.helloservice.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.*;

import com.mirjana.android.helloservice.*;
import com.mirjana.android.helloservice.activity.*;
import com.mirjana.android.helloservice.bean.wrapper.KorisnikInfo;
import com.mirjana.android.helloservice.retrofit.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {
    private EditText mLoginEdit;
    private EditText mPasswordEdit;
    private Button mLoginButton;
    private Button mRegisterButton;

    private String username;
    private String password;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        mLoginEdit = view.findViewById(R.id.editTextLogin);
        mPasswordEdit = view.findViewById(R.id.editTextPassword);
        mLoginButton = view.findViewById(R.id.buttonLoginAction);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call<KorisnikInfo> user = RetrofitClient.getInstance().getApi().
                        findUser(mLoginEdit.getText().toString().trim(), mPasswordEdit.getText().toString().trim());
                user.enqueue(new Callback<KorisnikInfo>() {
                    @Override
                    public void onResponse(Call<KorisnikInfo> call, Response<KorisnikInfo> response) {
                        KorisnikInfo wrapper = response.body();
                        if (wrapper != null) {
                            if (wrapper.getError().equals(Constants.USER_AUTHENTICATED)) {
                                Intent intent = new Intent(getActivity(), InfoActivity.class);
                                intent.putExtra(MainActivity.kupacInfoKey, wrapper.getObject().getKupac());
                                startActivity(intent);
                            }else{
                                if (wrapper.getError().equals(Constants.USER_PASSWORD_DOES_NOT_MATCH))
                                    Toast.makeText(getActivity().getBaseContext(), R.string.wrong_password_message, Toast.LENGTH_LONG).show();
                                else
                                    Toast.makeText(getActivity().getBaseContext(),
                                            getString(R.string.invalid_user_message, mLoginEdit.getText().toString()), Toast.LENGTH_LONG).show();                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<KorisnikInfo> call, Throwable t) {
                        Toast.makeText(getActivity().getBaseContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        mRegisterButton = view.findViewById(R.id.buttonRegisterAction);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).setViewPager(MainActivity.REGISTER_FRAGMENT, null);
            }
        });
        return view;
    }

}

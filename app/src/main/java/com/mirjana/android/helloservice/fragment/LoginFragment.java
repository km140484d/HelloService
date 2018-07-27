package com.mirjana.android.helloservice.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.*;

import com.mirjana.android.helloservice.*;
import com.mirjana.android.helloservice.activity.*;
import com.mirjana.android.helloservice.bean.*;
import com.mirjana.android.helloservice.retrofit.RetrofitClient;

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

                Call<Korisnik> user = RetrofitClient.getInstance().getApi().
                        login(mLoginEdit.getText().toString(), mPasswordEdit.getText().toString());
                user.enqueue(new Callback<Korisnik>() {
                    @Override
                    public void onResponse(Call<Korisnik> call, Response<Korisnik> response) {
                        Korisnik korisnik = response.body();
                        if (korisnik != null) {
                            Intent intent = new Intent(getActivity(), InfoActivity.class);
                            intent.putExtra(MainActivity.kupacKey, korisnik.getKupac());
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<Korisnik> call, Throwable t) {
                        Toast.makeText(getActivity().getBaseContext(), "Pogresan unos", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        mRegisterButton = view.findViewById(R.id.buttonRegisterAction);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).setViewPager(MainActivity.REGISTER_FRAGMENT);
            }
        });
        return view;
    }

}

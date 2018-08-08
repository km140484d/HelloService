package com.mirjana.android.helloservice.main.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.*;
import android.widget.*;

import com.mirjana.android.helloservice.R;
import com.mirjana.android.helloservice.bean.*;
import com.mirjana.android.helloservice.bean.wrapper.*;
import com.mirjana.android.helloservice.main.MainActivity;
import com.mirjana.android.helloservice.retrofit.*;

import retrofit2.*;

public class NewAccountFragment extends Fragment {

    private EditText loginEdit;
    private EditText passEdit;
    private Button createButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_new_account, container, false);
        loginEdit = view.findViewById(R.id.editTextNewAccountLogin);
        passEdit = view.findViewById(R.id.editTextNewAccountPassword);
        createButton = view.findViewById(R.id.buttonSubmitNewAccount);

        createButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                boolean leave = false;
                if (TextUtils.isEmpty(loginEdit.getText().toString().trim())) {
                    loginEdit.setError("Field must not be empty.");
                    leave = true;
                }
                if (TextUtils.isEmpty(passEdit.getText().toString().trim())) {
                    passEdit.setError("Field must not be empty.");
                    leave = true;
                }
                if (leave) return;
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getActivity());
                alertBuilder.setMessage(getString(R.string.create_account_message, loginEdit.getText(), passEdit.getText())).
                    setPositiveButton(R.string.accept, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Call<KorisnikInfo> korisnikInfo = RetrofitClient.getInstance().getApi().findUser(loginEdit.getText().toString().trim(),
                                    passEdit.getText().toString().trim());
                            korisnikInfo.enqueue(new Callback<KorisnikInfo>() {
                                @Override
                                public void onResponse(Call<KorisnikInfo> call, Response<KorisnikInfo> response) {
                                    KorisnikInfo wrapper = response.body();
                                    if (wrapper != null){
                                        if (wrapper.getError().equals(Constants.USER_AUTHENTICATED) ||
                                                wrapper.getError().equals(Constants.USER_PASSWORD_DOES_NOT_MATCH))
                                            Toast.makeText(getContext(),
                                                    getString(R.string.account_exists, loginEdit.getText().toString().trim()), Toast.LENGTH_LONG).show();
                                        else{
                                            Call<Korisnik> user = RetrofitClient.getInstance().getApi().registracijaKorisnika(
                                                    new Korisnik(loginEdit.getText().toString().trim(),
                                                            passEdit.getText().toString().trim(),
                                                            (Kupac)getArguments().getSerializable(MainActivity.kupacCreateKey)));
                                            //Toast.makeText(getContext(), "" + ((Kupac) getArguments().getSerializable(MainActivity.kupacCreateKey)).getIdKupca(), Toast.LENGTH_LONG).show();
                                            user.enqueue(new Callback<Korisnik>() {
                                                @Override
                                                public void onResponse(Call<Korisnik> call, Response<Korisnik> response) {
                                                    Korisnik korisnik = response.body();
                                                    if (korisnik != null)
                                                        ((MainActivity)getActivity()).setViewPager(MainActivity.LOGIN_FRAGMENT, null);
                                                    else
                                                        Toast.makeText(getContext(), "Error!", Toast.LENGTH_LONG).show();
                                                }

                                                @Override
                                                public void onFailure(Call<Korisnik> call, Throwable t) {
                                                    Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                                                }
                                            });
                                            //setArguments(null);

                                        }
                                    }
                                }

                                @Override
                                public void onFailure(Call<KorisnikInfo> call, Throwable t) {
                                    Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                alertBuilder.create().show();
            }
        });
        return view;
    }
}

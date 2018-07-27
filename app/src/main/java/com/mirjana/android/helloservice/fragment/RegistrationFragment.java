package com.mirjana.android.helloservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.*;

import com.mirjana.android.helloservice.R;

public class RegistrationFragment extends Fragment {

    private Button mRegisterSubmitButton;
    private EditText mEdNumberText;
    private EditText mMeterNumberText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        mRegisterSubmitButton = view.findViewById(R.id.buttonSubmitRegistration);
        mEdNumberText = view.findViewById(R.id.editTextEDNumber);
        mMeterNumberText = view.findViewById(R.id.editTextMeterNumber);
        return view;
    }
}

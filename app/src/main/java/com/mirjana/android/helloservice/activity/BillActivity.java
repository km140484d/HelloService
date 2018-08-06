package com.mirjana.android.helloservice.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;

import com.mirjana.android.helloservice.R;
import com.mirjana.android.helloservice.bean.Potrosac;

public class BillActivity extends AppCompatActivity {

    private Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);
        mButton = findViewById(R.id.buttonBill);
        mButton.setText(((Potrosac)getIntent().
                getSerializableExtra(ConsumersActivity.potrosacGetBills)).getEdBroj());
    }
}

package com.mirjana.android.helloservice.activity.bill;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mirjana.android.helloservice.R;
import com.mirjana.android.helloservice.activity.bill.fragment.*;
import com.mirjana.android.helloservice.bean.*;
import com.mirjana.android.helloservice.fragment.MainStatePagerAdapter;

import java.util.*;

public class BillActivity extends AppCompatActivity {

    private TextView mTextBillHeading;
    private TextView mTextBillAmount;

    private ViewPager mPager;
    private MainStatePagerAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_info);

        Racun racun = (Racun)getIntent().getSerializableExtra(BillListActivity.racunInfoKey);

        mTextBillHeading = findViewById(R.id.textViewBillHeading);
            mTextBillHeading.setText(racun.getIdOp().getMesec() + ", " + racun.getIdOp().getGodina());
        mTextBillAmount = findViewById(R.id.textViewBillHeadingAmount);
            mTextBillAmount.setText(racun.getUkupanIznos() + "");

        mPager = findViewById(R.id.viewPagerBillFragments);
        mAdapter = new MainStatePagerAdapter(getSupportFragmentManager());
        mAdapter.addFragment(new BillInfoFragment());
        mPager.setAdapter(mAdapter);
    }
}

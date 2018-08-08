package com.mirjana.android.helloservice.bill;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mirjana.android.helloservice.R;
import com.mirjana.android.helloservice.bill.fragment.*;
import com.mirjana.android.helloservice.bean.*;
import com.mirjana.android.helloservice.main.fragment.MainStatePagerAdapter;

import java.text.SimpleDateFormat;

public class BillActivity extends AppCompatActivity {

    private TextView mTextBillHeading;
    private TextView mTextBillPeriod;

    private ViewPager mPager;
    private MainStatePagerAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_info);

        Racun racun = (Racun)getIntent().getSerializableExtra(BillListActivity.racunInfoKey);
        ObracunskiPeriod op = racun.getIdOp();

        mTextBillHeading = findViewById(R.id.textViewBillHeading);
            mTextBillHeading.setText(op.getMesec() + ", " + op.getGodina());
        mTextBillPeriod = findViewById(R.id.textViewBillHeadingDatePeriod);
            mTextBillPeriod.setText("(" + new SimpleDateFormat("MM/dd/yyyy").format(op.getDatumOd())
                    + "-" + new SimpleDateFormat("MM/dd/yyyy").format(op.getDatumDo()) + ")");

        mPager = findViewById(R.id.viewPagerBillFragments);
        mAdapter = new MainStatePagerAdapter(getSupportFragmentManager());
        mAdapter.addFragment(new BillInfoFragment());
        mPager.setAdapter(mAdapter);
    }
}

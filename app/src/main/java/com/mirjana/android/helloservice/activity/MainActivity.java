package com.mirjana.android.helloservice.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mirjana.android.helloservice.fragment.MainStatePagerAdapter;
import com.mirjana.android.helloservice.R;
import com.mirjana.android.helloservice.fragment.*;

public class MainActivity extends AppCompatActivity {

    public static final String kupacInfoKey = "KUPAC_INFO";
    public static final String kupacCreateKey = "KUPAC_NAPRAVI";

    public static final int LOGIN_FRAGMENT = 0;
    public static final int REGISTER_FRAGMENT = 1;
    public static final int NEW_ACCOUNT_FRAGMENT = 2;

    //private MainStatePagerAdapter mPagerAdapter;
    private ViewPager mViewPager;
    private MainStatePagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new MainStatePagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.viewPagerMainFragments);
        setupViewPager(mViewPager);
    }

    public void setupViewPager(ViewPager pager){
        adapter.addFragment(new LoginFragment());
        adapter.addFragment(new RegistrationFragment());
        adapter.addFragment(new NewAccountFragment());
        pager.setAdapter(adapter);
    }

    public void setViewPager(int fragment, Bundle bundle){
        if (bundle != null){
            adapter.setFragmentArgument(fragment, bundle);
        }
        mViewPager.setCurrentItem(fragment);
    }

}

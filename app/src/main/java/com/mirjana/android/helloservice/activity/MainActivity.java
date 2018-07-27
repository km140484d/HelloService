package com.mirjana.android.helloservice.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mirjana.android.helloservice.fragment.MainStatePagerAdapter;
import com.mirjana.android.helloservice.R;
import com.mirjana.android.helloservice.fragment.*;

public class MainActivity extends AppCompatActivity {

    public static final String kupacKey = "KUPAC";

    public static final int LOGIN_FRAGMENT = 0;
    public static final int REGISTER_FRAGMENT = 1;

    //private MainStatePagerAdapter mPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.viewPagerMainFragments);
        setupViewPager(mViewPager);
    }

    public void setupViewPager(ViewPager pager){
        MainStatePagerAdapter adapter = new MainStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LoginFragment());
        adapter.addFragment(new RegistrationFragment());
        pager.setAdapter(adapter);
    }

    public void setViewPager(int fragment){
        mViewPager.setCurrentItem(fragment);
    }

}

package com.mirjana.android.helloservice.activity.bill.fragment;

import android.support.v4.app.*;

import java.util.*;

public class BillPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments;

    public BillPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}

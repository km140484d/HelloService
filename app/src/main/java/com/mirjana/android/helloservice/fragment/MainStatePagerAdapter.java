package com.mirjana.android.helloservice.fragment;

import android.os.Bundle;
import android.support.v4.app.*;

import java.util.*;

public class MainStatePagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> fragments = new ArrayList<>();

    public MainStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment){
        fragments.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void setFragmentArgument(int fragment, Bundle bundle) {
        getItem(fragment).setArguments(bundle);
    }
}

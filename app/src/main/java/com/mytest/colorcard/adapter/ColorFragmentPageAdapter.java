package com.mytest.colorcard.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by FJQ on 2017/11/19.
 */

public class ColorFragmentPageAdapter extends FragmentPagerAdapter {
    /**
     * The m fragment list.
     */
    private List<Fragment> mFragmentList = null;

    private String[] titles;

    public ColorFragmentPageAdapter(FragmentManager fm, List<Fragment> mFragmentList, String[] titles) {
        super(fm);
        this.mFragmentList = mFragmentList;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (mFragmentList!=null){
            if (position < mFragmentList.size()) {
                fragment = mFragmentList.get(position);
            } else {
                fragment = mFragmentList.get(0);
            }
        }
        return fragment;
    }

    @Override
    public int getCount() {
        if (mFragmentList!=null&&mFragmentList.size()>0){
            return mFragmentList.size();
        }
        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (titles != null && titles.length > 0)
            return titles[position];
        return null;
    }
}

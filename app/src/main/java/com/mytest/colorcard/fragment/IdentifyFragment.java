package com.mytest.colorcard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mytest.colorcard.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IdentifyFragment extends BaseFragment {
    public static final String TAG="IdentifyFragment";
    public IdentifyFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_identify;
    }

    @Override
    public void initView() {
        Log.d(TAG, "initView: ");
    }



}

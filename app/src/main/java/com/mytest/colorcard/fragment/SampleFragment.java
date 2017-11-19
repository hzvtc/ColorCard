package com.mytest.colorcard.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.mytest.colorcard.ColorSample;
import com.mytest.colorcard.R;
import com.mytest.colorcard.adapter.ColorSampleAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SampleFragment extends BaseFragment {

    public static final String TAG = "SampleFragment";
    @InjectView(R.id.colorRecylerView)
    RecyclerView colorRecylerView;
    private ColorSampleAdapter colorSampleAdapter;
    public SampleFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_sample;
    }

    @Override
    public void initView() {
        Log.d(TAG, "sampleList size: " + mMainActivity.sampleList.size());
        if (colorSampleAdapter==null) {
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext);
            mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            colorRecylerView.setLayoutManager(mLayoutManager);
            colorRecylerView.setHasFixedSize(true);
            colorSampleAdapter = new ColorSampleAdapter(mContext, mMainActivity.sampleList);
            colorRecylerView.setAdapter(colorSampleAdapter);
        }
    }


}

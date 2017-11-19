package com.mytest.colorcard.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mytest.colorcard.ColorSample;
import com.mytest.colorcard.R;
import com.mytest.colorcard.adapter.ColorSampleAdapter;
import com.mytest.colorcard.util.EmptyRecyclerView;
import com.mytest.colorcard.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends BaseFragment {

    public static final String TAG = "SearchFragment";
    @InjectView(R.id.colorEt)
    EditText colorEt;
    @InjectView(R.id.searchBtn)
    Button searchBtn;
    @InjectView(R.id.colorRecylerView)
    EmptyRecyclerView colorRecylerView;
    @InjectView(R.id.emptyView)
    TextView emptyView;
    private ColorSampleAdapter colorSampleAdapter;
    private String searchName;
    private List<ColorSample> matchedColorList;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    public void initView() {
        Log.d(TAG, "initView: ");
        Log.d(TAG, "sampleList size: " + mMainActivity.sampleList.size());
        showColorList(mMainActivity.sampleList);
        searchName = "";
        colorEt.setText("");

    }

    private void showColorList(List<ColorSample> colorSampleList) {
        if (colorSampleAdapter == null) {
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext);
            mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            colorRecylerView.setLayoutManager(mLayoutManager);
            colorRecylerView.setHasFixedSize(true);
            colorRecylerView.setEmptyView(colorRecylerView);
            colorSampleAdapter = new ColorSampleAdapter(mContext, colorSampleList);
            colorRecylerView.setAdapter(colorSampleAdapter);
        } else {
            colorSampleAdapter.refresh(colorSampleList);
        }
    }

    @OnClick(R.id.searchBtn)
    public void onClick() {
        String needSearchName = colorEt.getText().toString().trim();
        if (needSearchName.equals("")) {
            if (!searchName.equals(needSearchName)) {
                searchName = needSearchName;
                showColorList(mMainActivity.sampleList);
            } else {
                ToastUtil.getInstance(mContext).showShort("数据已经显示在页面上");
            }
        } else {
            if (!searchName.equals(needSearchName)) {
                searchName = needSearchName;
                matchedColorList = new ArrayList<>();
                for (ColorSample sample : mMainActivity.sampleList) {
                    if (sample.getColor().contains(needSearchName)) {
                        matchedColorList.add(sample);
                    }
                }
                Log.d(TAG, "matchedColorList size: " + matchedColorList.size());
                showColorList(matchedColorList);
            } else {
                ToastUtil.getInstance(mContext).showShort("数据已经显示在页面上");
            }

        }
    }
}

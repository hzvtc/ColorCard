package com.mytest.colorcard;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mytest.colorcard.adapter.ColorFragmentPageAdapter;
import com.mytest.colorcard.fragment.IdentifyFragment;
import com.mytest.colorcard.fragment.SampleFragment;
import com.mytest.colorcard.fragment.SearchFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @InjectView(R.id.tab)
    TabLayout tabLayout;
    @InjectView(R.id.viewpager)
    ViewPager viewpager;
    public static final int TAB_SAMPLE = 0;
    public static final int TAB_SERACH = 1;
    public static final int TAB_IDENTIFY = 2;
    public List<ColorSample> sampleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        loadColorCard();
        Log.d(TAG, "sampleList size: "+sampleList.size());
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new SampleFragment());
        fragments.add(new SearchFragment());
        fragments.add(new IdentifyFragment());

        ColorFragmentPageAdapter adapter = new ColorFragmentPageAdapter(getSupportFragmentManager(), fragments, new String[]{"色卡", "检索", "辩色"});
        viewpager.setAdapter(adapter);
//        viewpager.setCurrentItem(2);
        tabLayout.setupWithViewPager(viewpager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case TAB_SAMPLE:
                        break;
                    case TAB_SERACH:
                        break;
                    case TAB_IDENTIFY:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void loadColorCard() {
        sampleList = new ArrayList<>();


        String sampleColors = getResources().getString(R.string.sample_color_list);
        String ss[] = sampleColors.split("\n");
        String rgb, name, category;
        int i, j;
        for (String s : ss) {
            rgb = name = category = null;
            if (s.trim().length() > 0) {
                i = s.indexOf('[');
                j = s.indexOf(']');
                if (j > i && i >= 0) {
                    rgb = s.substring(i + 1, j);
                }

                i = s.indexOf('[', j);
                j = s.indexOf(']', i);
                if (j > i && i >= 0) {
                    name = s.substring(i + 1, j);
                }

                i = s.indexOf('[', j);
                j = s.indexOf(']', i);
                if (j > i && i >= 0) {
                    category = s.substring(i + 1, j);
                }

                if (rgb != null && name != null && category != null) {
                    sampleList.add(new ColorSample(rgb, name, category));
                }


            }
        }
    }
}

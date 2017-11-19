package com.mytest.colorcard.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mytest.colorcard.ColorSample;
import com.mytest.colorcard.R;

import java.util.List;
import butterknife.InjectView;

/**
 * Created by FJQ on 2017/11/19.
 */

public class ColorSampleAdapter extends BaseButterKnifeReclerViewAdapter<ColorSample, ColorSampleAdapter.ViewHolder> {
    public ColorSampleAdapter(Context context, List<ColorSample> mDatas) {
        super(context, mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_color;
    }

    @Override
    protected ViewHolder getViewHolder(View rootView, int viewType) {
        return new ViewHolder(rootView);
    }

    @Override
    protected void initItemView(ViewHolder holder, ColorSample model, int position) {
        holder.colorBg.setBackgroundColor(model.getVal());
        holder.colorName.setText(model.getColor());
    }

    static class ViewHolder extends BaseButterKnifeViewHolder {
        @InjectView(R.id.colorBg)
        ImageView colorBg;
        @InjectView(R.id.colorName)
        TextView colorName;

        ViewHolder(View view) {
            super(view);
        }
    }
}

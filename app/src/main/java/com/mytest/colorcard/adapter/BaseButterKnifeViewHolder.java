package com.mytest.colorcard.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by 2 on 2017/7/7.
 */

public class BaseButterKnifeViewHolder extends RecyclerView.ViewHolder {
    //用于区分不同数据类型的ViewHolder
    public int type;
    public BaseButterKnifeViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
    }

    public void onDestroy(){
        ButterKnife.reset(this);
    }


}

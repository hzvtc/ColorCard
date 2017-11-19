package com.mytest.colorcard.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.mytest.colorcard.R;

/**
 * Created by 2 on 2017/7/27.
 * 列表为空时，显示一个特殊的empty view来提示用户
 * 支持最大显示区域的功能
 */

public class EmptyRecyclerView extends RecyclerView {
    private View emptyView;
    private static final String TAG = "EmptyRecyclerView";
    private Context mContext;
    private int maxHeight;
    private int mRecyclerViewWidth;
    private int mRecyclerViewHeight;
    final private AdapterDataObserver observer = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            checkIfEmpty();
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            checkIfEmpty();
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            checkIfEmpty();
        }
    };

    public EmptyRecyclerView(Context context) {
        this(context,null);
    }

    public EmptyRecyclerView(Context context, AttributeSet attrs) {
        this(context,attrs,-1);
    }

    public EmptyRecyclerView(Context context, AttributeSet attrs,
                             int defStyle) {
        super(context, attrs, defStyle);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.test);
        maxHeight = (int) ta.getDimension(R.styleable.test_max_height,0f);
//        PalLog.d(TAG,"maxHeight:"+maxHeight);
        ta.recycle();
    }

    private void checkIfEmpty() {
        if (emptyView != null && getAdapter() != null) {
            final boolean emptyViewVisible =
                    getAdapter().getItemCount() == 0;
            emptyView.setVisibility(emptyViewVisible ? VISIBLE : GONE);
            setVisibility(emptyViewVisible ? GONE : VISIBLE);
        }
    }

    @Override
    public void setAdapter(Adapter adapter) {
        final Adapter oldAdapter = getAdapter();
        if (oldAdapter != null) {
            oldAdapter.unregisterAdapterDataObserver(observer);
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            adapter.registerAdapterDataObserver(observer);
        }

        checkIfEmpty();
    }

    public void setEmptyView(View emptyView) {
        this.emptyView = emptyView;
        checkIfEmpty();
    }

    public int getRecyclerViewWidth() {
        return mRecyclerViewWidth;
    }

    public int getRecyclerViewHeight() {
        return mRecyclerViewHeight;
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        if (maxHeight>0){
            try {
                heightSpec = MeasureSpec.makeMeasureSpec(maxHeight, MeasureSpec.AT_MOST);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //重新计算控件高、宽
        super.onMeasure(widthSpec, heightSpec);
    }
}

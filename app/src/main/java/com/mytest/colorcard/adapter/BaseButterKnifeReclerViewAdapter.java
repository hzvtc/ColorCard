package com.mytest.colorcard.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mytest.colorcard.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2 on 2017/7/7.
 */

public abstract class BaseButterKnifeReclerViewAdapter<T,E extends BaseButterKnifeViewHolder> extends RecyclerView.Adapter implements View.OnClickListener{
    private static final String TAG="BaseButterKnifeReclerViewAdapter";
    protected int curSelectedIndex;
    protected Context context;
    protected List<T> mDatas;
    protected View itemView;
    protected E curSelectedViewHolder;
    protected List<E> holders;
    protected List<Integer> posList;
    protected MainActivity mainActivity;

    public BaseButterKnifeReclerViewAdapter(Context context, List<T> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        holders = new ArrayList<>();
        posList = new ArrayList<>();
        this.mainActivity = (MainActivity) context;
    }

    public List<E> getHolders() {
        return holders;
    }

    public void clearPosList(){
        if (posList!=null&&posList.size()>0){
            posList.clear();
        }
        curSelectedIndex = 0;
    }
    @Override
    public E onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = getView(parent);
        return getViewHolder(itemView,viewType);
    }

    protected View getView(ViewGroup parent){
        return LayoutInflater.from(
                context).inflate(getLayoutId(), parent,
                false);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        T model = mDatas.get(position);
        if (model!=null){
            initItemView(((E)holder),model,position);
        }

    }

    @Override
    public int getItemCount() {
        if (mDatas!=null&&mDatas.size()>0){
            return mDatas.size();
        }
        return 0;
    }



    protected abstract int getLayoutId();
    protected abstract E getViewHolder(View rootView, int viewType);
    protected abstract void initItemView(E holder,T model,int position);
    //添加数据并更新UI
    public void addItem(T data, int position) {
        mDatas.add(position, data);
        notifyItemInserted(position); //Attention!
    }
    //删除数据并更新UI
    public void removeItem(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);//Attention!
    }

    //刷新数据并更新UI
    public void refresh(List<T> mDataList){
        posList.clear();
        this.mDatas = mDataList;
        notifyDataSetChanged();
    }

}

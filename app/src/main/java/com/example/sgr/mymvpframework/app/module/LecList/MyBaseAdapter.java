package com.example.sgr.mymvpframework.app.module.LecList;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/1/15/015.
 */

public abstract class MyBaseAdapter<T,L,K extends BaseViewHolder> extends BaseQuickAdapter {
    private List<T> list;

    public MyBaseAdapter(@LayoutRes int layoutResId, @Nullable List data) {
        super(layoutResId, data);
    }

    public List<T> getList() {
        return list;
    }
    public void refreshAdapter(boolean isDownRefresh, List<T> list, L data){
        if (isDownRefresh){
            getList().clear();
        }
        if (list != null){
            getList().addAll(list);
        }
        //刷新
        notifyDataSetChanged();
    }
}

package com.example.sgr.mymvpframework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.sgr.mymvpframework.R;
import com.example.sgr.mymvpframework.app.bean.ListBean;
import com.example.sgr.mymvpframework.app.module.LecList.JbpAdapter;
import com.example.sgr.mymvpframework.app.module.LecList.LecListPresenter;
import com.example.sgr.mymvpframework.app.module.LecList.LecListView;
import com.example.sgr.mymvpframework.app.mvp.BaseRefreshLceActivity;
import com.example.sgr.mymvpframework.app.view.LoadingAnimator;
import com.example.sgr.mymvpframework.app.view.LoadingAnimatorB;
import com.example.sgr.mymvpframework.app.view.LoadingAnimatorC;
import com.tz.mvp.framework.base.presenter.MvpPresenter;

import z.sye.space.library.PageStateLayout;

public class LecListActivity extends BaseRefreshLceActivity<LecListView,LecListPresenter> implements LecListView {
    @Override
    public BaseQuickAdapter bindAdapter() {
        return new JbpAdapter();
    }
    @Override
    protected int setLayoutId() {
        return R.layout.activity_lec_list;
    }

    @Override
    protected void initData() {
        super.initData();
        setLceAnimator(new LoadingAnimatorB());
        loadData(false,1);
//        setLceAnimator(new LoadingAnimatorB());
//        setLceAnimator(new LoadingAnimatorC());
    }

    //刷新数据->下拉刷新
    @Override
    public void refreshData(boolean isDownRefresh,int page) {
        super.refreshData(isDownRefresh,page);
        loadData(true,1);
    }

    //绑定数据
    @Override
    public void bindData(Object model,String type) {
        //super作用：框架内部封装了下拉刷新头部和上拉加载底部隐藏和显示逻辑(每一个功能模块都是重复)
        super.bindData(model,type);
        ListBean tempBean=(ListBean)model;
        refresh(isDownRefresh(),tempBean.getData());
//        getAdapter().refreshAdapter(isDownRefresh(),model.getList(),model);
    }

    //加载数据
    @Override
    public void loadData(boolean pullToRefresh,int page) {
        super.loadData(pullToRefresh,page);

        getPresenter().getJbpList("683f24d06cd246229659a094b5b9955e","窗帘",page);
    }

    @Override
    public LecListPresenter createPresenter() {
        return new LecListPresenter(this);
    }
}

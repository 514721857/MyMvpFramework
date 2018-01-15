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
import com.tz.mvp.framework.base.presenter.MvpPresenter;

public class LecListActivity extends BaseRefreshLceActivity<ListBean,LecListView,LecListPresenter> implements LecListView {
    @Override
    public BaseQuickAdapter bindAdapter() {
        return new JbpAdapter();
    }
    @Override
    protected int setLayoutId() {
        return R.layout.activity_lec_list;
    }


    //刷新数据->下拉刷新
    @Override
    public void refreshData(boolean isDownRefresh) {
        super.refreshData(isDownRefresh);
        loadData(true);
    }

    //绑定数据
    @Override
    public void bindData(ListBean model) {
        //super作用：框架内部封装了下拉刷新头部和上拉加载底部隐藏和显示逻辑(每一个功能模块都是重复)
        super.bindData(model);
        //6、更新Adapter->核心：更新ArrayList列表
        Log.v("responStatus",""+model.getStatus());
        for (int i=0;i<model.getData().size();i++){
            Log.v("respongetTitle",""+model.getData().get(i).getDoc());
        }

        getAdapter().setNewData(model.getData());
//        getAdapter().refreshAdapter(isDownRefresh(),model.getList(),model);
    }

    //加载数据
    @Override
    public void loadData(boolean pullToRefresh) {
        super.loadData(pullToRefresh);
        getPresenter().getJbpList("5d9e96bc906e4395824f4311775761b7","窗帘");
    }

    @Override
    public LecListPresenter createPresenter() {
        return new LecListPresenter(this);
    }
}

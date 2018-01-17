package com.example.sgr.mymvpframework.app.mvp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.sgr.mymvpframework.R;
import com.tz.mvp.framework.base.presenter.MvpPresenter;
import com.tz.mvp.framework.support.lce.MvpLceView;
import com.tz.mvp.framework.support.lce.impl.MvpLceActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/1/15/015.
 */

public abstract class BaseRefreshLceActivity <M, V extends MvpLceView<M>, P extends MvpPresenter<V>> extends MvpLceActivity<M, V, P> {

//    protected ImmersionBar mImmersionBar; 沉浸式标题栏
    private Unbinder unbinder;


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private int page=1,pagesize=10;

    @BindView(R.id.xrefreshview)
    SwipeRefreshLayout mSwipeRefreshLayout;


    private BaseQuickAdapter recyclerAdapter;
    private LinearLayoutManager linearLayoutManager;

    private boolean isDownRefresh = true;//表示的是下拉刷新界面

    public boolean isDownRefresh() {
        return isDownRefresh;
    }


    public BaseQuickAdapter getAdapter() {
        return recyclerAdapter;
    }

    public LinearLayoutManager getLinearLayoutManager() {
        return linearLayoutManager;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        //绑定控件
        unbinder = ButterKnife.bind(this);
  /*      //初始化沉浸式
        if (isImmersionBarEnabled())
            initImmersionBar();*/
        //初始化数据
        initData();
        //view与数据绑定
        initView();
        initRefreshView();

    }

    public void refresh(boolean isRefresh, List data) {
        if(isRefresh){
            page = 1;
            recyclerAdapter.setEnableLoadMore(false);//这里的作用是防止下拉刷新的时候还可以上拉加载
            setData(isRefresh, data);
            recyclerAdapter.setEnableLoadMore(true);
            mSwipeRefreshLayout.setRefreshing(false);
        }else{
            setData(isRefresh, data);
        }



    }

//将数据与适配器绑定
    private void setData(boolean isRefresh, List data) {
        page++;
        final int size = data == null ? 0 : data.size();
        if (isRefresh) {//下拉刷新
            recyclerAdapter.setNewData(data);
        } else {//上拉加载更多
            if (size > 0) {
                recyclerAdapter.addData(data);
            }
        }
        if (size < pagesize) {
            //第一页如果不够一页就不显示没有更多数据布局
            recyclerAdapter.loadMoreEnd(isRefresh);
            Toast.makeText(this, "没有更多的数据", Toast.LENGTH_SHORT).show();
        } else {
            recyclerAdapter.loadMoreComplete();
        }
    }
    /**
     * 初始化下拉刷新组件
     *
     *
     */
    public void initRefreshView() {
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        //设置列表为垂直方向显示
        recyclerView.setLayoutManager(linearLayoutManager);
        //绑定Adapter
        recyclerAdapter = bindAdapter();
        recyclerView.setAdapter(recyclerAdapter);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {//下拉刷新
                refreshData(true,page);


            }
        });
        recyclerAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {//上拉加载更多
                refreshData(false,page);
            }
        });

    }
    public abstract BaseQuickAdapter bindAdapter();
    @Override
    public void bindData(M data) {
        super.bindData(data);
        //如果你是下拉刷新组件,那么我就处理
        //刷新UI界面
 /*       if (isDownRefresh()) {
            //网络请求完成,关闭下拉刷新组件加载视图
            getRefreshView().stopRefresh();
        } else {
            getRefreshView().stopLoadMore();
        }*/
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //保存数据
    }

    public void refreshData(boolean isDownRefresh,int page) {
        this.page=page;
        this.isDownRefresh = isDownRefresh;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
      /*  if (mImmersionBar != null)
            mImmersionBar.destroy();  //在BaseActivity里销毁
    }*/
    }
    protected abstract int setLayoutId();

    protected void initImmersionBar() {
        //在BaseActivity里初始化  因为界面需要，状态栏的背景都需要是以图片为背景，所以这里需要在每个Activity里的xml布局文件中加入  topview布局
        //        https://github.com/gyf-dev/ImmersionBar  最外面布局为realayout 可能会导致挡住标题栏
/*
     mImmersionBar = ImmersionBar.with(this).statusBarDarkFont(true, 0.2f).statusBarView(R.id.top_view);
        mImmersionBar.init();*/

       /* mImmersionBar = ImmersionBar.with(this).fitsSystemWindows(true) .statusBarDarkFont(true, 0.2f)  ;
        mImmersionBar.init();*/
    }

    protected void initData() {
    }

    protected void initView() {
    }

    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }

}

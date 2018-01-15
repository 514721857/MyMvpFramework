package com.example.sgr.mymvpframework.app.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.sgr.mymvpframework.R;
import com.example.sgr.mymvpframework.app.view.LoadMoreLayout;
import com.example.sgr.mymvpframework.app.view.PullToRefreshLayout;
import com.tz.mvp.framework.base.presenter.MvpPresenter;
import com.tz.mvp.framework.support.lce.MvpLceView;
import com.tz.mvp.framework.support.lce.impl.MvpLceActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by Administrator on 2018/1/15/015.
 */

public abstract class BaseRefreshLceActivity <M, V extends MvpLceView<M>, P extends MvpPresenter<V>> extends MvpLceActivity<M, V, P> implements PtrHandler{

//    protected ImmersionBar mImmersionBar; 沉浸式标题栏
    private Unbinder unbinder;
    private LoadMoreLayout loadMoreLayout;

    @BindView(R.id.refreshlayout)
    PullToRefreshLayout refreshlayout;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    private BaseQuickAdapter recyclerAdapter;
    private LinearLayoutManager linearLayoutManager;

    private boolean isDownRefresh = true;

    public boolean isDownRefresh() {
        return isDownRefresh;
    }
    public PullToRefreshLayout getRefreshView() {
        return refreshlayout;
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

    //下拉刷新
    @Override
    public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
        return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
    }
    //    下拉刷新监听
    @Override
    public void onRefreshBegin(PtrFrameLayout frame) {
        refreshData(true);
        refreshlayout.refreshComplete();

    }

    /**
     * 初始化下拉刷新组件
     *
     *
     */
    public void initRefreshView() {
        refreshlayout.setPtrHandler(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        //设置列表为垂直方向显示
        recyclerView.setLayoutManager(linearLayoutManager);
        //绑定Adapter
        recyclerAdapter = bindAdapter();
        recyclerView.setAdapter(recyclerAdapter);
        loadMoreLayout = new LoadMoreLayout(this, recyclerView, recyclerAdapter, new LoadMoreLayout.OnLoadMoreListener() {
            boolean flag = false;

            @Override
            public void onLoadMore() {
                refreshData(false);
                loadMoreLayout.loadMoreComplete();
                Log.e("zh", "加载更多");
            }
        });
        loadMoreLayout.loadMoreEnable(true);

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

    public void refreshData(boolean isDownRefresh) {
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

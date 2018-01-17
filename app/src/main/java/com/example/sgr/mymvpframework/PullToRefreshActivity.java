package com.example.sgr.mymvpframework;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.sgr.mymvpframework.app.test.TestAdapter;
import com.example.sgr.mymvpframework.app.test.testBean;

import java.util.ArrayList;
import java.util.List;

public class PullToRefreshActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private TestAdapter mAdapter;
    private Handler handler = new Handler(Looper.getMainLooper());
    private List<testBean> MtestBean;


    private static final int PAGE_SIZE = 20;
    private static final int TOTAL_COUNT = 60;
    private int mNextRequestPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_refresh);

        initView();
        FirstData();
//        MtestBean
    }

    private void FirstData() {
        MtestBean = new ArrayList();
        for (int i = 1; i <= 6; i++) {
            testBean model = new testBean();
            model.setUid(i);
            MtestBean.add(model);
        }
        refresh();
    }


    private void initData() {
        MtestBean = new ArrayList();
        for (int i = 1; i <= PAGE_SIZE; i++) {
            testBean model = new testBean();
            model.setUid(i);
            MtestBean.add(model);
        }
    }

    private List<testBean> getMoreData() {
        List<testBean>  tempBean = new ArrayList();
        for (int i = MtestBean.size(); i <= MtestBean.size()+PAGE_SIZE; i++) {
            testBean model = new testBean();
            model.setUid(i);
            tempBean.add(model);
        }
        return tempBean;
    }


    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new TestAdapter();
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadMore();
                    }
                }, 1500);



            }
        });
        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
//        mAdapter.setPreLoadNumber(3);
        mRecyclerView.setAdapter(mAdapter);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        initData();
                        refresh();
                    }
                }, 1500);


            }
        });

    }

    private void refresh() {

        mNextRequestPage = 1;
        mAdapter.setEnableLoadMore(false);//这里的作用是防止下拉刷新的时候还可以上拉加载
        setData(true, MtestBean);
        mAdapter.setEnableLoadMore(true);
        mSwipeRefreshLayout.setRefreshing(false);

    }

    private void loadMore() {
        setData(false, getMoreData());
    }

    private void setData(boolean isRefresh, List data) {
        mNextRequestPage++;
        final int size = data == null ? 0 : data.size();
        if (isRefresh) {//下拉刷新
            mAdapter.setNewData(data);
        } else {//上拉加载更多
            if (size > 0) {
                mAdapter.addData(data);
            }
        }
        if (size < PAGE_SIZE) {
            //第一页如果不够一页就不显示没有更多数据布局
            mAdapter.loadMoreEnd(isRefresh);
            Toast.makeText(this, "no more data", Toast.LENGTH_SHORT).show();
        } else {
            mAdapter.loadMoreComplete();
        }
    }
}

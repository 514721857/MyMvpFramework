package com.example.sgr.mymvpframework.app.view;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.sgr.mymvpframework.R;
import com.ldoublem.loadingviewlib.view.LVCircularSmile;
import com.tz.mvp.framework.support.lce.impl.animator.DefaultLceAnimator;

/**
 * Created by Administrator on 2018/1/17/017.
 */

public class LoadingAnimatorB extends DefaultLceAnimator {

    private LVCircularSmile loading;

    @Override
    public void showLoading(View loadingView, View contentView, View errorView) {
        super.showLoading(loadingView, contentView, errorView);
        loading = (LVCircularSmile) loadingView.findViewById(R.id.lv_loading_smile);
        loading.setViewColor(Color.rgb(144, 238, 146));
        loading.startAnim();

    }
/*
    @Override
    public void showLoading(View loadingView, View contentView, View errorView) {
        Log.e("LoadingAnimatorB","showLoading");
        System.out.println("LoadingAnimatorBshowLoading");
//        super.showLoading(loadingView, contentView, errorView);
*/
/*
//        loading=new PageStateLayout(c);
        loading = (LVCircularSmile) loadingView.findViewById(R.id.lv_loading_smile);
        loading.setViewColor(Color.rgb(144, 238, 146));
        Log.e("LoadingAnimatorB","showLoading");
        loading.startAnim();*//*

    }
*/

    @Override
    public void showContent(View loadingView, View contentView, @NonNull View errorView) {
        if (loading != null){
            loading.stopAnim();
        }
        loadingView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
        contentView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorView(@NonNull View loadingView, @NonNull View contentView, View errorView) {
        super.showErrorView(loadingView, contentView, errorView);
        if (loading != null){
            loading.stopAnim();
        }
        loadingView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
        contentView.setVisibility(View.GONE);
    }
}

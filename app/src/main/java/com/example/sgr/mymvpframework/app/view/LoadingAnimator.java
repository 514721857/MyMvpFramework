package com.example.sgr.mymvpframework.app.view;

import android.support.annotation.NonNull;
import android.view.View;

import com.example.sgr.mymvpframework.R;
import com.tz.mvp.framework.support.lce.impl.animator.DefaultLceAnimator;

/**
 * 作者: Dream on 16/9/24 16:20
 * QQ:510278658
 * E-mail:510278658@qq.com
 */

public class LoadingAnimator extends DefaultLceAnimator {

    private LoadingView loading;

    @Override
    public void showLoading(View loadingView, View contentView, View errorView) {
        super.showLoading(loadingView, contentView, errorView);
        loading = (LoadingView) loadingView.findViewById(R.id.lv_loading);
        loading.openAnimation();
    }

    @Override
    public void showContent(View loadingView, View contentView, @NonNull View errorView) {
        if (loading != null){
            loading.closeAnimation();
        }
        loadingView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
        contentView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorView(@NonNull View loadingView, @NonNull View contentView, View errorView) {
        super.showErrorView(loadingView, contentView, errorView);
        if (loading != null){
            loading.closeAnimation();
        }
        loadingView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
        contentView.setVisibility(View.GONE);
    }
}

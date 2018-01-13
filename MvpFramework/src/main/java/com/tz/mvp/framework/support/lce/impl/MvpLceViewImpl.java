package com.tz.mvp.framework.support.lce.impl;

import android.view.View;
import android.view.View.OnClickListener;

import com.tz.architect.mvpframework.R;
import com.tz.mvp.framework.support.lce.MvpLceView;
import com.tz.mvp.framework.support.lce.impl.animator.DefaultLceAnimator;
import com.tz.mvp.framework.support.lce.impl.animator.ILceAnimator;

/**
 * 目标接口实现类
 * 
 * @author Dream
 *
 * @param <M>
 */
public class MvpLceViewImpl<M> implements MvpLceView<M> {

	private View loadingView;
	private View contentView;
	private View errorView;

	private ILceAnimator lceAnimator;

	/**
	 * 初始化视图
	 * 
	 * @param v
	 */
	public void initLceView(View v) {
		if (loadingView == null) {
			loadingView = v.findViewById(R.id.loadingView);
		}
		if (contentView == null) {
			contentView = v.findViewById(R.id.contentView);
		}
		if (errorView == null) {
			errorView = v.findViewById(R.id.errorView);
		}
		if (loadingView == null) {
			throw new NullPointerException("loadingView is not null!");
		}
		if (contentView == null) {
			throw new NullPointerException("contentView is not null!");
		}
		if (errorView == null) {
			throw new NullPointerException("errorView is not null!");
		}
	}

	/**
	 * 添加重写加载监听
	 * 
	 * @param onClickListener
	 */
	public void setOnErrorViewClickListener(OnClickListener onClickListener) {
		if (this.errorView != null) {
			this.errorView.setOnClickListener(onClickListener);
		}
	}

	private ILceAnimator getLceAnimator() {
		if (lceAnimator == null) {
			lceAnimator = DefaultLceAnimator.getInstance();
		}
		return lceAnimator;
	}

	/**
	 * 绑定动画执行策略
	 * 
	 * @param lceAnimator
	 */
	public void setLceAnimator(ILceAnimator lceAnimator) {
		this.lceAnimator = lceAnimator;
	}

	@Override
	public void showLoading(boolean pullToRefresh) {
		//注意：记得加判断，因为下拉刷新组件有正在加载头部视图，不需要显示加载过程了
		if(!pullToRefresh){
			getLceAnimator().showLoading(loadingView, contentView, errorView);
		}
	}

	@Override
	public void showContent() {
		getLceAnimator().showContent(loadingView, contentView, errorView);
	}

	@Override
	public void showError() {
		getLceAnimator().showErrorView(loadingView, contentView, errorView);
	}

	@Override
	public void bindData(M data) {
		
	}

	@Override
	public void loadData(boolean pullToRefresh) {
		
	}

}

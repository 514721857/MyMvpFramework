package com.tz.mvp.framework.support.lce;

import com.tz.mvp.framework.base.view.MvpView;

/**
 * 目标接口
 * 
 * @author Dream
 *
 * @param <M>
 */
public interface MvpLceView<M> extends MvpView {

	/**
	 * 显示loading页面 pullToRefresh：true代表你用的是下拉刷新组件
	 * 
	 * @param pullToRefresh
	 */
	public void showLoading(boolean pullToRefresh);

	/**
	 * 显示ContentView
	 */
	public void showContent();

	/**
	 * 显示异常界面
	 */
	public void showError();

	/**
	 * 绑定数据
	 * 
	 * @param data
	 */
	public void bindData(M data);

	/**
	 * 加载数据
	 *
	 * @param pullToRefresh
	 */
	public void loadData(boolean pullToRefresh);

}

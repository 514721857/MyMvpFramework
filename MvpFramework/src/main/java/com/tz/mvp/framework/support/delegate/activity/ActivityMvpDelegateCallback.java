package com.tz.mvp.framework.support.delegate.activity;

import com.tz.mvp.framework.base.presenter.MvpPresenter;
import com.tz.mvp.framework.base.view.MvpView;
import com.tz.mvp.framework.support.delegate.MvpDelegateCallback;

/**
 * 扩展目标接口 针对不同的模块，目标接口有差异
 * 
 * 需要监听保存数据以及获取数据的方法
 * 
 * @author Dream
 *
 */
public interface ActivityMvpDelegateCallback<V extends MvpView, P extends MvpPresenter<V>>
		extends MvpDelegateCallback<V, P> {

	// 获取实例
	public Object getLastCustomNonConfigurationInstance();

	// 还需要定义其它的一些自定义方法(用处？)－－－我要做一些逻辑处理
	// 注意：该方法可以改名字，可以不改
	public Object onRetainCustomNonConfigurationInstance();

	// 一下方法是对getLastCustomNonConfigurationInstance方法处理
	//为了方便扩展，所以留在
	public Object getNonLastCustomNonConfigurationInstance();

}

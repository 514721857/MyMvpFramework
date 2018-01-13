package com.tz.mvp.framework.support.delegate;

import com.tz.mvp.framework.base.presenter.MvpPresenter;
import com.tz.mvp.framework.base.view.MvpView;

/**
 * 代理模式－静态代理：目标接口
 * 
 * 
 * @author Dream
 *
 * @param <V>
 * @param <P>
 */
public interface MvpDelegateCallback<V extends MvpView, P extends MvpPresenter<V>> {
	/**
	 * 创建Presenter方法
	 * 
	 * @return
	 */
	public P createPresenter();

	/**
	 * 得到Presenter实例
	 * 
	 * @return
	 */
	public P getPresenter();

	/**
	 * 设置一个新的Presenter
	 * 
	 * @param presenter
	 */
	public void setPresenter(P presenter);

	/**
	 * 得到具体的MvpView实例对象
	 * 
	 * @return
	 */
	public V getMvpView();
	
	//是否保存数据
	public void setRetainInstance(boolean retaionInstance);
	public boolean isRetainInstance();
	
	//判断是否保存数据(该方法还会处理横竖屏切换)
	public boolean shouldInstanceBeRetained();
	
}

package com.tz.mvp.framework.support.delegate.activity;

import com.tz.mvp.framework.base.presenter.MvpPresenter;
import com.tz.mvp.framework.base.view.MvpView;

public class ActivityMvpConfigurationInstance<V extends MvpView, P extends MvpPresenter<V>> {
	private P presenter;
	private Object customeConfigurationInstance;

	public ActivityMvpConfigurationInstance(P presenter,
			Object customeConfigurationInstance) {
		super();
		this.presenter = presenter;
		this.customeConfigurationInstance = customeConfigurationInstance;
	}

	public P getPresenter() {
		return presenter;
	}

	public void setPresenter(P presenter) {
		this.presenter = presenter;
	}

	public Object getCustomeConfigurationInstance() {
		return customeConfigurationInstance;
	}

	public void setCustomeConfigurationInstance(
			Object customeConfigurationInstance) {
		this.customeConfigurationInstance = customeConfigurationInstance;
	}

}

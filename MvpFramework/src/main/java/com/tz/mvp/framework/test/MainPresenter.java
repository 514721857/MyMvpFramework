package com.tz.mvp.framework.test;

import android.content.Context;

import com.tz.mvp.framework.base.presenter.impl.MvpBasePresenter;

public class MainPresenter extends MvpBasePresenter<MainView> {
	
	private RegisterModel registerModel;

	public MainPresenter(Context context) {
		super(context);
		registerModel = new RegisterModel();
	}

	public void register(){
		
	}

}

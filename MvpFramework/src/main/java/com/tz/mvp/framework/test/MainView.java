package com.tz.mvp.framework.test;

import com.tz.mvp.framework.base.view.MvpView;

public interface MainView extends MvpView {
	public void onLoginResult(String result);
	
	//只需在该接口中添加相应功能接口即可
	public void onRegisterResult(String result);
}

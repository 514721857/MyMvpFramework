package com.tz.mvp.framework.test;

import com.tz.mvp.framework.support.view.MvpFragment;

public class MainFragment extends MvpFragment<MainView, MainPresenter> {

	@Override
	public MainPresenter createPresenter() {
		return new MainPresenter(getContext());
	}

	@Override
	public boolean isRetainInstance() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shouldInstanceBeRetained() {
		// TODO Auto-generated method stub
		return false;
	}

}

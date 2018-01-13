package com.tz.mvp.framework.test.layout;

import android.content.Context;
import android.util.AttributeSet;

import com.tz.mvp.framework.support.view.layout.MvpLinearLayout;

public class MyLinearLayout extends MvpLinearLayout<MyView, MyPresenter> implements MyView{

	public MyLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MyLinearLayout(Context context) {
		super(context);
	}

	@Override
	public MyPresenter createPresenter() {
		return new MyPresenter(getContext());
	}

	@Override
	public void onResult(String result) {
		
	}

}

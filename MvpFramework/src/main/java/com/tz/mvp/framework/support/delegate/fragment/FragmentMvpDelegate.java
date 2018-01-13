package com.tz.mvp.framework.support.delegate.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.tz.mvp.framework.base.presenter.MvpPresenter;
import com.tz.mvp.framework.base.view.MvpView;

public interface FragmentMvpDelegate<V extends MvpView, P extends MvpPresenter<V>> {
	public void onCreate(Bundle savedInstanceState);

	public void onActivityCreated(Bundle savedInstanceState);

	public void onViewCreated(View view, Bundle savedInstanceState);

	public void onStart();

	public void onPause();

	public void onResume();

	public void onStop();

	public void onDestroyView();

	public void onDestroy();

	public void onSaveInstanceState(Bundle outState);

	public void onAttach(Context context);

	public void onDetach();
}

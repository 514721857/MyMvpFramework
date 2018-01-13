package com.example.sgr.mymvpframework.app.module.login.view;

import com.example.sgr.mymvpframework.app.bean.LoginBean;
import com.tz.mvp.framework.base.view.MvpView;
import com.tz.mvp.framework.support.lce.MvpLceView;

/**
 * 作者: Dream on 16/9/25 00:04
 * QQ:510278658
 * E-mail:510278658@qq.com
 */

public interface LoginView extends MvpView {
    void onLoginResult(LoginBean result);
}

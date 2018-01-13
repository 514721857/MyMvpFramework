package com.example.sgr.mymvpframework.app.module.Lec;

import com.example.sgr.mymvpframework.app.bean.LoginBean;
import com.tz.mvp.framework.support.lce.MvpLceView;

/**
 * 定义Lec的 接口view LoginBean为参数
 * Created by Administrator on 2018/1/12/012.
 */

public interface LecTestView extends MvpLceView<LoginBean>{
    void onLoginResult(LoginBean result);
}

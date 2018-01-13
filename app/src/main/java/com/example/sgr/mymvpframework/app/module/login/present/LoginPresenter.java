package com.example.sgr.mymvpframework.app.module.login.present;

import android.content.Context;

import com.example.sgr.mymvpframework.app.bean.LoginBean;
import com.example.sgr.mymvpframework.app.http.HttpUtils;
import com.example.sgr.mymvpframework.app.module.login.model.CommonModel;
import com.example.sgr.mymvpframework.app.module.login.view.LoginView;
import com.example.sgr.mymvpframework.app.mvp.BasePresenter;


/**
 * 作者: Dream on 16/9/24 21:28
 * QQ:510278658
 * E-mail:510278658@qq.com
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    private CommonModel commonModel;

    public LoginPresenter(Context context){
        super(context);
        this.commonModel = new CommonModel(context);
    }

    public void getLogin(String account,String pwd,boolean pullToRefresh){
        //1、显示Loading页面
        //显示LoadingView
//        getView().showLoading(pullToRefresh);
        //2、发起请求的时候
        commonModel.getLogin(account, pwd, new HttpUtils.OnHttpResultListener() {
            //3、更新UI->有两种情况
            @Override
            public void onResult(Object result) {
            /*    //第二种情况：正确->请求成功
                if (result == null){
                    //4、绑定数据->更新UI
                    getView().bindData(null);
                }else {
                    getView().bindData((LoginBean) result);
                }
                //5、显示UI->显示ContentView
                getView().showContent();*/
                getView().onLoginResult((LoginBean) result);
            }

            @Override
            public void onCompleted() {

            }
            @Override
            public void onError(Throwable e) {
                //第一种情况：发送错误->请求失败
                //显示ErrorView
//                getView().showError();
            }
        });
    }

}

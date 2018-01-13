package com.example.sgr.mymvpframework.app.module.login.model;

import android.content.Context;

import com.example.sgr.mymvpframework.app.bean.ListBean;
import com.example.sgr.mymvpframework.app.bean.LoginBean;
import com.example.sgr.mymvpframework.app.bean.Result;
import com.example.sgr.mymvpframework.app.http.HttpService;
import com.example.sgr.mymvpframework.app.http.HttpUtils;
import com.example.sgr.mymvpframework.app.mvp.BaseModel;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者: Dream on 16/9/24 21:09
 * QQ:510278658
 * E-mail:510278658@qq.com
 */
public class CommonModel extends BaseModel {

    public CommonModel(Context context) {
        super(context);
    }

    /**
     * 登录
     * @param account
     * @param pwd
     * @param onLceHttpResultListener
     */
    public void getLogin(String account,String pwd,final HttpUtils.OnHttpResultListener onLceHttpResultListener) {
/*        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getServerUrl())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();

        HttpService essenceService = retrofit.create(HttpService.class);*/
 /*       HttpService essenceService = buildService(HttpService.class);
        essenceService.;
        buildObserve((MyObservable<ListBean>) essenceService,onLceHttpResultListener);

*/




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getServerUrl())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();
        HttpService essenceService = retrofit.create(HttpService.class);
        essenceService.getLceLogin("GD15039888","13602284381")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onCompleted() {
                        onLceHttpResultListener.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        onLceHttpResultListener.onError(new Exception(e));
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        onLceHttpResultListener.onResult(loginBean);
                    }


                });
    }

    /**
     * 获取聚宝盆里的下载列表
     * @param access_token
     * @param p
     * @param size
     * @param type_c
     * @param onLceHttpResultListener
     */
    public void getJbpList(String access_token,int p,int size,String type_c,final HttpUtils.OnHttpResultListener onLceHttpResultListener){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getServerUrl())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();
                 HttpService essenceService = retrofit.create(HttpService.class);
                 essenceService.getLceJbpList(access_token, p, size, type_c)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Result<ListBean>>() {
                    @Override
                    public void onCompleted() {
                        onLceHttpResultListener.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        onLceHttpResultListener.onError(new Exception(e));
                    }

                    @Override
                    public void onNext(Result<ListBean> model) {
                        onLceHttpResultListener.onResult(model);
                    }
                });
    }


}

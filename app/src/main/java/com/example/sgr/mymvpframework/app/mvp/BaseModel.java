package com.example.sgr.mymvpframework.app.mvp;

import android.content.Context;

import com.example.sgr.mymvpframework.app.bean.ListBean;
import com.example.sgr.mymvpframework.app.bean.LoginBean;
import com.example.sgr.mymvpframework.app.http.HttpService;
import com.example.sgr.mymvpframework.app.http.HttpUtils;
import com.tz.mvp.framework.base.model.MvpModel;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者: Dream on 16/9/24 21:10
 * QQ:510278658
 * E-mail:510278658@qq.com
 */

public class BaseModel implements MvpModel {

    private Context context;

    public BaseModel(Context context){
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public String getServerUrl(){
        return "http://manage.zhidao3d.com:8081";
    }

    public <T> T buildService(Class<T> service){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getServerUrl())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(service);
    }

    public void buildObserve( Observable<Object> Mobservable,final HttpUtils.OnHttpResultListener onLceHttpResultListener){
        Mobservable .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onCompleted() {
                        onLceHttpResultListener.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        onLceHttpResultListener.onError(new Exception(e));
                    }

                    @Override
                    public void onNext(Object model) {
                        onLceHttpResultListener.onResult(model);
                    }});

    }

}

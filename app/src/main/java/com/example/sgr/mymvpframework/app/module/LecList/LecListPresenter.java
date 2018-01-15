package com.example.sgr.mymvpframework.app.module.LecList;

import android.content.Context;
import android.util.Log;

import com.example.sgr.mymvpframework.app.bean.DataList;
import com.example.sgr.mymvpframework.app.bean.ListBean;
import com.example.sgr.mymvpframework.app.bean.Result;
import com.example.sgr.mymvpframework.app.http.HttpUtils;
import com.example.sgr.mymvpframework.app.module.login.model.CommonModel;
import com.example.sgr.mymvpframework.app.mvp.BasePresenter;

/**
 * Created by Administrator on 2018/1/13/013.
 */

public class LecListPresenter extends BasePresenter<LecListView>{
    private CommonModel commonModel;
    private int page=1,pagesize=10;

    public LecListPresenter(Context context) {
        super(context);
        this.commonModel = new CommonModel(context);
    }

    /**
     * 获取聚宝盆列表
     */
    public void getJbpList(String token,String type_c){
        getView().showLoading(false);
        commonModel.getJbpList(token,page,pagesize,type_c, new HttpUtils.OnHttpResultListener() {
            @Override
            public void onResult(Object result) {
                //第二种情况：正确->请求成功
                if (result == null){
                    //4、绑定数据->更新UI
                    getView().bindData(null);
                }else {
                    getView().bindData((ListBean) result);
                }
                //5、显示UI->显示ContentView
                getView().showContent();
            }

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("bug",e.toString());
             getView().showError();
            }
        });

    }

}

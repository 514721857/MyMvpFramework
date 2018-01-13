package com.example.sgr.mymvpframework.app.module.LecList;

import android.content.Context;

import com.example.sgr.mymvpframework.app.module.login.model.CommonModel;
import com.example.sgr.mymvpframework.app.mvp.BasePresenter;

/**
 * Created by Administrator on 2018/1/13/013.
 */

public class LecListPresenter extends BasePresenter<LecListView>{
    private CommonModel commonModel;

    public LecListPresenter(Context context) {
        super(context);
        this.commonModel = new CommonModel(context);
    }

    /**
     * 获取聚宝盆列表
     */
    public void getJbpList(){

    }

}

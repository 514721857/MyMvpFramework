package com.example.sgr.mymvpframework.app.module.Lec;

import android.content.Context;
import android.util.Log;

import com.example.sgr.mymvpframework.app.bean.LoginBean;
import com.example.sgr.mymvpframework.app.http.HttpService;
import com.example.sgr.mymvpframework.app.http.HttpUtils;
import com.example.sgr.mymvpframework.app.module.login.model.CommonModel;
import com.example.sgr.mymvpframework.app.mvp.BasePresenter;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.ContentValues.TAG;

/**必须持有M层和V层
 * Created by Administrator on 2018/1/12/012.
 */

public class LecPresenter extends BasePresenter<LecTestView> {
    private CommonModel commonModel;
    public LecPresenter(Context context) {
        super(context);
        this.commonModel = new CommonModel(context);
    }
    public void getLogin(String account,String pwd){
        //1、显示Loading页面
        //显示LoadingView
        getView().showLoading(false);
        //2、发起请求的时候
        commonModel.getLogin(account, pwd, new HttpUtils.OnHttpResultListener() {
            //3、更新UI->有两种情况
            @Override
            public void onResult(Object result) {
              //第二种情况：正确->请求成功
       /*         if (result == null){
                    //4、绑定数据->更新UI
                    getView().bindData(null);
                }else {
                    getView().bindData((LoginBean) result);
                }*/
                //5、显示UI->显示ContentView
                getView().showContent();
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
        public void getTest(){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://manage.zhidao3d.com:8081")
                    .build();

            HttpService movieService = retrofit.create(HttpService.class);//创建对象
            Call<ResponseBody> call = movieService.getTest("5d9e96bc906e4395824f4311775761b7",1,10,"窗帘");//传递请求参数 对应接口中的定义
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        Log.i(TAG, "onResponse: "+response.body().string());//返回的就是实体类，不需要Gson转换
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Log.i(TAG, "onFailure: "+t.getMessage());
                }
            });



    }

}

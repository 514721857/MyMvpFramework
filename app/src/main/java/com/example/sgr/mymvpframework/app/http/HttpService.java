package com.example.sgr.mymvpframework.app.http;

import com.example.sgr.mymvpframework.app.bean.ListBean;
import com.example.sgr.mymvpframework.app.bean.LoginBean;
import com.example.sgr.mymvpframework.app.bean.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者: Dream on 16/9/24 21:15
 * QQ:510278658
 * E-mail:510278658@qq.com
 */

public interface HttpService {

    /**
     * 登录接口
     * @param account
     * @param password
     * @return
     */
    @GET("app/base/login")
    Observable<LoginBean> getLceLogin(@Query("account") String account, @Query("password") String password);


    /**
     * 获取聚宝盆里的下载列表
     * @param access_token
     * @param p
     * @param size
     * @param type_c
     * @return
     */
    @GET("app/app_mat/get_type")
    Observable<Result<ListBean>> getLceJbpList(@Query("access_token") String access_token,@Query("p") int p,@Query("size") int size,@Query("type_c") String type_c);

}

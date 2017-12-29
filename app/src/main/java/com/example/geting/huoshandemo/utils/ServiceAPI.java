package com.example.geting.huoshandemo.utils;

import android.webkit.URLUtil;

import com.example.geting.huoshandemo.bean.LoginBean;
import com.example.geting.huoshandemo.bean.RegisterBean;

import java.net.URL;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ASUS on 2017/12/4.
 */

public interface ServiceAPI {


    @GET(UrlUtils.LOGIN)
    Call<LoginBean> login(@Query("mobile") String account, @Query("password") String pwd);
    @GET(UrlUtils.REGIST)
    Call<RegisterBean> regist(@Query("mobile") String account, @Query("password") String pwd);

}

package com.example.geting.huoshandemo.login;

import com.example.geting.huoshandemo.bean.LoginBean;
import com.example.geting.huoshandemo.home.BaseModel;
import com.example.geting.huoshandemo.utils.OnNetLisenter;
import com.example.geting.huoshandemo.utils.RetrofitHelper;
import com.example.geting.huoshandemo.utils.ServiceAPI;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by ASUS on 2017/11/8.
 */

public class LoginModel extends BaseModel implements ILoginModel {
    @Override
    public void login(String account, String pwd, final OnNetLisenter<LoginBean> netLisenter) {
        ServiceAPI serviceAPI = RetrofitHelper.getServiceAPI();
       Call<LoginBean> login = serviceAPI.login(account,pwd);
       login.enqueue(new Callback<LoginBean>() {
           @Override
           public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
               final LoginBean body = response.body();
               handler.post(new Runnable() {
                   @Override
                   public void run() {
                       netLisenter.onSuccess(body);
                   }
               });
           }

           @Override
           public void onFailure(Call<LoginBean> call, final Throwable t) {
               handler.post(new Runnable() {
                   @Override
                   public void run() {
                            netLisenter.onFaulare(t);
                   }
               });
           }
       });
    }
}

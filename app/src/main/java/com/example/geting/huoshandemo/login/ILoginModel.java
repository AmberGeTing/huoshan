package com.example.geting.huoshandemo.login;


import com.example.geting.huoshandemo.bean.LoginBean;
import com.example.geting.huoshandemo.utils.OnNetLisenter;

/**
 * Created by ASUS on 2017/11/8.
 */

public interface ILoginModel {
    //创建一个方法
    public void login(String account, String pwd, OnNetLisenter<LoginBean> netLisenter);
}

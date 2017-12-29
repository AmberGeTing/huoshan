package com.example.geting.huoshandemo.login;


import com.example.geting.huoshandemo.bean.RegisterBean;
import com.example.geting.huoshandemo.utils.OnNetLisenter;

/**
 * Created by ASUS on 2017/11/8.
 */

public interface IRegisterModel {
    public void register(String account, String pwd, OnNetLisenter<RegisterBean> onNetLisenter);
}

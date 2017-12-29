package com.example.geting.huoshandemo.home;

import com.example.geting.huoshandemo.bean.LoginBean;
import com.example.geting.huoshandemo.bean.RegisterBean;

/**
 * Created by geting on 2017/12/28.
 */

public interface IMain {
    public void showLogin(LoginBean loginBean);
    public void showRegister(RegisterBean registerBean);
    public String getAccount();
    public String getPwd();


}

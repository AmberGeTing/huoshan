package com.example.geting.huoshandemo.login;

import android.text.TextUtils;

import com.example.geting.huoshandemo.bean.LoginBean;
import com.example.geting.huoshandemo.bean.RegisterBean;
import com.example.geting.huoshandemo.home.IMain;
import com.example.geting.huoshandemo.utils.OnNetLisenter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * Created by ASUS on 2017/11/8.
 */

public class MainPresenter {
    private IMain iMain;
    private String account;
    private String pwd;
    private ILoginModel iLoginModel;
    private IRegisterModel iRegisterModel;

    public MainPresenter(IMain iMain) {
        this.iMain = iMain;
        iLoginModel = new LoginModel();
        iRegisterModel = new RegisterModel();
    }
    //创建一个登陆的方法
    public void login(){
        account = iMain.getAccount();
        pwd = iMain.getPwd();
        //判断密码和用户名是否正确

            //登陆
            iLoginModel.login(account, pwd, new OnNetLisenter<LoginBean>() {
                @Override
                public void onSuccess(LoginBean loginBean) {
                    iMain.showLogin(loginBean);
                }

                @Override
                public void onFaulare(Throwable e) {

                }
            });
        }

    //创建一个注册方法
    public void register(){
        String account = iMain.getAccount();
        String pwd = iMain.getPwd();
        //判断密码和用户名是否正确

            //登陆
            iRegisterModel.register(account, pwd, new OnNetLisenter<RegisterBean>() {
                @Override
                public void onSuccess(RegisterBean registerBean) {
                    iMain.showRegister(registerBean);
                }

                @Override
                public void onFaulare(Throwable e) {

                }
            });
        }


}

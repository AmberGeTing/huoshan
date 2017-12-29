package com.example.geting.huoshandemo.bean;

/**
 * Created by ASUS on 2017/11/8.
 */

public class BaseBean {
    private String msg;
    private String code;

    @Override
    public String toString() {
        return "BaseBean{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

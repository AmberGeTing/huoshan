package com.example.geting.huoshandemo.logined.tongcheng;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geting.huoshandemo.R;

/**
 * Created by geting on 2017/12/29.
 */

public class LoginedTongFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.loginedtongfragment, container, false);
        return view;

    }
}

package com.example.geting.huoshandemo.logined;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.example.geting.huoshandemo.R;
import com.example.geting.huoshandemo.logined.record.LoginedCameraFragment;
import com.example.geting.huoshandemo.logined.homepage.HomePageFragment;
import com.example.geting.huoshandemo.logined.video.LoginedVideoFragment;
import com.example.geting.huoshandemo.logined.mine.MineFragment;
import com.example.geting.huoshandemo.logined.news.NewsFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class LoginedActivity extends AppCompatActivity {

    private BottomTabBar mBottomTabBar;
    private LinearLayout mMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logined);
        initView();
        mBottomTabBar.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(8)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("首页",R.drawable.aeb,HomePageFragment.class)
                .addTabItem("关注",R.drawable.adz, LoginedVideoFragment.class)
                .addTabItem("录制",R.drawable.a2x, LoginedCameraFragment.class)
                .addTabItem("消息",R.drawable.aed, NewsFragment.class)
                .addTabItem("我的",R.drawable.aef, MineFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }

    private void initView() {
        mBottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
        mMain = (LinearLayout) findViewById(R.id.main);
    }
}

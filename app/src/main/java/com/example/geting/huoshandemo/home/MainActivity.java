package com.example.geting.huoshandemo.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geting.huoshandemo.R;
import com.example.geting.huoshandemo.bean.LoginBean;
import com.example.geting.huoshandemo.bean.RegisterBean;
import com.example.geting.huoshandemo.home.live.LiveFragment;
import com.example.geting.huoshandemo.login.MainPresenter;
import com.example.geting.huoshandemo.logined.LoginedActivity;
import com.example.geting.huoshandemo.utils.ViewPagerIndicator;
import com.example.geting.huoshandemo.home.video.VideoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IMain {
    private List<Fragment> mFragmentList;
    private FragmentPagerAdapter orderPickingAdapter;

    ViewPagerIndicator mIndicator;

    //当前选中的indicator
    private TextView currentItem;
    private ImageView mSou;
    /**
     * 直播
     */
    private TextView mLive;
    /**
     * 已拣货
     */
    private TextView mVideo;
    /**
     * 登录/注册
     */
    private TextView mLogin;
    private ViewPager mIdVp;
    private ViewPager.OnPageChangeListener onPageChangeListener;
    private PopupWindow mPopWindow;
    private PopupWindow mPopWindow2;
    /**
     * 请输入您的手机号
     */
    private EditText mEtPhone, mEtPhone2, mPwd;
    private ImageView mQq;
    private ImageView mWeixin;
    private ImageView mCha2, mCha;
    /**
     * 下一步
     */
    private Button mNext;
    /**
     * 注册
     */
    private Button mRegister;
    private MainPresenter mainPresenter;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);
        initView();
        mIdVp.setAdapter(orderPickingAdapter);
        mIdVp.addOnPageChangeListener(onPageChangeListener);
        mIdVp.setCurrentItem(0);
        currentItem = mLive;
        currentItem.setTextColor(Color.parseColor("#ffba00"));
        //点击登录--弹一个框popwindow

        //显示poupwindow
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow();
            }
        });
        //一进入应用查询数据库
        //查询数据库
        SharedPreferences  sp = getSharedPreferences("loginUser", Context.MODE_PRIVATE);
        String state = sp.getString("state", "1");
        //判断是否登录
        if("登录成功".equals(state)){
            //跳转到另外一个布局
            Intent intent = new Intent(MainActivity.this, LoginedActivity.class);
            startActivity(intent);
        }

    }

    //pop显示的方法
    private void showPopupWindow() {
        //设置contentView
        View contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.pop_item, null);
        mPopWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mPopWindow.setContentView(contentView);
        //获取屏幕的宽度
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;     // 屏幕宽度（像素）
        mPopWindow.setWidth(width);
        //初始化组件
        mEtPhone = (EditText) contentView.findViewById(R.id.et_phone);
        mEtPhone.setOnClickListener(this);
        mPwd = (EditText) contentView.findViewById(R.id.et_pwd);
        mPwd.setOnClickListener(this);
        mQq = (ImageView) contentView.findViewById(R.id.qq);
        mQq.setOnClickListener(this);
        mWeixin = (ImageView) contentView.findViewById(R.id.weixin);
        mWeixin.setOnClickListener(this);
        mCha = (ImageView) contentView.findViewById(R.id.cha);
        mCha.setOnClickListener(this);
        mLogin = (Button) contentView.findViewById(R.id.login);
        mLogin.setOnClickListener(this);
        mRegister = (Button) contentView.findViewById(R.id.register);
        mRegister.setOnClickListener(this);
        //获得焦点

        //显示PopupWindow
        View rootview = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main, null);
        mPopWindow.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);


    }

    private void initView() {

        mSou = (ImageView) findViewById(R.id.sou);
        mLive = (TextView) findViewById(R.id.live);
        mLive.setOnClickListener(this);
        mVideo = (TextView) findViewById(R.id.video);
        mVideo.setOnClickListener(this);
        mIndicator = (ViewPagerIndicator) findViewById(R.id.indicator);
        mLogin = (TextView) findViewById(R.id.login);
        mIdVp = (ViewPager) findViewById(R.id.id_vp);
        //初始化viewpager的item，并添加到list中
        mFragmentList = new ArrayList<>();
        LiveFragment liveFragment =
                new LiveFragment();
        VideoFragment videoFragment =
                new VideoFragment();
        mFragmentList.add(liveFragment);
        mFragmentList.add(videoFragment);
        //设置viewpager的适配器；
        orderPickingAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mFragmentList.size();
            }

            @Override
            public Fragment getItem(int i) {
                return mFragmentList.get(i);
            }
        };
        //设置ViewPager监听事件
        onPageChangeListener = new ViewPager.OnPageChangeListener() {
            //滑动时，indicator下面的横线跟着滑动
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                mIndicator.scroll(i, v);
            }

            //选中监听，改变indicator文字颜色
            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        if (currentItem == mLive)
                            return;
                        mLive.setTextColor(Color.parseColor("#ffba00"));
                        currentItem.setTextColor(Color.parseColor("#646464"));
                        currentItem = mLive;
                        break;
                    case 1:
                        if (currentItem == mVideo)
                            return;
                        mVideo.setTextColor(Color.parseColor("#ffba00"));
                        currentItem.setTextColor(Color.parseColor("#646464"));
                        currentItem = mVideo;
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        };



    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.live:
                mIdVp.setCurrentItem(0);
                break;
            case R.id.video:
                mIdVp.setCurrentItem(1);
                break;
            case R.id.et_phone:
                break;
            case R.id.qq:
                //实现qq登录
                break;
            case R.id.et_pwd:
                //实现密码
                break;
            case R.id.weixin:
                //实现微信登录
                break;
            case R.id.cha:
                Toast.makeText(this, "退出", Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
                break;
            case R.id.login:
                //点击登录
                //调用登录的接口
                mainPresenter.login();

                break;
            case R.id.register:
                //点击注册--跳转到
                break;
        }
    }


    @Override
    public void showLogin(LoginBean loginBean) {
          //显示登录的内容
        Toast.makeText(MainActivity.this,loginBean.getCode()+"",Toast.LENGTH_SHORT).show();
        String code = loginBean.getCode();
        if("0".equals(code)){
            //表示登录成功
            //创建一个数据库并且存放到数据库当中
            SharedPreferences sharedPreferences = getSharedPreferences("loginUser", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();//获取编辑器
            editor.putString("state", "登录成功");
            editor.commit();//提交修改
            //跳转到另外一个布局
            Intent intent = new Intent(MainActivity.this, LoginedActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void showRegister(RegisterBean registerBean) {
          //显示注册的内容

    }

    @Override
    public String getAccount() {
        return mEtPhone.getText().toString();
    }

    @Override
    public String getPwd() {
        return mPwd.getText().toString();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(MainActivity.this,"再次进入应用",Toast.LENGTH_SHORT).show();
        //查询数据库
        SharedPreferences  sp = getSharedPreferences("loginUser", Context.MODE_PRIVATE);
        String state = sp.getString("state", "1");
        //判断是否登录
        if("登录成功".equals(state)){
            //跳转到另外一个布局
            Intent intent = new Intent(MainActivity.this, LoginedActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}

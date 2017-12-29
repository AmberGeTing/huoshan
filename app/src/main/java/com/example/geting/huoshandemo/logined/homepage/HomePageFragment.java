package com.example.geting.huoshandemo.logined.homepage;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.geting.huoshandemo.R;
import com.example.geting.huoshandemo.logined.live.LoginedLiveFragment;
import com.example.geting.huoshandemo.logined.tongcheng.LoginedTongFragment;
import com.example.geting.huoshandemo.utils.ViewPagerIndicator;
import com.example.geting.huoshandemo.logined.video.LoginedVideoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geting on 2017/12/29.
 */

public class HomePageFragment extends Fragment implements View.OnClickListener {
    private List<Fragment> mFragmentList;
    private FragmentPagerAdapter orderPickingAdapter;

    ViewPagerIndicator mIndicator;

    //当前选中的indicator
    private TextView currentItem;
    private ViewPager.OnPageChangeListener onPageChangeListener;
    private View view;
    private ImageView mSou;
    /**
     * 直播
     */
    private TextView mLive;
    /**
     * 视频
     */
    private TextView mVideo;
    /**
     * 同城
     */
    private TextView mTongcheng;
    private ViewPager mIdVp;
    private LinearLayout mMain;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homepage, container, false);

        initView(view);
        mIdVp.setAdapter(orderPickingAdapter);
        mIdVp.addOnPageChangeListener(onPageChangeListener);
        mIdVp.setCurrentItem(0);
        currentItem = mLive;
        currentItem.setTextColor(Color.parseColor("#ffba00"));
        return view;

    }

    private void initView(View view) {
        mSou = (ImageView) view.findViewById(R.id.sou);
        mLive = (TextView) view.findViewById(R.id.live);
        mLive.setOnClickListener(this);
        mVideo = (TextView) view.findViewById(R.id.video);
        mVideo.setOnClickListener(this);
        mTongcheng = (TextView) view.findViewById(R.id.tongcheng);
        mTongcheng.setOnClickListener(this);
        mIndicator = (ViewPagerIndicator) view.findViewById(R.id.indicator);
        mIdVp = (ViewPager) view.findViewById(R.id.id_vp);
        mMain = (LinearLayout) view.findViewById(R.id.main);
        //初始化viewpager的item，并添加到list中
        mFragmentList = new ArrayList<>();
        LoginedLiveFragment liveFragment =
                new LoginedLiveFragment();
        LoginedVideoFragment videoFragment =
                new LoginedVideoFragment();
        LoginedTongFragment loginedTongFragment = new LoginedTongFragment();
        mFragmentList.add(liveFragment);
        mFragmentList.add(videoFragment);
        mFragmentList.add(loginedTongFragment);

        orderPickingAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return  mFragmentList.size();
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
                    case 2:
                        if (currentItem == mTongcheng)
                            return;
                        mTongcheng.setTextColor(Color.parseColor("#ffba00"));
                        currentItem.setTextColor(Color.parseColor("#646464"));
                        currentItem = mTongcheng;
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
            case R.id.tongcheng:
                mIdVp.setCurrentItem(2);
                break;
        }
    }
}
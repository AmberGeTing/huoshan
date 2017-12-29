package com.example.geting.huoshandemo.mine;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.geting.huoshandemo.R;
import com.example.geting.huoshandemo.mine.setup.SetUpActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;


/**
 * Created by geting on 2017/12/29.
 */

public class MineFragment extends Fragment implements View.OnClickListener {
    private View view;
    private ImageView mAdd;
    /**
     * 主人
     */
    private TextView mTvTitle;
    private ImageView mShare;
    private ImageView mShezhi;
    private RelativeLayout mTi;
    private SimpleDraweeView mHead;
    /**
     * 0
     */
    private TextView mFensi;
    /**
     * 0
     */
    private TextView mGuanzhu;
    /**
     * 4
     */
    private TextView mShuoli;
    /**
     * 编辑
     */

    /**
     * 火力/钻石
     */

    /**
     * 有趣的个性签名可以吸引更多的粉丝...
     */
    private TextView mQianming;
    private TabLayout mTab;
    private ViewPager mViewpager;
    /**
     * 编辑
     */
    private Button mBianji;
    /**
     * 火力/钻石
     */
    private Button mHuoli;
    private PopupWindow mPopWindow;
    /**
     * 邀请好友加入火山
     */
    private TextView mTv;
    private ImageView mCha;
    private RelativeLayout mMa;
    /**
     * 与好友一起分享生活精彩瞬间
     */
    private TextView mF;
    /**
     * 邀请好友
     */
    private Button mYaoqing;
    private LinearLayout ll;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine, container, false);
        initView(view);
        //设置一张图片
        Uri uri = Uri.parse("http://dynamic-image.yesky.com/740x-/uploadImages/2015/163/50/690V3VHW0P77.jpg");
//        sdv.setImageURI(uri);

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        mHead.setController(controller);
        //显示popwindow
        /*showPopupWindow();
        mCha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopWindow.dismiss();
            }
        });*/
        return view;

    }

    //pop显示的方法
    private void showPopupWindow() {
        //设置contentView
        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.pop_item02, null);
        mPopWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mPopWindow.setContentView(contentView);
        //获取屏幕的宽度
        DisplayMetrics metric = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;     // 屏幕宽度（像素）
        mPopWindow.setWidth(width);
        //初始化组件
        mTv = (TextView) contentView.findViewById(R.id.tv);
        mCha = (ImageView) contentView.findViewById(R.id.cha);
        mMa = (RelativeLayout) contentView.findViewById(R.id.ma);
        mF = (TextView) contentView.findViewById(R.id.f);
        mYaoqing = (Button) contentView.findViewById(R.id.yaoqing);
        mYaoqing.setOnClickListener(this);

        //获得焦点
        //显示PopupWindow
        View rootview = LayoutInflater.from(getActivity()).inflate(R.layout.mine, null);
        mPopWindow.showAsDropDown(mShezhi);


    }

    private void initView(View view) {
        mAdd = (ImageView) view.findViewById(R.id.add);
        mTvTitle = (TextView) view.findViewById(R.id.tv_title);
        mShare = (ImageView) view.findViewById(R.id.share);
        mShezhi = (ImageView) view.findViewById(R.id.shezhi);
        mTi = (RelativeLayout) view.findViewById(R.id.ti);
        mHead = (SimpleDraweeView) view.findViewById(R.id.head);
        mFensi = (TextView) view.findViewById(R.id.fensi);
        mGuanzhu = (TextView) view.findViewById(R.id.guanzhu);
        ll = view.findViewById(R.id.ll);

        mQianming = (TextView) view.findViewById(R.id.qianming);
        mTab = (TabLayout) view.findViewById(R.id.tab);
        mViewpager = (ViewPager) view.findViewById(R.id.viewpager);
        mAdd.setOnClickListener(this);
        mTvTitle.setOnClickListener(this);
        mShare.setOnClickListener(this);
        mShezhi.setOnClickListener(this);
        mTi.setOnClickListener(this);
        mHead.setOnClickListener(this);
        mFensi.setOnClickListener(this);
        mGuanzhu.setOnClickListener(this);
        mShuoli = (TextView) view.findViewById(R.id.shuoli);
        mBianji = (Button) view.findViewById(R.id.bianji);
        mBianji.setOnClickListener(this);
        mHuoli = (Button) view.findViewById(R.id.huoli);
        mHuoli.setOnClickListener(this);
        mQianming.setOnClickListener(this);
        mTab.setOnClickListener(this);
        mViewpager.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.add:
                break;
            case R.id.tv_title:
                break;
            case R.id.share:
                break;
            case R.id.shezhi:
                //点击设置--跳转到设置的界面
                Intent intent = new Intent(getActivity(), SetUpActivity.class);
                startActivity(intent);
                break;
            case R.id.ti:
                break;
            case R.id.head:
                break;
            case R.id.fensi:
                break;
            case R.id.guanzhu:
                break;
            case R.id.bianji:
                break;
            case R.id.huoli:
                break;
            case R.id.qianming:
                break;
            case R.id.tab:
                break;
            case R.id.viewpager:
                break;
            case R.id.yaoqing:
                break;
        }
    }
}
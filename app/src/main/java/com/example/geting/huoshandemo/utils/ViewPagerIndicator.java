package com.example.geting.huoshandemo.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class ViewPagerIndicator extends LinearLayout {
 
  //画笔
  private Paint mPaint;
   //用来画一条线
  private Path mPath;
  //绘制线的宽度
  private int mLineWidth;
  //线的初始位置
  private int mInitTranslationX;
  //移动位置
  private int mTranslationX;
  //子控件
  private View mChildView;
 
  public ViewPagerIndicator(Context context) {
    super(context,null);
  }
 
  public ViewPagerIndicator(Context context, AttributeSet attrs) {
 
    super(context, attrs);
    mPaint = new Paint();
    mPaint.setAntiAlias(true);
    mPaint.setColor(Color.parseColor("#ffba00"));
    mPaint.setStrokeWidth(4);
    mPaint.setStyle(Paint.Style.STROKE);
  }
 
  //完成布局后获取子控件
  @Override
  protected void onFinishInflate() {
    super.onFinishInflate();
    mChildView = getChildAt(0);
  }
//在onSizeChanged中获取宽和初始位置，并根据位置初始化线
  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    mTranslationX = 0;
    mLineWidth = mChildView.getMeasuredWidth();
    mInitTranslationX = (w/getChildCount()-mLineWidth)/2;

    initLine();
  }
//初始化线
  private void initLine(){
    mPath = new Path();
    mPath.moveTo(0,0);
    mPath.lineTo(mLineWidth,0);

  }
//绘制线
  @Override
  protected void dispatchDraw(Canvas canvas) {
    canvas.save();
    //移动到该坐标后开始绘制
    canvas.translate(mInitTranslationX + mTranslationX,getHeight());
    canvas.drawPath(mPath,mPaint);
    canvas.restore();
    super.dispatchDraw(canvas);
  }
 
  ////在viewpager的onPageScrolled监听方法中调用此方法。viewPager滑动时mTranslationX的距离跟着变化，实现线的滑动，position，offset由onPageScrolled传值
  public void scroll(int position ,float offset){
    int tabWidth = getWidth()/getChildCount();
    mTranslationX =(int) (tabWidth * offset +tabWidth * position);
    //请求重绘，调用dispatchDraw方法
    invalidate();
  }
}
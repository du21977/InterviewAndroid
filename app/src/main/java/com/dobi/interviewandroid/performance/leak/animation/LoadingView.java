package com.dobi.interviewandroid.performance.leak.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;

import com.dobi.interviewandroid.R;

/**
 * Created by Administrator on 2018/4/23.
 * 58 加载数据动画
 */

public class LoadingView extends LinearLayout {

    private ShapeView mShapeView;//上面的形状
    private View mShadowView;//中间的阴影
    private int mTranslationDistance = 0;
    // 动画执行的时间
    private final long ANIMATOR_DURATION = 350;
    // 是否停止动画
    private boolean mIsStopAnimator = false;

    public LoadingView(Context context) {
        this(context,null);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //平移的距离等于80个像素
        mTranslationDistance = dip2px(80);
        initLayout();
    }

    //dp转px
    private int dip2px(int dip) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dip,getResources().getDisplayMetrics());
    }

    /**
     * 初始化加载布局
     */
    private void initLayout() {
        //这个不行,要加载到父控件
        //inflate(getContext(),R.layout.ui_loading_view,null);
        // this 代表把 ui_loading_view 加载到父控件  LoadingView 中，直接this
        //这个控件本来就是View,所以可以直接写inflate，一般情况下View.inflate
        //inflate(getContext(),R.layout.ui_loading_view,this);
        //加载布局最终都会走这个方法
        LayoutInflater.from(getContext()).inflate(R.layout.ui_loading_view,this);

        mShapeView = (ShapeView) findViewById(R.id.shape_view);
        mShadowView = findViewById(R.id.shadow_view);

       // startFallAnimator();
        post(new Runnable() {
            @Override
            public void run() {
                // onResume 之后View绘制流程执行完毕之后（View的绘制流程源码分析那一章）
                //开始下落动画
                startFallAnimator();
            }
        });
        // onCreate() 方法中执行 ，布局文件解析 反射创建实例

    }

    // 开始下落动画
    private void startFallAnimator() {

        if(mIsStopAnimator){
            return;
        }

        //下落位移动画
       //mShapeView.setScaleY();可以通过这种方式找动画名称
        //移动距离从0到mTranslationDistance
        ObjectAnimator translationAnimator = ObjectAnimator.ofFloat(mShapeView,"translationY",0,mTranslationDistance);
        //translationAnimator.setDuration(ANIMATOR_DURATION);
        //配合中间阴影缩小,是下面的圆
        ObjectAnimator scaleAnimator = ObjectAnimator.ofFloat(mShadowView,"scaleX",1f,0.3f);
        //scaleAnimator.setDuration(ANIMATOR_DURATION);

        //动画集合
        AnimatorSet animatorSet = new AnimatorSet();
        //执行时间
        animatorSet.setDuration(ANIMATOR_DURATION);
        //下落的速度应该是越来越快,添加加速插值器
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.playTogether(translationAnimator,scaleAnimator);
        // 先执行 translationAnimator 接着执行 scaleAnimator
        // animatorSet.playSequentially(translationAnimator,scaleAnimator);
        //开始执行动画合集
        animatorSet.start();
        //设置动画监听
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                //改变形状
                mShapeView.exchange();
                //下落完之后就上抛
                startUpAnimator();

            }
        });



    }

    /**
     * 开始执行上抛动画
     */
    private void startUpAnimator() {
        if(mIsStopAnimator){
            return;
        }
        Log.e("TAG","startUpAnimator"+this);
        //Log.e("TAG","startUpAnimator");
        // 动画作用在谁的身上
        // 下落位移动画
        ObjectAnimator translationAnimator = ObjectAnimator.ofFloat(mShapeView,"translationY",mTranslationDistance,0);
        //translationAnimator.setDuration(ANIMATOR_DURATION);
        // 配合中间阴影缩小
        ObjectAnimator scaleAnimator = ObjectAnimator.ofFloat(mShadowView,"scaleX",0.3f,1f);
        //scaleAnimator.setDuration(ANIMATOR_DURATION);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(ANIMATOR_DURATION);
        //添加减速插值器
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.playTogether(translationAnimator,scaleAnimator);
        // 先执行 translationAnimator 接着执行 scaleAnimator
        // animatorSet.playSequentially(translationAnimator,scaleAnimator);
        // 上抛完之后就下落了，监听动画执行完毕
        // 是一种思想，在 Adapter 中的 BannerView 写过
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                // 上抛完之后就下落了
                startFallAnimator();
            }
            @Override
            public void onAnimationStart(Animator animation) {
                // 开始旋转
                startRotationAnimator();
            }
        });
        // 执行 -> 监听的 onAnimationStart 方法
        animatorSet.start();

    }

    /**
     * 上抛的时候需要旋转
     */
    private void startRotationAnimator() {
        ObjectAnimator rotationAnimator = null;
        switch (mShapeView.getCurrentShape()){
            case Circle:
            case Square:
                // 180
                rotationAnimator = ObjectAnimator.ofFloat(mShapeView,"rotation",0,180);
                break;
            case Triangle:
                // 120
                rotationAnimator = ObjectAnimator.ofFloat(mShapeView,"rotation",0,-120);
                break;
        }
        rotationAnimator.setDuration(ANIMATOR_DURATION);
        rotationAnimator.setInterpolator(new DecelerateInterpolator());
        rotationAnimator.start();

    }

    @Override
    public void setVisibility(int visibility) {
        super.setVisibility(View.INVISIBLE);// 不要再去排放和计算，少走一些系统的源码（View的绘制流程）
        // 清理动画
        mShapeView.clearAnimation();
        mShadowView.clearAnimation();
        // 把LoadingView从父布局移除
        ViewGroup parent = (ViewGroup) getParent();
        if(parent != null){
            parent.removeView(this);// 从父布局移除
            removeAllViews();// 移除自己所有的View
        }
        mIsStopAnimator = true;
    }


}

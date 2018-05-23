package com.dobi.interviewandroid.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dobi.interviewandroid.R;


/**
 * 用属性动画实现补间动画
 */
public class ObjectAnimator1 extends Activity {
	private ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_objectanimator);
		iv = (ImageView) findViewById(R.id.iv);
	}
	/**
	 * 透明度
	 * @param view
	 */
	public void alpha(View view){
//		iv.setAlpha(alpha);
//		iv.getAlpha()
		ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "alpha", 0.0f,0.2f,0.4f,0.6f,0.8f,1.0f);
		oa.setDuration(4000);
		oa.setRepeatMode(ObjectAnimator.REVERSE);
		oa.setRepeatCount(ObjectAnimator.INFINITE);
		oa.start();
	}
	/**
	 * 旋转动画
	 * @param view
	 */
	public void rotate(View view){
		//iv.setRotationY(rotationY)
		ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "rotationX", 0.0f,30f,60.0f,90f);
		oa.setDuration(2000);
		oa.setRepeatMode(ObjectAnimator.REVERSE);
		oa.setRepeatCount(ObjectAnimator.INFINITE);
		oa.start();
	}
	/**
	 * 缩放
	 * @param view
	 */
	public void scale(View view){
		//iv.setScaleX()
		ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "scaleY", 0.0f,0.2f,0.5f,2.0f);
		oa.setDuration(2000);
		oa.setRepeatMode(ObjectAnimator.REVERSE);
		oa.setRepeatCount(ObjectAnimator.INFINITE);
		oa.start();
	}

	/**
	 * 位移
	 * @param view
	 */
	public void trans(View view){
		//iv.setScaleX()
		//iv.setTranslationX()
		ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "translationX", 0.0f,30f,60f,200f);
		oa.setDuration(2000);
		oa.setRepeatMode(ObjectAnimator.REVERSE);
		oa.setRepeatCount(ObjectAnimator.INFINITE);
		oa.start();
	}

	public void set(View view){
		System.out.println("---");
		//动画的集合
		AnimatorSet set = new AnimatorSet();
		ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "rotation", 0.0f,30f,60.0f,90f);
		oa.setDuration(4000);
		ObjectAnimator oa2 = ObjectAnimator.ofFloat(iv, "translationX", 0.0f,10f,20,40f,60f,100f,200f,600f);
		oa2.setDuration(2000);
		//set.playSequentially(oa,oa2);
		set.playTogether(oa,oa2);
		set.start();
	}

}

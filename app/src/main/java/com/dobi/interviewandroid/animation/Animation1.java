package com.dobi.interviewandroid.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.dobi.interviewandroid.R;


public class Animation1 extends Activity {
	private ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animation1);
		iv = (ImageView) findViewById(R.id.iv);
	}

	/**
	 * 透明度变化的动画
	 *
	 * @param view
	 */
	public void alpha(View view) {
		// 完全透明0.0f->完全不透明1.0f
		AlphaAnimation aa = new AlphaAnimation(0.0f, 1.0f);
		// 动画播放2秒
		aa.setDuration(2000);
		aa.setRepeatCount(2);
		aa.setRepeatMode(Animation.REVERSE);
		iv.startAnimation(aa);
	}

	/**
	 * 缩放动画
	 *
	 * @param view
	 */
	public void scale(View view) {
		ScaleAnimation sa = new ScaleAnimation(0.0f, 2.0f, 0.0f, 2.0f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		sa.setDuration(2000);
		sa.setRepeatCount(2);
		sa.setRepeatMode(Animation.REVERSE);
		iv.startAnimation(sa);
	}

	/**
	 * 位移动画
	 *
	 * @param view
	 */
	public void Trans(View view) {
		TranslateAnimation ta = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, -0.5f, Animation.RELATIVE_TO_SELF, 0.5f,
				Animation.RELATIVE_TO_SELF, -0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		ta.setDuration(2000);
		ta.setRepeatCount(2);
		ta.setRepeatMode(Animation.REVERSE);
		iv.startAnimation(ta);
	}
	/**
	 * 旋转动画
	 *
	 * @param view
	 */
	public void rotate(View view) {
		RotateAnimation ra = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF,
				0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		ra.setDuration(2000);
		ra.setRepeatCount(2);
		ra.setRepeatMode(Animation.REVERSE);
		iv.startAnimation(ra);
	}

	public void set(View view){
		AnimationSet set = new AnimationSet(false);
		TranslateAnimation ta = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, -0.5f, Animation.RELATIVE_TO_SELF, 0.5f,
				Animation.RELATIVE_TO_SELF, -0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		ta.setDuration(2000);
		ta.setRepeatCount(2);
		ta.setRepeatMode(Animation.REVERSE);
		RotateAnimation ra = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF,
				0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		ra.setDuration(2000);
		ra.setRepeatCount(2);
		ra.setRepeatMode(Animation.REVERSE);
		ScaleAnimation sa = new ScaleAnimation(0.0f, 2.0f, 0.0f, 2.0f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		sa.setDuration(2000);
		sa.setRepeatCount(2);
		sa.setRepeatMode(Animation.REVERSE);
		set.addAnimation(sa);
		set.addAnimation(ta);
		set.addAnimation(ra);
		iv.startAnimation(set);
	}
}

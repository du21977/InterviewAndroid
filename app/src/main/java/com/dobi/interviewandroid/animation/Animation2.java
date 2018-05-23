package com.dobi.interviewandroid.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.dobi.interviewandroid.R;


/**
 * 补间动画用xml的形式加载
 */
public class Animation2 extends Activity {
	private ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animation2);
		iv = (ImageView) findViewById(R.id.iv);
	}

	/**
	 * 透明度变化的动画
	 *
	 * @param view
	 */
	public void alpha(View view) {
		Animation aa = AnimationUtils.loadAnimation(this, R.anim.alpha);
		iv.startAnimation(aa);
	}

	/**
	 * 缩放动画
	 *
	 * @param view
	 */
	public void scale(View view) {
		Animation sa = AnimationUtils.loadAnimation(this, R.anim.scale);
		iv.startAnimation(sa);
	}

	/**
	 * 位移动画
	 *
	 * @param view
	 */
	public void Trans(View view) {
		Animation ta = AnimationUtils.loadAnimation(this, R.anim.trans);
		iv.startAnimation(ta);
	}
	/**
	 * 旋转动画
	 *
	 * @param view
	 */
	public void rotate(View view) {
		Animation ra = AnimationUtils.loadAnimation(this, R.anim.rotate);
		iv.startAnimation(ra);
	}

	public void set(View view){
		Animation set = AnimationUtils.loadAnimation(this, R.anim.set);
		iv.startAnimation(set);
	}
}

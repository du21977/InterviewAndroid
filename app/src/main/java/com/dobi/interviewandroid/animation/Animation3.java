package com.dobi.interviewandroid.animation;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import com.dobi.interviewandroid.R;


/**
 * 补间动画与属性动画的区别
 * 补间动画运动时，点击没效果，实际位置没有跟着变化
 */
public class Animation3 extends Activity {
	private ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animation3);
		iv = (ImageView) findViewById(R.id.iv);
		iv.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "萌萌哒~么么", Toast.LENGTH_LONG).show();
			}
		});
//      补间动画
//		TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f,
//				Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.5f);
//		ta.setDuration(4000);
//		ta.setRepeatCount(Animation.INFINITE);//不停止,一直播放
//		ta.setRepeatMode(Animation.REVERSE);
//		iv.startAnimation(ta);

//		属性动画
		ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "translationX", 0,10.0f,20.0f,30.0f,40.0f,100.0f,200.0f);
		oa.setDuration(5000);//设置动画时间
		oa.setRepeatCount(ObjectAnimator.INFINITE);//设置动画次数，-1代表无限次
		oa.setRepeatMode(ObjectAnimator.REVERSE);//设置动画模式
		//oa.setInterpolator(new DecelerateInterpolator());//设置减速插值器
		oa.setInterpolator(new LinearInterpolator());//设置匀速插值器
		oa.start();
	}
}

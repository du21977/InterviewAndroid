package com.dobi.interviewandroid.performance.leak.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dobi.interviewandroid.R;

/**
 * 解决动画死循环造成的内存泄漏
 * 通过将自定义控件从父控件中移除，并且设置标志位让循环停止
 */
public class LeakAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_animation);
    }

    public void click(View view){
        view.setVisibility(View.GONE);
    }

    public void start(View view){
        Intent intent = new Intent(this,LeakAnimationActivity.class);
        startActivity(intent);
    }
}

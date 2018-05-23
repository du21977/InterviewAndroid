package com.dobi.interviewandroid.handler;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.dobi.interviewandroid.R;

import java.lang.ref.WeakReference;

/**
 * 防止Handler引起内存泄漏
 *
 * 1.使用静态内部类
 * 2.实在要使用外部类数据，持有外部类弱引用
 * 3.在onDestroy时移除Handler
 */
public class Handler2Activity extends AppCompatActivity {

    private MyHandler mHandler = new MyHandler(this);
    private TextView mTextView;

    //静态内部类
    private static  class  MyHandler extends Handler{
        private WeakReference<Context> reference;
        public MyHandler(Context context){
            reference = new WeakReference<>(context);
        }

        @Override
        public void handleMessage(Message msg) {
            Handler2Activity activity = (Handler2Activity) reference.get();
            if(activity !=null){
                activity.mTextView.setText("haha");
            }

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler2);
        loadData();
    }

    private void loadData() {
        Message message = Message.obtain();
        mHandler.sendMessage(message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //
        mHandler.removeCallbacksAndMessages(null);
    }
}

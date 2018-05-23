package com.dobi.interviewandroid.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.dobi.interviewandroid.R;

/**
 * 子线程与主线程通信通过Handler
 */
public class HandlerActivity extends AppCompatActivity {

    //容易造成内存泄漏
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
           switch (msg.what){
               case 1:
                   break;
           }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hander);

        MyThread myThread = new MyThread();
        myThread.start();

    }


   class MyThread extends  Thread{
       @Override
       public void run() {
           Message msg = Message.obtain();
           mHandler.sendMessage(msg);
           super.run();
       }
   }
}

package com.dobi.interviewandroid.handlerthread;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.dobi.interviewandroid.R;

/**
 * 在子线程中创建Handler，并处理消息，说白了，就是为了减轻主线程的压力
 */
public class HandlerThreadActivity extends AppCompatActivity {

    Handler mHandler1;

    private HandlerThread myHandlerThread ;
    private Handler handler ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread);

        initData();
    }

    /**
     * Handler在子线程中处理，说白了就是给主线程减小压力
     */
    private void initData() {
        //创建一个线程,线程名字：handler-thread
        myHandlerThread = new HandlerThread( "handler-thread") ;
        //开启一个线程
        myHandlerThread.start();
        //在这个线程中创建一个handler对象，对实际上在子线程
        handler = new Handler( myHandlerThread.getLooper() ){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //这个方法是运行在 handler-thread 线程中的 ，可以执行耗时操作
                Log.d( "handler " , "消息： " + msg.what + "  线程： " + Thread.currentThread().getName()  ) ;

            }
        };

        //在主线程给handler发送消息，消息会在子线程中被处理
        handler.sendEmptyMessage( 1 ) ;

        new Thread(new Runnable() {
            @Override
            public void run() {
                //在子线程给handler发送数据
                handler.sendEmptyMessage( 2 ) ;
            }
        }).start() ;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //释放资源
        myHandlerThread.quit() ;
    }


    /**
     * 自己的线程
     * 要new Handler 必须有looper
     */
    class MyThread extends  Thread{
        @Override
        public void run() {
            super.run();

            Looper.prepare();
            mHandler1 = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    Log.e("threadName--" , Thread.currentThread().getName()+"  " +msg.what);
                }
            };

            try{
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            mHandler1.sendEmptyMessage(2);
            Looper.loop();
        }
    }
}

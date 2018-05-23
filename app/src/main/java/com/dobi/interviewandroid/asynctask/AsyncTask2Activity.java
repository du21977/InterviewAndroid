package com.dobi.interviewandroid.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

import com.dobi.interviewandroid.R;

import java.lang.ref.WeakReference;

/**
 * 解决 AysncTask内存泄漏
 */
public class AsyncTask2Activity extends AppCompatActivity {

    MyAsyncTask myAsyncTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task2);

         myAsyncTask = new MyAsyncTask(this);
        //可以传参
        myAsyncTask.execute();

    }

    /**
     * 测试内存泄漏
     */
    private void testThreadLeak() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                SystemClock.sleep(10000);
                return null;
            }
        }.execute();

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(10000);
            }
        }).start();
    }

    /**
     * 使用静态内部类和弱引用解决内存泄漏
     */
    static class MyAsyncTask extends AsyncTask<Void, Void, Void> {
        private WeakReference<Context> weakReference;

        public MyAsyncTask(Context context) {
            weakReference = new WeakReference<>(context);
        }

        @Override
        protected Void doInBackground(Void... params) {
            SystemClock.sleep(10000);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            AsyncTask2Activity activity = (AsyncTask2Activity) weakReference.get();
            if (activity != null) {
                //...
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        myAsyncTask.cancel(true);
    }
}

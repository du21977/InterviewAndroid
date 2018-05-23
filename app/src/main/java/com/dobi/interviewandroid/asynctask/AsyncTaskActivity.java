package com.dobi.interviewandroid.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dobi.interviewandroid.R;

/**
 * 基本使用
 */
public class AsyncTaskActivity extends AppCompatActivity {


    TextView mTextView;
    ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        mTextView = (TextView) findViewById(R.id.tv_asynctask);
        mProgressBar = (ProgressBar) findViewById(R.id.pb_asynctask);

        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();

    }

    /**
     * 第一个参数
     * 第二个参数：进度
     * 第三个参数：返回的结果
     */
    class MyAsyncTask extends AsyncTask<Integer,Integer,String>{


        @Override
        protected String doInBackground(Integer... params) {
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String result) {
            mTextView.setText("执行完成" + result);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            int value = values[0];
           mProgressBar.setProgress(value);
        }
    }
}

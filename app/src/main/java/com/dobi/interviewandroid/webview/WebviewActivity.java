package com.dobi.interviewandroid.webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.dobi.interviewandroid.R;


/**
 * 用进程方式
 */
public class WebviewActivity extends AppCompatActivity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        mWebView = (WebView) findViewById(R.id.wv_show);
        mWebView.loadUrl("http://www.baidu.com");
    }


    @Override
    protected void onDestroy() {
        destroyWebView();
        android.os.Process.killProcess(android.os.Process.myPid());
        super.onDestroy();
    }

    private void destroyWebView() {
        if (mWebView != null) {
            mWebView.pauseTimers();
            mWebView.removeAllViews();
            mWebView.destroy();
            mWebView = null;
        }
    }
}

package com.dobi.interviewandroid.webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.dobi.interviewandroid.R;

/**
 * 动态添加webview，防止内存泄漏
 * https://www.jianshu.com/p/3e8f7dbb0dc7
 */
public class Webview2Activity extends AppCompatActivity {

    LinearLayout linearLayout ;
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview2);
        linearLayout = (LinearLayout) findViewById(R.id.ll_webview);
        initData();
    }

    private void initData() {
        mWebView = new WebView(getApplicationContext());
        linearLayout.addView(mWebView);

    }

    @Override
    protected void onDestroy() {
        if( mWebView!=null) {

            // 如果先调用destroy()方法，则会命中if (isDestroyed()) return;这一行代码，需要先onDetachedFromWindow()，再
            // destory()

            //从父控件中移除
            ViewParent parent = mWebView.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(mWebView);
            }

            mWebView.stopLoading();
            // 退出时调用此方法，移除绑定的服务，否则某些特定系统会报错
            mWebView.getSettings().setJavaScriptEnabled(false);
            mWebView.clearHistory();
            mWebView.clearView();
            mWebView.removeAllViews();
            mWebView.destroy();

        }


        super.onDestroy();
    }
}

package com.dobi.interviewandroid.performance.leak;

import android.content.Context;

/**
 * Created by Administrator on 2018/5/22.
 * 双重锁TCL
 * 同时使用getApplicationContext防止内存泄漏
 *
 */

public class Singleton {

    //volatile线程可见性 和 禁止重排序
    public static volatile Singleton mSingleton;
    private Context mContext;

    private Singleton(Context context){
        mContext = context.getApplicationContext();
    }

    public static Singleton getInstance(Context context){

        if(mSingleton ==null){
            synchronized (Singleton.class){
                if(mSingleton==null){
                    mSingleton = new Singleton(context);
                }
            }

        }
        return  mSingleton;

    }
}

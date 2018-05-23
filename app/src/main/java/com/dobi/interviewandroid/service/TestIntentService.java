package com.dobi.interviewandroid.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2018/5/21.
 */

public class TestIntentService extends IntentService {


    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public TestIntentService(String name) {
        super(name);
    }

    /**
     * 实现异步任务，处理耗时任务
     * @param intent
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }


}

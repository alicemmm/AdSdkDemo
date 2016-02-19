package com.perasia.mylibrary.service;


import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.perasia.mylibrary.netWork.LihttpUrlUtil;

import java.util.concurrent.atomic.AtomicInteger;

public class LiCoreService extends IntentService {
    private static final String TAG = LiCoreService.class.getSimpleName();

    public static final String ACTION_ONE = "perasia.mylibrary.intent.action.ONE";
    public static final String ACTION_TWO = "perasia.mylibrary.intent.action.TWO";

    public LiCoreService() {
        super("LiCoreService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void setIntentRedelivery(boolean enabled) {
        super.setIntentRedelivery(enabled);
        Log.e(TAG, "setIntentRedelivery");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.e(TAG, "onHandleIntent");

        if (intent == null) {
            return;
        }

        String action = intent.getAction();

        if (action.equals(ACTION_ONE)) {
            Log.e(TAG, "action one");
            actionOne();
        } else if (action.equals(ACTION_TWO)) {
            actionTwo();
        }

    }

    private void actionOne() {

        AtomicInteger i = new AtomicInteger(0);

        do {
            try {
                Thread.sleep(5000);
                Log.e(TAG, "one sleep tip");
                String res = LihttpUrlUtil.getUrlResponse("http://192.168.5.110:88/");
                Log.e(TAG, "res=" + res);

                i.getAndIncrement();

                Log.e(TAG, "i=" + i.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (i.get() < 2);
    }

    private void actionTwo() {
        try {
            Thread.sleep(3000);
            Log.e(TAG, "action two");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }
}

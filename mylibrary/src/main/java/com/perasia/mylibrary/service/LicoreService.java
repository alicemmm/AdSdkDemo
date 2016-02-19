package com.perasia.mylibrary.service;


import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

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
        }

    }

    private void actionOne() {
        do {
            try {
                Thread.sleep(5000);
                Log.e(TAG, "one sleep tip");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }
}

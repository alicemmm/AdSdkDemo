package com.perasia.mylibrary.service;


import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.text.TextUtils;

public class LiCoreService extends Service {
    private static final String TAG = LiCoreService.class.getSimpleName();

    public static final String ACTION_START = "com.perasia.mylibrary.intent.action.START";

    private volatile LiHandler mCoreHandler;

    private final class LiHandler extends Handler{
        public LiHandler(){

        }
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        do {
            if (intent == null) {
                break;
            }

            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                break;
            }

            if (action.equals(ACTION_START)) {

            }

        } while (false);

        return Service.START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

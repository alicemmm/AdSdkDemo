package com.perasia.mylibrary.receiver;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LiOpenReceiver extends BroadcastReceiver {
    private static final String TAG = LiOpenReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        if (null == context || null == intent) {
            return;
        }

        String action = intent.getAction();
        if (Intent.ACTION_BOOT_COMPLETED.equals(action)) {

        } else if (intent.ACTION_CONFIGURATION_CHANGED.equals(action)) {

        }else if(Intent.ACTION_USER_PRESENT.equals(action)){

        }


    }
}

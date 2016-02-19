package com.perasia.mylibrary;


import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.perasia.mylibrary.service.LiCoreService;

public class Cnxad {
    private static final String TAG = Cnxad.class.getSimpleName();

    public static void init(Context context) {
        if (context == null) {
            Log.e(TAG, "cnxad init failed");
            return;
        }

        String appId = LiPhoneInfo.getAppKey(context);

        if (TextUtils.isEmpty(appId)) {
            Log.e(TAG, "cnxad init failed");
            return;
        }

        Intent intent = new Intent(context, LiCoreService.class);
        intent.setAction(LiCoreService.ACTION_ONE);
        context.startService(intent);
    }

    /**
     * model so so
     */
    public static void init(Context context, String appid) {
        String appId = appid;
        if (TextUtils.isEmpty(appid)) {
            appId = LiPhoneInfo.getAppKey(context);
        }

        if (TextUtils.isEmpty(appId)) {
            Log.e(TAG, "cnxad init failed");
        }

    }

    public static void setBanner(Context context, LiBannerView liBannerView) {
        Glide.with(context).load("http://source.jisuoping.com/image/20160113163953920.jpg").into(liBannerView);


    }
}

package com.perasia.mylibrary;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import com.perasia.mylibrary.netWork.LihttpUrlUtil;
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

        Intent intent1 = new Intent(context, LiCoreService.class);
        intent1.setAction(LiCoreService.ACTION_TWO);
        context.startService(intent1);
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

    public static void setBanner(LiBannerView liBannerView) {
        String imgUrl = "http://source.jisuoping.com/image/20160120152355188.jpg";
        new DownImgAsyncTask(liBannerView).execute(imgUrl);
    }

    static class DownImgAsyncTask extends AsyncTask<String, Void, Bitmap> {
        LiBannerView liBannerView;

        public DownImgAsyncTask(LiBannerView liBannerView) {
            this.liBannerView = liBannerView;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap b = LihttpUrlUtil.getImageBitmap(params[0]);
            return b;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute(result);
            if (result != null) {
                liBannerView.setImageBitmap(result);
            }
        }

    }
}

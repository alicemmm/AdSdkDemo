package com.perasia.adsdkdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.perasia.mylibrary.Cnxad;
import com.perasia.mylibrary.LiBannerView;
import com.perasia.mylibrary.LiPhoneInfo;
import com.perasia.mylibrary.service.LiCoreService;

import xvideo.ji.com.jiad.JiHttpUtils;

public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        init();
    }

    private void init() {

        LiBannerView banner = (LiBannerView) findViewById(R.id.about_banner);
        Cnxad.setBanner(mContext, banner);

        Log.e(TAG, "appkey=" + LiPhoneInfo.getAppKey(mContext));

        Intent intentService = new Intent(mContext,LiCoreService.class);
        intentService.setAction(LiCoreService.ACTION_ONE);
        startService(intentService);

        Intent intentService2 = new Intent(mContext,LiCoreService.class);
        intentService2.setAction(LiCoreService.ACTION_TWO);
        startService(intentService2);

        JiHttpUtils.test(mContext);

    }

}

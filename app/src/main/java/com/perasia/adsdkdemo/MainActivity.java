package com.perasia.adsdkdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.perasia.mylibrary.Cnxad;
import com.perasia.mylibrary.LiBannerView;
import com.perasia.mylibrary.LiPhoneInfo;

import java.util.HashMap;
import java.util.Map;

import xvideo.ji.com.jiad.JiHttpPostUtil;

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
        Cnxad.init(mContext);

        LiBannerView banner = (LiBannerView) findViewById(R.id.about_banner);
        Cnxad.setBanner(banner);

        Log.e(TAG, "appkey=" + LiPhoneInfo.getAppKey(mContext));

//        Intent intentService = new Intent(mContext, LiCoreService.class);
//        intentService.setAction(LiCoreService.ACTION_ONE);
//        startService(intentService);
//
//        Intent intentService2 = new Intent(mContext, LiCoreService.class);
//        intentService2.setAction(LiCoreService.ACTION_TWO);
//        startService(intentService2);


        final Map<String, String> map = new HashMap<>();
//        final String url = "http://www.baidu.com";
        final String url = "http://192.168.5.110:88/";

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                JiHttpPostUtil.sendPostMessage(map, "UTF-8", url);
            }
        });

        thread.start();


//
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String res = LihttpUrlUtil.getUrlResponse("http://www.baidu.com/");
//                Log.e(TAG, "res=" + res);
//            }
//        });


    }

}

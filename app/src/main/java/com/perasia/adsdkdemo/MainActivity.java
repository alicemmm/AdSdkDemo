package com.perasia.adsdkdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.perasia.mylibrary.Cnxad;
import com.perasia.mylibrary.LiBannerView;
import com.perasia.mylibrary.LiPhoneInfo;

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
        LiPhoneInfo info = new LiPhoneInfo(mContext);
        Log.e(TAG, "devices id: " + info.getDeviceId());
        Log.e(TAG, "getPhoneModule: " + info.getPhoneModule());
        Log.e(TAG, "getSerialNumber: " + info.getSerialNumber());
        Log.e(TAG, "getPhoneNumber: " + info.getPhoneNumber());
        Log.e(TAG, "getMacAddress: " + info.getMacAddress());
        Log.e(TAG, "getCpuInfo: " + info.getCpuInfo());
        Log.e(TAG, "getTotalMemory: " + info.getTotalMemory());

        LiBannerView banner = (LiBannerView) findViewById(R.id.about_banner);
        Cnxad.setBanner(mContext, banner);


    }


}

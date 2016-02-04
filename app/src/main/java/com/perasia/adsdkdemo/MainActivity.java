package com.perasia.adsdkdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.perasia.mylibrary.Cnxad;
import com.perasia.mylibrary.LiBannerView;

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


    }


}

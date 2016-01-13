package com.perasia.mylibrary;

import android.app.Activity;
import android.os.Bundle;

import com.perasia.mylibrary.util.LiResourceUtil;

public class ShowLiActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LiResourceUtil.getLayoutId(this, "activity_show_li"));
    }
}

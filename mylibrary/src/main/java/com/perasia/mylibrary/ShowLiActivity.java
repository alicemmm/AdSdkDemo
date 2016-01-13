package com.perasia.mylibrary;

import android.app.Activity;
import android.os.Bundle;

public class ShowLiActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ResourceUtil.getLayoutId(this, "activity_show_li"));
    }
}

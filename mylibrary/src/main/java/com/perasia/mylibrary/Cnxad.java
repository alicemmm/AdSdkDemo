package com.perasia.mylibrary;


import android.content.Context;

import com.bumptech.glide.Glide;

public class Cnxad {

    public static void setBanner(Context context, LiBannerView liBannerView){
        Glide.with(context).load("http://source.jisuoping.com/image/20160113163953920.jpg").into(liBannerView);
    }
}

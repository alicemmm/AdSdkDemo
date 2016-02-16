package com.perasia.mylibrary;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;


public class LiBannerView extends ImageView {

    private Context mContext;

    public LiBannerView(Context context) {
        super(context);
        mContext = context;
    }

    public LiBannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mContext.startActivity(new Intent(mContext, ShowLiActivity.class));
        return super.onTouchEvent(event);
    }
}

package com.perasia.mylibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;


public class LiAdView extends RelativeLayout {
    private static final String TAG = LiAdView.class.getSimpleName();

    public LiAdView(Context context) {
        super(context);
    }

    public LiAdView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}

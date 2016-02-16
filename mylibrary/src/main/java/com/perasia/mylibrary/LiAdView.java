package com.perasia.mylibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;


public class LiAdView extends RelativeLayout {
    private static final String TAG = LiAdView.class.getSimpleName();

    private static final int TIME_SPAN = 3000;

    private Context mContext;

    public LiAdView(Context context) {
        this(context, null);
    }

    public LiAdView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}

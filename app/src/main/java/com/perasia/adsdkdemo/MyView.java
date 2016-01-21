package com.perasia.adsdkdemo;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    private Paint mPaint;

    public MyView(Context context) {
        super(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyView);
        int textcolor = a.getColor(R.styleable.MyView_textColor, 0xffffffff);
        float textsize = a.getDimension(R.styleable.MyView_textSize, 36);
        mPaint.setTextSize(textsize);
        mPaint.setColor(textcolor);
        a.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(new Rect(10, 10, 100, 100), mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawText("this is a dog", 10, 110, mPaint);
    }
}

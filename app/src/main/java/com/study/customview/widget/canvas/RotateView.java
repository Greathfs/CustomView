package com.study.customview.widget.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by HFS on 2017/2/7.
 */

public class RotateView extends View {
    public RotateView(Context context) {
        super(context);
    }

    public RotateView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);

        Rect rect1 = new Rect(0,0,400,220);
        canvas.drawRect(rect1, paint);

//        //不指定旋转中心
//        canvas.rotate(30);
//        paint.setColor(Color.RED);
//        Rect rect2 = new Rect(0,0,400,220);
//        canvas.drawRect(rect2, paint);

        //指定旋转中心
        canvas.rotate(180,200,220);
        paint.setColor(Color.RED);
        Rect rect2 = new Rect(0,0,400,220);
        canvas.drawRect(rect2, paint);
    }
}

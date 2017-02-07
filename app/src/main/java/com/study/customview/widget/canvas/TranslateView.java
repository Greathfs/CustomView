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
 * Canvas平移
 */

public class TranslateView extends View {

    public TranslateView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TranslateView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        //未平移
        Rect rect1 = new Rect(0,0,400,220);
        canvas.drawRect(rect1, paint);
        //平移
        paint.setColor(Color.RED);
        canvas.translate(500,300);
        Rect rect2 = new Rect(0,0,400,220);
        canvas.drawRect(rect2, paint);

    }
}

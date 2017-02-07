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

public class SkewView extends View {
    public SkewView(Context context) {
        super(context);
    }

    public SkewView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //skew 扭曲
        Paint paint=new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);

        Rect rect = new Rect(0,0,200,200);

        canvas.drawRect(rect, paint);
        canvas.skew(1,0);//X轴倾斜45度，Y轴不变
        paint.setColor(Color.RED);
        canvas.drawRect(rect, paint);
    }
}

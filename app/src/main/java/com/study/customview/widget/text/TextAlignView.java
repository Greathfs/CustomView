package com.study.customview.widget.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by HFS on 2017/2/12.
 */

public class TextAlignView extends View {
    public TextAlignView(Context context) {
        super(context);
    }

    public TextAlignView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        //设置基本属性
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(120);


//        paint.setTextAlign(Paint.Align.LEFT);
//        paint.setTextAlign(Paint.Align.RIGHT);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("abcdefghijk", 200, 200, paint);
        //绘制坐标系
        paint.setColor(Color.BLUE);
        canvas.drawLine(0, 200, getWidth(), 200, paint);
        canvas.drawLine(200, 0, 200, getHeight(), paint);

    }
}

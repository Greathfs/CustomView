package com.study.customview.widget.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by HFS on 2017/2/7.
 */

public class ScaleView extends View {
    public ScaleView(Context context) {
        super(context);
    }

    public ScaleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint=new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);

        canvas.translate(400,400);

        RectF rectF=new RectF(0,0,400,400);
        canvas.drawRect(rectF,paint);
//        //未控制缩放点
//        canvas.scale(0.5f,0.5f);
//
//        paint.setColor(Color.RED);
//        canvas.drawRect(rectF,paint);

//        //控制缩放点
//        //缩放中心向右偏移了200个单位
//        canvas.scale(0.5f,0.5f,200,0);
//
//        paint.setColor(Color.RED);
//        canvas.drawRect(rectF,paint);

//        //指定负数缩放比例
//        canvas.scale(-0.5f,-0.5f);
////
//        paint.setColor(Color.RED);
//        canvas.drawRect(rectF,paint);


        //指定负数缩放比例
        canvas.scale(-0.5f,-0.5f,200,0);
//
        paint.setColor(Color.RED);
        canvas.drawRect(rectF,paint);

    }
}

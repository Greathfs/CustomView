package com.study.customview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by HFS on 2017/2/4.
 * 椭圆V
 */

public class OvalView extends View {
    private Paint mPaint=new Paint();

    public OvalView(Context context) {
        super(context);

        initPaint();
    }

    public OvalView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public OvalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(10f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //为了说明绘制椭圆原理这里加一段代码
        Rect rect=new Rect(100,100,800,400);
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(rect,mPaint);

        //第一种
        RectF rectF=new RectF(100,100,800,400);
        mPaint.setColor(Color.BLACK);
        canvas.drawOval(rectF,mPaint);

        //第二种
//        canvas.drawOval(100,100,800,400,mPaint);
    }
}

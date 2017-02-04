package com.study.customview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by HFS on 2017/2/4.
 * 点View
 */

public class PointView extends View {

    private Paint mPaint=new Paint();

    public PointView(Context context) {
        super(context);

        initPaint();
    }

    public PointView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public PointView(Context context, AttributeSet attrs, int defStyleAttr) {
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
        //画一个点
        canvas.drawPoint(200,300,mPaint);

        //画一组点
        canvas.drawPoints(new float[]{
                500,600,
                500,700,
                500,800,
                500,900

        },mPaint);
   }
}

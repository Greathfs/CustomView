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
 * 圆角矩形View
 */

public class RoundRectView extends View {
    private Paint mPaint=new Paint();

    public RoundRectView(Context context) {
        super(context);

        initPaint();
    }

    public RoundRectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public RoundRectView(Context context, AttributeSet attrs, int defStyleAttr) {
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

        RectF rect=new RectF(100,100,800,400);
        canvas.drawRoundRect(rect,30,30,mPaint);
    }
}

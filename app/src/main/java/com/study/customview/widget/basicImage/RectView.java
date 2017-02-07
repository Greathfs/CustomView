package com.study.customview.widget.basicImage;

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
 * 矩形View
 */

public class RectView extends View {
    private Paint mPaint=new Paint();

    public RectView(Context context) {
        super(context);

        initPaint();
    }

    public RectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public RectView(Context context, AttributeSet attrs, int defStyleAttr) {
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

        //第一种
        canvas.drawRect(200,300,500,600,mPaint);
        //第二种
        Rect rect=new Rect(200,300,500,600);
        canvas.drawRect(rect,mPaint);
        //第三种
        RectF rectF=new RectF(200,300,500,600);
        canvas.drawRect(rectF,mPaint);
    }
}

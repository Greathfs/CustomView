package com.study.customview.widget.basicImage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by HFS on 2017/2/4.
 * 直线View
 */

public class LineView extends View {
    private Paint mPaint=new Paint();

    public LineView(Context context) {
        super(context);

        initPaint();
    }

    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public LineView(Context context, AttributeSet attrs, int defStyleAttr) {
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
        //从（200，300）这个点开始 到(500,600)这个点结束
        canvas.drawLine(200,400,500,600,mPaint);
        // 绘制一组线 每四数字(两个点的坐标)确定一条线
        canvas.drawLines(new float[]{
                100,200,200,200,
                100,300,200,300
        },mPaint);
    }
}

package com.study.customview.widget.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by HFS on 2017/2/27.
 */

public class LinePathView extends View {
    public LinePathView(Context context) {
        super(context);
    }

    public LinePathView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);//填充样式改为描边
        paint.setStrokeWidth(5);//设置画笔宽度
        paint.setColor(Color.BLUE);

        Path path = new Path();
        path.moveTo(100, 100);//以（100,100）为起点
        path.lineTo(100, 500);//从(100,100)到(100.500)绘制一条直线
        path.lineTo(500, 500);//从(100,500)到(500,500)绘制一条直线
        path.close();//闭环


        canvas.drawPath(path, paint);
    }
}

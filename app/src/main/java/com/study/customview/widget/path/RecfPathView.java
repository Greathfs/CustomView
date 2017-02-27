package com.study.customview.widget.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by HFS on 2017/2/27.
 */

public class RecfPathView extends View {
    public RecfPathView(Context context) {
        super(context);
    }

    public RecfPathView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);//填充样式改为描边
        paint.setStrokeWidth(5);//设置画笔宽度
        paint.setColor(Color.BLUE);

        //第一个逆向生成
        Path CCWRectpath = new Path();
        RectF rect1 =  new RectF(50, 50, 240, 200);
        CCWRectpath.addRect(rect1, Path.Direction.CCW);

        //第二个顺向生成
        Path CWRectpath = new Path();
        RectF rect2 =  new RectF(290, 50, 480, 200);
        CWRectpath.addRect(rect2, Path.Direction.CW);

        canvas.drawPath(CCWRectpath, paint);
        canvas.drawPath(CWRectpath, paint);
    }
}

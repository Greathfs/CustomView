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

public class RoundRecfPathView extends View {
    public RoundRecfPathView(Context context) {
        super(context);
    }

    public RoundRecfPathView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //设置Paint
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);//填充样式改为描边
        paint.setStrokeWidth(5);//设置画笔宽度
        paint.setColor(Color.BLUE);

        Path path = new Path();
        RectF rect1 =  new RectF(50, 50, 240, 200);
        //所有圆角大小相同
        path.addRoundRect(rect1, 10, 15 , Path.Direction.CCW);

        RectF rect2 =  new RectF(290, 50, 480, 200);
        //指定四个圆角不同大小
        float radii[] ={10,15,20,25,30,35,40,45};
        path.addRoundRect(rect2, radii, Path.Direction.CCW);

        canvas.drawPath(path, paint);

    }
}

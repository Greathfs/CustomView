package com.study.customview.widget.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by HFS on 2017/2/11.
 */

public class PathView extends View {
    public PathView(Context context) {
        super(context);
    }

    public PathView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setColor(Color.RED);  //设置画笔颜色

        paint.setStrokeWidth (5);//设置画笔宽度
        paint.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
        paint.setTextSize(45);//设置文字大小
        paint.setStyle(Paint.Style.STROKE);//绘图样式，设置为填充

        String string="Hello World";

        //先创建两个相同的圆形路径，并先画出两个路径原图
        Path circlePath=new Path();
        circlePath.addCircle(220,600, 180, Path.Direction.CCW);//逆向绘制
        canvas.drawPath(circlePath, paint);//绘制出路径原形

        Path circlePath2=new Path();
        circlePath2.addCircle(750,600, 180, Path.Direction.CCW);
        canvas.drawPath(circlePath2, paint);//绘制出路径原形

        paint.setColor(Color.GREEN);
        //hoffset、voffset参数值全部设为0，看原始状态是怎样的
        canvas.drawTextOnPath(string, circlePath, 0, 0, paint);
        //第二个路径，改变hoffset、voffset参数值
        canvas.drawTextOnPath(string, circlePath2, 80, 30, paint);
    }
}

package com.study.customview.widget.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by HFS on 2017/2/11.
 */

public class OtherDiffView extends View {
    public OtherDiffView(Context context) {
        super(context);
    }

    public OtherDiffView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint=new Paint();
        paint.setColor(Color.BLUE);  //设置画笔颜色

        paint.setStrokeWidth (5);//设置画笔宽度
        paint.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
        paint.setTextSize(100);//设置文字大小
        paint.setStyle(Paint.Style.FILL);//绘图样式，设置为填充

        //变通样式字体
        canvas.drawText("这是一条测试数据", 20,200, paint);

        //水平方向拉伸两倍
        paint.setTextScaleX(2);//只会将水平方向拉伸，高度不会变
        canvas.drawText("这是一条测试数据", 20,400, paint);

        //写在同一位置,不同颜色,看下高度是否看的不变
        paint.setTextScaleX(1);//先还原拉伸效果
        canvas.drawText("这是一条测试数据", 20,600, paint);

        paint.setColor(Color.RED);
        paint.setTextScaleX(2);//重新设置拉伸效果
        canvas.drawText("这是一条测试数据", 20,600, paint);
    }
}

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

public class TextDiffView extends View {
    public TextDiffView(Context context) {
        super(context);
    }

    public TextDiffView(Context context, AttributeSet attrs) {
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
        paint.setStyle(Paint.Style.FILL);

        //样式设置
        //粗体
        paint.setFakeBoldText(true);
        //下划线
        paint.setUnderlineText(true);
        //删除线
        paint.setStrikeThruText(true);

        //不倾斜
        canvas.drawText("这是一条测试数据",20,200,paint);

        //向有倾斜
        paint.setTextSkewX((float) -0.25);
        canvas.drawText("这是一条测试数据",20,400,paint);

        //向左倾斜
        paint.setTextSkewX((float) 0.25);
        canvas.drawText("这是一条测试数据",20,600,paint);
    }
}

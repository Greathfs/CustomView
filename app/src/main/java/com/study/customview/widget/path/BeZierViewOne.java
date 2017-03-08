package com.study.customview.widget.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by win7 on 2017/3/8.
 */

public class BeZierViewOne extends View {
    public BeZierViewOne(Context context) {
        super(context);
    }

    public BeZierViewOne(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Paint
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setColor(Color.BLUE);

        //BeZierView
        Path path = new Path();
        path.moveTo(100, 300);
        path.quadTo(200, 400, 300, 300);
        path.quadTo(400, 200, 500, 300);

        canvas.drawPath(path, paint);


    }
}

package com.study.customview.widget.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by HFS on 2017/2/27.
 */

public class ArcPathView extends View {
    public ArcPathView(Context context) {
        super(context);
    }

    public ArcPathView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);

        Path path=new Path();
        RectF rect=new RectF(100,100,200,300);
        path.addArc(rect,0,180);

        canvas.drawPath(path,paint);

    }
}

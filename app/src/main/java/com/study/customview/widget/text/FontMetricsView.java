package com.study.customview.widget.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by HFS on 2017/2/12.
 */

public class FontMetricsView extends View {
    public FontMetricsView(Context context) {
        super(context);
    }

    public FontMetricsView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int baseLineY = 200;
        int baseLineX = 0 ;

        Paint paint = new Paint();
        //写文字
        paint.setColor(Color.GREEN);
        paint.setTextSize(120); //以px为单位
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("abcdefghijk", baseLineX, baseLineY, paint);

        //计算各线在位置
        Paint.FontMetrics fm = paint.getFontMetrics();
        float ascent = baseLineY + fm.ascent;
        float descent = baseLineY + fm.descent;
        float top = baseLineY + fm.top;
        float bottom = baseLineY + fm.bottom;

        //画基线
        paint.setColor(Color.RED);
        canvas.drawLine(baseLineX, baseLineY, 3000, baseLineY, paint);

        //画top
        paint.setColor(Color.BLUE);
        canvas.drawLine(baseLineX, top, 3000, top, paint);

        //画ascent
        paint.setColor(Color.GREEN);
        canvas.drawLine(baseLineX, ascent, 3000, ascent, paint);

        //画descent
        paint.setColor(Color.BLACK);
        canvas.drawLine(baseLineX, descent, 3000, descent, paint);

        //画bottom
        paint.setColor(Color.RED);
        canvas.drawLine(baseLineX, bottom, 3000, bottom, paint);
    }
}

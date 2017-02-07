package com.study.customview.widget.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by HFS on 2017/2/7.
 */

public class SaveRestoreView extends View {
    public SaveRestoreView(Context context) {
        super(context);
    }

    public SaveRestoreView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.RED);
        //保存的画布大小为全屏幕大小
        canvas.save();

        canvas.clipRect(new Rect(100,100,800,800));
        canvas.drawColor(Color.GREEN);
        canvas.save();

        canvas.clipRect(new Rect(100,100,600,600));
        canvas.drawColor(Color.YELLOW);
        canvas.save();

        canvas.clipRect(new Rect(100,100, 400, 400));
        canvas.drawColor(Color.WHITE);


        canvas.restore();
        canvas.restore();
        canvas.restore();
        canvas.drawColor(Color.BLUE);
    }
}

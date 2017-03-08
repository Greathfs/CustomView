package com.study.customview.widget.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by win7 on 2017/3/8.
 */

public class BeZierViewTwo extends View {
    private Path mPath = new Path();
    private float mPreX, mPreY;

    public BeZierViewTwo(Context context) {
        super(context);
    }

    public BeZierViewTwo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                //将Path的初始位置设置到手指的触点处，如果不调用mPath.moveTo的话，会默认是从(0,0)开始的
                mPath.moveTo(event.getX(), event.getY());
                mPreX = event.getX();
                mPreY = event.getY();
                return true;
            }
            case MotionEvent.ACTION_MOVE: {
                //结束点是这个线段的中间位置，所以很容易求出它的坐标endX,endY；控制点是上一个手指位置即mPreX,mPreY
                float endX = (mPreX + event.getX()) / 2;
                float endY = (mPreY + event.getY()) / 2;
                mPath.quadTo(mPreX, mPreY, endX, endY);
                mPreX = event.getX();
                mPreY = event.getY();
                invalidate();
            }
            break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(2);

        canvas.drawPath(mPath, paint);
    }

    public void reset() {
        mPath.reset();
        postInvalidate();
    }
}

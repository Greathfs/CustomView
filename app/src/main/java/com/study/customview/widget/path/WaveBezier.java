package com.study.customview.widget.path;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by win7 on 2017/3/8.
 */

public class WaveBezier extends View {
    private static final String TAG = "WaveBezier";

    private Paint mPaint;
    private Path mPath;
    private int mItemWaveLength = 1000;
    private int mWaveCount;
    private int dx, dy;

    public WaveBezier(Context context) {
        super(context);
        init();
    }

    public WaveBezier(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        mPath = new Path();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.LTGRAY);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWaveCount = (int) Math.round(w / mItemWaveLength + 1.5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw: ");
        mPath.reset();
        int originY = 300;
        int halfWaveLen = mItemWaveLength / 2;

//        mPath.moveTo(-mItemWaveLength + dx, getHeight());
        //实现向下移动动画
        mPath.moveTo(-mItemWaveLength + dx, dy);
        dy += 1;
        //画出当前屏幕中可能容得下的所有波
        for (int i = 0; i < mWaveCount; i++) {
            //rQuadTo 相对位置
            mPath.rQuadTo(halfWaveLen / 2, -100, halfWaveLen, 0);
            mPath.rQuadTo(halfWaveLen / 2, 100, halfWaveLen, 0);
        }
        mPath.lineTo(getWidth(), getHeight());
        mPath.lineTo(0, getHeight());
//        mPath.close();

        canvas.drawPath(mPath, mPaint);
    }

    public void startAnim() {
        ValueAnimator animator = ValueAnimator.ofInt(0, mItemWaveLength);
        animator.setDuration(4000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dx = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }
}

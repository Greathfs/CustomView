package com.study.customview.widget.progress;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.study.customview.utils.CommonUtils;

/**
 * Created by HFS on 2017/6/7.
 */

public class ProgressView extends View {

    /**
     * 提示框的高度
     */
    private int mTipHeight;
    /**
     * 提示框的宽度
     */
    private int mTipWidth;
    /**
     * 提示框画笔的宽度
     */
    private int mTipPaintWidth;

    /**
     * 进度条画笔宽度
     */
    private int mProgressPaintWidth;


    /**
     * Text画笔宽度
     */
    private int mTextPaintWidth;

    /**
     * 提示框的画笔
     */
    private Paint mTipPaint;

    /**
     * 进度条的画笔
     */
    private Paint mProgressPaint;

    /**
     * 当前进度条的画笔
     */
    private Paint mCurrentProgressPaint;

    /**
     * 进度值画笔
     */
    private Paint mTextPaint;

    /**
     * 当前进度条
     */
    private float mCurrentProgress;

    /**
     * 设置总长度
     */
    private float mTotalProgress;

    /**
     * 进度条离提示框的高度
     */
    private int mMarginTipHeight;

    /**
     * 进度动画
     */
    private ValueAnimator mProgressAnimator;

    /**
     * 动画持续时间
     */
    private long mAnimationDurating = 10000;

    /**
     * 开始延时时间
     */
    private long mAnimationStartDelay = 500;

    /**
     * 显示进度值
     */
    private String mTextString = "0";

    private Rect mTextRect = new Rect();

    /**
     * 三角形高度
     */
    private int mTriangleHeight;

    /**
     * 圆角矩形圆角半径
     */
    private int mRoundRecfRadius;

    /**
     * 进度条背景颜色
     */
    private int bgColor = 0xFFe1e5e8;
    /**
     * 进度条颜色
     */
    private int progressColor = 0xFFf66b12;

    /**
     * 绘制提示框的矩形
     */
    private RectF rectF = new RectF();

    private int mWidth;

    private int mHeight;

    private int mViewHeight;

    /**
     * 移动距离
     */
    private float mMoveDis;

    /**
     * 画三角形的path
     */
    private Path path = new Path();

    private Context mContext;


    /**
     * 回调接口
     */
    private OnProgressChangeListener mOnProgressChangeListener;


    public ProgressView(Context context) {
        this(context, null);
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;

        initSize();

        initPaint();

    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        mProgressPaint = getPaint(mProgressPaintWidth, bgColor, Paint.Style.STROKE);
        mCurrentProgressPaint = getPaint(mProgressPaintWidth, progressColor, Paint.Style.STROKE);
        mTipPaint = getPaint(mTextPaintWidth, progressColor, Paint.Style.FILL);

        initTextPaint();
    }

    /**
     * 初始化文字画笔
     */
    private void initTextPaint() {
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(mTextPaintWidth);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setAntiAlias(true);
    }

    /**
     * 统一处理paint
     *
     * @param strokeWidth
     * @param color
     * @param style
     * @return
     */
    private Paint getPaint(int strokeWidth, int color, Paint.Style style) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(strokeWidth);
        paint.setColor(color);
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(style);
        return paint;
    }

    /**
     * 初始化一些默认值
     */
    private void initSize() {
        mProgressPaintWidth = CommonUtils.dp2px(mContext, 4);
        mTipHeight = CommonUtils.dp2px(mContext, 15);
        mTipWidth = CommonUtils.dp2px(mContext, 30);
        mTipPaintWidth = CommonUtils.dp2px(mContext, 1);
        mTriangleHeight = CommonUtils.dp2px(mContext, 3);
        mRoundRecfRadius = CommonUtils.dp2px(mContext, 2);
        mTextPaintWidth = CommonUtils.sp2px(mContext, 10);
        mMarginTipHeight = CommonUtils.dp2px(mContext, 8);

        //view真实的高度
        mViewHeight = mTipHeight + mTipPaintWidth + mTriangleHeight + mProgressPaintWidth + mMarginTipHeight;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        setMeasuredDimension(measureWidth(widthMode, width), measureHeight(heightMode, height));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制背景
        canvas.drawLine(getPaddingLeft(), mTipHeight + mMarginTipHeight, getWidth(), mTipHeight + mMarginTipHeight, mProgressPaint);

        //绘制真实进度
        canvas.drawLine(getPaddingLeft(), mTipHeight + mMarginTipHeight, mCurrentProgress, mTipHeight + mMarginTipHeight, mCurrentProgressPaint);


        drawTip(canvas);

        drawText(canvas);

    }

    private void drawText(Canvas canvas) {
        mTextRect.left = (int) mMoveDis;
        mTextRect.top = 0;
        mTextRect.right = (int) (mTipWidth + mMoveDis);
        mTextRect.bottom = mTipHeight;
        Paint.FontMetricsInt fontMetrics = mTextPaint.getFontMetricsInt();
        int baseline = (mTextRect.bottom + mTextRect.top - fontMetrics.bottom - fontMetrics.top) / 2;
        //文字绘制到整个布局的中心位置
        canvas.drawText(mTextString + "%", mTextRect.centerX(), baseline, mTextPaint);
    }

    private void drawTip(Canvas canvas) {
        drawRoundRect(canvas);
        drawTriangle(canvas);
    }

    /**
     * 绘制圆角矩形
     *
     * @param canvas
     */
    private void drawRoundRect(Canvas canvas) {
        rectF.set(mMoveDis, 0, mTipWidth + mMoveDis, mTipHeight);
        canvas.drawRoundRect(rectF, mRoundRecfRadius, mRoundRecfRadius, mTipPaint);
    }

    /**
     * 绘制三角形
     *
     * @param canvas
     */
    private void drawTriangle(Canvas canvas) {
        //三角形第一个点
        path.moveTo(mTipWidth / 2 - mTriangleHeight + mMoveDis, mTipHeight);
        //三角形第二个点
        path.lineTo(mTipWidth / 2 + mMoveDis, mTipHeight + mTriangleHeight);
        //三角形第三个点
        path.lineTo(mTipWidth / 2 + mTriangleHeight + mMoveDis, mTipHeight);
        canvas.drawPath(path, mTipPaint);
        path.reset();

    }


    /**
     * 测量宽度
     *
     * @param mode
     * @param width
     * @return
     */
    private int measureWidth(int mode, int width) {
        switch (mode) {
            case MeasureSpec.UNSPECIFIED:
            case MeasureSpec.AT_MOST:
                break;
            case MeasureSpec.EXACTLY:
                mWidth = width;
                break;
        }
        return mWidth;
    }

    /**
     * 测量高度
     *
     * @param mode
     * @param height
     * @return
     */
    private int measureHeight(int mode, int height) {
        switch (mode) {
            case MeasureSpec.UNSPECIFIED:
            case MeasureSpec.AT_MOST:
                mHeight = mViewHeight;
                break;
            case MeasureSpec.EXACTLY:
                mHeight = height;
                break;
        }
        return mHeight;
    }

    /**
     * 设置进度
     *
     * @param progress
     * @return
     */
    public ProgressView setProgress(float progress) {
        mMoveDis=0;
        mTotalProgress = progress;
        initAnimation();
        return this;
    }

    /**
     * 进度移动动画  通过插值的方式改变移动的距离
     */
    private void initAnimation() {
        mProgressAnimator = ValueAnimator.ofFloat(0, mTotalProgress);
        mProgressAnimator.setDuration(mAnimationDurating);
        mProgressAnimator.setStartDelay(mAnimationStartDelay);
        mProgressAnimator.setInterpolator(new LinearInterpolator());
        mProgressAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
                //这是我们自己的需求进度只显示整数
                mTextString = CommonUtils.formatNum(CommonUtils.format2Int(value));
                //百分比的进度转换成view宽度一样的比例
                mCurrentProgress = value * mWidth / 100;
                //进度回调方法
                if (mOnProgressChangeListener != null) {
                    mOnProgressChangeListener.onProgressChange(value);
                }

                //移动百分比提示框，只有当前进度到提示框中间位置之后开始移动，
                //当进度框移动到最右边的时候停止移动，但是进度条还可以继续移动
                //moveDis是tip框移动的距离
                if (mCurrentProgress >= (mTipWidth / 2) &&
                        mCurrentProgress <= (mWidth - mTipWidth / 2)) {
                    mMoveDis = mCurrentProgress - mTipWidth / 2;
                }
                invalidate();
            }
        });
        mProgressAnimator.start();
    }


    public interface OnProgressChangeListener {
        void onProgressChange(float progress);
    }

    public ProgressView setOnProgressChangeListener(OnProgressChangeListener onProgressChangeListener) {
        mOnProgressChangeListener = onProgressChangeListener;
        return this;
    }


    /**
     * 开启动画
     */
    public void startProgressAnimation() {
        if (mProgressAnimator != null &&
                !mProgressAnimator.isRunning() &&
                !mProgressAnimator.isStarted())
            mProgressAnimator.start();
    }

    /**
     * 暂停动画
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void pauseProgressAnimation() {
        if (mProgressAnimator != null) {
            mProgressAnimator.pause();
        }
    }

    /**
     * 恢复动画
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void resumeProgressAnimation() {
        if (mProgressAnimator != null)
            mProgressAnimator.resume();
    }

    /**
     * 停止动画
     */
    public void stopProgressAnimation() {
        if (mProgressAnimator != null) {
            mProgressAnimator.end();
        }
    }

}

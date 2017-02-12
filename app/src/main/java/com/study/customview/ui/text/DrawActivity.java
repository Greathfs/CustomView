package com.study.customview.ui.text;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.study.customview.R;
import com.study.customview.widget.text.CenterText;
import com.study.customview.widget.text.FontMetricsView;
import com.study.customview.widget.text.OtherDiffView;
import com.study.customview.widget.text.PaintDiffView;
import com.study.customview.widget.text.PathView;
import com.study.customview.widget.text.PositionView;
import com.study.customview.widget.text.TextAlignView;
import com.study.customview.widget.text.TextDiffView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DrawActivity extends AppCompatActivity {

    @BindView(R.id.paint_diff_view)
    PaintDiffView mPaintDiffView;
    @BindView(R.id.text_diff_view)
    TextDiffView mTextDiffView;
    @BindView(R.id.other_diff_view)
    OtherDiffView mOtherDiffView;
    @BindView(R.id.position_text_view)
    PositionView mPositionView;
    @BindView(R.id.path_text_view)
    PathView mPathView;
    @BindView(R.id.text_align_view)
    TextAlignView mTextAlignView;
    @BindView(R.id.fontmetrics_view)
    FontMetricsView mFontMetricsView;
    @BindView(R.id.center_view)
    CenterText mCenterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        ButterKnife.bind(this);

        String stringExtra = getIntent().getStringExtra(DrawTextActivity.EXTR_NUM);

        switch (stringExtra) {
            case "0":
                mPaintDiffView.setVisibility(View.VISIBLE);
                break;
            case "1":
                mTextDiffView.setVisibility(View.VISIBLE);
                break;
            case "2":
                mOtherDiffView.setVisibility(View.VISIBLE);
                break;
            case "3":
                mPositionView.setVisibility(View.VISIBLE);
                break;
            case "4":
                mPathView.setVisibility(View.VISIBLE);
                break;
            case "5":
                mTextAlignView.setVisibility(View.VISIBLE);
                break;

            case "6":
                mFontMetricsView.setVisibility(View.VISIBLE);
                break;
            case "7":
                mCenterText.setVisibility(View.VISIBLE);
                break;
        }

    }
}

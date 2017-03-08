package com.study.customview.ui.path;

import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.study.customview.R;
import com.study.customview.widget.path.ArcPathView;
import com.study.customview.widget.path.BeZierViewOne;
import com.study.customview.widget.path.BeZierViewTwo;
import com.study.customview.widget.path.CirclePathView;
import com.study.customview.widget.path.LinePathView;
import com.study.customview.widget.path.OvalPathView;
import com.study.customview.widget.path.RecfPathView;
import com.study.customview.widget.path.RoundRecfPathView;
import com.study.customview.widget.path.WaveBezier;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PathViewActivity extends AppCompatActivity {

    @BindView(R.id.path_line_path)
    LinePathView mPathLinePath;
    @BindView(R.id.path_recf_path)
    RecfPathView mPathRecfPath;
    @BindView(R.id.path_round_recf_path)
    RoundRecfPathView mPathRoundRecfPath;
    @BindView(R.id.path_circle_path)
    CirclePathView mPathCirclePath;
    @BindView(R.id.path_oval_path)
    OvalPathView mPathOvalPath;
    @BindView(R.id.path_arc_path)
    ArcPathView mPathArcPath;
    @BindView(R.id.path_bezier_one)
    BeZierViewOne mBeZierViewOne;
    @BindView(R.id.path_bezier_two)
    BeZierViewTwo mBeZierViewTwo;
    @BindView(R.id.btn_reset)
    Button mButton;
    @BindView(R.id.path_wave_bezier)
    WaveBezier mWaveBezier;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path_view);
        ButterKnife.bind(this);

        String stringExtra = getIntent().getStringExtra(PathActivity.EXTR_NUM);

        switch (stringExtra) {
            case "0":
                mPathLinePath.setVisibility(View.VISIBLE);
                break;
            case "1":
                mPathRecfPath.setVisibility(View.VISIBLE);
                break;
            case "2":
                mPathRoundRecfPath.setVisibility(View.VISIBLE);
                break;
            case "3":
                mPathCirclePath.setVisibility(View.VISIBLE);
                break;
            case "4":
                mPathOvalPath.setVisibility(View.VISIBLE);
                break;
            case "5":
                mPathArcPath.setVisibility(View.VISIBLE);
                break;
            case "6":
                mBeZierViewOne.setVisibility(View.VISIBLE);
                break;
            case "7":
                mBeZierViewTwo.setVisibility(View.VISIBLE);
                mButton.setVisibility(View.VISIBLE);
                break;
            case "8":
                mWaveBezier.setVisibility(View.VISIBLE);
                mWaveBezier.startAnim();
                break;



        }
    }

    @OnClick(R.id.btn_reset)
    void onClick() {
        mBeZierViewTwo.reset();
    }
}

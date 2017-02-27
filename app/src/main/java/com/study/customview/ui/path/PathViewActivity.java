package com.study.customview.ui.path;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.study.customview.R;
import com.study.customview.widget.path.ArcPathView;
import com.study.customview.widget.path.CirclePathView;
import com.study.customview.widget.path.LinePathView;
import com.study.customview.widget.path.OvalPathView;
import com.study.customview.widget.path.RecfPathView;
import com.study.customview.widget.path.RoundRecfPathView;

import butterknife.BindView;
import butterknife.ButterKnife;

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


        }
    }
}

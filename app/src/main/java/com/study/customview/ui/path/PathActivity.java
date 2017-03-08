package com.study.customview.ui.path;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.study.customview.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class PathActivity extends AppCompatActivity {

    public static final String EXTR_NUM = "num";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_line_path, R.id.btn_rect_path, R.id.btn_round_rect_path, R.id.btn_circle_path, R.id.btn_oval_path, R.id.btn_arc_path, R.id.btn_bezier_one,
            R.id.btn_bezier_two, R.id.btn_bezier_three})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_line_path:
                jump(PathViewActivity.class, "0");
                break;
            case R.id.btn_rect_path:
                jump(PathViewActivity.class, "1");
                break;
            case R.id.btn_round_rect_path:
                jump(PathViewActivity.class, "2");
                break;
            case R.id.btn_circle_path:
                jump(PathViewActivity.class, "3");
                break;
            case R.id.btn_oval_path:
                jump(PathViewActivity.class, "4");
                break;
            case R.id.btn_arc_path:
                jump(PathViewActivity.class, "5");
                break;
            case R.id.btn_bezier_one:
                jump(PathViewActivity.class, "6");
                break;
            case R.id.btn_bezier_two:
                jump(PathViewActivity.class, "7");
                break;
            case R.id.btn_bezier_three:
                jump(PathViewActivity.class, "8");
                break;
        }
    }

    public void jump(Class clz, String num) {
        Intent intent = new Intent();
        intent.putExtra(EXTR_NUM, num);
        intent.setClass(this, clz);
        startActivity(intent);
    }
}

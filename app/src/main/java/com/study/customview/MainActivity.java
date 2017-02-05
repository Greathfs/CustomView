package com.study.customview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.study.customview.ui.ArcActivity;
import com.study.customview.ui.CircleActivity;
import com.study.customview.ui.CircularActivity;
import com.study.customview.ui.ColorActivity;
import com.study.customview.ui.LineActivity;
import com.study.customview.ui.OvalActivity;
import com.study.customview.ui.PointActivity;
import com.study.customview.ui.RectActivity;
import com.study.customview.ui.RoundRectActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_draw_color, R.id.btn_draw_point, R.id.btn_draw_line,R.id.btn_draw_rect,R.id.btn_draw_round_rect,
                R.id.btn_draw_oval,R.id.btn_draw_circle,R.id.btn_draw_arc,R.id.btn_draw_circular})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_draw_color:
                jump(ColorActivity.class);
                break;
            case R.id.btn_draw_point:
                jump(PointActivity.class);
                break;
            case R.id.btn_draw_line:
                jump(LineActivity.class);
                break;
            case R.id.btn_draw_rect:
                jump(RectActivity.class);
                break;
            case R.id.btn_draw_round_rect:
                jump(RoundRectActivity.class);
                break;
            case R.id.btn_draw_oval:
                jump(OvalActivity.class);
                break;
            case R.id.btn_draw_circle:
                jump(CircleActivity.class);
                break;
            case R.id.btn_draw_arc:
                jump(ArcActivity.class);
                break;
            case R.id.btn_draw_circular:
                jump(CircularActivity.class);
                break;
            default:
                break;
        }
    }

    public void jump(Class clz) {
        startActivity(new Intent(this, clz));
    }

}

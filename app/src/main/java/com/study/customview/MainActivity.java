package com.study.customview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.study.customview.ui.basicImage.ArcActivity;
import com.study.customview.ui.basicImage.CircleActivity;
import com.study.customview.ui.canvas.ClipActivity;
import com.study.customview.ui.canvas.RotateActivity;
import com.study.customview.ui.canvas.SaveRestoreActivity;
import com.study.customview.ui.canvas.ScaleActivity;
import com.study.customview.ui.canvas.SkewActivity;
import com.study.customview.ui.canvas.TranslateActivity;
import com.study.customview.ui.circular.CircularActivity;
import com.study.customview.ui.basicImage.ColorActivity;
import com.study.customview.ui.basicImage.LineActivity;
import com.study.customview.ui.basicImage.OvalActivity;
import com.study.customview.ui.basicImage.PointActivity;
import com.study.customview.ui.basicImage.RectActivity;
import com.study.customview.ui.basicImage.RoundRectActivity;
import com.study.customview.ui.text.DrawTextActivity;

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
                R.id.btn_draw_oval,R.id.btn_draw_circle,R.id.btn_draw_arc,R.id.btn_draw_circular,R.id.btn_canvas_translate,
                R.id.btn_canvas_rotate,R.id.btn_canvas_clip,R.id.btn_canvas_scale,R.id.btn_canvas_skew,R.id.btn_canvas_save_restore,
                R.id.btn_draw_text})
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
            case R.id.btn_canvas_translate:
                jump(TranslateActivity.class);
                break;
            case R.id.btn_canvas_rotate:
                jump(RotateActivity.class);
                break;
            case R.id.btn_canvas_scale:
                jump(ScaleActivity.class);
                break;
            case R.id.btn_canvas_skew:
                jump(SkewActivity.class);
                break;
            case R.id.btn_canvas_clip:
                jump(ClipActivity.class);
                break;
            case R.id.btn_canvas_save_restore:
                jump(SaveRestoreActivity.class);
                break;
            case R.id.btn_draw_text:
                jump(DrawTextActivity.class);
                break;

            default:
                break;
        }
    }

    public void jump(Class clz) {
        startActivity(new Intent(this, clz));
    }

}

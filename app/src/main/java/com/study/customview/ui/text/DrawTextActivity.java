package com.study.customview.ui.text;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.study.customview.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DrawTextActivity extends AppCompatActivity {

    public static final String EXTR_NUM = "num";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_text);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_paint_diff, R.id.btn_text_diff, R.id.btn_other_diff,R.id.btn_position_view,R.id.btn_path_view})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_paint_diff:
                jump(DrawActivity.class,"0");
                break;
            case R.id.btn_text_diff:
                jump(DrawActivity.class,"1");
                break;
            case R.id.btn_other_diff:
                jump(DrawActivity.class,"2");
                break;
            case R.id.btn_position_view:
                jump(DrawActivity.class,"3");
                break;
            case R.id.btn_path_view:
                jump(DrawActivity.class,"4");
                break;
        }
    }

    public void jump(Class clz) {
        startActivity(new Intent(this, clz));
    }
    public void jump(Class clz,String num) {
        Intent intent=new Intent();
        intent.putExtra(EXTR_NUM,num);
        intent.setClass(this,clz);
        startActivity(intent);
    }
}

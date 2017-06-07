package com.study.customview.ui.progress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.study.customview.R;
import com.study.customview.widget.progress.ProgressView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProgressActivity extends AppCompatActivity {

    private static final String TAG = "ProgressActivity";

    @BindView(R.id.progress)
    ProgressView mProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        ButterKnife.bind(this);


        mProgressView.setProgress(80);
        mProgressView.setOnProgressChangeListener(new ProgressView.OnProgressChangeListener() {
            @Override
            public void onProgressChange(float progress) {
                Log.d(TAG, "progress="+progress);
            }
        });

        mProgressView.startProgressAnimation();

    }

    @OnClick({R.id.btn_reset})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_reset:

                mProgressView.setProgress(100);
                mProgressView.startProgressAnimation();

                break;
        }
    }
}

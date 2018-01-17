package com.example.sgr.mymvpframework;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ldoublem.loadingviewlib.view.LVCircularSmile;

import z.sye.space.library.PageStateLayout;

public class LoadingActivity extends AppCompatActivity {
    Button stop;
    LVCircularSmile smile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
//        smile=new LVCircularSmile(this);
        smile=(LVCircularSmile)findViewById(R.id.lv_circularSmile);
        smile.setViewColor(Color.rgb(144, 238, 146));
        smile.startAnim();
        stop=(Button)findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                smile.stopAnim();
            }
        });
    }
}

package com.example.sgr.mymvpframework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sgr.mymvpframework.app.bean.LoginBean;
import com.example.sgr.mymvpframework.app.module.login.present.LoginPresenter;
import com.example.sgr.mymvpframework.app.module.login.view.LoginView;
import com.tz.mvp.framework.base.presenter.MvpPresenter;
import com.tz.mvp.framework.support.lce.MvpLceView;
import com.tz.mvp.framework.support.lce.impl.MvpLceActivity;
import com.tz.mvp.framework.support.view.MvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity{

    @BindView(R.id.btn)
    Button btn;

    private Unbinder unbinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
    }


    @OnClick({R.id.btn,R.id.btn2,R.id.btn3,R.id.btn4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
                Intent in1=new Intent(this,LecTestActivity.class);
                startActivity(in1);
                break;
            case R.id.btn2:
                Intent in2=new Intent(this,LecListActivity.class);
                startActivity(in2);
                break;
            case R.id.btn3:
                Intent in3=new Intent(this,PullToRefreshActivity.class);
                startActivity(in3);
                break;
            case R.id.btn4:
                Intent in4=new Intent(this,LoadingActivity.class);
                startActivity(in4);
                break;

        }
    }

}

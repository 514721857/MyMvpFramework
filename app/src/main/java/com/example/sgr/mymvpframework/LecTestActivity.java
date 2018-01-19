package com.example.sgr.mymvpframework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sgr.mymvpframework.app.bean.LoginBean;
import com.example.sgr.mymvpframework.app.module.Lec.LecPresenter;
import com.example.sgr.mymvpframework.app.module.Lec.LecTestView;
import com.example.sgr.mymvpframework.app.view.LoadingAnimator;
import com.tz.mvp.framework.support.lce.impl.MvpLceActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/***
 * 这个是基本的封装mvp框架，还没有Lec，但是还可以封装一个baseMvpActivity（封装一些初始化的东西
 * 如：inivView，ButterKnife，沉浸式状态栏，等等）
 *
 *
 */
public class LecTestActivity extends MvpLceActivity<LecTestView,LecPresenter> implements LecTestView{
    @BindView(R.id.btn)
    Button btn;

    @BindView(R.id.text)
    TextView text;

    private Unbinder unbinder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lec_test);
        unbinder = ButterKnife.bind(this);
        setLceAnimator(new LoadingAnimator());
    }
    @OnClick({R.id.btn,R.id.button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
                getPresenter().getLogin("text","text");
                break;
            case R.id.button:
                getPresenter().getTest();
                break;



        }
    }


    @Override
    public LecPresenter createPresenter() {
        return new LecPresenter(this);
    }

    @Override
    public void bindData(Object data,String type) {

    }

    @Override
    public void loadData(boolean pullToRefresh,int page) {

    }

    @Override
    public void onLoginResult(LoginBean result) {
        Log.e("token",result.getAccess_token());
        //登录成功之后，回调ui
        text.setText(result.getName());
    }
}

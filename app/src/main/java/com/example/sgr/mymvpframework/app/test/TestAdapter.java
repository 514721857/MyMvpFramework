 package com.example.sgr.mymvpframework.app.test;


import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.sgr.mymvpframework.R;
import com.example.sgr.mymvpframework.app.bean.DataList;
import com.example.sgr.mymvpframework.app.module.LecList.CommonViewHolder;


 /**
 * Created by Administrator on 2017/8/24.
 */


public class TestAdapter extends BaseQuickAdapter<testBean,CommonViewHolder> implements BaseQuickAdapter.OnItemChildClickListener,BaseQuickAdapter.OnItemClickListener{
    public TestAdapter() {
        super(R.layout.list_home_text_item);
    }
    @Override
    protected void convert(CommonViewHolder baseViewHolder, testBean personItem) {
//        baseViewHolder.setText(R.id.product_name,personItem.getName());
        baseViewHolder.setText(R.id.tv_home_text, personItem.getUid()+"");


    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
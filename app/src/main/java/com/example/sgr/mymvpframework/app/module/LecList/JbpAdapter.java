 package com.example.sgr.mymvpframework.app.module.LecList;


import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.sgr.mymvpframework.R;
import com.example.sgr.mymvpframework.app.bean.DataList;
import com.example.sgr.mymvpframework.app.bean.ListBean;

import java.util.List;


 /**
 * Created by Administrator on 2017/8/24.
 */


public class JbpAdapter extends BaseQuickAdapter<DataList,CommonViewHolder> implements BaseQuickAdapter.OnItemChildClickListener,BaseQuickAdapter.OnItemClickListener{
    public JbpAdapter() {
        super(R.layout.item_jbp);
    }
    @Override
    protected void convert(CommonViewHolder baseViewHolder, DataList personItem) {
//        baseViewHolder.setText(R.id.product_name,personItem.getName());
        baseViewHolder.setText(R.id.title, personItem.getTitle());
        baseViewHolder.setText(R.id.c_down, personItem.getC_down());

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
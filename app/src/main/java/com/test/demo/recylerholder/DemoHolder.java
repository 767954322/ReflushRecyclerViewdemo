package com.test.demo.recylerholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.demo.bean.MyDataItem;
import com.test.demo.recyclerviewlian1.R;
import com.test.demo.utils.recyclerbase.BaseViewHolder;

/**
 * Created by gumenghao on 17/5/23.
 */

public class DemoHolder extends BaseViewHolder<MyDataItem> {//<>内为List的item对象

    private TextView tv_item_tital;

    public DemoHolder(ViewGroup parent) {
        super(parent, R.layout.item_recyclerview);
    }

    //找对象
    @Override
    public void onInitializeView() {
        super.onInitializeView();

        tv_item_tital = findViewById(R.id.tv_item_tital);

    }

    //赋值
    @Override
    public void setData(MyDataItem data) {
        super.setData(data);

        tv_item_tital.setText(data.getTital());
    }

    //监听
    @Override
    public void onItemViewClick(MyDataItem data) {
        super.onItemViewClick(data);

        tv_item_tital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

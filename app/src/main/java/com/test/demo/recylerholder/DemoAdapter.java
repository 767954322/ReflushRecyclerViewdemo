package com.test.demo.recylerholder;

import android.content.Context;
import android.view.ViewGroup;

import com.test.demo.bean.MyDataItem;
import com.test.demo.utils.recyclerbase.BaseViewHolder;
import com.test.demo.utils.recyclerbase.RecyclerAdapter;

/**
 * Created by gumenghao on 17/5/23.
 */

public class DemoAdapter extends RecyclerAdapter<MyDataItem>{

    public DemoAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder<MyDataItem> onCreateBaseViewHolder(ViewGroup parent, int viewType) {
        return new DemoHolder(parent);
    }
}

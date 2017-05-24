package com.test.demo.recyclerviewlian1;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.demo.base.BaseActivity;
import com.test.demo.bean.MyDataItem;
import com.test.demo.recylerholder.DemoAdapter;
import com.test.demo.utils.recyclerbase.Action;
import com.test.demo.utils.recyclerbase.RefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {

    private RefreshRecyclerView mRecyclerView;
    private DemoAdapter mAdapter;
    private Handler mHandler;
    private int page = 1;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mRecyclerView = (RefreshRecyclerView) findViewById(R.id.rlv_recyclerview);
    }

    @Override
    protected void initListener() {
        super.initListener();

        mRecyclerView.setRefreshAction(action_reflush);
        mRecyclerView.setLoadMoreAction(action_loadmore);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        mHandler = new Handler();
        mAdapter = new DemoAdapter(this);

        //设置Recyclerview属性
        showHeaderOrFooter(true,false);
        mRecyclerView.setSwipeRefreshColors(0xFF437845, 0xFFE44F98, 0xFF2FAC21);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.showSwipeRefresh();
        getData(true);
    }

    //设置Recyclerview属性
    private void showHeaderOrFooter(boolean header, boolean footer) {
        //添加Header
        if (header) {
            TextView header_textView = new TextView(this);
            header_textView.setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 48));
            header_textView.setTextSize(16);
            header_textView.setGravity(Gravity.CENTER);
            header_textView.setText("-- Header --");
            mAdapter.setHeader(header_textView);
        }
        if (footer) {
            //添加footer
            TextView footer_textview = new TextView(this);
            footer_textview.setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 48));
            footer_textview.setTextSize(16);
            footer_textview.setGravity(Gravity.CENTER);
            footer_textview.setText("-- Footer --");
            mAdapter.setFooter(footer_textview);
        }

    }

    Action action_reflush = new Action() {
        @Override
        public void onAction() {
            getData(true);
        }
    };

    Action action_loadmore = new Action() {
        @Override
        public void onAction() {
            getData(false);
        }
    };

    public void getData(final boolean isRefresh) {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isRefresh) {
                    page = 1;
                    mAdapter.clear();
                    mAdapter.addAll(getVirtualData());
                    mRecyclerView.dismissSwipeRefresh();
                    mRecyclerView.getRecyclerView().scrollToPosition(0);
                } else {
                    mAdapter.addAll(getVirtualData());
                    if (page >= 3) {
                        mRecyclerView.showNoMore();
                    }
                    page++;
                }
            }
        }, 1500);
    }

    public List<MyDataItem> getVirtualData() {

        List<MyDataItem> list = new ArrayList<>();

        for (int i = 0; i < 15; i++)
            list.add(new MyDataItem("Item" + (i + 1)));

        return list;
    }

}

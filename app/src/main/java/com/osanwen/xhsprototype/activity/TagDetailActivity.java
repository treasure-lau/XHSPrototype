package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.osanwen.xhsprototype.R;

/**
 * 标签详情页面
 * Created by liusaibao on 03/09/2017.
 */

public class TagDetailActivity extends BaseAppCompatActivity implements View.OnClickListener {

    public static Intent createIntent(Context context) {
        return new Intent(context, TagDetailActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_detail);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.actionBar);
//        setSupportActionBar(toolbar);
        addBackEvent();
//        setTitle("");

        findViewById(R.id.back_btn).setOnClickListener(this);
        final TextView mTitle = (TextView)findViewById(R.id.title);

        final FrameLayout mFrameLayout = (FrameLayout)findViewById(R.id.layout_header);
        mFrameLayout.setOnClickListener(this);
        SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_layout);
        mSwipeRefreshLayout.setEnabled(false);
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    mTitle.setText("减肥也要好好吃饭");
                    mFrameLayout.setVisibility(View.INVISIBLE);
                    isShow = true;
                } else if(isShow) {
                    mTitle.setText("");//carefull there should a space between double quote otherwise it wont work
                    mFrameLayout.setVisibility(View.VISIBLE);
                    isShow = false;
                }
            }
        });
    }

    @Override
    protected boolean isAddBackEvent() {
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_btn:
                finish();
                break;
            case R.id.layout_header:
                startActivity(TagIntroActivity.createIntent(this));
                break;
        }
    }
}

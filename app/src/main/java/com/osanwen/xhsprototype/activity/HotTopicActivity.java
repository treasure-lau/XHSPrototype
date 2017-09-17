package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.HotTopicAdapter;
import com.osanwen.xhsprototype.adapter.base.BaseQuickAdapter;
import com.osanwen.xhsprototype.util.TempData;

/**
 * 热门话题页面
 * Created by liusaibao on 03/09/2017.
 */

public class HotTopicActivity extends BaseAppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, HotTopicActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_topic);
        setTitle(R.string.topicGuide);
        RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.rv_hot_topic);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        HotTopicAdapter hotTopicAdapter = new HotTopicAdapter(TempData.getData(10));
        hotTopicAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(TagDetailActivity.createIntent(HotTopicActivity.this));
            }
        });
        mRecyclerView.setAdapter(hotTopicAdapter);
    }
}

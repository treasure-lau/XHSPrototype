package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.FollowTagEditAdapter;
import com.osanwen.xhsprototype.adapter.base.BaseQuickAdapter;
import com.osanwen.xhsprototype.util.TempData;

/**
 *
 * Created by liusaibao on 03/09/2017.
 */

public class FollowTagEditActivity extends BaseAppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, FollowTagEditActivity.class);
    }

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_tag_edit);
        setTitle(R.string.page_title_edit_follow_tags);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_follow_tag_edit);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        FollowTagEditAdapter adapter = new FollowTagEditAdapter(TempData.getData(10));
        mRecyclerView.setAdapter(adapter);
    }
}

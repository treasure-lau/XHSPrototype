package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.CommentListAdapter;
import com.osanwen.xhsprototype.adapter.base.BindAdapter;
import com.osanwen.xhsprototype.util.TempData;

/**
 * 帐号绑定
 * Created by liusaibao on 03/09/2017.
 */

public class BindActivity extends BaseAppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, BindActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind);
        setTitle(R.string.bind_list_title);
        RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.rv_bind);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new BindAdapter(TempData.getBindData()));
    }
}

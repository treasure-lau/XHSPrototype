package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.CommentListAdapter;
import com.osanwen.xhsprototype.util.TempData;
import com.osanwen.xhsprototype.widget.PushCommentPopWindow;

/**
 * 评论列表
 * Created by liusaibao on 10/09/2017.
 */

public class CommentListActivity extends BaseAppCompatActivity {

    private PushCommentPopWindow popWindow;

    public static Intent createIntent(Context context) {
        return new Intent(context, CommentListActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_list);
        setTitle(R.string.note_comment_title);
        popWindow = new PushCommentPopWindow(this);
        findViewById(R.id.note_comment_bar_tv_content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popWindow.showPopupWindow();
            }
        });
        RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.rv_comment_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new CommentListAdapter(TempData.getData(10)));
    }
}

package com.osanwen.xhsprototype.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.NoteCommentFoldAdapter;
import com.osanwen.xhsprototype.util.TempData;

/**
 * 二级评论
 * Created by liusaibao on 10/09/2017.
 */

public class NoteCommentFoldView extends LinearLayout {

    public NoteCommentFoldView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_comment_fold, this, true);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.rv_second_comment_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new NoteCommentFoldAdapter(TempData.getData(2)));
    }
}

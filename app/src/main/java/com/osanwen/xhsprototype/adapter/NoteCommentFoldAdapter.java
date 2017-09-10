package com.osanwen.xhsprototype.adapter;

import android.support.annotation.Nullable;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.base.BaseQuickAdapter;
import com.osanwen.xhsprototype.adapter.base.BaseViewHolder;
import com.osanwen.xhsprototype.library.vlayout.LayoutHelper;
import com.osanwen.xhsprototype.util.TempData;

import java.util.List;

/**
 * 二级评论
 * Created by liusaibao on 10/09/2017.
 */

public class NoteCommentFoldAdapter extends BaseQuickAdapter<TempData, BaseViewHolder> {

    public NoteCommentFoldAdapter(@Nullable List<TempData> data) {
        super(R.layout.view_note_second_comment, data);
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return null;
    }

    @Override
    protected void convert(BaseViewHolder helper, TempData item) {

    }
}

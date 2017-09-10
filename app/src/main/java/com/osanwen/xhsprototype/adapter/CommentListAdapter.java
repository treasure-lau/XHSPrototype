package com.osanwen.xhsprototype.adapter;

import android.support.annotation.Nullable;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.base.BaseQuickAdapter;
import com.osanwen.xhsprototype.adapter.base.BaseViewHolder;
import com.osanwen.xhsprototype.library.vlayout.LayoutHelper;
import com.osanwen.xhsprototype.util.TempData;

import java.util.List;

/**
 * 评论列表
 * Created by liusaibao on 10/09/2017.
 */

public class CommentListAdapter extends BaseQuickAdapter<TempData, BaseViewHolder> {

    public CommentListAdapter(@Nullable List<TempData> data) {
        super(R.layout.view_comment, data);
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return null;
    }

    @Override
    protected void convert(BaseViewHolder helper, TempData item) {

    }
}

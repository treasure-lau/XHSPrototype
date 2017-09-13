package com.osanwen.xhsprototype.adapter;

import android.support.annotation.Nullable;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.base.BaseQuickAdapter;
import com.osanwen.xhsprototype.adapter.base.BaseViewHolder;
import com.osanwen.xhsprototype.library.vlayout.LayoutHelper;
import com.osanwen.xhsprototype.util.TempData;

import java.util.List;

/**
 * 关注用户
 * Created by liusaibao on 12/09/2017.
 */

public class FollowUserAdapter extends BaseQuickAdapter<TempData, BaseViewHolder> {

    public FollowUserAdapter(@Nullable List<TempData> data) {
        super(R.layout.listitem_follow, data);
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return null;
    }

    @Override
    protected void convert(BaseViewHolder helper, TempData item) {

    }
}

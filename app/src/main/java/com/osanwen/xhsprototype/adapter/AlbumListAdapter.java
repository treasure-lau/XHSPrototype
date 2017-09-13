package com.osanwen.xhsprototype.adapter;

import android.support.annotation.Nullable;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.base.BaseQuickAdapter;
import com.osanwen.xhsprototype.adapter.base.BaseViewHolder;
import com.osanwen.xhsprototype.library.vlayout.LayoutHelper;
import com.osanwen.xhsprototype.util.TempData;

import java.util.List;

/**
 * 专题列表
 * Created by liusaibao on 12/09/2017.
 */

public class AlbumListAdapter extends BaseQuickAdapter<TempData, BaseViewHolder> {

    public AlbumListAdapter(@Nullable List<TempData> data) {
        super(R.layout.layout_board, data);
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return null;
    }

    @Override
    protected void convert(BaseViewHolder helper, TempData item) {

    }
}

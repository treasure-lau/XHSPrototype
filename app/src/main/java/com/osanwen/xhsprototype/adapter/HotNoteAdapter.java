package com.osanwen.xhsprototype.adapter;

import android.support.annotation.Nullable;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.base.BaseQuickAdapter;
import com.osanwen.xhsprototype.adapter.base.BaseViewHolder;
import com.osanwen.xhsprototype.library.vlayout.LayoutHelper;
import com.osanwen.xhsprototype.library.vlayout.layout.LinearLayoutHelper;
import com.osanwen.xhsprototype.util.TempData;

import java.util.List;

/**
 * 热门长笔记
 * Created by liusaibao on 30/07/2017.
 */

public class HotNoteAdapter extends BaseQuickAdapter<TempData, BaseViewHolder> {

    public HotNoteAdapter(@Nullable List<TempData> data) {
        super(R.layout.item_main_hot_note, data);
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new LinearLayoutHelper();
    }

    @Override
    protected void convert(BaseViewHolder helper, TempData item) {
        helper.setImageResource(R.id.iv_note_ic, item.drawableResId);
    }
}

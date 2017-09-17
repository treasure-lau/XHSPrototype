package com.osanwen.xhsprototype.adapter;

import android.support.annotation.Nullable;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.base.BaseQuickAdapter;
import com.osanwen.xhsprototype.adapter.base.BaseViewHolder;
import com.osanwen.xhsprototype.library.vlayout.LayoutHelper;
import com.osanwen.xhsprototype.library.vlayout.layout.StaggeredGridLayoutHelper;
import com.osanwen.xhsprototype.util.TempData;

import java.util.ArrayList;
import java.util.List;

/**
 * 搜索笔记结果
 * Created by liusaibao on 27/08/2017.
 */

public class SearchNoteAdapter extends BaseQuickAdapter<TempData, BaseViewHolder> {


    public SearchNoteAdapter() {
        super(R.layout.item_search_note_new, new ArrayList<TempData>());
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new StaggeredGridLayoutHelper(2);
    }

    @Override
    protected void convert(BaseViewHolder helper, TempData item) {

    }
}

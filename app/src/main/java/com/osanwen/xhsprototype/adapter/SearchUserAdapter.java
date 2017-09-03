package com.osanwen.xhsprototype.adapter;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.base.BaseQuickAdapter;
import com.osanwen.xhsprototype.adapter.base.BaseViewHolder;
import com.osanwen.xhsprototype.library.vlayout.LayoutHelper;
import com.osanwen.xhsprototype.library.vlayout.layout.StaggeredGridLayoutHelper;
import com.osanwen.xhsprototype.util.TempData;

import java.util.ArrayList;

/**
 * 搜索笔记结果
 * Created by liusaibao on 27/08/2017.
 */

public class SearchUserAdapter extends BaseQuickAdapter<TempData, BaseViewHolder> {


    public SearchUserAdapter() {
        super(R.layout.item_search_user, new ArrayList<TempData>());
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return null;
    }

    @Override
    protected void convert(BaseViewHolder helper, TempData item) {

    }
}

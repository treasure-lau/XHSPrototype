package com.osanwen.xhsprototype.adapter;

import android.support.annotation.Nullable;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.base.BaseQuickAdapter;
import com.osanwen.xhsprototype.adapter.base.BaseViewHolder;
import com.osanwen.xhsprototype.library.vlayout.LayoutHelper;
import com.osanwen.xhsprototype.util.TempData;

import java.util.List;

/**
 * 搜索结果
 * Created by liusaibao on 30/07/2017.
 */

public class SearchResultAdapter extends BaseQuickAdapter<TempData, BaseViewHolder> {

    public SearchResultAdapter(@Nullable List<TempData> data) {
        super(R.layout.item_search_result, data);
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return null;
    }

    @Override
    protected void convert(BaseViewHolder helper, TempData item) {
        helper.setText(R.id.title_tv, item.text1);
    }
}

package com.osanwen.xhsprototype.adapter.base;

import android.support.annotation.Nullable;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.library.vlayout.LayoutHelper;
import com.osanwen.xhsprototype.util.TempData;

import java.util.List;

/**
 * 绑定
 * Created by liusaibao on 12/09/2017.
 */

public class BindAdapter extends BaseQuickAdapter<TempData, BaseViewHolder> {

    public BindAdapter(@Nullable List<TempData> data) {
        super(R.layout.item_bind_list, data);
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return null;
    }

    @Override
    protected void convert(BaseViewHolder helper, TempData item) {
        helper.setImageResource(R.id.type_icon, item.drawableResId);
        helper.setText(R.id.tv_type_name, item.text1);
    }
}

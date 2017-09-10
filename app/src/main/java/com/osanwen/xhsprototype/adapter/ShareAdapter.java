package com.osanwen.xhsprototype.adapter;

import android.support.annotation.Nullable;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.base.BaseQuickAdapter;
import com.osanwen.xhsprototype.adapter.base.BaseViewHolder;
import com.osanwen.xhsprototype.library.vlayout.LayoutHelper;
import com.osanwen.xhsprototype.util.TempData;

import java.util.List;

/**
 *
 * Created by liusaibao on 10/09/2017.
 */

public class ShareAdapter extends BaseQuickAdapter<TempData, BaseViewHolder> {

    public ShareAdapter(@Nullable List<TempData> data) {
        super(R.layout.share_item, data);
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return null;
    }

    @Override
    protected void convert(BaseViewHolder helper, TempData item) {
        helper.setImageResource(R.id.image, item.drawableResId);
        helper.setText(R.id.text, item.text1);
    }
}

package com.osanwen.xhsprototype.adapter;

import android.support.annotation.Nullable;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.base.BaseQuickAdapter;
import com.osanwen.xhsprototype.adapter.base.BaseViewHolder;
import com.osanwen.xhsprototype.library.vlayout.LayoutHelper;
import com.osanwen.xhsprototype.util.TempData;

import java.util.List;

/**
 * 热门视频
 * Created by liusaibao on 30/07/2017.
 */

public class HotVideoAdapter extends BaseQuickAdapter<TempData, BaseViewHolder> {

    public HotVideoAdapter(@Nullable List<TempData> data) {
        super(R.layout.item_main_hot_video, data);
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return null;
    }

    @Override
    protected void convert(BaseViewHolder helper, TempData item) {
        helper.setImageResource(R.id.iv_item_img, item.drawableResId);
        helper.setText(R.id.tv_view_count, item.text1);
        helper.setText(R.id.tv_item_desc, item.text2);
    }
}

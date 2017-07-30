package com.osanwen.xhsprototype.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.base.BaseQuickAdapter;
import com.osanwen.xhsprototype.adapter.base.BaseViewHolder;
import com.osanwen.xhsprototype.library.vlayout.LayoutHelper;
import com.osanwen.xhsprototype.library.vlayout.layout.LinearLayoutHelper;
import com.osanwen.xhsprototype.util.TempData;

import java.util.List;

/**
 * 热门话题
 * Created by liusaibao on 30/07/2017.
 */

public class HotTopicAdapter extends BaseQuickAdapter<TempData, BaseViewHolder> {

    public HotTopicAdapter(@Nullable List<TempData> data) {
        super(R.layout.item_main_hot_topic, data);
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new LinearLayoutHelper();
    }

    @Override
    protected void convert(BaseViewHolder helper, TempData item) {
        helper.setImageResource(R.id.iv_topic_ic, item.drawableResId);
        helper.setText(R.id.tv_topic_name, item.text1);
        helper.setText(R.id.tv_topic_follow_count, item.text2);
    }
}

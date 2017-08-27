package com.osanwen.xhsprototype.adapter;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.base.BaseMultiItemQuickAdapter;
import com.osanwen.xhsprototype.adapter.base.BaseViewHolder;
import com.osanwen.xhsprototype.adapter.base.entity.MultiItemEntity;
import com.osanwen.xhsprototype.library.vlayout.LayoutHelper;
import com.osanwen.xhsprototype.util.TempData;

import java.util.List;

/**
 * 发布图文笔记的图片列表
 * Created by liusaibao on 27/08/2017.
 */

public class PushNoteAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public static final int ADD_PIC_ITEM_TYPE = 1;
    public static final int SHOW_PIC_ITEM_TYPE = 2;

    public PushNoteAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(ADD_PIC_ITEM_TYPE, R.layout.widget_add_icon_item);
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return null;
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {

    }
}

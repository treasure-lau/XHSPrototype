package com.osanwen.xhsprototype.entity;

import com.osanwen.xhsprototype.adapter.PushNoteAdapter;
import com.osanwen.xhsprototype.adapter.base.entity.MultiItemEntity;

/**
 * 添加图片的类型
 * Created by liusaibao on 27/08/2017.
 */

public class AddPicEntity implements MultiItemEntity {

    @Override
    public int getItemType() {
        return PushNoteAdapter.ADD_PIC_ITEM_TYPE;
    }
}

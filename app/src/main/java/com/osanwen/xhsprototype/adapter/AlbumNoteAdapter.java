package com.osanwen.xhsprototype.adapter;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.base.BaseQuickAdapter;
import com.osanwen.xhsprototype.adapter.base.BaseViewHolder;
import com.osanwen.xhsprototype.library.vlayout.LayoutHelper;
import com.osanwen.xhsprototype.library.vlayout.layout.StaggeredGridLayoutHelper;
import com.osanwen.xhsprototype.util.TempData;

import java.util.ArrayList;

/**
 * 专辑笔记
 * Created by liusaibao on 27/08/2017.
 */

public class AlbumNoteAdapter extends BaseQuickAdapter<TempData, BaseViewHolder> {


    private boolean isEdit = false;

    public AlbumNoteAdapter() {
        super(R.layout.item_album_note, new ArrayList<TempData>());
    }

    public void setEdit(boolean edit) {
        isEdit = edit;
        notifyDataSetChanged();
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new StaggeredGridLayoutHelper(2);
    }

    @Override
    protected void convert(BaseViewHolder helper, TempData item) {
        helper.setVisible(R.id.btn_select, isEdit);
    }
}

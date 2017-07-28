package com.osanwen.xhsprototype.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.osanwen.xhsprototype.R;

/**
 * 首页item pager
 * Created by liusaibao on 29/07/2017.
 */

public class MainItemPagerView extends RelativeLayout {

    public MainItemPagerView(Context context) {
        super(context);

        LayoutInflater.from(context).inflate(R.layout.view_main_item_pager, this, true);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();


    }
}

package com.osanwen.xhsprototype.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.osanwen.xhsprototype.R;


/**
 * 首页item标题
 * Created by liusaibao on 29/07/2017.
 */

public class MainItemTitleView extends RelativeLayout {

    public MainItemTitleView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.view_main_item_title, this, true);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

    }
}

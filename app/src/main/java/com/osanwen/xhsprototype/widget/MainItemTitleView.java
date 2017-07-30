package com.osanwen.xhsprototype.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.osanwen.xhsprototype.R;


/**
 * 首页item标题
 * Created by liusaibao on 29/07/2017.
 */

public class MainItemTitleView extends RelativeLayout {

    private TextView mTextView1;
    private TextView mTextView2;

    public MainItemTitleView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.view_main_item_title, this, true);
        mTextView1 = (TextView) findViewById(R.id.tv_label_name);
        mTextView2 = (TextView) findViewById(R.id.tv_label_see_more);
    }

    public void setData(int stringResId) {
        mTextView1.setText(stringResId);
        if (stringResId == R.string.multi_notes) {
            mTextView2.setVisibility(View.GONE);
        }
    }
}

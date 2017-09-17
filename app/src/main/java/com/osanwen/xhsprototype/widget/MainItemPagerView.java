package com.osanwen.xhsprototype.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.activity.NoteDetailActivity;
import com.osanwen.xhsprototype.adapter.ImagePagerAdapter;
import com.osanwen.xhsprototype.util.TempData;

import java.util.List;

/**
 * 首页item pager
 * Created by liusaibao on 29/07/2017.
 */

public class MainItemPagerView extends RelativeLayout {

    private ViewPager mViewPager;
    private TextView mTextView;

    public MainItemPagerView(Context context) {
        super(context);

        LayoutInflater.from(context).inflate(R.layout.view_main_item_pager, this, true);
        mViewPager = (ViewPager) findViewById(R.id.pager_image);
        mTextView = (TextView) findViewById(R.id.indicator);
    }

    public void setData(List<TempData> dataList) {
        ImagePagerAdapter adapter = new ImagePagerAdapter(dataList);
        adapter.setListener(new ImagePagerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(TempData data) {
                getContext().startActivity(NoteDetailActivity.createIntent(getContext()));
            }
        });
        mViewPager.setAdapter(adapter);
        mTextView.setText("1/3");
    }
}

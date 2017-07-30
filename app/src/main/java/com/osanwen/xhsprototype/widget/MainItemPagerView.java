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
        mViewPager.setAdapter(new MainPagerAdapter(dataList));
        mTextView.setText("1/3");
    }

    private static class MainPagerAdapter extends PagerAdapter {

        private List<TempData> dataList;

        MainPagerAdapter(List<TempData> dataList) {
            this.dataList = dataList;
        }

        @Override
        public int getCount() {
            return dataList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(container.getContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(params);
            imageView.setImageResource(dataList.get(position).drawableResId);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((ImageView)object);
        }
    }
}

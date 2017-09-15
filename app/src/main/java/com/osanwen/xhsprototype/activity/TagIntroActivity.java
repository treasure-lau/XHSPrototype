package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.ImagePagerAdapter;
import com.osanwen.xhsprototype.util.TempData;

/**
 * 话题介绍
 * Created by liusaibao on 03/09/2017.
 */

public class TagIntroActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, TagIntroActivity.class);
    }

    private ViewPager mViewPager;
    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_intro);
        findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mTextView = (TextView) findViewById(R.id.page_num);
        mViewPager.setAdapter(new ImagePagerAdapter(TempData.getPager()));
        mTextView.setText("1/3");
    }
}

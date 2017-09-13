package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.TabFragmentAdapter;
import com.osanwen.xhsprototype.fragment.AlbumListFragment;
import com.osanwen.xhsprototype.fragment.FollowTagFragment;
import com.osanwen.xhsprototype.fragment.FollowUserFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 关注
 * Created by liusaibao on 0页面3/09/2017.
 */

public class FollowActivity extends BaseAppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, FollowActivity.class);
    }

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);
        setTitle(R.string.userprofile_text_tag);
        mViewPager = (ViewPager)findViewById(R.id.viewpager);

        mTabLayout = (TabLayout)findViewById(R.id.tablayout);
        List<String> tabList = new ArrayList<>();
        tabList.add("用户");
        tabList.add("专辑");
        tabList.add("标签");
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(tabList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(tabList.get(1)));

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new FollowUserFragment());
        fragmentList.add(new AlbumListFragment());
        fragmentList.add(new FollowTagFragment());

        TabFragmentAdapter fragmentAdapter = new TabFragmentAdapter(getSupportFragmentManager(), fragmentList, tabList);
        mViewPager.setAdapter(fragmentAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
//        mTabLayout.setTabsFromPagerAdapter(fragmentAdapter);//给Tabs设置适配器
    }
}

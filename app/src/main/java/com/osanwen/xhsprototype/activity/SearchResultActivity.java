package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.TabFragmentAdapter;
import com.osanwen.xhsprototype.fragment.SearchNoteFragment;
import com.osanwen.xhsprototype.fragment.SearchUserFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 搜索结果
 * Created by liusaibao on 11/08/2017.
 */

public class SearchResultActivity extends BaseAppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    public static Intent createIntent(Context context) {
        return new Intent(context, SearchResultActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        setTitle("搜索结果");
        mViewPager = (ViewPager)findViewById(R.id.pager);

        mTabLayout = (TabLayout)findViewById(R.id.tabs);
        List<String> tabList = new ArrayList<>();
        tabList.add("笔记");
        tabList.add("用户");
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(tabList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(tabList.get(1)));

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new SearchNoteFragment());
        fragmentList.add(new SearchUserFragment());

        TabFragmentAdapter fragmentAdapter = new TabFragmentAdapter(getSupportFragmentManager(), fragmentList, tabList);
        mViewPager.setAdapter(fragmentAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
//        mTabLayout.setTabsFromPagerAdapter(fragmentAdapter);//给Tabs设置适配器
    }
}

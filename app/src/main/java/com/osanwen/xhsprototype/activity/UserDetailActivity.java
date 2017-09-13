package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.TabFragmentAdapter;
import com.osanwen.xhsprototype.fragment.SearchNoteFragment;
import com.osanwen.xhsprototype.fragment.AlbumListFragment;
import com.osanwen.xhsprototype.widget.ShareDialogFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息
 * Created by liusaibao on 03/09/2017.
 */

public class UserDetailActivity extends BaseAppCompatActivity implements View.OnClickListener {

    public static Intent createIntent(Context context) {
        return new Intent(context, UserDetailActivity.class);
    }

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(toolbar);
        addBackEvent();
        setTitle("");

        findViewById(R.id.iv_user_ic).setOnClickListener(this);
        findViewById(R.id.attent_count_layout).setOnClickListener(this);
        findViewById(R.id.fans_count_layout).setOnClickListener(this);

        final RelativeLayout mRelativeLayout = (RelativeLayout)findViewById(R.id.mine_info_layout);
        SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_layout);
        mSwipeRefreshLayout.setEnabled(false);

        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("lyb2518");
                    mRelativeLayout.setVisibility(View.INVISIBLE);
                    isShow = true;
                } else if(isShow) {
                    collapsingToolbar.setTitle("");//carefull there should a space between double quote otherwise it wont work
                    mRelativeLayout.setVisibility(View.VISIBLE);
                    isShow = false;
                }
            }
        });
        mViewPager = (ViewPager)findViewById(R.id.viewpager);

        mTabLayout = (TabLayout)findViewById(R.id.tab_layout);
        List<String> tabList = new ArrayList<>();
        tabList.add("笔记 · 10");
        tabList.add("专辑 · 10");
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(tabList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(tabList.get(1)));

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new SearchNoteFragment());
        fragmentList.add(new AlbumListFragment());

        TabFragmentAdapter fragmentAdapter = new TabFragmentAdapter(getSupportFragmentManager(), fragmentList, tabList);
        mViewPager.setAdapter(fragmentAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_user_ic:
                break;
            case R.id.attent_count_layout:
                startActivity(FollowActivity.createIntent(this));
                break;
            case R.id.fans_count_layout:
                break;
        }
    }

    @Override
    protected boolean isAddBackEvent() {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_share, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share) {
            ShareDialogFragment dialog = new ShareDialogFragment();
            dialog.show(getSupportFragmentManager(), "user share dialog");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

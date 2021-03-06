package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.HotNoteAdapter;
import com.osanwen.xhsprototype.adapter.HotTopicAdapter;
import com.osanwen.xhsprototype.adapter.base.BaseQuickAdapter;
import com.osanwen.xhsprototype.library.vlayout.DelegateAdapter;
import com.osanwen.xhsprototype.library.vlayout.VirtualLayoutManager;
import com.osanwen.xhsprototype.util.TempData;
import com.osanwen.xhsprototype.widget.MainItemHotVideoView;
import com.osanwen.xhsprototype.widget.MainItemPagerView;
import com.osanwen.xhsprototype.widget.MainItemTitleView;

import java.util.ArrayList;
import java.util.List;

/**
 * 主页面
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static Intent createIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private DelegateAdapter mDelegateAdapter;
    private RecyclerView mRecyclerView;
    private DrawerLayout drawer;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            toolbar.setElevation(0);
        }
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initView();
        initListener();
        initData();
    }

    private void initView() {
        mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.main_refresh);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.base_red);


        mRecyclerView = (RecyclerView) findViewById(R.id.main_list);

        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);

        mDelegateAdapter = new DelegateAdapter(layoutManager);
        mRecyclerView.setAdapter(mDelegateAdapter);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView)findViewById(R.id.nav_view);
    }

    private void initListener() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
        findViewById(R.id.ic_header).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(SearchActivity.createIntent(MainActivity.this));
            }
        });
        mNavigationView.getHeaderView(0).findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(UserDetailActivity.createIntent(MainActivity.this));
                drawer.closeDrawer(GravityCompat.START);
            }
        });
    }

    private void initData() {

        List<DelegateAdapter.Adapter> adapters = new ArrayList<>();

        MainItemPagerView pagerView = new MainItemPagerView(this);
        pagerView.setData(TempData.getPager());
        adapters.add(DelegateAdapter.simpleAdapter(pagerView));

        MainItemTitleView topicView = new MainItemTitleView(this);
        topicView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(HotTopicActivity.createIntent(MainActivity.this));
            }
        });
        topicView.setData(R.string.topicGuide);
        HotTopicAdapter hotTopicAdapter = new HotTopicAdapter(TempData.getData(3));
        hotTopicAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(TagDetailActivity.createIntent(MainActivity.this));
            }
        });
        adapters.add(DelegateAdapter.simpleAdapter(topicView));
        adapters.add(hotTopicAdapter);

        MainItemTitleView videoView = new MainItemTitleView(this);
        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(HotVideoActivity.createIntent(MainActivity.this));
            }
        });
        videoView.setData(R.string.hot_video);
        adapters.add(DelegateAdapter.simpleAdapter(videoView));
        MainItemHotVideoView hotVideoView = new MainItemHotVideoView(this);
        hotVideoView.setData(TempData.getVideo());
        adapters.add(DelegateAdapter.simpleAdapter(hotVideoView));

        MainItemTitleView noteView = new MainItemTitleView(this);
        noteView.setData(R.string.multi_notes);
        adapters.add(DelegateAdapter.simpleAdapter(noteView));
        final HotNoteAdapter noteAdapter = new HotNoteAdapter(TempData.getNote());
        noteAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                noteAdapter.addData(TempData.getNote());
                noteAdapter.loadMoreComplete();
            }
        }, mRecyclerView);
        noteAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(NoteDetailActivity.createIntent(MainActivity.this));
            }
        });
        adapters.add(noteAdapter);

        mDelegateAdapter.addAdapters(adapters);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_push_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add) {
            startActivity(ChosePushTypeActivity.createIntent(this));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_account_info) {
            startActivity(ProfileEditActivity.createIntent(this));
        } else if (id == R.id.nav_account_bind) {
            startActivity(BindActivity.createIntent(this));
        } else if (id == R.id.nav_modify_password) {
            startActivity(ModifyPasswordActivity.createIntent(this));
        } else if (id == R.id.nav_about) {
            startActivity(AboutActivity.createIntent(this));
        } else if (id == R.id.nav_feedback) {
            // todo 跳转页面
        } else if (id == R.id.nav_logout) {
            startActivity(LoginActivity.createIntent(this));
            finish();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

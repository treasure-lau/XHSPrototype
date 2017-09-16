package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.AlbumNoteAdapter;
import com.osanwen.xhsprototype.adapter.base.BaseQuickAdapter;
import com.osanwen.xhsprototype.library.vlayout.DelegateAdapter;
import com.osanwen.xhsprototype.library.vlayout.VirtualLayoutManager;
import com.osanwen.xhsprototype.util.TempData;
import com.osanwen.xhsprototype.widget.ShareDialogFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 专辑详情
 * Created by liusaibao on 03/09/2017.
 */

public class AlbumDetailActivity extends BaseAppCompatActivity implements View.OnClickListener {

    public static Intent createIntent(Context context) {
        return new Intent(context, AlbumDetailActivity.class);
    }

    private RecyclerView mRecyclerView;
    private DelegateAdapter mDelegateAdapter;
    private AlbumNoteAdapter mAdapter;

    private RelativeLayout mRelativeLayout;
    private TextView followTv;

    private MenuItem shareItem;
    private MenuItem manageItem;
    private MenuItem finishItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail);
        setTitle(R.string.album);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.edit_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_album_detail);
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);

        mDelegateAdapter = new DelegateAdapter(layoutManager);
        mRecyclerView.setAdapter(mDelegateAdapter);

        mAdapter = new AlbumNoteAdapter();
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(NoteDetailActivity.createIntent(AlbumDetailActivity.this));
            }
        });
        mAdapter.addData(TempData.getData(10));
        View view = getLayoutInflater().inflate(R.layout.board_info_layout, mRecyclerView, false);
        followTv = (TextView) view.findViewById(R.id.btn_follow);
        followTv.setOnClickListener(this);
        followTv.setBackgroundResource(R.drawable.btn_follow_selected);
        followTv.setText(R.string.title_edit_wish_list);
        followTv.setTextAppearance(this, R.style.TextSmall_Red);
        followTv.setVisibility(View.GONE);
        List<DelegateAdapter.Adapter> adapters = new ArrayList<>();
        adapters.add(DelegateAdapter.simpleAdapter(view));
        adapters.add(mAdapter);
        mDelegateAdapter.setAdapters(adapters);
        findViewById(R.id.btn_delete_to_other).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_album_detail, menu);
        shareItem = menu.findItem(R.id.action_share);
        manageItem = menu.findItem(R.id.action_manage);
        finishItem = menu.findItem(R.id.action_finish);
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
        if (id == R.id.action_manage) {
            finishItem.setVisible(true);
            shareItem.setVisible(false);
            manageItem.setVisible(false);
            mRelativeLayout.setVisibility(View.VISIBLE);
            mAdapter.setEdit(true);
            followTv.setVisibility(View.VISIBLE);
            return true;
        }
        if (id == R.id.action_finish) {
            finishItem.setVisible(false);
            shareItem.setVisible(true);
            manageItem.setVisible(true);
            mRelativeLayout.setVisibility(View.GONE);
            mAdapter.setEdit(false);
            followTv.setVisibility(View.GONE);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_delete_to_other:
                startActivity(MoveAlbumActivity.createIntent(this));
                break;
            case R.id.btn_follow:
                startActivity(AlbumEditActivity.createIntent(this));
                break;
        }
    }
}

package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.SearchNoteAdapter;
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

public class SubjectDetailActivity extends BaseAppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, SubjectDetailActivity.class);
    }

    private RecyclerView mRecyclerView;
    private DelegateAdapter mDelegateAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_detail);
        setTitle(R.string.album);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_subject_detail);
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);

        mDelegateAdapter = new DelegateAdapter(layoutManager);
        mRecyclerView.setAdapter(mDelegateAdapter);

        SearchNoteAdapter adapter = new SearchNoteAdapter();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(NoteDetailActivity.createIntent(SubjectDetailActivity.this));
            }
        });
        adapter.addData(TempData.getData(10));
        List<DelegateAdapter.Adapter> adapters = new ArrayList<>();
        adapters.add(DelegateAdapter.simpleAdapter(getLayoutInflater().inflate(R.layout.board_info_layout, mRecyclerView, false)));
        adapters.add(adapter);
        mDelegateAdapter.setAdapters(adapters);
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

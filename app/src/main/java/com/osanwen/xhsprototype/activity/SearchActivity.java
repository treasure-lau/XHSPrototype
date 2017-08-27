package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.SearchAdapter;
import com.osanwen.xhsprototype.adapter.base.BaseQuickAdapter;
import com.osanwen.xhsprototype.util.TempData;
import com.osanwen.xhsprototype.widget.ClearableEditText;

import java.util.ArrayList;

/**
 * 搜索
 * Created by liusaibao on 30/07/2017.
 */

public class SearchActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, SearchActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
    }

    private void initView() {
        ClearableEditText editText = (ClearableEditText)findViewById(R.id.et_text);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.search_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        final SearchAdapter adapter = new SearchAdapter(new ArrayList<TempData>());
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(SearchResultActivity.createIntent(SearchActivity.this));
            }
        });
        recyclerView.setAdapter(adapter);
        editText.setListener(new ClearableEditText.TextChangedListener() {
            @Override
            public void empty() {
                adapter.clear();
            }

            @Override
            public void setValue(String keyword) {
                adapter.replaceData(TempData.getSearchResult());
            }
        });
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

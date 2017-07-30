package com.osanwen.xhsprototype;

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

import com.osanwen.xhsprototype.adapter.SearchResultAdapter;
import com.osanwen.xhsprototype.util.TempData;
import com.osanwen.xhsprototype.widget.ClearableEditText;

import java.util.ArrayList;
import java.util.List;

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
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.search_result_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        final SearchResultAdapter adapter = new SearchResultAdapter(new ArrayList<TempData>());
        recyclerView.setAdapter(adapter);
        editText.setListener(new ClearableEditText.SearchResultListener() {
            @Override
            public void setData(List<TempData> dataList) {
                adapter.replaceData(dataList);
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

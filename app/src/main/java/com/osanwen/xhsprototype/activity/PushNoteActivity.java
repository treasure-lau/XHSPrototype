package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.PushNoteAdapter;
import com.osanwen.xhsprototype.adapter.base.entity.MultiItemEntity;
import com.osanwen.xhsprototype.entity.AddPicEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 发布图文笔记
 * Created by liusaibao on 27/08/2017.
 */

public class PushNoteActivity extends BaseAppCompatActivity implements View.OnClickListener {

    public static Intent createIntent(Context context) {
        return new Intent(context, PushNoteActivity.class);
    }

    private TextView titleTv;
    private TextView contentTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.push_note);
        setContentView(R.layout.activity_push_note);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<MultiItemEntity> aList = new ArrayList<>();
        aList.add(new AddPicEntity());
        recyclerView.setAdapter(new PushNoteAdapter(aList));
        titleTv = (TextView) findViewById(R.id.title_tv);
        titleTv.setOnClickListener(this);
        contentTv = (TextView) findViewById(R.id.text_content);
        contentTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_tv:
            case R.id.text_content:
                startActivity(EditTextActivity.createIntent(this));
                break;
        }
    }
}

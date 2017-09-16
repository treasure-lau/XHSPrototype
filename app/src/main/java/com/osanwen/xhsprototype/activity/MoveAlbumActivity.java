package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.FavAlbumListAdapter;
import com.osanwen.xhsprototype.util.TempData;

/**
 * 移动专辑
 * Created by liusaibao on 03/09/2017.
 */

public class MoveAlbumActivity extends AppCompatActivity implements View.OnClickListener {

    public static Intent createIntent(Context context) {
        return new Intent(context, MoveAlbumActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_album);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.listview_fav);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new FavAlbumListAdapter(TempData.getData(2)));
        findViewById(R.id.ic_close).setOnClickListener(this);
        findViewById(R.id.add_board).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ic_close:
                finish();
                break;
            case R.id.add_board:
                startActivity(AlbumEditActivity.createIntent(this));
                break;
        }
    }
}

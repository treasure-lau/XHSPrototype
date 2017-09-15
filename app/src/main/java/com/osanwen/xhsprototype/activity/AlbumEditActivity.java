package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.osanwen.xhsprototype.R;

/**
 * 新建、编辑专辑
 * Created by liusaibao on 03/09/2017.
 */

public class AlbumEditActivity extends BaseAppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, AlbumEditActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_edit);
        setTitle(R.string.title_create_wish_list);
    }
}

package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.osanwen.xhsprototype.R;

/**
 * 发布图文笔记
 * Created by liusaibao on 27/08/2017.
 */

public class PushVideoActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, PushVideoActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_video);
    }
}

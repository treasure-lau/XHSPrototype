package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.osanwen.xhsprototype.R;

/**
 * 选择发笔记的类型
 * Created by liusaibao on 27/08/2017.
 */

public class ChosePushTypeActivity extends AppCompatActivity implements View.OnClickListener {


    public static Intent createIntent(Context context) {
        return new Intent(context, ChosePushTypeActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_push_type);
        findViewById(R.id.push_note).setOnClickListener(this);
        findViewById(R.id.push_video).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.push_note:
                startActivity(PushNoteActivity.createIntent(this));
                break;
            case R.id.push_video:
                startActivity(PushVideoActivity.createIntent(this));
                break;
        }
    }
}

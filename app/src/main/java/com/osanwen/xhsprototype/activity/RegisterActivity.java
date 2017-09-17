package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.osanwen.xhsprototype.R;

/**
 * 注册
 * Created by liusaibao on 23/07/2017.
 */

public class RegisterActivity extends BaseAppCompatActivity implements View.OnClickListener {

    public static Intent createIntent(Context context) {
        return new Intent(context, RegisterActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle(R.string.title_register);
        findViewById(R.id.btn_register).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}

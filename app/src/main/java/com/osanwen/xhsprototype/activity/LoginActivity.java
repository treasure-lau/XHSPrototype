package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.osanwen.xhsprototype.R;

/**
 * 登录
 * Created by liusaibao on 23/07/2017.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    public static Intent createIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.tv_quick_register).setOnClickListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_quick_register:
                startActivity(RegisterActivity.createIntent(this));
                break;
            case R.id.btn_login:
                startActivity(MainActivity.createIntent(this));
                break;
        }
    }
}

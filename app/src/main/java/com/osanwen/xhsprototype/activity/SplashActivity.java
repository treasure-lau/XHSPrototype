package com.osanwen.xhsprototype.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.osanwen.xhsprototype.R;

/**
 * 启动页
 * Created by liusaibao on 23/07/2017.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(LoginActivity.createIntent(SplashActivity.this));
            }
        }, 2 * 1000);
    }
}

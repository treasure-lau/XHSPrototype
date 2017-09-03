package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 用户信息
 * Created by liusaibao on 03/09/2017.
 */

public class UserInfoActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, UserInfoActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}

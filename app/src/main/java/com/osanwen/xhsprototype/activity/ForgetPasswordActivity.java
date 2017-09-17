package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.osanwen.xhsprototype.R;

/**
 * 忘记密码
 * Created by liusaibao on 23/07/2017.
 */

public class ForgetPasswordActivity extends BaseAppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, ForgetPasswordActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        setTitle(R.string.forget_password_title);
    }
}

package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.osanwen.xhsprototype.R;

/**
 * 个人设置
 * Created by liusaibao on 03/09/2017.
 */

public class ProfileEditActivity extends BaseAppCompatActivity implements View.OnClickListener {

    public static Intent createIntent(Context context) {
        return new Intent(context, ProfileEditActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);
        setTitle(R.string.setting_account_info);
        findViewById(R.id.rl_icon).setOnClickListener(this);
        findViewById(R.id.rl_nick).setOnClickListener(this);
//        findViewById(R.id.rl_red_id).setOnClickListener(this);
        findViewById(R.id.rl_xingbie).setOnClickListener(this);
        findViewById(R.id.rl_place).setOnClickListener(this);
        findViewById(R.id.rl_birthday).setOnClickListener(this);
        findViewById(R.id.rl_sign).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_icon:
                break;
            case R.id.rl_nick:
                startActivity(NicknameEditActivity.createIntent(this));
                break;
//            case R.id.rl_red_id:
//                startActivity(IdEditActivity.createIntent(this));
//                break;
            case R.id.rl_xingbie:
                break;
            case R.id.rl_place:
                break;
            case R.id.rl_birthday:
                break;
            case R.id.rl_sign:
                startActivity(SignEditActivity.createIntent(this));
                break;
        }
    }
}

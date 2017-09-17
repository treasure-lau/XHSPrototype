package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.osanwen.xhsprototype.R;

/**
 * 粉丝页面
 * Created by liusaibao on 03/09/2017.
 */

public class FansActivity extends BaseAppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, FansActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fans);
        setTitle(R.string.ta_fans);
    }
}

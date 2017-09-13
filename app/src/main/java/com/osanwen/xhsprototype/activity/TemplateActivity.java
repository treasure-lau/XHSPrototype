package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 *
 * Created by liusaibao on 03/09/2017.
 */

public class TemplateActivity extends BaseAppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, TemplateActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}

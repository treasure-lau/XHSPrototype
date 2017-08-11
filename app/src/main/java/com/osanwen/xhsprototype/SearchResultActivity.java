package com.osanwen.xhsprototype;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 搜索结果
 * Created by liusaibao on 11/08/2017.
 */

public class SearchResultActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, SearchResultActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

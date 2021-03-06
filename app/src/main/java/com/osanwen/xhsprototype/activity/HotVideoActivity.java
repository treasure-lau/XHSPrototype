package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.osanwen.xhsprototype.R;

/**
 * 热门视频页面
 * Created by liusaibao on 03/09/2017.
 */

public class HotVideoActivity extends BaseAppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, HotVideoActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_video);
        setTitle(R.string.hot_video);
    }
}

package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;

import com.osanwen.xhsprototype.R;

/**
 * 编辑签名页面
 * Created by liusaibao on 03/09/2017.
 */

public class SignEditActivity extends BaseAppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, SignEditActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_edit);
        setTitle(R.string.ed_sign);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_finish, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_finish) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

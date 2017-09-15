package com.osanwen.xhsprototype.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.widget.AddFavPopWindow;
import com.osanwen.xhsprototype.widget.PushCommentPopWindow;
import com.osanwen.xhsprototype.widget.ShareDialogFragment;

/**
 * 笔记详情
 * Created by liusaibao on 03/09/2017.
 */

public class NoteDetailActivity extends BaseAppCompatActivity implements View.OnClickListener {

    private PushCommentPopWindow pushCommentPopWindow;
    private AddFavPopWindow addFavPopWindow;

    public static Intent createIntent(Context context) {
        return new Intent(context, NoteDetailActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addBackEvent();
        setTitle("");

        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("笔记详情");
                    isShow = true;
                } else if(isShow) {
                    collapsingToolbar.setTitle("");//carefull there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }
        });
        for (int i = 0; i < 3; i++) {
            LinearLayout commentLL = (LinearLayout) findViewById(R.id.comment_content);
            View view = getLayoutInflater().inflate(R.layout.item_note_detail_comment, commentLL, false);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_second_comment);
            linearLayout.setVisibility(View.VISIBLE);
            linearLayout.addView(getLayoutInflater().inflate(R.layout.view_second_comment, linearLayout, false));
            commentLL.addView(view);
        }

        pushCommentPopWindow = new PushCommentPopWindow(this);
        addFavPopWindow = new AddFavPopWindow(this);

        findViewById(R.id.tv_comment).setOnClickListener(this);
        findViewById(R.id.rl_comment_list_title).setOnClickListener(this);
        findViewById(R.id.see_all_comment).setOnClickListener(this);
        findViewById(R.id.note_detail_collect_layout).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_comment_list_title:
            case R.id.see_all_comment:
                startActivity(CommentListActivity.createIntent(this));
                break;
            case R.id.tv_comment:
                pushCommentPopWindow.showPopupWindow();
                break;
            case R.id.note_detail_collect_layout:
                addFavPopWindow.showPopupWindow();
                break;
        }
    }

    @Override
    protected boolean isAddBackEvent() {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_note_more, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_more) {
            ShareDialogFragment dialog = new ShareDialogFragment();
            dialog.show(getSupportFragmentManager(), "more dialog");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.osanwen.xhsprototype.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.library.keyboard.EmoticonsKeyBoardPopWindow;
import com.osanwen.xhsprototype.library.keyboard.adpater.EmoticonsAdapter;
import com.osanwen.xhsprototype.library.keyboard.adpater.PageSetAdapter;
import com.osanwen.xhsprototype.library.keyboard.data.EmoticonPageEntity;
import com.osanwen.xhsprototype.library.keyboard.data.EmoticonPageSetEntity;
import com.osanwen.xhsprototype.library.keyboard.interfaces.EmoticonClickListener;
import com.osanwen.xhsprototype.library.keyboard.interfaces.EmoticonDisplayListener;
import com.osanwen.xhsprototype.library.keyboard.interfaces.PageViewInstantiateListener;
import com.osanwen.xhsprototype.library.keyboard.widget.EmoticonPageView;
import com.sj.emoji.DefEmoticons;
import com.sj.emoji.EmojiBean;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 笔记详情
 * Created by liusaibao on 03/09/2017.
 */

public class NoteDetailActivity extends BaseAppCompatActivity {

    private EmoticonsKeyBoardPopWindow popWindow;

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

        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("");
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
        LinearLayout commentLL = (LinearLayout)findViewById(R.id.comment_content);
        commentLL.addView(getLayoutInflater().inflate(R.layout.item_note_detail_comment, commentLL, false));
        commentLL.addView(getLayoutInflater().inflate(R.layout.item_note_detail_comment, commentLL, false));
        commentLL.addView(getLayoutInflater().inflate(R.layout.item_note_detail_comment, commentLL, false));

        findViewById(R.id.tv_comment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(NoteDetailActivity.this);
//                View sheetView = getLayoutInflater().inflate(R.layout.layout_comment_popup, null);
//                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                mBottomSheetDialog.setContentView(sheetView, params);
//                mBottomSheetDialog.show();
//                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(sheetView);
//                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                popWindow.showPopupWindow();
            }
        });
        initEmoticonsKeyBoardPopWindow();
    }

    private void initEmoticonsKeyBoardPopWindow() {
        popWindow = new EmoticonsKeyBoardPopWindow(this);
        // source data
        ArrayList<EmojiBean> emojiArray = new ArrayList<>();
        Collections.addAll(emojiArray, DefEmoticons.getDefEmojiArray());
        // emoticon click
        final EmoticonClickListener emoticonClickListener = new EmoticonClickListener() {
            @Override
            public void onEmoticonClick(Object o, int actionType, boolean isDelBtn) {
//                if (isDelBtn) {
//                    int action = KeyEvent.ACTION_DOWN;
//                    int code = KeyEvent.KEYCODE_DEL;
//                    KeyEvent event = new KeyEvent(action, code);
//                    ek_bar.getEtChat().onKeyDown(KeyEvent.KEYCODE_DEL, event);
//                } else {
//                    if (o == null) {
//                        return;
//                    }
//                    String content = null;
//                    if (o instanceof EmojiBean) {
//                        content = ((EmojiBean) o).emoji;
//                    }
//                    int index = ek_bar.getEtChat().getSelectionStart();
//                    Editable editable = ek_bar.getEtChat().getText();
//                    editable.insert(index, content);
//                }
            }
        };

        // emoticon instantiate
        final EmoticonDisplayListener emoticonDisplayListener = new EmoticonDisplayListener() {
            @Override
            public void onBindView(int i, ViewGroup viewGroup, EmoticonsAdapter.ViewHolder viewHolder, Object object, final boolean isDelBtn) {
                final EmojiBean emojiBean = (EmojiBean) object;
                if (emojiBean == null && !isDelBtn) {
                    return;
                }

                viewHolder.ly_root.setBackgroundResource(R.drawable.bg_emoticon);

                if (isDelBtn) {
                    viewHolder.iv_emoticon.setImageResource(R.drawable.icon_del);
                } else {
                    viewHolder.iv_emoticon.setImageResource(emojiBean.icon);
                }

                viewHolder.rootView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        emoticonClickListener.onEmoticonClick(emojiBean, 0, isDelBtn);
                    }
                });
            }
        };

        //  page instantiate
        PageViewInstantiateListener pageViewInstantiateListener = new PageViewInstantiateListener<EmoticonPageEntity>() {
            @Override
            public View instantiateItem(ViewGroup viewGroup, int i, EmoticonPageEntity pageEntity) {
                if (pageEntity.getRootView() == null) {
                    EmoticonPageView pageView = new EmoticonPageView(viewGroup.getContext());
                    pageView.setNumColumns(pageEntity.getRow());
                    pageEntity.setRootView(pageView);
                    try {
                        EmoticonsAdapter adapter = new EmoticonsAdapter(viewGroup.getContext(), pageEntity, null);
                        // emoticon instantiate
                        adapter.setOnDisPlayListener(emoticonDisplayListener);
                        pageView.getEmoticonsGridView().setAdapter(adapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return pageEntity.getRootView();
            }
        };
        // build
        EmoticonPageSetEntity xhsPageSetEntity
                = new EmoticonPageSetEntity.Builder()
                .setLine(3)
                .setRow(7)
                .setEmoticonList(emojiArray)
                .setIPageViewInstantiateItem(pageViewInstantiateListener)
                .setShowDelBtn(EmoticonPageEntity.DelBtnStatus.LAST)
                .setIconUri(R.drawable.icon_emoji)
                .build();

        PageSetAdapter pageSetAdapter = new PageSetAdapter();
        pageSetAdapter.add(xhsPageSetEntity);
        popWindow.setAdapter(pageSetAdapter);
    }

    @Override
    protected boolean isAddBackEvent() {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.more, menu);
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

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

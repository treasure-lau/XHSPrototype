package com.osanwen.xhsprototype.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.library.keyboard.EmoticonsKeyBoardPopWindow;
import com.osanwen.xhsprototype.library.keyboard.adpater.EmoticonsAdapter;
import com.osanwen.xhsprototype.library.keyboard.adpater.PageSetAdapter;
import com.osanwen.xhsprototype.library.keyboard.data.EmoticonPageEntity;
import com.osanwen.xhsprototype.library.keyboard.data.EmoticonPageSetEntity;
import com.osanwen.xhsprototype.library.keyboard.data.PageSetEntity;
import com.osanwen.xhsprototype.library.keyboard.interfaces.EmoticonClickListener;
import com.osanwen.xhsprototype.library.keyboard.interfaces.EmoticonDisplayListener;
import com.osanwen.xhsprototype.library.keyboard.interfaces.PageViewInstantiateListener;
import com.osanwen.xhsprototype.library.keyboard.widget.EmoticonPageView;
import com.osanwen.xhsprototype.library.keyboard.widget.EmoticonsFuncView;
import com.osanwen.xhsprototype.library.keyboard.widget.EmoticonsIndicatorView;
import com.osanwen.xhsprototype.library.keyboard.widget.EmoticonsToolBarView;
import com.sj.emoji.DefEmoticons;
import com.sj.emoji.EmojiBean;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 键盘表情
 * Created by liusaibao on 10/09/2017.
 */

public class EmoticonsKeyBoardLayout extends RelativeLayout implements EmoticonsFuncView.OnEmoticonsPageViewListener, EmoticonsToolBarView.OnToolBarItemClickListener {

    private EmoticonsFuncView mEmoticonsFuncView;
    private EmoticonsIndicatorView mEmoticonsIndicatorView;
    private EmoticonsToolBarView mEmoticonsToolBarView;

    public EmoticonsKeyBoardLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_func_emoticon, this, true);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mEmoticonsFuncView = ((EmoticonsFuncView) findViewById(R.id.view_epv));
        mEmoticonsIndicatorView = (EmoticonsIndicatorView) findViewById(R.id.view_eiv);
        mEmoticonsToolBarView = (EmoticonsToolBarView) findViewById(R.id.view_etv);
        mEmoticonsFuncView.setOnIndicatorListener(this);
        mEmoticonsToolBarView.setOnToolBarItemClickListener(this);
        initEmoticonsKeyBoardPopWindow();
    }

    private void initEmoticonsKeyBoardPopWindow() {
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
        setAdapter(pageSetAdapter);
    }

    private void setAdapter(PageSetAdapter pageSetAdapter) {
        if (pageSetAdapter != null) {
            ArrayList<PageSetEntity> pageSetEntities = pageSetAdapter.getPageSetEntityList();
            if (pageSetEntities != null) {
                for (PageSetEntity pageSetEntity : pageSetEntities) {
                    mEmoticonsToolBarView.addToolItemView(pageSetEntity);
                }
            }
        }
        mEmoticonsFuncView.setAdapter(pageSetAdapter);
    }

    @Override
    public void emoticonSetChanged(PageSetEntity pageSetEntity) {
        mEmoticonsToolBarView.setToolBtnSelect(pageSetEntity.getUuid());
    }

    @Override
    public void playTo(int position, PageSetEntity pageSetEntity) {
        mEmoticonsIndicatorView.playTo(position, pageSetEntity);
    }

    @Override
    public void playBy(int oldPosition, int newPosition, PageSetEntity pageSetEntity) {
        mEmoticonsIndicatorView.playBy(oldPosition, newPosition, pageSetEntity);
    }

    @Override
    public void onToolBarItemClick(PageSetEntity pageSetEntity) {
        mEmoticonsFuncView.setCurrentPageSet(pageSetEntity);
    }
}

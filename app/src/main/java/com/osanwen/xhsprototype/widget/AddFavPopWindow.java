package com.osanwen.xhsprototype.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.activity.AlbumEditActivity;
import com.osanwen.xhsprototype.adapter.FavAlbumListAdapter;
import com.osanwen.xhsprototype.library.keyboard.utils.EmoticonsKeyboardUtils;
import com.osanwen.xhsprototype.util.TempData;

/**
 * 收藏弹窗
 * Created by LiuSaibao on 9/15/2017.
 */

public class AddFavPopWindow extends PopupWindow implements View.OnClickListener {

    private Context mContext;

    public AddFavPopWindow(Context context) {
        super(context, null);
        this.mContext = context;
        View contentView = LayoutInflater.from(context).inflate(R.layout.add_fav_layout, null);
        setContentView(contentView);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setAnimationStyle(R.style.PopupAnimation);
        setOutsideTouchable(true);
        update();
        ColorDrawable dw = new ColorDrawable(0000000000);
        setBackgroundDrawable(dw);
        contentView.findViewById(R.id.add_new_board).setOnClickListener(this);
        RecyclerView mRecyclerView = (RecyclerView)contentView.findViewById(R.id.listview_fav);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(new FavAlbumListAdapter(TempData.getData(2)));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_new_board:
                mContext.startActivity(AlbumEditActivity.createIntent(mContext));
                break;
        }
    }

    public void showPopupWindow() {
        View rootView = EmoticonsKeyboardUtils.getRootView((Activity) mContext);
        if (this.isShowing()) {
            this.dismiss();
        } else {
            this.showAtLocation(rootView, Gravity.BOTTOM, 0, 0);
        }
    }
}

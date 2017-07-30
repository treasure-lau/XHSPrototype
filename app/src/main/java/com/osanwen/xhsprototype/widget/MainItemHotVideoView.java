package com.osanwen.xhsprototype.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.HotVideoAdapter;
import com.osanwen.xhsprototype.util.TempData;

import java.util.List;

/**
 * 热门视频
 * Created by liusaibao on 30/07/2017.
 */

public class MainItemHotVideoView extends RelativeLayout {

    private RecyclerView mRecyclerView;

    public MainItemHotVideoView(Context context) {
        super(context);

        LayoutInflater.from(context).inflate(R.layout.view_hot_video, this, true);
        mRecyclerView = (RecyclerView)findViewById(R.id.hot_video_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
    }

    public void setData(List<TempData> dataList) {
        mRecyclerView.setAdapter(new HotVideoAdapter(dataList));
    }
}

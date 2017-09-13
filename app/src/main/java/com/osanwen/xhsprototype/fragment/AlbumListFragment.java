package com.osanwen.xhsprototype.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.activity.AlbumDetailActivity;
import com.osanwen.xhsprototype.adapter.base.BaseQuickAdapter;
import com.osanwen.xhsprototype.adapter.AlbumListAdapter;
import com.osanwen.xhsprototype.util.TempData;

/**
 * 专题列表
 * Created by liusaibao on 12/09/2017.
 */

public class AlbumListFragment extends Fragment {

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_album_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_album_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AlbumListAdapter adapter = new AlbumListAdapter(TempData.getData(10));
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(AlbumDetailActivity.createIntent(getContext()));
            }
        });
        mRecyclerView.setAdapter(adapter);
    }
}

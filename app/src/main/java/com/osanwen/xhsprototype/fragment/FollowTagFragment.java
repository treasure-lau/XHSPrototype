package com.osanwen.xhsprototype.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.activity.UserDetailActivity;
import com.osanwen.xhsprototype.adapter.FollowTagAdapter;
import com.osanwen.xhsprototype.adapter.FollowUserAdapter;
import com.osanwen.xhsprototype.adapter.base.BaseQuickAdapter;
import com.osanwen.xhsprototype.util.TempData;

/**
 * 关注标签页面
 * Created by LiuSaibao on 9/13/2017.
 */

public class FollowTagFragment extends Fragment {

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_follow_tag, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_follow_tag);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FollowTagAdapter adapter = new FollowTagAdapter(TempData.getData(10));
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
        mRecyclerView.setAdapter(adapter);
    }
}

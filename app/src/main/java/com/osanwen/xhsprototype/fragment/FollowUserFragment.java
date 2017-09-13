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
import com.osanwen.xhsprototype.activity.UserDetailActivity;
import com.osanwen.xhsprototype.adapter.FollowUserAdapter;
import com.osanwen.xhsprototype.adapter.base.BaseQuickAdapter;
import com.osanwen.xhsprototype.util.TempData;

/**
 * 关注用户页面
 * Created by LiuSaibao on 9/13/2017.
 */

public class FollowUserFragment extends Fragment {

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_follow_user, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_follow_user);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FollowUserAdapter adapter = new FollowUserAdapter(TempData.getData(10));
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(UserDetailActivity.createIntent(getContext()));
            }
        });
        mRecyclerView.setAdapter(adapter);
    }
}

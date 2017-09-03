package com.osanwen.xhsprototype.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.SearchUserAdapter;
import com.osanwen.xhsprototype.util.TempData;

/**
 * 搜索用户结果页面
 * Created by liusaibao on 27/08/2017.
 */

public class SearchUserFragment extends Fragment {

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_user, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_user_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SearchUserAdapter adapter = new SearchUserAdapter();
        adapter.addData(TempData.getData(10));
        mRecyclerView.setAdapter(adapter);
    }
}

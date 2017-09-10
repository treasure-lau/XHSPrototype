package com.osanwen.xhsprototype.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.adapter.ShareAdapter;
import com.osanwen.xhsprototype.util.TempData;

/**
 * 分享
 * Created by liusaibao on 10/09/2017.
 */

public class ShareDialogFragment extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_share, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycleView);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 4);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ShareAdapter(TempData.getShareData()));
        return view;
    }
}

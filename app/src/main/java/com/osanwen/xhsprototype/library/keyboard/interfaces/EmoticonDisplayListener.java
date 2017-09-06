package com.osanwen.xhsprototype.library.keyboard.interfaces;

import android.view.ViewGroup;

import com.osanwen.xhsprototype.library.keyboard.adpater.EmoticonsAdapter;

public interface EmoticonDisplayListener<T> {

    void onBindView(int position, ViewGroup parent, EmoticonsAdapter.ViewHolder viewHolder, T t, boolean isDelBtn);
}

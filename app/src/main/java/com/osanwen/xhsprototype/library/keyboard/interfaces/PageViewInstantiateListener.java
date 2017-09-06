package com.osanwen.xhsprototype.library.keyboard.interfaces;

import android.view.View;
import android.view.ViewGroup;

import com.osanwen.xhsprototype.library.keyboard.data.PageEntity;

public interface PageViewInstantiateListener<T extends PageEntity> {

    View instantiateItem(ViewGroup container, int position, T pageEntity);
}

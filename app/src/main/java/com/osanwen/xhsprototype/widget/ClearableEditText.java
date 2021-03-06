package com.osanwen.xhsprototype.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.osanwen.xhsprototype.R;
import com.osanwen.xhsprototype.util.TempData;
import com.osanwen.xhsprototype.util.TextWatcherAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 可清空文本的edittext
 * Created by liusaibao on 30/07/2017.
 */

public class ClearableEditText extends FrameLayout {

    public ClearableEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_clearable_edittext, this, true);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        final EditText editText = (EditText)findViewById(R.id.text);
        final ImageView imageView = (ImageView)findViewById(R.id.btn_delete);
        imageView.setVisibility(View.GONE);
        editText.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                String value = s.toString();
                if (TextUtils.isEmpty(value)) {
                    imageView.setVisibility(View.GONE);
                    if (mListener != null) {
                        mListener.empty();
                    }
                } else {
                    if (imageView.getVisibility() == View.GONE) {
                        imageView.setVisibility(View.VISIBLE);
                    }
                    if (mListener != null) {
                        mListener.setValue(value);
                    }
                }
            }
        });
        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.GONE);
                editText.getText().clear();
            }
        });
    }

    private TextChangedListener mListener;

    public void setListener(TextChangedListener mListener) {
        this.mListener = mListener;
    }

    public interface TextChangedListener {
        void empty();
        void setValue(String keyword);
    }
}

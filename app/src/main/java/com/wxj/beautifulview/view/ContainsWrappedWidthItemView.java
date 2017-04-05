package com.wxj.beautifulview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * User: W03673
 * Date: 2017/4/5.
 * Time: 16:22.
 * Descriptions: 子项根据自身宽度加入到该ViewGroup中
 */

public class ContainsWrappedWidthItemView extends ViewGroup {

    public ContainsWrappedWidthItemView(Context context) {
        super(context);
    }

    public ContainsWrappedWidthItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }
}

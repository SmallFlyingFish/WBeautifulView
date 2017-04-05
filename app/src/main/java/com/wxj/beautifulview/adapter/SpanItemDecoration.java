package com.wxj.beautifulview.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * User: W03673
 * Date: 2017/4/5.
 * Time: 11:28.
 * Descriptions:
 */

public class SpanItemDecoration extends RecyclerView.ItemDecoration {
    private int spaceSize;

    public SpanItemDecoration(int spaceSize) {
        this.spaceSize = spaceSize;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = spaceSize;
        outRect.right = spaceSize;
        outRect.bottom = spaceSize;

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildPosition(view) == 0)
            outRect.top = spaceSize;
    }
}

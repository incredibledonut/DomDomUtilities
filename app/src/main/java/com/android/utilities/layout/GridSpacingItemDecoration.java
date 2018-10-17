package com.android.utilities.layout;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private int mSpanCount;
    private float mSpace;

    public GridSpacingItemDecoration(int spanCount, int space) {
        this.mSpanCount = spanCount;
        mSpace = space;
    }

    @Override
    public void getItemOffsets(final Rect outRect,
                               final View view,
                               RecyclerView parent,
                               RecyclerView.State state) {

        final int position = parent.getChildLayoutPosition(view);
        final int column = position % mSpanCount;
        final int spacing = (int) mSpace;

        outRect.left = spacing - column * spacing / mSpanCount;
        outRect.right = (column + 1) * spacing / mSpanCount;
        outRect.top = (position < mSpanCount) ? spacing : 0;
        outRect.bottom = spacing;
    }
}
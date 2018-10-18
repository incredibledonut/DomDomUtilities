package com.android.utilities.layout;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class LinearSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public LinearSpacingItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect,
                               View view,
                               RecyclerView parent,
                               RecyclerView.State state) {

        final int position = parent.getChildLayoutPosition(view);

        outRect.left = space;
        outRect.right = space;
        outRect.top = (position == 0) ? space : 0;
        outRect.bottom = space;
    }
}

package com.android.utilities.layout.textview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by Ying on 6/15/2016.
 */
public class GeorgiaBoldItalicTextView extends AppCompatTextView {
    public GeorgiaBoldItalicTextView(Context context) {
        super(context);
        setupTypeface(context);
    }

    public GeorgiaBoldItalicTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupTypeface(context);
    }

    public GeorgiaBoldItalicTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupTypeface(context);
    }

    private void setupTypeface(Context context) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Georgia-Bold-Italic.ttf"));
    }
}

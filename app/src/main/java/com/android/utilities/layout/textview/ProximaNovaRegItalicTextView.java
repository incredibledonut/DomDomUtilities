package com.android.utilities.layout.textview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Ying on 6/15/2016.
 */
public class ProximaNovaRegItalicTextView extends AppCompatTextView {
    public ProximaNovaRegItalicTextView(Context context) {
        super(context);
        setupTypeface(context);
    }

    public ProximaNovaRegItalicTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupTypeface(context);
    }

    public ProximaNovaRegItalicTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupTypeface(context);
    }

    private void setupTypeface(Context context) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/ProximaNova-RegItalic" +
                ".otf"));
    }
}

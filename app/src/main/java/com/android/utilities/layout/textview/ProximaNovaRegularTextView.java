package com.android.utilities.layout.textview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by Ying on 6/15/2016.
 */
public class ProximaNovaRegularTextView extends AppCompatTextView {
    public ProximaNovaRegularTextView(Context context) {
        super(context);
        setupTypeface(context);
    }

    public ProximaNovaRegularTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupTypeface(context);
    }

    public ProximaNovaRegularTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupTypeface(context);
    }

    private void setupTypeface(Context context) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/ProximaNova-Regular.otf"));
    }
}

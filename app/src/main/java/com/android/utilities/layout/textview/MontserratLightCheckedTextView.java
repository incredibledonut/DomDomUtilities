package com.android.utilities.layout.textview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.util.AttributeSet;

public class MontserratLightCheckedTextView extends AppCompatCheckedTextView {

    public MontserratLightCheckedTextView(Context context) {
        super(context);
        setupTypeface(context);
    }

    public MontserratLightCheckedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupTypeface(context);
    }

    public MontserratLightCheckedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupTypeface(context);
    }

    private void setupTypeface(Context context) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Montserrat-Light.ttf"));
    }

}

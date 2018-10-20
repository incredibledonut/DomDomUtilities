package com.android.utilities.layout.edittext;


import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

/**
 * Created by Ying on 6/15/2016.
 */
public class MontserratLightEditText extends AppCompatEditText {
    public MontserratLightEditText(Context context) {
        super(context);
        setupTypeface(context);
    }

    public MontserratLightEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupTypeface(context);
    }

    public MontserratLightEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupTypeface(context);
    }

    private void setupTypeface(Context context) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/MontSerrat-Light.ttf"));
    }
}
package com.android.utilities.layout.edittext;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Ying on 6/15/2016.
 */
public class ProximaNovaBoldEditText extends AppCompatEditText {
    public ProximaNovaBoldEditText(Context context) {
        super(context);
        setupTypeface(context);
    }

    public ProximaNovaBoldEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupTypeface(context);
    }

    public ProximaNovaBoldEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupTypeface(context);
    }

    private void setupTypeface(Context context) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/ProximaNova-Bold.otf"));
    }
}

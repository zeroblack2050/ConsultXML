package com.cosmo.LecturaXML.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

import com.cosmo.LecturaXML.R;

/**
 * Created by Superadmin1 on 18/11/2017.
 */

public class CustomTextView extends AppCompatTextView {

    public CustomTextView(Context context) {
        super(context);
        setAllCaps(true);
        //setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        setTextColor(ContextCompat.getColor(context,R.color.colorPrimaryDark));
        setHeight(50);
        setWidth(getMaxWidth());
        setBottom(5);
        setTypeface(Typeface.SANS_SERIF);
        setTypeface(Typeface.DEFAULT_BOLD);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setAllCaps(true);
        //setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        setTextColor(ContextCompat.getColor(context,R.color.colorAccent));
        setHeight(50);
        setWidth(getMaxWidth());
        setBottom(5);
        setTypeface(Typeface.SANS_SERIF);
        setTypeface(Typeface.DEFAULT_BOLD);
    }
}

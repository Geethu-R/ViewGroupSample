package com.tringapps.viewgroupsample;

import android.content.Context;
import android.content.res.TypedArray;
import android.renderscript.ScriptGroup;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by geethu on 16/12/16.
 */

public class TestCustomView extends LinearLayout {

    int input_type;
    int src;
    int color;
    EditText userNameView;
    ImageView imageView;
    String hint;

    public TestCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,R.styleable.TestCustomView,0,0);

        try {
            hint = a.getString(R.styleable.TestCustomView_hint);
            color = a.getColor(R.styleable.TestCustomView_text_color, 0);
            src = a.getResourceId(R.styleable.TestCustomView_image_src,R.drawable.user);
            input_type = a.getInt(R.styleable.TestCustomView_android_inputType,EditorInfo.TYPE_NULL);

        }finally {

        }

        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.inflater,this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        userNameView = (EditText) findViewById(R.id.usernameView);
        imageView = (ImageView) findViewById(R.id.imageView);
        userNameView.setHint(hint);
        userNameView.setTextColor(color);
        userNameView.setHintTextColor(color);
        imageView.setImageResource(src);
        userNameView.setInputType(input_type);
    }

}

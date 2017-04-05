package com.wxj.beautifulview;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.Gravity;

/**
 * User: W03673
 * Date: 2017/3/30.
 * Time: 18:04.
 * Descriptions:
 */

public class MyDialog extends Dialog {
    public MyDialog(@NonNull Context context) {
        this(context, R.style.MyDialog);
    }

    public MyDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_float);
        assert getWindow() != null;
        getWindow().setGravity(Gravity.CENTER);

        setCanceledOnTouchOutside(true);
        setCancelable(false);
    }
}

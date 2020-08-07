package com.ty.find.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;

public class ItemGradview extends GridView {
    public ItemGradview(Context context) {
        super(context);
    }

    public ItemGradview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ItemGradview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ItemGradview(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            return true;

        }
        return super.dispatchTouchEvent(ev);
    }
}

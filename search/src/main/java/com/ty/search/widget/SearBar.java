package com.ty.search.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.ty.search.R;

public class SearBar extends LinearLayout {

   private ITitleinterface  iTitleinterface;

    public void setiTitleinterface(ITitleinterface iTitleinterface) {
        this.iTitleinterface = iTitleinterface;
    }

    public SearBar(Context context) {
        super(context);
    }

    public SearBar(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.widget_searbar,this);
        ImageView imageView = findViewById(R.id.back);
        TextView textView = findViewById(R.id.yes);
        final EditText editText = findViewById(R.id.edt_input);

        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                iTitleinterface.onClickBack(v);
            }
        });

        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               iTitleinterface.getContent( editText.getText().toString());
            }
        });

    }

    public SearBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SearBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public interface ITitleinterface{
        void onClickBack(View view);
        void getContent(String txt);
    }
}

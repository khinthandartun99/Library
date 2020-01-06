package com.example.myapp.Utils;

import android.graphics.Typeface;
import android.widget.Button;
import android.widget.TextView;


import com.example.myapp.MainApplication;

import me.myatminsoe.mdetect.MDetect;

public class FontEmbedder {

    private static Typeface typeface;

    public static void init(Typeface typeface){
        FontEmbedder.typeface = typeface;
    }

    public static void force(TextView textView, String text){
        textView.setText(Moulder.mercyOnZgUser(text));
        textView.setTypeface(typeface);
    }

    public static void forceTitle(TextView textView, String text) {
        textView.setText(Moulder.mercyOnZgUser(text));
        if(MDetect.INSTANCE.isUnicode()) {
            textView.setTypeface(MainApplication.typefaceManager.getMyanmarSagar());
        } else {
            textView.setTypeface(typeface);
        }
    }

    public static void force(Button button, String text){
        button.setText(Moulder.mercyOnZgUser(text));
        button.setTypeface(typeface);
    }

    public static void force(Button button){
        force(button, button.getText().toString());
    }

}

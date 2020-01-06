package com.example.myapp;

import android.app.Application;

import com.example.myapp.Utils.FontEmbedder;
import com.example.myapp.Utils.Moulder;
import com.example.myapp.Utils.TypefaceManager;

import me.myatminsoe.mdetect.MDetect;

public class MainApplication extends Application {
    public static TypefaceManager typefaceManager;

    @Override
    public void onCreate() {
        super.onCreate();

        MDetect.INSTANCE.init(this);
        typefaceManager = new TypefaceManager(getAssets());

        if (MDetect.INSTANCE.isUnicode()){
            FontEmbedder.init(typefaceManager.getShitUnicode());
            Moulder.init(true);
        }else {
            FontEmbedder.init(typefaceManager.getShitZawgyi());
            Moulder.init(false);
        }
    }

}

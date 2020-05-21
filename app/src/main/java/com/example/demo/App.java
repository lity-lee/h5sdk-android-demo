package com.example.demo;

import android.app.Application;

import com.example.x5library.CoralInit;
import com.example.x5library.CoralWebView;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CoralInit.Init(getApplicationContext());
    }
}

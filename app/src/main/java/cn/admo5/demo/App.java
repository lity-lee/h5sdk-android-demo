package cn.admo5.demo;

import android.app.Application;


import cn.admo5.x5Library.CoralInit;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CoralInit.Init(getApplicationContext());
    }
}

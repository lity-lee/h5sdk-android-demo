package com.example.demo;

import android.os.Bundle;
import android.view.View;

import com.example.x5library.CoralWebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WebActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        CoralWebView cwv = findViewById(R.id.cwb);
        cwv.getSettings().setJavaScriptEnabled(true);// 支持js
        cwv.getSettings().setUseWideViewPort(true); //自适应屏幕
        cwv.loadUrl("http://h5-demo.sdk.2bx.com/index.html");
    }
}

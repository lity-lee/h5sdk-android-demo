package cn.admo5.demo;

import cn.admo5.x5Library.WebViewBuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WebActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebViewBuilder.create().start(MainActivity.this,"http://h5-demo.sdk.2bx.com/index.html");
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebViewBuilder.create()
                        .headCreate()
                        .setHtext("广告")
                        .build()
                        .start(MainActivity.this,"http://h5-demo.sdk.2bx.com/index.html");
            }
        });

    }
}

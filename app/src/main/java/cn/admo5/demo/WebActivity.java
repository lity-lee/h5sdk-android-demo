package cn.admo5.demo;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebChromeClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import cn.admo5.x5Library.CoralWebView;
import cn.admo5.x5Library.WebTool;

public class WebActivity extends AppCompatActivity {

    private WebTool mWebTool;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        CoralWebView cwv = findViewById(R.id.cwb);
        cwv.getSettings().setJavaScriptEnabled(true);// 支持js
        cwv.getSettings().setUseWideViewPort(true); //自适应屏幕
        mWebTool = new WebTool(cwv,this);
        cwv.loadUrl("http://h5-demo.sdk.2bx.com/index.html");
        cwv.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String s, String s1, String s2, String s3, long l) {
                Toast.makeText(WebActivity.this,"s"+s+"s1"+s1+"s2"+s2+"s3"+s3,Toast.LENGTH_SHORT).show();
//                Log.w(WebActivity.this.getClass().getName(),);
            }

        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWebTool.onRecycle();
    }
}

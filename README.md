##  1 导入文件：
###  1.1 导入aar依赖包
##### 下载arr文件 [h5sdk2020xxxx-1.0.0.aar](http://admo5-static.2bx.com/h5sdk/aar/h5sdk20200522-1.0.0.aar "h5sdk2020xxxx-1.0.0.aar") , (xxxx是库的编译日期)复制到应用Module/libs文件夹（没有的话须手动创建）并将以下代码添加到您app的build.gradle中:
```xml
   repositories {
        flatDir {
            dirs 'libs', '../libs'
        }
    }
	 depedencies {
	compile(name:'h5sdk20200522-1.0.0', ext:'aar')
	}
```
### 1.2添加对应的权限

```xml
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission  android:name="android.permission.READ_PHONE_STATE" />
```
## 2适配不同版本
### #### 2.1 适配7.0及以上
##### 为获取更好的广告推荐效果，以及提高激励视频广告、下载类广告等填充率，建议在广告请求前， 合适的时机获取手机权限：如果您的应用需要在Anroid7.0及以上环境运行，请在AndroidManifest中添加如下代码：
``
```xml
<provider
        android:name="android.support.v4.content.FileProvider"
        android:authorities="${applicationId}.fileprovider"
        android:exported="false"
        android:grantUriPermissions="true">
        <meta-data
         android:name="android.support.FILE_PROVIDER_PATHS"
         android:resource="@xml/filepaths" />
    </provider>
```
##### 在res/xml目录下，新建一个xml文件filepaths，在该文件中添加如下代码：
```xml
<?xml version="1.0" encoding="utf-8"?>
    <paths   xmlns:android="http://schemas.android.com/apk/res/android">
             <root-path name="root" path="" />
             <external-path name="external_storage_root" path="." />
             <external-path name="external_storage_download" path="Download" />
             <files-path path="images/" name="my_images" />
          </paths>
```
### 2.2为了适配9.0激励适配广告，请在入口的Appcation 添加

### android:usesCleartextTraffic=”true”

### 2.3适配Androidx请在AndroidManifest请在将android.support.v4.content.FileProvider换成 android:name="androidx.core.content.FileProvider"
```xml
 android:name="android.support.v4.content.FileProvider"
 android:name="androidx.core.content.FileProvider"
```
## 3 SDK集成部署介绍
### 3.1初始化SDK
##### 在你的Application 加入CoralInit.Init(getApplicationContext());
````xml
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CoralInit.Init(getApplicationContext());
    }
}
````
### 3.2使用CoralWebView替换android原生webView
```xml
   <cn.admo5.x5Library.CoralWebView
        android:id="@+id/cwb"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

```
### 3.3加载对应接入广告的H5页面代码如下：
```java
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
```
##### 或快速调用
```xml
	WebViewBuilder.create().headBarShow(true).start(MainActivity.this,"http://h5-demo.sdk.2bx.com/index.html");
	WebViewBuilder.create().start(MainActivity.this,"http://h5-demo.sdk.2bx.com/index.html");

```

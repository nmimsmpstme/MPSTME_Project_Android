package com.example.jukeboxplayer;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class YouTube extends Activity {

private WebView mWebView;
private String extra;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.videos_layout);       

        
    mWebView = (WebView) findViewById(R.id.videos_webview); 
    mWebView.getSettings().setJavaScriptEnabled(true);
    mWebView.getSettings().setPluginsEnabled(true);

    final Activity activity = this;
    mWebView.setWebChromeClient(new WebChromeClient() {
      public void onProgressChanged(WebView view, int progress) {
        // Activities and WebViews measure progress with different scales.
        // The progress meter will automatically disappear when we reach 100%
        activity.setProgress(progress * 1000);
      }
    });

    mWebView.setWebViewClient(new MyOwnWebViewClient());   


    mWebView.loadUrl("http://m.youtube.com/channel/UC-9-kyTW8ZkZNDHQJ6FgpwQ");     
    mWebView.setWebViewClient(new MyOwnWebViewClient());      
}


@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
        mWebView.goBack();
        return true;
    }
    return super.onKeyDown(keyCode, event);
}
}

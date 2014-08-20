package com.example.scoreit;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class PlayStore extends Activity {

private WebView mWebView;
private String extra;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.playstore_layout);       

        
    mWebView = (WebView) findViewById(R.id.videos_webview); 
    mWebView.getSettings().setJavaScriptEnabled(true);
    

    final Activity activity = this;
    mWebView.setWebChromeClient(new WebChromeClient() {
      public void onProgressChanged(WebView view, int progress) {
    
        activity.setProgress(progress * 1000);
      }
    });

    mWebView.setWebViewClient(new MyOwnWebViewClient());   


    mWebView.loadUrl("http://play.google.com/store");     
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

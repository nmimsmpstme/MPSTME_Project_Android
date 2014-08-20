package com.example.scoreit;

import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MyOwnWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

}

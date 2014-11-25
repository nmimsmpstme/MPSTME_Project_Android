package com.example.jukeboxplayer;

import android.webkit.WebView;
import android.webkit.WebViewClient;
//Enables the possibility for the User to navigate in the WebView and prevents,
//that the Standard-Browser is invoked

public class MyOwnWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

}

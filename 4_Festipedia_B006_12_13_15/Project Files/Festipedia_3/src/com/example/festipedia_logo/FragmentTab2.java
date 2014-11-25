package com.example.festipedia_logo;

import com.actionbarsherlock.app.SherlockFragment;




import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class FragmentTab2 extends SherlockFragment {
	int flag1=0;
	String a;
	//@Override
	FragmentTab2(String x)
	{a=x;}
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragmenttab2, container, false);
		return rootView;}
	@Override public void onViewCreated(View view, Bundle savedInstanceState) 
	{ super.onViewCreated(view, savedInstanceState);
	
	//Log.d("value of url", a);
		WebView web=(WebView) getView().findViewById(R.id.webView1);
		web.reload();
		web.getSettings().setJavaScriptEnabled(true);
		//String url =  "https://maps.google.co.in/maps?q=mpstme&ie=UTF-8&ei=bFgKU7H6OoL4rQenx4HACw&sqi=2&ved=0CAkQ_AUoAw";
		String url=a;
		WebViewClient webClient = new WebViewClient()
	    {
	        @Override
	        public boolean shouldOverrideUrlLoading(WebView  view, String  url)
	        {
	            return false;
	        }
	    };
	    web.setWebViewClient(webClient);
	    
	    web.loadUrl(url);
	
		
	}
	}


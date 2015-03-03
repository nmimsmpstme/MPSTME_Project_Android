package com.example.recurso;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class tabbed_pane extends TabActivity {
	String lang;
	String le;
	int level;
	
	
	
	public void onPause() {
	    overridePendingTransition(R.anim.back_down_in, R.anim.back_down_out);
	    super.onPause();
	}
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabbed_pane);
		Intent in=getIntent();
		 lang=in.getStringExtra("lang");
		 le=in.getStringExtra("level");
		 level=Integer.parseInt(le);
		
		Resources ressources = getResources(); 
		TabHost tabHost = getTabHost(); 

		// Basics tab
		Intent intentBasics = new Intent().setClass(this, Basics.class);
		intentBasics.putExtra("lang", lang);
		TabSpec tabSpecBasics = tabHost
		  .newTabSpec("Basics")
		  .setIndicator("Basics")
		  
		  .setContent(intentBasics);
		

		
		
		// Intermediate tab
		Intent intentIntermediate = new Intent().setClass(this, Intermediate.class);
		intentIntermediate.putExtra("lang", lang);
		TabSpec tabSpecIntermediate = tabHost
		  .newTabSpec("Intermediate")
		  
		  .setIndicator("Inter")
		  .setContent(intentIntermediate);
		
		
		

		// Advanced tab
		Intent intentAdvanced = new Intent().setClass(this, Advanced.class);
		intentAdvanced.putExtra("lang", lang);
		TabSpec tabSpecAdvanced = tabHost
		  .newTabSpec("Advanced")
		  
		  .setIndicator("Advanced")
		  .setContent(intentAdvanced);
		
		
		tabHost.addTab(tabSpecBasics);
		tabHost.addTab(tabSpecIntermediate);
		tabHost.addTab(tabSpecAdvanced);
		
		tabHost.setCurrentTab(level);
		
		
	}
	
}

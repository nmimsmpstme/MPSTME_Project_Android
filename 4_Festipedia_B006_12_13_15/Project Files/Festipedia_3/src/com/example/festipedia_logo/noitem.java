package com.example.festipedia_logo;

import com.actionbarsherlock.app.SherlockFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class noitem extends SherlockFragment {
	String pg;
	public noitem(String x){
		pg=x;
	}

public View onCreateView(LayoutInflater inflater, ViewGroup container,
			
			Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.second);
		
		View rootView = inflater.inflate(R.layout.noitem, container, false);
		TextView t1=(TextView) rootView.findViewById(R.id.textView1);
		if(pg.equals("det")){
			t1.setText("We currently do not have any events for this category at the chosen location");
		}
		else if(pg.equals("search")){
			t1.setText("No matching search results");
		}
		return rootView;
}
}

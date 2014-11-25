package com.example.festipedia_logo;

import com.actionbarsherlock.app.SherlockFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ack extends SherlockFragment {

public View onCreateView(LayoutInflater inflater, ViewGroup container,
			
			Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.second);
		
		View rootView = inflater.inflate(R.layout.ack, container, false);
		return rootView;
}
}

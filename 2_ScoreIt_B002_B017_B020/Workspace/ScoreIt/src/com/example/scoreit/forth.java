package com.example.scoreit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class forth extends Fragment {
	private FragmentActivity fa;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	View v = inflater.inflate(R.layout.home2, container, false);
 ImageButton login=(ImageButton) v.findViewById(R.id.imagebutton11);
 fa = super.getActivity();
        login.setOnClickListener(new View.OnClickListener(){

        	@Override
        	 public void onClick(View v) {

        	 Intent myIntent=new Intent(getActivity(),candy.class);
        	 
        	 startActivity(myIntent);

        	 }});
ImageButton x=(ImageButton) v.findViewById(R.id.fifabutton1);
        
        x.setOnClickListener(new View.OnClickListener(){

        	@Override
        	 public void onClick(View v) {

        	 Intent myIntent=new Intent(getActivity(),simpsons.class);
        	 
        	 startActivity(myIntent);

        	 }});
        
        
ImageButton y=(ImageButton) v.findViewById(R.id.realbutton1);
        
        y.setOnClickListener(new View.OnClickListener(){

        	@Override
        	 public void onClick(View v) {

        	 Intent myIntent=new Intent(getActivity(),blend.class);
        	 
        	startActivity(myIntent);

        	 }});
        
        
        return v;
        
    }


   
    
}

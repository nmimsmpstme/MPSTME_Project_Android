package com.example.festipedia_logo;

import java.util.HashMap;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;

public class searchfrag1 extends SherlockFragment {
	private LinearLayout mLayout;
	private Spinner search;
	private Button submit;
	//private Spinner diffcat=null;
	//private EditText query=null;
	ArrayAdapter<String> adapter,adapter1;
	String[] searchstr,cat;
	String sear,sear1,querystr;
	Spinner spinner;
	Drawable buttonback;
	EditText et1;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.search1, container, false);
		mLayout=(LinearLayout)rootView.findViewById(R.id.linearsearch);
		search=(Spinner)rootView.findViewById(R.id.spinner1);
		//spinner = (Spinner)this.findViewById(R.id.spinner1);
		 searchstr = new String[] { "Category", "Location",
					"College Name","Fest Name"};

		 adapter = new ArrayAdapter<String>(getActivity(),
				  android.R.layout.simple_spinner_dropdown_item,searchstr
				  );
		 search.setAdapter(adapter);
		 Button button1=(Button)rootView.findViewById(R.id.button1);
		 et1=(EditText)rootView.findViewById(R.id.editText1);
		// spinner.setOnClickListener(onClick());
		//mButton= (Button)findViewById(R.id.button1);
		
		/*TextView textView=new TextView(this);
		textView.setText("Hello");*/
		 button1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View view) {
					// creating new product in background thread
			
					/*final FragmentTransaction ft = getFragmentManager().beginTransaction(); 
		            ft.replace(R.id.content_frame,new home1() , "Fest Content"); 
		            ft.commit();*/
					sear=search.getSelectedItem().toString();
					genquery();
					final FragmentTransaction ft = getFragmentManager().beginTransaction(); 
		            ft.replace(R.id.content_frame,new Searchresult(querystr) , "Fest Content"); 
		            ft.commit();
				}
			});
		 		 
		 return rootView;
	}
	

		private void genquery(){
		if(sear=="Category")
		{
			querystr="select * from festipedia1 where category LIKE '%"+et1.getText().toString()+"%' ORDER BY eventname";
		}
		else if(sear=="Location")
		{
			querystr="select * from festipedia1 where location LIKE '%"+et1.getText().toString()+"%' ORDER BY eventname";
		}
		else if(sear=="College Name")
		{
			querystr="select * from festipedia1 where collegename LIKE '%"+et1.getText().toString()+"%' ORDER BY eventname";
		}
		else if(sear=="Fest Name")
		{
			querystr="select * from festipedia1 where eventname LIKE '%"+et1.getText().toString()+"%' ORDER BY eventname";
		}
	}
}

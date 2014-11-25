package com.example.festipedia_logo;

import java.util.HashMap;

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

import com.actionbarsherlock.app.SherlockFragment;

public class searchfrag extends SherlockFragment {
	private LinearLayout mLayout;
	private Spinner search;
	private Button submit;
	private Spinner diffcat=null;
	private EditText query=null;
	ArrayAdapter<String> adapter,adapter1;
	String[] searchstr,cat;
	String sear,sear1,querystr;
	Spinner spinner;
	Drawable buttonback;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.search, container, false);
		mLayout=(LinearLayout)rootView.findViewById(R.id.linearsearch);
		search=(Spinner)rootView.findViewById(R.id.spinner1);
		//spinner = (Spinner)this.findViewById(R.id.spinner1);
		 searchstr = new String[] { "Category", "Location",
					"College Name","Fest Name"};

		 adapter = new ArrayAdapter<String>(getActivity(),
				  android.R.layout.simple_spinner_dropdown_item,searchstr
				  );
		 search.setAdapter(adapter);
		// spinner.setOnClickListener(onClick());
		//mButton= (Button)findViewById(R.id.button1);
		
		/*TextView textView=new TextView(this);
		textView.setText("Hello");*/
		 search.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { 
			    	sear=search.getSelectedItem().toString();
					if(sear!="Category")
						{
							if(query==null)
							{
								if(diffcat!=null)
								{	mLayout.removeView(diffcat);
									//diffcat.setVisibility(android.view.View.GONE);
									diffcat=null;
									mLayout.removeView(submit);
									//submit.setVisibility(android.view.View.GONE);
									submit=null;
								}
								mLayout.addView(createNewControlView());
								mLayout.addView(createNewButtonView());
								submit.setOnClickListener(onClick());
							}
						}
					else
						{
							if(diffcat==null)
							{
								if(query!=null)
								{
									//mLayout.removeView(query);
									mLayout.removeView(query);
									query=null;
									mLayout.removeView(submit);
									submit=null;
								}
								mLayout.addView(createNewSpinnerView());
								mLayout.addView(createNewButtonView());
								submit.setOnClickListener(onClick());
							}
						}
			    } 

			    public void onNothingSelected(AdapterView<?> adapterView) {
			        return;
			    } 
			}); 
		 return rootView;
	}
	private OnClickListener onClick(){
		return new OnClickListener(){
			@Override
			public void onClick(View v){
				if(diffcat!=null){
					sear1=diffcat.getSelectedItem().toString();
				}
				genquery();
				final FragmentTransaction ft = getFragmentManager().beginTransaction(); 
                ft.replace(R.id.content_frame,new Searchresult(querystr) , "Fest Content"); 
                ft.commit();
				}
		};
	}
	private EditText createNewControlView(){
		final LayoutParams lparams=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		//query=new EditText(this,null,R.style.editTextClassic);
		//ContextThemeWrapper newContext = new ContextThemeWrapper(this, R.style.editTextClassic);
		query=new EditText(getActivity());
		query.setLayoutParams(lparams);
		query.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
		//textView.setText("New text:"+text);
		return query;
		
	}
	private Button createNewButtonView(){
		final LayoutParams lparams=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		submit=new Button(getActivity());
		submit.setLayoutParams(lparams);
		submit.setText("Search");
		buttonback=getResources().getDrawable(R.drawable.buttonback);
		submit.setBackground(buttonback);
		return submit;
		
	}
	private Spinner createNewSpinnerView(){
		final LayoutParams lparams=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		diffcat=new Spinner(getActivity());
		cat = new String[] { "Cultural", "Technical",
				"Sports"};

	 adapter1 = new ArrayAdapter<String>(getActivity(),
			  android.R.layout.simple_spinner_dropdown_item,cat
			  );
	 diffcat.setAdapter(adapter1);
	 
		diffcat.setLayoutParams(lparams);
		//textView.setText("New text:"+text);
		return diffcat;
		
	}
	private void genquery(){
		if(sear=="Category")
		{
			querystr="select * from festipedia1 where category='"+sear1+"' ORDER BY eventname";
		}
		else if(sear=="Location")
		{
			querystr="select * from festipedia1 where location LIKE '%"+query.getText().toString()+"%' ORDER BY eventname";
		}
		else if(sear=="College Name")
		{
			querystr="select * from festipedia1 where collegename LIKE '%"+query.getText().toString()+"%' ORDER BY eventname";
		}
		else if(sear=="Fest Name")
		{
			querystr="select * from festipedia1 where eventname LIKE '%"+query.getText().toString()+"%' ORDER BY eventname";
		}
	}
}

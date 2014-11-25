package com.ara.aroundme;


import java.util.ArrayList;
import java.util.Currency;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObservable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Xmlmain extends Activity {
ListView list;
Button btn,btn2,searchBtn,showAllBtn,restBtn,atmBtn,hospitalBtn;
/*String [] values = {"1","2","3","4","5","6","7","8","9"};
String [] values2 = {"1","2","3","4","5","6","7","8","9"};*/
String APIKey="AIzaSyC01RrsGx05uuWVcZV33NuUf5WM395z2eM";
ArrayList<Dataset> values ;
double lon[],lat[];
double currentLat,currentLon;
String Name[];
Dataset valuesLimited[]= new Dataset[20];
Intent i;

Custom_Adapter adapter;
EditText edit;
int loopSize;

/*	@Override
	public void onBackPressed() {    
	    Intent intent = new Intent();
	    intent.setAction(Intent.ACTION_MAIN);
	    intent.addCategory(Intent.CATEGORY_HOME);
	    startActivity(intent);
	}*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlmain);
        searchBtn = (Button)findViewById(R.id.searchButton);
        showAllBtn = (Button)findViewById(R.id.showAll);
        restBtn = (Button)findViewById(R.id.rest);
        atmBtn = (Button)findViewById(R.id.atm);
        hospitalBtn=(Button)findViewById(R.id.hospital);
        edit = (EditText)findViewById(R.id.editText1);
        list = (ListView)findViewById(R.id.listView1);
        i=getIntent();
       // currentLat=i.getExtras().getDouble("lat");
      //  currentLon=i.getExtras().getDouble("lon");
        
        values = new ArrayList<Dataset>();
        
      //  Dataset data1 = new Dataset();
     //   data1.image = R.drawable.ic_launcher;
     //   data1.head = "Navin";
     //   data1.subhead = "How are you?";
     //   data1.time = "11:00";
        
        
     //   values.add(data1);
        
        
        
        
        
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
        //		android.R.layout.simple_list_item_1,values);
         adapter = new Custom_Adapter(Xmlmain.this,
        		R.layout.row,values);
        
        
        list.setAdapter(adapter);
        searchBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			GlobalPass.search=edit.getText().toString();	
			new back().execute();	
							
				
			}
		});
        
        atmBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			GlobalPass.search="atm";	
			new back().execute();	
							
				
			}
		});
 
        restBtn.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
		GlobalPass.search="restaurant";	
		new back().execute();	
						
			
		}
		});
        
        hospitalBtn.setOnClickListener(new View.OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    		GlobalPass.search="hospitals";	
    		new back().execute();	
    			    			
    		}
    	});
        
        showAllBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent=new Intent(Xmlmain.this,Maps.class);
				loopSize=GlobalPass.maxMarkers;
			   	 if(loopSize>values.size())
			   	 	{loopSize=values.size();}
				intent.putExtra("size",loopSize);
				for (int i=0;i<loopSize;i++)
				{
					//valuesLimited[i]=values.get(i);
					//Name[i]=values.get(i).head;
					//lat[i]=values.get(i).latitude;
					//lon[i]=values.get(i).longitude;
					intent.putExtra("lat"+i,values.get(i).latitude);
					intent.putExtra("lon"+i,values.get(i).longitude);
					intent.putExtra("name"+i,values.get(i).head);
					intent.putExtra("address"+i,values.get(i).subhead);
					Log.i("MO2", i+" = "+values.get(i).head);
				}
				
				
				startActivity(intent);	
							
				
			}
		});
       
    }


    class back extends AsyncTask<Void, Void, Void>{
    	ArrayList<Dataset> array;
    	@Override
    	protected Void doInBackground(Void... arg0) {
    		Mainparser p = new Mainparser();
    		 array = p.execute();
    		 if(array.size()>20)
    			 {
    			 	Log.i("MO2", "Cancelled");
    			 	cancel(true);
    			 	isCancelled();
    			 }
    		 return null;
    	}

		@Override
		protected void onPostExecute(Void result) {
			adapter.clear();
			adapter.addAll(array);
			super.onPostExecute(result);
			
		}
    	
    	
    }
   


    
}

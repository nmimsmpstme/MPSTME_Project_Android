package com.ara.aroundme;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import com.ara.aroundme.Xmlmain.back;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Stationmap extends Activity {

	double latitude, longitude;
	String Name;
	String APIKey="AIzaSyC01RrsGx05uuWVcZV33NuUf5WM395z2eM";
	ArrayList<Dataset> array;
	//final ProgressDialog dialog = ProgressDialog.show(Stationmap.this, "","Downloading. Please wait...", true);
	int flag=0;
	LatLng Station;
	
	int loopSize=GlobalPass.maxMarkers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stationmap);
        Intent intent= getIntent();
    	
    	//Name=getStringExtra("name");
    	
        	longitude=intent.getExtras().getDouble("lon");
        	latitude=intent.getExtras().getDouble("lat");
        	GlobalPass.stationLat=latitude;
        	GlobalPass.stationLon=longitude;
        	Name=intent.getExtras().getString("name");
        	
        	Button btn,btn2,searchBtn,showAllBtn,restBtn,atmBtn,mallBtn;

        // Get a handle to the Map Fragment
        final GoogleMap map = ((MapFragment) getFragmentManager()
                .findFragmentById(R.id.smap)).getMap();
        
        Station = new LatLng(latitude, longitude);

        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(Station, 15));

        map.addMarker(new MarkerOptions()
                .title(Name)
                .snippet("Station")
                .position(Station));
        
        restBtn = (Button)findViewById(R.id.rest);
        atmBtn = (Button)findViewById(R.id.atm);
        mallBtn=(Button)findViewById(R.id.mall);
        
        atmBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			GlobalPass.search="atm";	
			new back().execute();
			
	    	//dialog.show();						
				
			}
		});
 
        restBtn.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
		GlobalPass.search="restaurant";	
		new back().execute();		
			
		}
		});
        
        mallBtn.setOnClickListener(new View.OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    		GlobalPass.search="mall";	
    		new back().execute();	
    		    			    			
    		}
    	});
       
    }
    
    void addToMap(ArrayList <Dataset> array)
    {
    	 final GoogleMap map = ((MapFragment) getFragmentManager()
                 .findFragmentById(R.id.smap)).getMap();
    	 map.clear();
    	 map.setMyLocationEnabled(true);
    	 map.addMarker(new MarkerOptions()
         .title(Name)
         .snippet("Station")
         .position(Station));
    	 loopSize=GlobalPass.maxMarkers;
    	 if(loopSize>array.size())
    	 	{loopSize=array.size();}
    	 for (int i=0;i<loopSize;i++)
         {
         	double lat,lon;
 			lat=array.get(i).latitude;
         	lon=array.get(i).longitude;
         	String Name= array.get(i).head;
         	String Address= array.get(i).subhead;
         	LatLng temp= new LatLng(lat, lon);
         	 map.addMarker(new MarkerOptions()
              .title(Name)
              .snippet(Address)
              .position(temp));
         }
    }
    
   
        class back extends AsyncTask<Void, Void, Void>{
        	
        	
        	@Override
        	protected Void doInBackground(Void... arg0) {
        		Log.i("MO3","Inside Break");
        		Stationparser p = new Stationparser();
        		Log.i("MO3","Before Execute");
        		 array = p.execute();
        		 Log.i("MO3","After Execute--");
        		         		 
        		 if(array.size()>20)
    			 {
        			flag=1;
    			 	Log.i("MO2", "Cancelled");
    			 	cancel(true);
    			 	isCancelled();
    			 }
        		 return null;
        	}

        	@Override
    		protected void onPostExecute(Void result) {
        		Log.i("MO3","Post Execute");
    			super.onPostExecute(result);
    			addToMap(array);
    			
    		}
        	
    }
        
        
	
}

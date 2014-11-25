package com.ara.aroundme;


import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.Global;
import android.util.Log;
import android.widget.Toast;

public class Map0 extends Activity {
	
	public double lat,lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
    	LocationManager manager;
    	final ProgressDialog dialog = ProgressDialog.show(Map0.this, "", 
                "Loading. Please wait...", true);
    	dialog.show();
    	manager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
    	
    	Intent intent=getIntent();
    	
    

        // Get a handle to the Map Fragment
        final GoogleMap maps = ((MapFragment) getFragmentManager()
                .findFragmentById(R.id.map)).getMap();

        

        maps.setMyLocationEnabled(true);
        
        maps.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
			
			@Override
			public void onMyLocationChange(Location arg0) {
			//	 LatLng CurrentLoc = new LatLng(lat, lon);
				 LatLng CurrentLoc=new LatLng(arg0.getLatitude(),arg0.getLongitude());
			//	 Xmlparser.setLatLng(lat, lon);
				 GlobalPass.currentLat=CurrentLoc.latitude;
				 GlobalPass.currentLon=CurrentLoc.longitude;
				 
			//	 Dataset.Location=new LatLng(arg0.getLatitude(),arg0.getLongitude());
				maps.animateCamera(CameraUpdateFactory.newLatLngZoom(CurrentLoc, 13));
			//	maps.moveCamera(CameraUpdateFactory.newLatLngZoom(CurrentLoc, 13));
        maps.addMarker(new MarkerOptions()
                .title("You")
                .snippet("Right now")
                .position(CurrentLoc));
        Log.i("MO2","Inside  "+CurrentLoc.latitude);
			}
		});
        
        
        Log.i("MO2","Maps Passing: "+GlobalPass.currentLat+"  "+GlobalPass.currentLon);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            	dialog.cancel();
                Intent i=new Intent(Map0.this,Xmlmain.class);
                startActivity(i);
            }
        }, 5000);
        
       
    }
    
    
	LocationListener listener=new LocationListener() {
		
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onProviderDisabled(String provider) {
			Toast.makeText(Map0.this, "GPS switched off", Toast.LENGTH_LONG).show();
			
		}

		@Override
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			lat=location.getLatitude();
			lon=location.getLongitude();
			Log.i("MO2","onchanged  "+location.getLatitude());
			
		}
	};
	
	
}
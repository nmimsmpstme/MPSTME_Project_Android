package com.ara.aroundme;


import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

public class Maps extends Activity {
	
	double lat,lon;
	int loopSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
    	LocationManager manager;

    	manager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
    	
    	Intent intent=getIntent();
    	
    

        // Get a handle to the Map Fragment
        final GoogleMap maps = ((MapFragment) getFragmentManager()
                .findFragmentById(R.id.map)).getMap();

        

        maps.setMyLocationEnabled(true);
        
        maps.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
			
			@Override
			public void onMyLocationChange(Location arg0) {
				 LatLng CurrentLoc = new LatLng(lat, lon);
				 CurrentLoc=new LatLng(arg0.getLatitude(),arg0.getLongitude());
			//	 Xmlparser.setLatLng(lat, lon);
        
				maps.animateCamera(CameraUpdateFactory.newLatLngZoom(CurrentLoc, 13));
			//	maps.moveCamera(CameraUpdateFactory.newLatLngZoom(CurrentLoc, 13));
        maps.addMarker(new MarkerOptions()
                .title("You")
                .snippet("Right now")
                .position(CurrentLoc));
			}
		});
        loopSize=intent.getIntExtra("size", 15);;
   	 
        for (int i=0;i<loopSize;i++)
        {
        	lat=intent.getDoubleExtra("lat"+i,0);
        	lon=intent.getDoubleExtra("lon"+i,0);
        	String Name= intent.getStringExtra("name"+i);
        	String Address= intent.getStringExtra("address"+i);
        	LatLng temp= new LatLng(lat, lon);
        	 maps.addMarker(new MarkerOptions()
             .title(Name)
             .snippet(Address)
             .position(temp));
        }
       
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
			Toast.makeText(Maps.this, "GPS switched off", Toast.LENGTH_LONG).show();
			
		}

		@Override
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			lat=location.getLatitude();
			lon=location.getLongitude();
			
			
		}
	};
	
	
}
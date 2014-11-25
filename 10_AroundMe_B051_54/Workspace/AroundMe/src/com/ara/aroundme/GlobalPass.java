package com.ara.aroundme;

import android.location.Location;



public class GlobalPass {
	
	static double currentLat,currentLon;
	static double stationLat,stationLon;
	static String search;
	static Location currentLocation;
	static final int maxMarkers=15;
	public static void setLoc()
	{
		currentLocation.setLatitude(currentLat);
		currentLocation.setLongitude(currentLon);
	
	}
	
}

package com.ara.aroundme;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.google.android.gms.maps.model.LatLng;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.util.Log;

public class Stationparser {
	String temp="";
	String APIKey="AIzaSyC01RrsGx05uuWVcZV33NuUf5WM395z2eM";
	ArrayList<Dataset> array;
	Dataset data;
	Location tempLoc;
	//String Link="https://maps.googleapis.com/maps/api/place/nearbysearch/xml?key="+APIKey+"&location=19.117233,72.846553&radius=1500&sensor=false&keyword=atm";
	ArrayList<Dataset> execute(){
		try{
			Log.i("MO3","Inside Stationparser");
			Log.i("MO3"," "+GlobalPass.stationLat+" "+GlobalPass.stationLon);
			final double lat=GlobalPass.stationLat;
			final double lon=GlobalPass.stationLon;
			//Log.i("MO2","parser Current "+lat+"  "+lon);
			String Link="https://maps.googleapis.com/maps/api/place/nearbysearch/xml?key="+APIKey+"&location="+lat+","+lon+"&radius=400&sensor=false&keyword="+GlobalPass.search;
		//URLConnection conn = new URL("https://maps.googleapis.com/maps/api/place/nearbysearch/xml?key="+APIKey+"&location="+lat+","+lon+"&radius=1500&sensor=false&keyword="+name).openConnection();
			URLConnection conn = new URL(Link).openConnection();
			InputStream is = conn.getInputStream();
		
		DefaultHandler dh = new DefaultHandler(){

			@Override
			public void characters(char[] ch, int start, int length)
					throws SAXException {
				 temp = new String(ch,start,length);
				
				super.characters(ch, start, length);
			}

			@Override
			public void endElement(String uri, String localName, String qName)
					throws SAXException {
			//	if(array.size()<20)
			//	{
				Log.i("MO", temp);
				Log.i("MO", "Stop "+qName);
				if(qName.equals("name")){
					data.head =temp;
				}
				if(qName.equals("vicinity")){
					data.subhead =temp;
				}
				if(qName.equals("type")){
					data.time = "";
				}
				
						if(qName.equals("lat")){
							data.latitude = Double.parseDouble(temp);
						}
						if(qName.equals("lng")){
							data.longitude= Double.parseDouble(temp);
						}
			
			//	}
				
				
				//tempLoc.setLatitude(data.longitude);
				//tempLoc.setLongitude(data.latitude);
				//float result[] = new float[3];
				//Location.distanceBetween(GlobalPass.currentLat, GlobalPass.currentLon, data.latitude, data.longitude, result);
				//data.distance=(int) result[0];
				//data.distance=(int)tempLoc.distanceTo(GlobalPass.currentLocation);
				
				 
				if(qName.equals("result")){
					array.add(data);
				}
				
				super.endElement(uri, localName, qName);
			}

			@Override
			public void startElement(String uri, String localName,
					String qName, Attributes attributes) throws SAXException {
				Log.i("MO", "Start "+qName);
				if(qName.equals("PlaceSearchResponse")){
					array = new ArrayList<Dataset>();
				}
				
				if(qName.equals("result")){
					data = new Dataset();
				}
				
				super.startElement(uri, localName, qName, attributes);
			}
			
		};
		
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		parser.parse(is, dh);
		
		}catch(Exception e){
			
		}
		
		return array;
	}

}

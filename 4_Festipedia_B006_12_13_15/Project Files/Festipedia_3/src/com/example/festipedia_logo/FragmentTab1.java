package com.example.festipedia_logo;
 
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.actionbarsherlock.app.SherlockFragment;
 



import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockListFragment;
//import com.example.festipedia_logo.Searchpage.LoadAllProducts;


//import com.example.connection.disp;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class FragmentTab1 extends SherlockFragment {
	ArrayAdapter<String> adapter;
	String[] city;
	// Progress Dialog
	private ProgressDialog pDialog;

	// Creating JSON Parser object
	JSONParser jParser = new JSONParser();
EditText b;
	ArrayList<HashMap<String, String>> productsList;

	// url to get all products list
	private static String url_all_products =new Global().getcon()+"myall.php";
Button a;

	// JSON Node names
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_PRODUCTS = "products";
	private static final String TAG_PID = "price";
	private static final String TAG_NAME = "eventname";
String eventname,collegename,eventwebsite,startdate,enddate,category,location,googleurl;
	// products JSONArray
	JSONArray products = null;
ListView l;
TextView one,two,three,four,five,six,seven;
Spinner spinner;
String Festdet[]=new String[8];
	FragmentTab1(String []a){
		Festdet=a;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		
		 
	        
	        
		//setContentView(R.layout.second);
		View rootView = inflater.inflate(R.layout.fragmenttab1, container, false);
one = (TextView) rootView.findViewById(R.id.textView2);
two = (TextView) rootView.findViewById(R.id.TextView06);
three = (TextView) rootView.findViewById(R.id.TextView09);
four = (TextView) rootView.findViewById(R.id.TextView07);
five = (TextView) rootView.findViewById(R.id.TextView08);
six = (TextView) rootView.findViewById(R.id.TextView10);
seven = (TextView) rootView.findViewById(R.id.textView4);
//	setContentView(R.layout.all_products);
	//	l = (ListView) rootView.findViewById(R.id.myListView);
one.setText(Festdet[0]);
two.setText(Festdet[1]);
three.setText(Festdet[5]);
four.setText(Festdet[3]);
five.setText(Festdet[4]);
six.setText(Festdet[2]);
seven.setText(Festdet[6]);
//new Global().seturl(googleurl);
		// Hashmap for ListView
		//productsList = new ArrayList<HashMap<String, String>>();
		//new LoadAllProducts().execute();
		
		
		return rootView;
		// Get listview
		//ListView lv = getListView();

		// on seleting single product
		// launching Edit Product Screen
			}

	// Response from Edit Product Activity
	//@Override
		/**
	 * Background Async Task to Load all product by making HTTP Request
	 * */
	/*class LoadAllProducts extends AsyncTask<String, String, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			
			pDialog = new ProgressDialog(getActivity());
			pDialog.setMessage("Loading products. Please wait...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		/**
		 * getting All products from url
		 * 
		protected String doInBackground(String... args) {
			// Building Parameters
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			// String eve=getArguments().getString("message");
			String eve=Festname;
			params.add(new BasicNameValuePair("eve", eve));
			// getting JSON string from URL
			JSONObject json = jParser.makeHttpRequest(url_all_products, "GET", params);
			
			// Check your log cat for JSON reponse
		//	Log.d("All Products: ", json.toString());

			try {
				// Checking for SUCCESS TAG
				int success = json.getInt(TAG_SUCCESS);

				if (success == 1) {
					// products found
					// Getting Array of Products
					products = json.getJSONArray(TAG_PRODUCTS);

					// looping through All Products
						JSONObject c = products.getJSONObject(0);

						// Storing each json item in variable
						
					//	String id = c.getString(TAG_PID);
						 eventname = c.getString(TAG_NAME);
						 collegename=c.getString("collegename");
						 eventwebsite=c.getString("eventwebsite");
						 startdate=c.getString("startdate");
						 enddate=c.getString("enddate");
						 category=c.getString("category");
						 location=c.getString("location");
						 googleurl=c.getString("googlemap");
//						txtDesc = (EditText) findViewById(R.id.inputDesc);
						//l.setFilterText(id);
						// creating new HashMap
						//HashMap<String, String> map = new HashMap<String, String>();
						
						// adding each child node to HashMap key => value
					//	map.put(TAG_PID, id);
					//	map.put("a", eventname);
						//map.put("b", collegename);
						//map.put("c", location);

						// adding HashList to ArrayList
						//productsList.add(map);
					
				} else {
					// no products found
					// Launch Add New product Activity
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			return null;
			
		}

		/**
		 * After completing background task Dismiss the progress dialog
		 * *
	protected void onPostExecute(String file_url) {
			// dismiss the dialog after getting all products
			pDialog.dismiss();
			// updating UI from Background Thread
			getActivity().runOnUiThread(new Runnable() {
				public void run() {
					/**
					 * Updating parsed JSON data into ListView
					 * */
					
		
		//FragmentTab2=new FragmentTab2(location);
	/*	FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.replace(R.id.content_frame, new FragmentTab2(location));	
		}
			});

		}

	}*/
	 
}
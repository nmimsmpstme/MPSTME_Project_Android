package com.example.festipedia_logo;

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

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
 
public class SlidetabTesting extends SherlockFragment {
 String Festname;
 ArrayAdapter<String> adapter;
	String[] city;
	// Progress Dialog
	private ProgressDialog pDialog;

	// Creating JSON Parser object
	JSONParser jParser = new JSONParser();
EditText b;
	ArrayList<HashMap<String, String>> productsList=new ArrayList<HashMap<String, String>>();;

	// url to get all products list
	private static String url_all_products =new Global().getcon()+"myall.php";


	// JSON Node names
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_PRODUCTS = "products";
	private static final String TAG_PID = "price";
	private static final String TAG_NAME = "eventname";
String eventname,collegename,eventwebsite,startdate,enddate,category,location,googleurl;
	// products JSONArray
	JSONArray products = null;
ListView l;
String values[]=new String[8];
ViewPager mViewPager;
SlidetabTesting(String x){
	 Festname=x;
 }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewpager_main, container, false);
        // Locate the ViewPager in viewpager_main.xml
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
        // Set the ViewPagerAdapter into ViewPager
        new LoadAllProducts().execute();
        
       
        return view;
    }
 
    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class
                    .getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    class LoadAllProducts extends AsyncTask<String, String, String> {

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
		 * */
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
						values[0] = c.getString(TAG_NAME);
						values[1]=c.getString("collegename");
						values[2]=c.getString("eventwebsite");
						values[3]=c.getString("startdate");
						values[4]=c.getString("enddate");
						values[5]=c.getString("category");
						values[6]=c.getString("location");
						values[7]=c.getString("googlemap");
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
		 * **/
	protected void onPostExecute(String file_url) {
			// dismiss the dialog after getting all products
			pDialog.dismiss();
			// updating UI from Background Thread
			getActivity().runOnUiThread(new Runnable() {
				public void run() {
					//Log.d("yes",values[7]);
					mViewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(),values));		
				}
			});

		}

	}
	 

}
package com.example.festipedia_logo;

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
import android.app.Fragment;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
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
import android.widget.Toast;

public class details1 extends SherlockFragment {
	ArrayAdapter<String> adapter;
	String[] city;
	// Progress Dialog
	private ProgressDialog pDialog;
	String category,location;
	// Creating JSON Parser object
	JSONParser jParser = new JSONParser();
EditText b;int flag=0;
	ArrayList<HashMap<String, String>> productsList;

	// url to get all products list
	private static String url_all_products =new Global().getcon()+"catfest.php";
Button a;

	// JSON Node names
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_PRODUCTS = "products";
	private static final String TAG_NAME = "eventname";
	private static final String TAG_DATE = "startdate";
	// products JSONArray
	JSONArray products = null;
ListView l;
Spinner spinner;
TextView t1;
details1(String c, String b){
	category=c;
	location=b;
}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.second);
		View rootView = inflater.inflate(R.layout.home2, container, false);

	//	setContentView(R.layout.all_products);
		l = (ListView) rootView.findViewById(R.id.list);
		
		// Hashmap for ListView
		productsList = new ArrayList<HashMap<String, String>>();
		new LoadAllProducts().execute();
		l.setOnItemClickListener(new OnItemClickListener() {
	        @Override
	        	public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
	        	HashMap<String,String> map = (HashMap<String,String>) l.getItemAtPosition(position);          
	        	String itemValue = map.get(TAG_NAME);
	                  // ListView Clicked item value
	                  //String  itemValue    = (String) l.getItemAtPosition(position).getValue();  
	        	final FragmentTransaction ft = getFragmentManager().beginTransaction(); 
	                ft.replace(R.id.content_frame,new SlidetabTesting(itemValue) , "Fest Content"); 
	                ft.commit();
	        }
	        
	    });
				        		
		return rootView;
					}

	/**
	 * Background Async Task to Load all product by making HTTP Request
	 * */
	class LoadAllProducts extends AsyncTask<String, String, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			
			pDialog = new ProgressDialog(getActivity());
			pDialog.setMessage("Loading festivals. Please wait...");
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
			
			params.add(new BasicNameValuePair("category", category));
			params.add(new BasicNameValuePair("location", location));
			Log.d("test",category);
			Log.d("test1",location);
			// getting JSON string from URL
			JSONObject json = jParser.makeHttpRequest(url_all_products, "GET", params);
			
		//	Log.d("All Products: ", json.toString());

			try {
				// Checking for SUCCESS TAG
				int success = json.getInt(TAG_SUCCESS);

				if (success == 1) {
					// products found
					// Getting Array of Products
					products = json.getJSONArray(TAG_PRODUCTS);

					// looping through All Products
					for (int i = 0; i < products.length(); i++) {
						JSONObject c = products.getJSONObject(i);

						// Storing each json item in variable
						
						String name = c.getString(TAG_NAME);
						String date = c.getString(TAG_DATE);
						//l.setFilterText(id);
						// creating new HashMap
						HashMap<String, String> map = new HashMap<String, String>();

						// adding each child node to HashMap key => value
						map.put(TAG_NAME, name);
						map.put(TAG_DATE, date);
						// adding HashList to ArrayList
						productsList.add(map);
					}
				} else {
				//t1.setText("We currently do not have any events for this category at the chosen location");
					flag=1;
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
					/**
					 * Updating parsed JSON data into ListView
					 * */
					if(flag==1){
						flag=0;
						final FragmentTransaction ft = getFragmentManager().beginTransaction(); 
		                ft.replace(R.id.content_frame,new noitem("det")); 
		                ft.commit();
					}
					else{
					ListAdapter adapter = new SimpleAdapter
							(
									getActivity(), productsList,
									R.layout.list_item, new String[] 
									{
										TAG_NAME,TAG_DATE
									},
										new int[] {  
										R.id.name, R.id.name1 
										});			
							l.setAdapter(adapter);
					}
				}
			});
			

		}
		}
	}


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

//import com.example.connection.disp;

import android.app.Activity;
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
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Searchtest extends SherlockFragment {

	// Progress Dialog
	private ProgressDialog pDialog;

	// Creating JSON Parser object
	JSONParser jParser = new JSONParser();

	ArrayList<HashMap<String, String>> productsList;

	// url to get all products list
	private static String url_all_products =new Global().getcon()+"search.php";

	// JSON Node names
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_PRODUCTS = "products";
	private static final String TAG_PID = "price";
	private static final String TAG_NAME = "name";

	// products JSONArray
	JSONArray products = null;
ListView l;
String a;
TextView mn;
Searchtest(String x){
	 a=x;
 }
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.second);
		View rootView = inflater.inflate(R.layout.home3, container, false);
	//	setContentView(R.layout.all_products);
		l = (ListView) rootView.findViewById(R.id.list);
//		final String a = ((TextView) rootView.findViewById(R.id.name)).getText()
	//			.toString();
		// Hashmap for ListView
		mn = (TextView) rootView.findViewById(R.id.textView1);
		mn.setText(a);
		productsList = new ArrayList<HashMap<String, String>>();

		// Loading products in Background Thread
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
			params.add(new BasicNameValuePair("eve", a));
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
					for (int i = 0; i < products.length(); i++) {
						JSONObject c = products.getJSONObject(i);

						// Storing each json item in variable
						
						String id = c.getString(TAG_PID);
						String name = c.getString(TAG_NAME);
						
//						txtDesc = (EditText) findViewById(R.id.inputDesc);
						l.setFilterText(id);
						// creating new HashMap
						HashMap<String, String> map = new HashMap<String, String>();

						// adding each child node to HashMap key => value
						map.put(TAG_PID, id);
						map.put(TAG_NAME, name);

						// adding HashList to ArrayList
						productsList.add(map);
					}
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
					/**
					 * Updating parsed JSON data into ListView
					 * */
					ListAdapter adapter = new SimpleAdapter(
							getActivity(), productsList,
							R.layout.list_item, new String[] {
									TAG_NAME},
							new int[] {  R.id.name });
					// updating listview
					l.setAdapter(adapter);
				}
			});

		}

	}
}
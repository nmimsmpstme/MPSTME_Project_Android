package com.example.festipedia_logo;

//import com.actionbarsherlock.app.SherlockFragment;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.festipedia_logo.details1.LoadAllProducts;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
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
import android.widget.Toast;

public class mainpage extends Activity {
	 Button button1;
	 Button button4;
	
	 ArrayAdapter<String> adapter;
		String[] city;
		//String loc;
		Spinner spinner;
	 //String loc;
		private static String url_all_products =new Global().getcon()+"loc.php";
		Button a;
		ConnectivityManager cm;NetworkInfo activeNetwork;
			// JSON Node names
			private static final String TAG_SUCCESS = "success";
			private static final String TAG_PRODUCTS = "products";
			private static final String TAG_NAME = "eventname";
			private static final String TAG_LOCATION = "location";
			private ProgressDialog pDialog;
			//String category,location;
			// Creating JSON Parser object
			JSONParser jParser = new JSONParser();
		EditText b;int flag=0,conflag=0;
			ArrayList<HashMap<String, String>> productsList;
			// products JSONArray
			JSONArray products = null;
			//String []loc=new String[1000];
			ArrayList<String> lo=new ArrayList<String>();
		//ListView l;
		//Spinner spinner;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		getActionBar().setDisplayShowTitleEnabled(false);
		getActionBar().setDisplayUseLogoEnabled(false);
		getActionBar().setDisplayShowCustomEnabled(true);
		getActionBar().setDisplayShowHomeEnabled(false);
		//getSupportActionBar().setIcon(R.drawable.fest);
		//getSupportActionBar().setLogo(R.drawable.fest);
		Drawable d=getResources().getDrawable(R.drawable.actionbar);
	    getActionBar().setBackgroundDrawable(d);
	
		setContentView(R.layout.mainmenu);
		spinner = (Spinner)this.findViewById(R.id.spinner1);
		cm=(ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
		activeNetwork=cm.getActiveNetworkInfo();
		if((activeNetwork!=null && activeNetwork.isConnectedOrConnecting())==true){
			conflag=0;
			productsList = new ArrayList<HashMap<String, String>>();
			new LoadAllProducts().execute();
		}
		else{
			conflag=1;
			 city = new String[] { "--Location--"};
	 adapter = new ArrayAdapter<String>(this,
			  android.R.layout.simple_spinner_dropdown_item,city
			  );
	    spinner.setAdapter(adapter);
			}
			
		

//	View rootView = inflater.inflate(R.layout.mainmenu, container, false);
		//Intent in = getIntent();
        //loc = in.getStringExtra("loc");
		Button button1 = (Button) findViewById(R.id.button1);
		Button button4 = (Button) findViewById(R.id.button4);
		Button button2 = (Button) findViewById(R.id.button2);
		Button button5 = (Button) findViewById(R.id.button5);
		Button button3 = (Button) findViewById(R.id.button3);
		//TextView t1= (TextView) findViewById(R.id.getlocation);
		//t1.setText(loc);
		
button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// creating new product in background thread
		
				/*final FragmentTransaction ft = getFragmentManager().beginTransaction(); 
                ft.replace(R.id.content_frame,new home1() , "Fest Content"); 
                ft.commit();*/
				if(conflag==1){
					Toast.makeText(getApplicationContext(), "Please Connect to Internet", Toast.LENGTH_LONG).show();
				}
				else{
				String s=spinner.getSelectedItem().toString();
				
				
				Intent i = new Intent(getApplicationContext(),
						MainActivity.class);
				i.putExtra("loc", 0);
				i.putExtra("category", "Technical");
				i.putExtra("location", s);
				// Closing all previous activities
				//i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
                
				//new CreateNewProduct().execute();
			}
			}
		});
button2.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View view) {
		// creating new product in background thread

		/*final FragmentTransaction ft = getFragmentManager().beginTransaction(); 
        ft.replace(R.id.content_frame,new home1() , "Fest Content"); 
        ft.commit();*/
		if(conflag==1){
			Toast.makeText(getApplicationContext(), "Please Connect to Internet", Toast.LENGTH_LONG).show();
		}
		else{
		String s=spinner.getSelectedItem().toString();
	
		Intent i = new Intent(getApplicationContext(),
				MainActivity.class);
		i.putExtra("loc", 0);
		i.putExtra("category", "Cultural");
		i.putExtra("location", s);
		// Closing all previous activities
		//i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
		}
		//new CreateNewProduct().execute();
	}
});
button3.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View view) {
		// creating new product in background thread

		/*final FragmentTransaction ft = getFragmentManager().beginTransaction(); 
        ft.replace(R.id.content_frame,new home1() , "Fest Content"); 
        ft.commit();*/
		if(conflag==1){
			Toast.makeText(getApplicationContext(), "Please Connect to Internet", Toast.LENGTH_LONG).show();
		}
		else{
		String s=spinner.getSelectedItem().toString();
	
		Intent i = new Intent(getApplicationContext(),
				MainActivity.class);
		i.putExtra("loc", 0);
		i.putExtra("category", "Sports");
		i.putExtra("location", s);
		// Closing all previous activities
		//i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
		}
		//new CreateNewProduct().execute();
	}
});
button4.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View view) {
		// creating new product in background thread
	/*	final FragmentTransaction ft = getFragmentManager().beginTransaction(); 
        ft.replace(R.id.content_frame,new testing() , "Fest Content"); 
        ft.commit();*/
		if(conflag==1){
			Toast.makeText(getApplicationContext(), "Please Connect to Internet", Toast.LENGTH_LONG).show();
		}
		else{
		Intent i = new Intent(getApplicationContext(),
				MainActivity.class);
        i.putExtra("loc", 1);
		// Closing all previous activities
		//i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
		//new CreateNewProduct().execute();
	}
	}
});
button5.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View view) {
		// creating new product in background thread
	/*	final FragmentTransaction ft = getFragmentManager().beginTransaction(); 
        ft.replace(R.id.content_frame,new testing() , "Fest Content"); 
        ft.commit();*/
		if(conflag==1){
			Toast.makeText(getApplicationContext(), "Please Connect to Internet", Toast.LENGTH_LONG).show();
		}
		else{
		Intent i = new Intent(getApplicationContext(),
				MainActivity.class);
        i.putExtra("loc", 2);
		// Closing all previous activities
		//i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
		//new CreateNewProduct().execute();
	}
	}
});
          
	
	}
	public void onBackPressed() {
				finish();
				
	        }
	public void onRestart() { 
		super.onRestart();
		cm=(ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
		activeNetwork=cm.getActiveNetworkInfo();
		if((activeNetwork!=null && activeNetwork.isConnectedOrConnecting())==true){
			conflag=0;
			adapter.clear();
			productsList = new ArrayList<HashMap<String, String>>();
			new LoadAllProducts().execute();
			
			
		}
		else{
			conflag=1;
			 city = new String[] { "--Location--"};
			 adapter = new ArrayAdapter<String>(this,
					  android.R.layout.simple_spinner_dropdown_item,city
					  );
			    spinner.setAdapter(adapter);
	}
	}
	class LoadAllProducts extends AsyncTask<String, String, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			
			pDialog = new ProgressDialog(mainpage.this);
			pDialog.setMessage("Loading Locations. Please wait...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		/**
		 * getting All products from url
		 * */
		protected String doInBackground(String... args) {
			// Building Parameters
			//List<NameValuePair> params = new ArrayList<NameValuePair>();
			
			//Log.d("test",category);
			//Log.d("test1",location);
			// getting JSON string from URL
			JSONObject json = jParser.makeHttpRequest(url_all_products, "GET",null);
			
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
						
						//String name = c.getString(TAG_NAME);
						String location = c.getString(TAG_LOCATION);
				//		loc[i]=location;
						lo.add(location);
						//l.setFilterText(id);
						// creating new HashMap
						HashMap<String, String> map = new HashMap<String, String>();

						// adding each child node to HashMap key => value
						//map.put(TAG_NAME, name);
						map.put(TAG_LOCATION, location);
						// adding HashList to ArrayList
						productsList.add(map);
					}
				} else {
				//t1.setText("We currently do not have any events for this category at the chosen location");
					//flag=1;
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
			runOnUiThread(new Runnable() {
				public void run() {
					/**
					 * Updating parsed JSON data into ListView
					 * */
					adapter = new ArrayAdapter<String>(mainpage.this,
							  android.R.layout.simple_spinner_dropdown_item,lo
							  );
					
						spinner.setAdapter(adapter);
				
				}
					/*ListAdapter adapter = new SimpleAdapter
							(
									mainpagetry.this, productsList,
									R.layout.list_item, new String[] 
									{
										TAG_LOCATION
									},
										new int[] {  
										R.id.name
										});			
							spinner.setAdapter(adapter);
					}*/
					
				
			});
			

		}
		}
	}



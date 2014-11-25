package com.example.festipedia_logo;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;




import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.view.GravityCompat;

//@TargetApi(Build.VERSION_CODES.HONEYCOMB)
@TargetApi(Build.VERSION_CODES.ECLAIR)
public class MainActivity extends SherlockFragmentActivity {
	
	// Declare Variables
	DrawerLayout mDrawerLayout;
	ListView mDrawerList;
	ActionBarDrawerToggle mDrawerToggle;
	MenuListAdapter mMenuAdapter;
	String[] title;
	//String[] subtitle;
	int icon;
	//String a= "Add Event";
	//Fragment Home = new details1();
	Fragment Add = new adding();
	Fragment Search = new searchfrag1();
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	static int flag=0;
	int loc;
	String cat,location;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		if (savedInstanceState != null){
	         View root = findViewById(R.id.content_layout); //find your root view
	         loadTextViewState((ViewGroup)root, savedInstanceState); //load state 
	    }
		super.onCreate(savedInstanceState);
		// Get the view from drawer_main.xml
		setContentView(R.layout.activity_main);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		getSupportActionBar().setDisplayUseLogoEnabled(false);
		getSupportActionBar().setDisplayShowCustomEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(false);
		//getSupportActionBar().setIcon(R.drawable.fest);
		//getSupportActionBar().setLogo(R.drawable.fest);
		Drawable d=getResources().getDrawable(R.drawable.actionbar);
	    getSupportActionBar().setBackgroundDrawable(d);
		//getSupportActionBar().setBackgroundDrawable(fest);
	    Intent in = getIntent();
        loc = in.getIntExtra("loc",-1);
        cat=in.getStringExtra("category");
        location=in.getStringExtra("location");
        if(loc!=-1){
        FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
        if(loc==1)
        {
    		ft1.replace(R.id.content_frame, new adding());
        }
        if(loc==2)
        {
    		ft1.replace(R.id.content_frame, new searchfrag1());
        }
        if(loc==0)
        {
        	ft1.replace(R.id.content_frame, new details1(cat,location));
        }
        ft1.commit();}
		// Get the Title
        else{
        	Intent i = new Intent(getApplicationContext(),
					mainpage.class);
			//i.putExtra("loc", 0);
			// Closing all previous activities
			//i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
        }
        mTitle = mDrawerTitle = getTitle();

		// Generate title
		title = new String[] { "Home", "Add",
				 "Search" };
		
		// Generate subtitle
		//subtitle = new String[] { "Subtitle Fragment 1", "Subtitle Fragment 2",
		//		"Subtitle Fragment 3" };

		// Generate icon
		icon =  R.drawable.action_about;

		// Locate DrawerLayout in drawer_main.xml
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		// Locate ListView in drawer_main.xml
		mDrawerList = (ListView) findViewById(R.id.listview_drawer);

		// Set a custom shadow that overlays the main content when the drawer
		// opens
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		// Pass string arrays to MenuListAdapter
		mMenuAdapter = new MenuListAdapter(MainActivity.this, title, 
				icon);

		// Set the MenuListAdapter to the ListView
		mDrawerList.setAdapter(mMenuAdapter);

		// Capture listview menu item click
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		// Enable ActionBar app icon to behave as action to toggle nav drawer
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		

		// ActionBarDrawerToggle ties together the the proper interactions
		// between the sliding drawer and the action bar app icon
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			public void onDrawerClosed(View view) {
				// TODO Auto-generated method stub
				super.onDrawerClosed(view);
			}

			public void onDrawerOpened(View drawerView) {
				// TODO Auto-generated method stub
				// Set the title on the action when drawer open
				getSupportActionBar().setTitle(mDrawerTitle);
				super.onDrawerOpened(drawerView);
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			//selectItem(0);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == android.R.id.home) {

			if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
				mDrawerLayout.closeDrawer(mDrawerList);
			} else if(!mDrawerLayout.isDrawerOpen(mDrawerList)){
				mDrawerLayout.openDrawer(mDrawerList);
			}
			else{ Intent i = new Intent();
            i.setClass(this,MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
           
			}
		}
//		else if(item.getItemId()==R.id.action_settings)
//		{ 	
//				Intent i=new Intent(MainActivity.this,Developer.class);
//				startActivity(i);
//				
//			//setContentView(R.layout.drawer_main);
//		}
		return super.onOptionsItemSelected(item);
	}
	private String keyForTextView(TextView txt){
	    return "textView"+txt.getId();
	}

	
	/* go through all your views in your layout and save their values */
	/*private void saveTextViewState(ViewGroup rootView, Bundle bundle){
	    int children = rootView.getChildCount();
	    for (int i = 0; i < children; i++) {
	        View view = rootView.getChildAt(i);
	        if (view instanceof TextView){
	            TextView txt = (TextView)view;
	            if (txt.getText() != null){
	                bundle.putString(keyForTextView(txt), txt.getText().toString());
	            }

	        }else if (view instanceof ViewGroup){
	            saveTextViewState((ViewGroup)view, bundle);
	        }
	    }
	}*/


	@Override
	protected void onSaveInstanceState(Bundle outState) {

	    View root = findViewById(R.id.content_layout); //find your root view of your layout
	   // saveTextViewState((ViewGroup)root, outState); //save state 

	    super.onSaveInstanceState(outState);
	}
	 private void loadTextViewState(ViewGroup rootView, Bundle bundle){
		    int children = rootView.getChildCount();
		    for (int i = 0; i < children; i++) {
		        View view = rootView.getChildAt(i);
		        if (view instanceof TextView){
		            TextView txt = (TextView)view;
		            String saved = bundle.getString(keyForTextView(txt));
		            txt.setText(saved); 

		        }else if (view instanceof ViewGroup){
		            loadTextViewState((ViewGroup)view, bundle);
		        }
		    }
		}
	// ListView click listener in the navigation drawer
	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			selectItem(position);
		}
	}
	
	private void selectItem(int position) {
		flag=0;ConnectivityManager cm;NetworkInfo activeNetwork;
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		// Locate Position
		switch (position) {
		case 0:
			Intent i = new Intent(/*getApplicationContext()*/MainActivity.this, mainpage.class);
			startActivity(i);
			break;
		case 1:
			ft.replace(R.id.content_frame, Add);
			break;/*
		case 2:cm=(ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
		activeNetwork=cm.getActiveNetworkInfo();
		if((activeNetwork!=null && activeNetwork.isConnectedOrConnecting())==true){
			ft.replace(R.id.content_frame, videos);}
		else{
			ft.replace(R.id.content_frame, videos);flag=1;}
			
			break;
		case 3:
			cm=(ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
			activeNetwork=cm.getActiveNetworkInfo();
			if((activeNetwork!=null && activeNetwork.isConnectedOrConnecting())==true){
			ft.replace(R.id.content_frame, tour);}
			else{
				ft.replace(R.id.content_frame, tour);flag=1;}
				
			
			break;*/
		case 2:
			ft.replace(R.id.content_frame,Search);
			break;
		/*
	case 5:
		cm=(ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
		activeNetwork=cm.getActiveNetworkInfo();
		if((activeNetwork!=null && activeNetwork.isConnectedOrConnecting())==true){
		ft.replace(R.id.content_frame, blog);}
		else{
			ft.replace(R.id.content_frame, blog);flag=1;}
			
		
		break;
	*/
		}
		ft.commit();
		mDrawerList.setItemChecked(position, true);

		// Get the title followed by the position
		setTitle(title[position]);
		// Close drawer
		mDrawerLayout.closeDrawer(mDrawerList);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggles
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getSupportActionBar().setTitle(mTitle);
	}
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		 MenuInflater inflater = getSupportMenuInflater();
	       inflater.inflate(R.menu.main, menu);
	       return super.onCreateOptionsMenu(menu);
	   
	}
	
	private long mLastPress = 0;
	@Override
	public void onBackPressed() {
	   /* Toast onBackPressedToast = Toast.makeText(this, "Press once again to go to main menu", Toast.LENGTH_SHORT);
	    long currentTime = System.currentTimeMillis();
	    if (currentTime - mLastPress > 1000) {
	        onBackPressedToast.show();
	        
	        FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
			ft1.replace(R.id.content_frame, Home);
			ft1.commit();
	        
	        /*
	        Intent i = new Intent(getApplicationContext(),
					mainpageact.class);
			//i.putExtra("loc", 0);
			// Closing all previous activities
			//i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			// Closing all previous activities
			//i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			*/
	    /*    mLastPress = currentTime;
	    } else {
	        onBackPressedToast.cancel();  //Difference with previous answer. Prevent continuing showing toast after application exit 
	       
	        super.onBackPressed();
	     */  
		  //onBackPressedToast.cancel();  //Difference with previous answer. Prevent continuing showing toast after application exit 
	       
	        super.onBackPressed();
	    }
	}
/*	protected String doInBackground(String... args) {
		String Eventname = eventname.getText().toString();
		String Collegename = collegename.getText().toString();
		String Location= location.getText().toString();
		String Googlemap = googlemap.getText().toString();
		String Eventwebsite = eventwebsite.getText().toString();
		
		//String description = inputDesc.getText().toString();

		// Building Parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("eventname", Eventname));
		params.add(new BasicNameValuePair("googlemap", Googlemap));
		params.add(new BasicNameValuePair("collegename", Collegename));
		params.add(new BasicNameValuePair("eventwebsite",Eventwebsite));
		params.add(new BasicNameValuePair("location", Location));
		
		//params.add(new BasicNameValuePair("description", description));

		// getting JSON Object
		// Note that create product url accepts POST method
		JSONObject json = jsonParser.makeHttpRequest(url_create_product,
				"POST", params);
		
		
		final FragmentTransaction ft = getSupportFragmentManager().beginTransaction(); 
        ft.replace(R.id.content_frame,new home1() , "Fest Content"); 
        ft.commit();
        return null;

}*/





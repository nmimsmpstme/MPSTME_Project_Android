package com.akul.splitfare;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.gc.materialdesign.views.ButtonFloat;

public class Groups extends ActionBarActivity 
{

	
	String[] listview_names ;
	int[] listview_images;
	String[] gids;
	private ListView lv;
	private static ArrayList<String> array_sort;
	 private static ArrayList<Integer> image_sort;
	String dlgresp;
	 static Groups g;
	 @Override
	protected void onCreate(Bundle savedInstanceState)
	 {
		 g = this;
		 setTheme(ConfigHandler.getstyle()); 
		 super.onCreate(savedInstanceState);
		android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
	        if (toolbar != null) 
	        {
	    	    setSupportActionBar(toolbar);
	        }
			final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
			  try
			  {
			        ViewConfiguration config = ViewConfiguration.get(this);
			        Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
			        if(menuKeyField != null) 
			        {
			            menuKeyField.setAccessible(true);
			            menuKeyField.setBoolean(config, false);
			        }
			    } 
			  catch (Exception ex)
			  {
				  
			  }
			setContentView(R.layout.activity_transactions);
	/**
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}**/
		actionBar.setTitle("SplitFa₹e");
		
		//getSupportActionBar().setTitle("SplitFare");
		ButtonFloat add = (ButtonFloat) findViewById(R.id.buttonFloataddGrp);
		int clr = getResources().getColor(ConfigHandler.getColorres());
		String col = "#"+Integer.toHexString(clr);
		add.setBackgroundColor(Color.parseColor(col));
		add.setOnClickListener(new OnClickListener(){
				public void onClick(View v) 
				{
					LayoutInflater li = LayoutInflater.from(Groups.this);
					final View dlg = li.inflate(R.layout.grp, null);
					 MaterialDialog progress = new MaterialDialog.Builder(Groups.this)
				        .customView(dlg)
				        .title("Create Group")
				        .cancelable(false)
				        .positiveText("Create")
				        .negativeText("Cancel")
				        .callback(new MaterialDialog.ButtonCallback() 
				        {
				            @Override
				            public void onPositive(MaterialDialog dialog) 
				            {
				            	dialog.dismiss();
				            	EditText e = (EditText) dlg.findViewById(R.id.ed_grpname);
				            	dlgresp = e.getText().toString();
				            	Void params = null;
				            	new creategrp().execute(params);
				            }
				            @Override
				            public void onNegative(MaterialDialog dialog) 
				            {
				            	dialog.dismiss();
				            }
				        })
				        .build();
				        progress.show();
                }
		});
  
		Void params = null;
		new fetchgrp().execute(params);
	}
@Override
public void onResume()
{
	super.onResume();
	if(Common.grpedited)
	{
		///////////////////////////////IMPLIMENT IN A BETTER WAY
		///////////////////////////////IMPLIMENT IN A BETTER WAY
		///////////////////////////////IMPLIMENT IN A BETTER WAY
		///////////////////////////////IMPLIMENT IN A BETTER WAY
		///////////////////////////////IMPLIMENT IN A BETTER WAY
		///////////////////////////////IMPLIMENT IN A BETTER WAY
		///////////////////////////////IMPLIMENT IN A BETTER WAY
		///////////////////////////////IMPLIMENT IN A BETTER WAY
		///////////////////////////////IMPLIMENT IN A BETTER WAY
		///////////////////////////////IMPLIMENT IN A BETTER WAY
		///////////////////////////////IMPLIMENT IN A BETTER WAY
		///////////////////////////////IMPLIMENT IN A BETTER WAY
		///////////////////////////////IMPLIMENT IN A BETTER WAY
		///////////////////////////////IMPLIMENT IN A BETTER WAY
		///////////////////////////////IMPLIMENT IN A BETTER WAY
		///////////////////////////////IMPLIMENT IN A BETTER WAY
		///////////////////////////////IMPLIMENT IN A BETTER WAY
		refgrp();
		Common.grpedited = false;
	}
}
	 void refgrp()
	 {
			Void params = null;
			new fetchgrp().execute(params);
	 }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.groups, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if(id == R.id.my_profile)
		{
			startActivity(new Intent(Groups.this,Profile.class));
			return true;
		}
		if(id == R.id.calc)
		{
			startActivity(new Intent(Groups.this,Calculator.class));
			return true;
		}
		if (id == R.id.refresh_grps)
		{
			refgrp();
			return true;
		}
		if(id == R.id.ab_Preferences)
		{
			startActivity(new Intent(Groups.this , Preferences.class));
			return true;
		}
		if(id == R.id.ab_about)
		{
			new MaterialDialog.Builder(this)
			.title("SplitFa₹e")
			.content("SplitFa₹e\nVersion 1.0\n\nDeveloped By:\nAkul Gupta\nAnkit Makraria\nAstha Jain\nParidhi Goyal")
			.positiveText("OK")
			.positiveColor(R.color.green_500)
			.icon(ConfigHandler.getd()?R.drawable.ic_launcher:R.drawable.ic_launcherd)
			.cancelable(false)
			.callback(new MaterialDialog.ButtonCallback() {
            @Override
            public void onPositive(MaterialDialog dialog) 
            {
            	dialog.dismiss();
            }
			})
			.build().show();
			return true;
		}
		if(id == R.id.ab_Logout)
		{
			ConfigHandler.setuid("-1");
			ConfigHandler.setd(false);
			ConfigHandler.setacc(0);
			ConfigHandler.setcurr("₹");
			ConfigHandler.setn("");
			Toast.makeText(this, "Logged Out !", Toast.LENGTH_LONG).show();
			startActivity(new Intent(Groups.this,Reglogin.class));
			finish();
		}
		if(id == R.id.ab_tutorial)
		{
			startActivity(new Intent(Groups.this,Tutorial.class));
			return true;
		}
		/**
		if (id == R.id.add) 
		{
			LayoutInflater li = LayoutInflater.from(this);
			final View dlg = li.inflate(R.layout.grp, null);
			 MaterialDialog progress = new MaterialDialog.Builder(this)
		        .customView(dlg)
		        .title("Create Group")
		        .cancelable(false)
		        .positiveText("Create")
		        .negativeText("Cancel")
		        .callback(new MaterialDialog.ButtonCallback() 
		        {
		            @Override
		            public void onPositive(MaterialDialog dialog) 
		            {
		            	dialog.dismiss();
		            	EditText e = (EditText) dlg.findViewById(R.id.ed_grpname);
		            	dlgresp = e.getText().toString();
		            	Void params = null;
		            	new creategrp().execute(params);
		            }
		            @Override
		            public void onNegative(MaterialDialog dialog) 
		            {
		            	dialog.dismiss();
		            }
		        })
		        .build();
		        progress.show();
		    
			return true;
		}**/
		return super.onOptionsItemSelected(item);
	}

	private class creategrp extends AsyncTask<Void,Void,Void>
	{
		String uid;
		MaterialDialog progress;
		Document d = null;
		 @Override
		  protected void onPreExecute() 
		   {
			 progress = new MaterialDialog.Builder(Groups.this)
		        .customView(R.layout.progressdlg3)
		        .cancelable(false)
		        .build();
		        progress.show();
			 uid = ConfigHandler.getuid();
		   }
			private Handler handler = new Handler()
			{

			      public void handleMessage( Message msg )
			            {
			             Toast.makeText(Groups.this,"ERROR: "+msg.getData().getString( "message" ), Toast.LENGTH_LONG ).show();
			    	  	//Common.showerrdialog(getBaseContext(), "ERROR", msg.getData().getString( "message" ));
			             progress.dismiss();
			 	        }
			};

		@Override
		protected Void doInBackground(Void... params) 
		{
			String resp =null;
			try
			{
			resp= Common.APICall("http://akul.cu.cc/cgrp.php?u="+uid+"&grp="+dlgresp).substring(4);
			}
			catch(final Exception e)
			{
				  Thread t = new Thread()
		    	    {
		    	        public void run()
		    	        {

		    	            Message myMessage = new Message();
		    	            Bundle resBundle = new Bundle();
		    	          //"Unable To Connect To the Server.. Please Check Your Internet Connection : "+
		    	            resBundle.putString( "message","Unable To Connect To The Server  ( "+ e.getCause().toString()+")" );
		    	            myMessage.setData( resBundle );
		    	            handler.sendMessage( myMessage );
		    	        }
		    	    };
		    	    t.start();
		    	    this.cancel(true);

			}
			if(resp.contains("ERR"))
			{
				
			}
			return null;
		}
		@Override
		 protected void onPostExecute(Void arg) 
		 {
			progress.dismiss();
			refgrp();
		 }
	
	}
	private class fetchgrp extends AsyncTask<Void,Void,Void>
	{
		String uid;
		MaterialDialog progress;
		Document d = null;
		 @Override
		  protected void onPreExecute() 
		   {
			 progress = new MaterialDialog.Builder(Groups.this)
		        .customView(R.layout.progressdlg2)
		        .cancelable(false)
		        .build();
		        progress.show();
			 uid = ConfigHandler.getuid();
		   }

			private Handler handler = new Handler()
			{

			      public void handleMessage( Message msg )
			            {
			             Toast.makeText(Groups.this,"ERROR: "+msg.getData().getString( "message" ), Toast.LENGTH_LONG ).show();
			    	  	//Common.showerrdialog(getBaseContext(), "ERROR", msg.getData().getString( "message" ));
			             progress.dismiss();
			 	        }
			};

		@Override
		protected Void doInBackground(Void... arg0) 
		{
			
			try
			{
				d = Common.getdoc("http://akul.cu.cc/ggrpsbyid.php?u="+uid);
				NodeList nl = d.getElementsByTagName("group");
				listview_names = new String[nl.getLength()];
				listview_images = new int[nl.getLength()];
				gids = new String[nl.getLength()];
				for(int x =0 ;x<nl.getLength();x++)
				{
					listview_names[x] = nl.item(x).getAttributes().getNamedItem("name").getNodeValue();
					gids[x] = nl.item(x).getAttributes().getNamedItem("id").getNodeValue();
					listview_images[x] = R.drawable.grpf;
				}
			}
			catch(final Exception e)
			{
				  Thread t = new Thread()
		    	    {
		    	        public void run()
		    	        {

		    	            Message myMessage = new Message();
		    	            Bundle resBundle = new Bundle();
		    	          //"Unable To Connect To the Server.. Please Check Your Internet Connection : "+
		    	            resBundle.putString( "message","Unable To Connect To The Server  ( "+ e.getCause().toString()+")" );
		    	            myMessage.setData( resBundle );
		    	            handler.sendMessage( myMessage );
		    	        }
		    	    };
		    	    t.start();
				progress.dismiss();
				this.cancel(true);
			}
			
			return null;
		}
		
		@Override
		 protected void onPostExecute(Void arg) 
		 {
			lv = (ListView) findViewById(android.R.id.list);
			  array_sort=new ArrayList<String> (Arrays.asList(listview_names));
			  image_sort=new ArrayList<Integer>();
			  for (int index = 0; index < listview_images.length; index++)
			  {
			   image_sort.add(listview_images[index]);
			  }
			  lv.setDivider(null);
			  lv.setDividerHeight(0);
			  lv.setAdapter(new LVAdaptern(Groups.this , array_sort , image_sort ,listview_images , listview_names));
			  lv.setOnItemClickListener(new OnItemClickListener() {

				  public void onItemClick(AdapterView<?> arg0,
				  View arg1, int position, long arg3)
				  {
					///////////////////////////////////////
						Intent intent = new Intent(Groups.this , Transactions.class);
					    Bundle b = new Bundle();
						b.putString("id", gids[position]);
						b.putString("name" , array_sort.get(position));
						intent.putExtras(b); 
						startActivity(intent);
				  }
				 });
			progress.dismiss();
		 }
	}
	}


	

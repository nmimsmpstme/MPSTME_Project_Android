package com.akul.splitfare;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

public class Profile extends ActionBarActivity
{
	   private static final int REQUEST_CODE = 1;
	   private Bitmap bitmap;
	   private ImageView imageView;
	   private Bitmap bmp;
	   Void params = null;
	   private TextView t;
	  
	   String sr(String urlParameters) throws Exception
	   {
		   URL url = new URL("http://akul.cu.cc/setdp.php");
		    URLConnection conn = url.openConnection();
		    conn.setDoOutput(true);
		    OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
		    writer.write(urlParameters);//"value=1&anotherValue=1");
		    writer.flush();
		    String line;
		    String resp="";
		    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    while ((line = reader.readLine()) != null) 
		    {
		      resp+= line+"\n";
		    }
		    writer.close();
		    reader.close();
		    return resp;
	   }
	   void stordp()
	   {
		   new AsyncTask<Void,Void,Void>()
		   {
			MaterialDialog progress;
			 @Override
			 protected void onPreExecute()
			 {
				 progress = new MaterialDialog.Builder(Profile.this)
			        .customView(R.layout.progressdlg2)
			        .cancelable(false)
			        .build();
			        progress.show();
			 }
			@Override
			protected Void doInBackground(Void... params) 
			{
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();  
				bmp.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
				byte[] byteArray = byteArrayOutputStream .toByteArray();
				String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);
			Log.e("MYA",encoded);
			Log.e("MYA",encoded);
				try
				{
					
					String resp = sr("u="+ConfigHandler.getuid()+"&dp="+encoded);
				
					if(resp.contains("ERR"))
					{
						throw new Exception("Server Error");
					}
				}
				catch(Exception e)
				{
					this.cancel(true);
					e.printStackTrace();
				}
				return null;
			}
			@Override
			protected void onPostExecute(Void v)
			{
				progress.dismiss();
			}
		   }.execute(params);
	   }
	 void loadprofile()  
	 {
		 new AsyncTask<Void,Void,Void> ()
		 {
			 MaterialDialog progress;
			 String n;
			 @Override
			 protected void onPreExecute()
			 {
				 progress = new MaterialDialog.Builder(Profile.this)
			        .customView(R.layout.progressdlg2)
			        .cancelable(false)
			        .build();
			        progress.show();
			 }

			@Override
			protected Void doInBackground(Void... params) 
			{
				  try
			      {
			        	 n= Common.APICall("http://akul.cu.cc/getfn.php?u="+ConfigHandler.getuid()).substring(4).trim();
			        	 String s = Common.APICall("http://akul.cu.cc/getdp.php?u="+ConfigHandler.getuid()).substring(4);
			        	 if(s.trim().equalsIgnoreCase("NULL"))
			        	 {
			        		 bmp = BitmapFactory.decodeResource(getResources(), R.drawable.user);
			        	 }
			        	 else
			        	 {
			        	 byte[] by = Base64.decode(s, 0);
			        	 bmp = BitmapFactory.decodeByteArray(by, 0, by.length);
			        	 //bmp = BitmapFactory.decodeStream((InputStream)new URL("http://akul.cu.cc/getdp.php?u=1").getContent());
			        	 }
			        }
			         catch (Exception e)
			         {
						e.printStackTrace();
					} 
				return null;
			}
			@Override
			protected void onPostExecute(Void v)
			{
				imageView.setImageBitmap(bmp);	 
				progress.dismiss();
				t.setText(n);
			}
		 }.execute(params);
	 }
	   @Override
	protected void onCreate(Bundle savedInstanceState) 
	{
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
		  getSupportActionBar().setElevation(0);
		  setContentView(R.layout.activity_profile);
		  imageView = (ImageView)findViewById(R.id.imageView1);
		  ImageButton ib = (ImageButton)findViewById(R.id.ImageButton01);
		  t = (TextView)findViewById(R.id.tvprof1);
		  loadprofile();
		  ib.setOnClickListener(new View.OnClickListener()
		  {
			@Override
			public void onClick(View arg0) 
			{

		        Intent intent = new Intent();
		        intent.setType("image/*");
		        intent.putExtra("crop", "true");
		        intent.putExtra("aspectX", 1);
		        intent.putExtra("aspectY", 1);
		        intent.putExtra("outputX", 256);
		        intent.putExtra("outputY", 256);
		        intent.putExtra("return-data", true);
		        intent.setAction(Intent.ACTION_GET_CONTENT);
		        intent.addCategory(Intent.CATEGORY_OPENABLE);
		        startActivityForResult(intent, REQUEST_CODE);
			}
		});
		  /**
		  ImageButton b = (ImageButton) findViewById(R.id.imageButton1);
		  b.setOnClickListener(new View.OnClickListener() {
		 	@Override
			public void onClick(View arg0) 
			{
			}
		});**/
		  ListView lv = (ListView)findViewById(R.id.prof_lv);
		  lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
		  {
			  LayoutInflater li = LayoutInflater.from(Profile.this);
				final View dlg = li.inflate(R.layout.chpassdlg, null);
				final EditText e = (EditText) dlg.findViewById(R.id.ed_chpassep);
				final EditText n = (EditText) dlg.findViewById(R.id.ed_chpassnwp);
				final EditText v = (EditText) dlg.findViewById(R.id.ed_chpassvp);
				MaterialDialog progress = new MaterialDialog.Builder(Profile.this)
			        .customView(dlg)
			        .title("Change Password")
			        .cancelable(false)
			        .positiveText("Change")
			        .negativeText("Cancel")
			        .positiveColorRes(R.color.green_600)
			         .negativeColorRes(R.color.red_600)
			        .callback(new MaterialDialog.ButtonCallback() 
			        {
			        	@Override
			        	public void onPositive(MaterialDialog d)
			        	{
			        		if(Common.gt(e)=="" || Common.gt(n)=="" || Common.gt(v)=="")
			        		{
			        			Common.showerrdialog(Profile.this, "ERROR", "Please Enter All Fields");
			        			d.dismiss();
						    }
			        		else if(!Common.gt(n).equals(Common.gt(v)))
			        		{
			        			Common.showerrdialog(Profile.this, "ERROR", "Entered Passwords Do Not Match");
			        			d.dismiss();
						    }
			        		else
			        		{
			        			d.dismiss();
			        			commit(Common.gt(e).trim() , Common.gt(n).trim());
			        	    }
			        	}
			        	@Override
			        	public void onNegative(MaterialDialog d)
			        	{
			        		d.dismiss();
			        	}
			        })
			        .build();
			
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) 
			{
				Void params = null;
					if(arg2==0)
					{
						progress.show();
					}
					}
		});
	}
	   void commit(final String op ,final String np)
	   {
			new AsyncTask<Void,Void,Void>()
			{
				MaterialDialog progress;
				 @Override
				 protected void onPreExecute()
				 {
					 progress = new MaterialDialog.Builder(Profile.this)
				        .customView(R.layout.progressdlg2)
				        .cancelable(false)
				        .build();
				        progress.show();
				 }
				@Override
				protected Void doInBackground(Void... params) 
				{
					try
					{
					String salt = Common.APICall("http://akul.cu.cc/getsaltbyid.php?u="+ConfigHandler.getuid()).substring(4).trim();
						String  opf =Common.hash(op+salt);
						String npf =Common.hash(np+salt);
						String resp = Common.APICall("http://akul.cu.cc/chpass.php?u="+ConfigHandler.getuid()+"&op="+opf+"&np="+npf).substring(4);
						if(resp.contains("ERR"))
						{
							runOnUiThread(new Runnable() {
				                public void run() 
				                {
				                	Toast.makeText(Profile.this, "Invalid Password", Toast.LENGTH_LONG).show();
				                	progress.dismiss();
				                }
				            });
						}
						}
					catch(Exception e)
					{
						runOnUiThread(new Runnable() {
			                public void run() 
			                {
			                	Toast.makeText(Profile.this, "Invalid Password", Toast.LENGTH_LONG).show();
			                	progress.dismiss();
			                }
			            });
						e.printStackTrace();
					}
					return null;
				}
				@Override
				protected void onPostExecute(Void v)
				{
					progress.dismiss();
					Toast.makeText(Profile.this, "Password Changed!", Toast.LENGTH_LONG).show();
				}
			}.execute(params);
	   }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		int id = item.getItemId();
		return super.onOptionsItemSelected(item);
	}
	
	 @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	    {
	        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK)
	         try
	        {
	        		Bundle extras2 = data.getExtras();
	        	 //   bmp.recycle();
		            //InputStream stream = getContentResolver().openInputStream(data.getData());
	                bmp= Common.getCroppedBitmap((Bitmap) extras2.getParcelable("data"));//Common.getCroppedBitmap(BitmapFactory.decodeStream(stream));
	                imageView.setImageBitmap(bmp);
	                //stream.close();
	                stordp();
	            }
	        catch (Exception e) 
	        {
	                e.printStackTrace();
	        } 
	        super.onActivityResult(requestCode, resultCode, data);
	    }

}

	


package com.akul.splitfare;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.gc.materialdesign.views.ButtonFloat;

public class GRPinfo extends ActionBarActivity {
	String gid;
	String t;
	String[] listview_names ;
	int[] listview_images;
	private ListView lv;
	private static ArrayList<String> array_sort;
	 private static ArrayList<Bitmap> image_sort;
	 String memname;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		 setTheme(ConfigHandler.getstyle()); 
		super.onCreate(savedInstanceState);
		 android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
		 Bundle b = getIntent().getExtras();
			t = b.getString("name");
	        gid = b.getString("id");
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
	    	setContentView(R.layout.activity_grpinfo);
	    	actionBar.setTitle(t);
	    	Common.grpmemchanged = false;
	    	final Void params = null;
			new fetchmem().execute(params);
			ButtonFloat add = (ButtonFloat) findViewById(R.id.buttonFloatadd);
			int clr = getResources().getColor(ConfigHandler.getColorres());
			String col = "#"+Integer.toHexString(clr);
			add.setBackgroundColor(Color.parseColor(col));
			final ButtonFloat f = add;
			add.setOnClickListener(new OnClickListener(){
					public void onClick(View v) 
					{
						LayoutInflater li = LayoutInflater.from(GRPinfo.this);
						final View dlg = li.inflate(R.layout.mem, null);
						 MaterialDialog progress = new MaterialDialog.Builder(GRPinfo.this)
					        .customView(dlg)
					        .title("Add Member")
					        .cancelable(false)
					        .positiveText("Add")
					        .negativeText("Cancel")
					        .callback(new MaterialDialog.ButtonCallback() 
					        {
					            @Override
					            public void onPositive(MaterialDialog dialog) 
					            {
					            	dialog.dismiss();
					            	EditText e = (EditText) dlg.findViewById(R.id.ed_grpname);
					            	memname = e.getText().toString();
					            	//Toast.makeText(GRPinfo.this, memname,Toast.LENGTH_LONG);
					            	new addmem().execute(params);
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
	   	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.grpinfo, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		int id = item.getItemId();
		if(id == R.id.grp_leave)
		{
			new MaterialDialog.Builder(GRPinfo.this)
	        .title("Leave Group")
	        .content("Are You Sure You Want To Leave This Group ?")
	        .positiveText("Yes")
	        .negativeText("No")
	        .positiveColorRes(R.color.red_600)
	        .negativeColorRes(R.color.green_600)
	        .callback(new MaterialDialog.ButtonCallback() 
	        {
	            @Override
	            public void onPositive(MaterialDialog dialog) 
	            {
	            	try
	            	{
	            		Thread th = new Thread()
	            		{
	            			@Override
	            			public void run()
	            			{
	            				try
	            				{
	            					String resp = Common.APICall("http://akul.cu.cc/leavegrp.php?u="+ConfigHandler.getuid()+"&g="+gid);
	            					if(resp.contains("ERR"))
	            					{
	            						throw(new Exception("Server Error"));
	            					}
	            					else
	            					{
	            						Common.grpleft =true;
	            						GRPinfo.this.finish();
	            					}
	            				}
	            				catch(Exception e)
	            				{
	            					e.printStackTrace();
	            				}
	            			}
	            		};
	            		th.start();
	            		th.join();
	            	}
	            	catch(Exception e)
	            	{
	            		
	            	}
	            	dialog.dismiss();
	            }
	            @Override
	            public void onNegative(MaterialDialog d)
	            {
	             	d.dismiss();
	 	        }
	        })
	        .cancelable(false)
	        .show();
		}
		if(id == R.id.grp_rename)
		{
			LayoutInflater li = LayoutInflater.from(GRPinfo.this);
			final View dlg = li.inflate(R.layout.rename_grp, null);
			final EditText e = (EditText) dlg.findViewById(R.id.ed_grpnwname);
			MaterialDialog progress = new MaterialDialog.Builder(GRPinfo.this)
		        .customView(dlg)
		        .title("Rename Group")
		        .cancelable(false)
		        .positiveText("Save")
		        .negativeText("Cancel")
		        .positiveColorRes(R.color.green_600)
		         .negativeColorRes(R.color.red_600)
		        .callback(new MaterialDialog.ButtonCallback() 
		        {
		        	@Override
		        	public void onPositive(MaterialDialog d)
		        	{
		        		try
		        		{
		        			Thread th = new Thread()
		        			{
		        				@Override
		        				public void run()
		        				{
		        					try
		        					{
		        					String r = Common.APICall("http://akul.cu.cc/rengrp.php?g="+gid+"&n="+Common.gt(e)).substring(4);
		    		        		if(r.contains("ERR"))
		    		        		{
		    		        			throw(new Exception());
		    		        		}
		    		        		else
		    		        		{
		    		        			Common.grpedited = true;
		    		        		}
		    		        		}
		        	        		catch(Exception e)
		    		        		{
		    		        			e.printStackTrace();
		    		        		}
		    		      	}
		    		    	};
		    		    	th.start();
		    		    	th.join();
		    		    	d.dismiss();
		    		    	if(Common.grpedited)
		    		    	{
		    		    		getSupportActionBar().setTitle(Common.gt(e));
		    		    		Transactions.t= Common.gt(e);
		    		    	}
			    		}
		        		catch(Exception ex)
		        		{
		    			    
		        		}
		        	}
		        	@Override
		        	public void onNegative(MaterialDialog d)
		        	{
		        		d.dismiss();
		        	}
		        	
		        	
		        })
		        .build();
		        progress.show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	class addmem extends AsyncTask<Void,Void,Void>
	{
		MaterialDialog progress;
		boolean ok;
		  protected void onPreExecute() 
		   {
			 progress = new MaterialDialog.Builder(GRPinfo.this)
		        .customView(R.layout.progressdlg2)
		        .cancelable(false)
		        .build();
		        progress.show();
			}
			private Handler handler = new Handler()
			{

			      public void handleMessage( Message msg )
			            {
			             Toast.makeText(GRPinfo.this,"ERROR: "+msg.getData().getString( "message" ), Toast.LENGTH_LONG ).show();
			    	  	//Common.showerrdialog(getBaseContext(), "ERROR", msg.getData().getString( "message" ));
			             progress.dismiss();
			 	        }
			};

				@Override
		protected Void doInBackground(Void... params) 
		{
					ok = true;
					try
					{
						String resp = Common.APICall("http://akul.cu.cc/addtg.php?email="+memname.replace("@","%40")+"&g="+gid).substring(4);
						if(resp.contains("ERR"))
						{
							ok=false;
							if(resp.contains("ERR02"))
							{
								Thread t = new Thread()
								{
							        @Override
							        public void run() 
							        {
							            runOnUiThread(new Runnable() {
							                public void run() 
							                {
							                	Toast.makeText(GRPinfo.this, "ERROR: Entered e-mail id does not belong to any user", Toast.LENGTH_LONG).show();
							                	progress.dismiss();
							                }
							            });
	
							        }
							    };
							    t.start();
							}
							else if(resp.contains("ERR03"))
							{
								Thread t = new Thread()
								{
							        @Override
							        public void run() 
							        {
							            runOnUiThread(new Runnable() {
							                public void run() 
							                {
							                	Toast.makeText(GRPinfo.this, "ERROR: Entered user is already a member of the group", Toast.LENGTH_LONG).show();
							                	progress.dismiss();
							                }
							            });
	
							        }
							    };
							    t.start();
							}
						}
						else
						{
							Thread t1 = new Thread()
							{
						        @Override
						        public void run() 
						        {
						            runOnUiThread(new Runnable() {
						                public void run() 
						                {
		 										if(ok)
												{
													progress.dismiss();
													Void params=null;
													new fetchmem().execute(params);
													Common.grpmemchanged = true;
												}
						                }
						            });

						        }
						    };
						    t1.start();
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
	}
	class fetchmem extends AsyncTask<Void , Void ,Void>
	{
		String uid;
		MaterialDialog progress;
		Document d = null;
		String fn;
		Bitmap[] lv_bitmaps ;
		 @Override
		  protected void onPreExecute() 
		   {
			 progress = new MaterialDialog.Builder(GRPinfo.this)
		        .customView(R.layout.progressdlg2)
		        .cancelable(false)
		        .build();
		        progress.show();
			 uid = ConfigHandler.getuid();
			   }
		@Override
		protected Void doInBackground(Void... arg0) 
		{
			try
			{
				fn = Common.APICall("http://akul.cu.cc/getfn.php?u="+uid).substring(4);
				d = Common.getdoc("http://akul.cu.cc/gmembyid.php?g="+gid);
				NodeList nl = d.getElementsByTagName("user");
				listview_names = new String[nl.getLength()];
				listview_images = new int[nl.getLength()];
				lv_bitmaps = new Bitmap[nl.getLength()];
				for(int x =0 ;x<nl.getLength();x++)
				{
					lv_bitmaps[x] = Common.getBitmap(nl.item(x).getAttributes().getNamedItem("id").getNodeValue().trim());
					if(nl.item(x).getAttributes().getNamedItem("name").getNodeValue().trim().equalsIgnoreCase(fn))
					{
						listview_names[x] = "Me";
						//listview_images[x] = R.drawable.user;
					}
					else
					{
					listview_names[x] = nl.item(x).getAttributes().getNamedItem("name").getNodeValue();
					//listview_images[x] = R.drawable.user;
					}
				}
			}
			catch(Exception e)
			{
				
			}
			return null;
		}
		 protected void onPostExecute(Void arg) 
		 {
			lv = (ListView) findViewById(R.id.memlist);
			  array_sort=new ArrayList<String> (Arrays.asList(listview_names));
			  image_sort=new ArrayList<Bitmap>();
			  for (int index = 0; index < listview_images.length; index++)
			  {
			   image_sort.add(lv_bitmaps[index]);
			  }
			  lv.setDivider(null);
			  lv.setDividerHeight(0);
			  lv.setAdapter(new LVAdapter(GRPinfo.this , array_sort , image_sort ,lv_bitmaps, listview_names));
			progress.dismiss();
		 }

	}
	}


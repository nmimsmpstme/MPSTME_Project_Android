package com.akul.splitfare;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.gc.materialdesign.views.ButtonFloat;

public class Transactions extends ActionBarActivity
{
	String gid;
	static String t;
	String amt;
	String desc;
	String[] names;
	String[] ids;
	float[] reps;
	float[] repas;
	float[] amts;
	TransactionsAdapter adapter;
	private ListView lv;
	private ArrayList<String> dlist = new ArrayList<String>();
	private ArrayList<String> dlist2 = new ArrayList<String>();	
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
		setContentView(R.layout.activity_trans);
		Common.grpleft = false;
		actionBar.setTitle(t);
		final Void params = null;
		new fetchtransac().execute(params);
		ButtonFloat add = (ButtonFloat) findViewById(R.id.buttonFloataddTrans);
		int clr = getResources().getColor(ConfigHandler.getColorres());
		String col = "#"+Integer.toHexString(clr);
		add.setBackgroundColor(Color.parseColor(col));
		add.setOnClickListener(new OnClickListener(){
			public void onClick(View v) 
			{
				LayoutInflater li = LayoutInflater.from(Transactions.this);
				final View dlg = li.inflate(R.layout.transdlg, null);
				 MaterialDialog progress = new MaterialDialog.Builder(Transactions.this)
			        .customView(dlg)
			        .title("Add Transaction")
			        .cancelable(false)
			        .positiveText("Add")
			        .negativeText("Cancel")
			        .callback(new MaterialDialog.ButtonCallback() 
			        {
			            @Override
			            public void onPositive(MaterialDialog dialog) 
			            {
			            	dialog.dismiss();
			            	EditText e = (EditText) dlg.findViewById(R.id.ed_trdesc);
			            	desc = e.getText().toString();
			            	EditText e2 = (EditText) dlg.findViewById(R.id.ed_tramt);
			            	amt = e2.getText().toString();
			            	new createtransac().execute(params);
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
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.transactions, menu);
		
		return true;
	}
	@Override
	public void onResume()
	{
		super.onResume();
		if(Common.grpedited)
		{
			getSupportActionBar().setTitle(t);
			//Common.grpedited = false;
	   }
		if(Common.grpleft)
		{
			Common.grpedited = true;
			finish();
		}
		if(Common.grpmemchanged)
		{
			Common.grpmemchanged = false;
			Void params =null;
			new fetchtransac().execute(params);
		}
	}
	void sendreminder(final ArrayList<String> l , final ArrayList<String> l2)
	{
		String[] mStringArray = new String[l.size()];
		mStringArray = l.toArray(mStringArray);
		
		new MaterialDialog.Builder(Transactions.this)
        .title("Select The Person To Remind")
        .items(mStringArray)
        .itemsCallback(new MaterialDialog.ListCallback()
        {
            @Override
            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) 
            {
            	String Message = "Hey "+l.get(which)+"\nYou owe me "+l2.get(which).substring(1)+" "+ConfigHandler.getcurr()+"\n\nKindly Pay Me Back at your earliest convenience";
            	Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            	sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, Message);
                startActivity(Intent.createChooser(sharingIntent,"Remind Using"));
            }
        }).build().show();
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		int id = item.getItemId();
		if(id == R.id.rep_history)
		{
			startActivity(new Intent(Transactions.this,RepHistory.class).putExtra("gid", gid).putExtra("t", t));
		}
		if(id == R.id.repa_history)
		{
			startActivity(new Intent(Transactions.this,Repahistory.class).putExtra("gid", gid).putExtra("t", t));
		}
		if (id == R.id.summary_trans)
		{
			dlist.clear();
			dlist2.clear();
			int total =0;
			float[] dues = new float[names.length];
			dlist = new ArrayList<String>();
			amts = new float[names.length];
			for(int x=0;x<adapter.getCount();x++)
			{
				int up =0;
				total += Integer.parseInt(adapter.getItem(x).amt);
				for(int y=0;y<names.length;y++)
				{
					if(adapter.getItem(x).name.equalsIgnoreCase(names[y]))
					{
						up =y;
						break;
					}
				}
				amts[up] += Integer.parseInt(adapter.getItem(x).amt);
			}
			int meindx = 0;
			for(int i=0;i<names.length;i++)
			{
				amts[i]=amts[i] + reps[i] - repas[i];
			}
			float actamt = total/(float)names.length;
			for(int m=0;m<names.length;m++)
			{
				if(names[m].equalsIgnoreCase("Me"))
				{
					meindx=m;
					break;
				}
			}
			float td= actamt -amts[meindx];
			if(td>0)
			{
				for(int m=0;m<names.length;m++)
				{
					if(m != meindx)
					{
						if(amts[m]-actamt>0)
						{
							if(amts[m]-actamt>=td)
							{
								dues[m] = td;
								break;
							}
							else
							{
								dues[m] = amts[m]-actamt;
								td -= amts[m]-actamt;
							}
						}
					}
				}
			}
			else if(td < 0)
			{
				for(int m=0;m<names.length;m++)
				{
					if(m != meindx)
					{
						if(actamt-amts[m]>0)
						{
							if(actamt-amts[m] >= -(td))
							{
								dues[m] = td;
								break;
							}
							else
							{
								dues[m] = -(actamt-amts[m]);
								td += actamt-amts[m];
							}
						}
					}
			
				}
			}
			
			String msg="\n\nRespective Amounts Paid:";
			for(int w=0;w<names.length;w++)
			{
				msg+="\n"+names[w]+"  "+amts[w]+ConfigHandler.getcurr();
			}
			msg +="\n\nRepayments Made: "+reps[meindx]+ConfigHandler.getcurr()+"\nRepayments Accepted: "+repas[meindx]+ConfigHandler.getcurr()+"\n";			
			boolean d = false;
			for(int w=0;w<names.length;w++)
			{
				if(dues[w] != 0)
				{
					if(dues[w]>0)
					{
						msg+="\nYou Owe "+names[w]+"  "+dues[w]+ConfigHandler.getcurr();
						d = true;
					}
					else
					{
						msg+="\n"+names[w]+" Owes You "+-dues[w]+ConfigHandler.getcurr();
						dlist.add(names[w]);
						dlist2.add(""+dues[w]);
					}
				}
			}
			if(!d)
			{
				new MaterialDialog.Builder(this)
		        .title("Summary")
		        .content("Total Expense:"+total+" "+ConfigHandler.getcurr()+msg)
		        .positiveText("OK")
		        .negativeText(dlist.size()==0?"":"Remind")
		        .positiveColorRes(R.color.green_600)
		        .callback(new MaterialDialog.ButtonCallback() 
		        {
		            @Override
		            public void onPositive(MaterialDialog dialog) 
		            {
		            	dialog.dismiss();
		            }
		            @Override
		            public void onNegative(MaterialDialog dialog) 
		            {
		            	dialog.dismiss();
		            	sendreminder(dlist,dlist2);
		            }
		        })
		        .cancelable(false)
		        .show();
			}
			else
			{
		    	final float[] f = dues;
		    	final String[] fids = ids;
		    	final int m = meindx;
		    	final float[] ds = dues;
		    	new MaterialDialog.Builder(this)
		        .title("Summary")
		        .content("Total Expense:"+total+" ₹"+msg)
		        .positiveText("OK")
		        .negativeText(dlist.size()==0?"":"Remind")
		        .neutralText("Clear Dues")
		        .neutralColorRes(R.color.blue_600)
		        .positiveColorRes(R.color.green_600)
		        .callback(new MaterialDialog.ButtonCallback() 
		        {
		        	  @Override
			            public void onNegative(MaterialDialog dialog) 
			            {
			            	dialog.dismiss();
			            	sendreminder(dlist,dlist2);
			            }
		            @Override
		            public void onPositive(MaterialDialog dialog) 
		            {
		            	dialog.dismiss();
		            }
		            @Override
		            public void onNeutral(MaterialDialog d)
		            {
		            	d.dismiss();
		            	MaterialDialog progress = new MaterialDialog.Builder(Transactions.this)
				        .customView(R.layout.progressdlg2)
				        .cancelable(false)
				        .build();
				        progress.show();
				        final boolean flag = true;
				        try
				        {
				        	Thread th = new Thread()
				        	{
				        		@Override
				        		public void run()
				        		{
				        			for(int w=0;w<names.length;w++)
				        			{
				        				if(f[w] != 0)
				        				{
				        					if(f[w]>0)
				        					{
				        						try
				        						{
				        						Common.APICall("http://akul.cu.cc/createrep.php?g="+gid+"&fu="+ConfigHandler.getuid().trim()+"&tu="+fids[w]+"&a="+f[w]);
				        						}
				        						catch(Exception e)
				        						{
				        							e.printStackTrace();
				        							//flag = false;
				        							this.stop();
				        						}
				        					}
				        				}
				        			}
				        		}
				        	};
				        	th.start();
				        	th.join();
				        	progress.dismiss();
				        	Toast.makeText(Transactions.this, "Dues Cleared !", Toast.LENGTH_LONG).show();
				        	float s=0;
				        	for(int x=0;x<names.length;x++)
				        	{
				        		if(f[x]>0)
	        					{
				        			s += ds[x];
				        			repas[x] += ds[x];
	        					}
				        	}
				        	reps[m] += s;
				        }
				        catch(Exception e)
				        {
				        	
				        }
		            	
		            }
		        })
		        .cancelable(false)
		        .show();
			}
			return true;
		}
		if (id == R.id.info)
		{
			Common.grpedited = false;
			Intent intent = new Intent(Transactions.this , GRPinfo.class);
		    Bundle b = new Bundle();
			b.putString("id", gid);
			b.putString("name" , t);
			intent.putExtras(b); 
			startActivity(intent);

			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	class createtransac extends AsyncTask<Void,Void,Void>
	{
		MaterialDialog progress;
		boolean ok;
		String uid;
		private Handler handler = new Handler()
		{

		      public void handleMessage( Message msg )
		            {
		             Toast.makeText(Transactions.this,"ERROR: "+msg.getData().getString( "message" ), Toast.LENGTH_LONG ).show();
		    	  	//Common.showerrdialog(getBaseContext(), "ERROR", msg.getData().getString( "message" ));
		             progress.dismiss();
		 	        }
		};

		  protected void onPreExecute() 
		   {
			 progress = new MaterialDialog.Builder(Transactions.this)
		        .customView(R.layout.progressdlg2)
		        .cancelable(false)
		        .build();
		        progress.show();
		        uid = ConfigHandler.getuid();
			}

		@Override
		protected Void doInBackground(Void... params) 
		{
			String result = "";
			try
			{
			result = Common.APICall("http://akul.cu.cc/createtransac.php?u="+uid+"&g="+gid+"&desc="+desc+"&amt="+amt).substring(4);
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
			if(result.contains("ERR"))
			{
				 runOnUiThread(new Runnable() {
		                public void run() 
		                {
		                	progress.dismiss();
		                }
		            });
				}
			
			else
			{
				progress.dismiss();
			final String res= result;
				runOnUiThread(new Runnable() {
	                public void run() 
	                {
	    				adapter.add(new Transaction(false,res.trim(), desc,"Me",amt));
	                	progress.dismiss();
	                }
	            });
			}
			return null;
		}
		
	}
	class fetchtransac extends AsyncTask<Void,Void,Void>
	{
		String uid;
		MaterialDialog progress;
		Document d = null;
		String fn;
		private Handler handler = new Handler()
		{

		      public void handleMessage( Message msg )
		            {
		             Toast.makeText(Transactions.this,"ERROR: "+msg.getData().getString( "message" ), Toast.LENGTH_LONG ).show();
		    	  	//Common.showerrdialog(getBaseContext(), "ERROR", msg.getData().getString( "message" ));
		             progress.dismiss();
		 	        }
		};

		 @Override
		  protected void onPreExecute() 
		   {
			 progress = new MaterialDialog.Builder(Transactions.this)
		        .customView(R.layout.progressdlg2)
		        .cancelable(false)
		        .build();
		        progress.show();
			 uid = ConfigHandler.getuid();
				lv = (ListView) findViewById(R.id.lv_trans);
				adapter = new TransactionsAdapter(getApplicationContext(), R.layout.listitem_transac);
				lv.setDivider(null);
				lv.setDividerHeight(0);
			   }
			@Override
		protected Void doInBackground(Void... arg0) 
		{
				try 
				{
					fn = Common.APICall("http://akul.cu.cc/getfn.php?u="+uid).substring(4);
					d = Common.getdoc("http://akul.cu.cc/gettransac.php?g="+gid);
					NodeList nl = d.getElementsByTagName("transaction");
					for(int x =0 ;x<nl.getLength();x++)
					{
						if(nl.item(x).getAttributes().getNamedItem("name").getNodeValue().trim().equalsIgnoreCase(fn))
						{
							adapter.add(new Transaction(false,nl.item(x).getAttributes().getNamedItem("id").getNodeValue().trim(), nl.item(x).getAttributes().getNamedItem("desc").getNodeValue().trim() ,"Me" ,nl.item(x).getAttributes().getNamedItem("amt").getNodeValue().trim()));
						}
						else
						{
							adapter.add(new Transaction(true,nl.item(x).getAttributes().getNamedItem("id").getNodeValue().trim(), nl.item(x).getAttributes().getNamedItem("desc").getNodeValue().trim() ,nl.item(x).getAttributes().getNamedItem("name").getNodeValue().trim() ,nl.item(x).getAttributes().getNamedItem("amt").getNodeValue().trim()));
						}
					}
			
				} 
				catch (final Exception e) 
				{
					e.printStackTrace();
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
				Document d = null;
				try
				{
				d = Common.getdoc("http://akul.cu.cc/gmembyid.php?g="+gid);
				NodeList nl = d.getElementsByTagName("user");
				names= new String[nl.getLength()];
				ids = new String[nl.getLength()];
				amts = new float[nl.getLength()];
				reps = new float[nl.getLength()];
				repas = new float[nl.getLength()];
				String fn = Common.APICall("http://akul.cu.cc/getfn.php?u="+ConfigHandler.getuid()).substring(4);
				for(int x =0 ;x<nl.getLength();x++)
				{
					if(nl.item(x).getAttributes().getNamedItem("name").getNodeValue().trim().equalsIgnoreCase(fn))
					{
						names[x] = "Me";
					}
					else
					{
					names[x] = nl.item(x).getAttributes().getNamedItem("name").getNodeValue();
					}
					ids[x] = nl.item(x).getAttributes().getNamedItem("id").getNodeValue();
					String s = Common.APICall("http://akul.cu.cc/getrepsum.php?g="+gid+"&u="+ids[x]).substring(4);
					String s2 = Common.APICall("http://akul.cu.cc/getrepasum.php?g="+gid+"&u="+ids[x]).substring(4);
					reps[x] = Float.parseFloat(s.trim());
					repas[x] = Float.parseFloat(s2.trim());
				}
				} 
				catch (final Exception e) 
				{
					e.printStackTrace();
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
		 
		protected void onPostExecute(Void arg) 
		 {
			lv.setLongClickable(true);
			lv.setOnItemLongClickListener(new OnItemLongClickListener() 
			{
				@Override
				public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
						final int arg2, long arg3)
				{
				 final Transaction t = adapter.getItem(arg2);
				 final String id = t.id.trim();
			     if(t.left == true)
			     {
			    		new MaterialDialog.Builder(Transactions.this)
				        .title("Select An Action")
				        .items(new String[] {"More Details"})
				        .itemsCallback(new MaterialDialog.ListCallback()
				        {
				            @Override
				            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) 
				            {
				            	try
			            		{
			            		Common.tdialshow=false;
			            		Common.resp = "";
			            		Thread th = new Thread()
			            		{
			            			@Override
			            			public void run()
			            			{
			            				try
			            				{
			            				Common.resp = Common.APICall("http://akul.cu.cc/gettransdet.php?t="+id).substring(4);
			            				if(Common.resp.contains("ERR"))
			            				{
			            					
			            				}
			            				else
			            				{
			            					Common.tdialshow = true;
			            				}
			            				}
			            				catch(Exception ex)
			            				{
			            					
			            				}
			            			}
			            		};
			            		th.start();
			            		th.join();
			            		if(Common.tdialshow)
			            		{
	            					new MaterialDialog.Builder(Transactions.this)
	            			        .title("Transaction Details")
	            			        .content("Transaction Date : "+Common.resp.substring(0, Common.resp.indexOf(" ")).trim()+"\nTransaction Time: "+Common.resp.substring(Common.resp.indexOf(" ")).trim()+"\nDetails: "+t.comment+"\nAmount:"+t.amt)
	            			        .positiveText("OK")
	            			        .positiveColorRes(R.color.green_600)
	            			        .callback(new MaterialDialog.ButtonCallback() {
	            			            @Override
	            			            public void onPositive(MaterialDialog dialog) 
	            			            {
	            			            	dialog.dismiss();
	            			            }
	            			        })
	            			        .cancelable(false)
	            			        .show();
			            		}
			            		}
			            		catch(Exception ex)
			            		{
			            		}

				            }
				        })
				        .build()
				        .show();
			    		
			    		
			     }
			     else if(t.left == false)
			        {
					new MaterialDialog.Builder(Transactions.this)
			        .title("Select An Action")
			        .items(new String[] {"More Details","Edit" , "Undo"})
			        .itemsCallback(new MaterialDialog.ListCallback()
			        {
			            @Override
			            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) 
			            {
			            	if(which == 0)
			            	{
			            		try
			            		{
			            		Common.tdialshow=false;
			            		Common.resp = "";
			            		Thread th = new Thread()
			            		{
			            			@Override
			            			public void run()
			            			{
			            				try
			            				{
			            				Common.resp = Common.APICall("http://akul.cu.cc/gettransdet.php?t="+id).substring(4);
			            				if(Common.resp.contains("ERR"))
			            				{
			            					
			            				}
			            				else
			            				{
			            					Common.tdialshow = true;
			            				}
			            				}
			            				catch(Exception ex)
			            				{
			            					
			            				}
			            			}
			            		};
			            		th.start();
			            		th.join();
			            		if(Common.tdialshow)
			            		{
	            					new MaterialDialog.Builder(Transactions.this)
	            			        .title("Transaction Details")
	            			        .content("Transaction Date : "+Common.resp.substring(0, Common.resp.indexOf(" ")).trim()+"\nTransaction Time: "+Common.resp.substring(Common.resp.indexOf(" ")).trim()+"\nDetails: "+t.comment+"\nAmount:"+t.amt)
	            			        .positiveText("OK")
	            			        .positiveColorRes(R.color.green_600)
	            			        .callback(new MaterialDialog.ButtonCallback() {
	            			            @Override
	            			            public void onPositive(MaterialDialog dialog) 
	            			            {
	            			            	dialog.dismiss();
	            			            }
	            			        })
	            			        .cancelable(false)
	            			        .show();

			            		}
			            		}
			            		catch(Exception ex)
			            		{
			            		}
			            	}
			            	else if(which == 1)
			            	{
			            		LayoutInflater li = LayoutInflater.from(Transactions.this);
			    				final View dlg = li.inflate(R.layout.transdlg, null);
			    				EditText e = (EditText) dlg.findViewById(R.id.ed_trdesc);
			    				EditText e2 = (EditText) dlg.findViewById(R.id.ed_tramt);
	    			            e.setText(t.comment);
	    			            e2.setText(t.amt);
			    				MaterialDialog progress = new MaterialDialog.Builder(Transactions.this)
			    			        .customView(dlg)
			    			        .title("Edit Transaction")
			    			        .cancelable(false)
			    			        .positiveText("Save")
			    			        .negativeText("Cancel")
			    			        .callback(new MaterialDialog.ButtonCallback() 
			    			        {
			    			            @Override
			    			            public void onPositive(MaterialDialog dialog) 
			    			            {
			    			            	dialog.dismiss();
			    			            	final EditText e = (EditText) dlg.findViewById(R.id.ed_trdesc);
			    			            	String d = e.getText().toString();
			    			            	final EditText e2 = (EditText) dlg.findViewById(R.id.ed_tramt);
			    			            	String amt = e2.getText().toString();
			    			            	try
			    			            	{
			    			            	Thread t3 = new Thread()
			    			            	{
			    			            		@Override
			    			            		public void run()
			    			            		{
			    			            			try
			    			            			{
			    			            				String resp=Common.APICall("http://akul.cu.cc/edittrans.php?t="+id+"&desc="+Common.gt(e)+"&amt="+Common.gt(e2));
			    			            			}
			    			            			catch(Exception ex)
			    			            			{
			    			            				ex.printStackTrace();
			    			            			}
			    			            		}
			    			            	};
			    			            	t3.start();
			    			            	t3.join();
			    			            	Toast.makeText(Transactions.this, "Transaction Edited..", Toast.LENGTH_LONG).show();
			    			            	Transaction tr = ((TransactionsAdapter) lv.getAdapter()).getItem(arg2);
			    			            	tr.comment = Common.gt(e);
			    			            	tr.amt = Common.gt(e2);
					             			((TransactionsAdapter) lv.getAdapter()).remove(((TransactionsAdapter) lv.getAdapter()).getItem(arg2));
					             			//((TransactionsAdapter) lv.getAdapter()).insert(tr, arg2);
					             			if(((TransactionsAdapter) lv.getAdapter()).getCount() ==0 || ((TransactionsAdapter) lv.getAdapter()).getCount() == arg2)
					             			{
					             			    ((TransactionsAdapter) lv.getAdapter()).add(tr);
					             			}
					             			else
					             			{
					             			((TransactionsAdapter) lv.getAdapter()).add(arg2,tr);
							             	}
					             			((TransactionsAdapter) lv.getAdapter()).notifyDataSetChanged();
					             			lv.refreshDrawableState();
					                		}
			    			            	catch(Exception ex)
			    			            	{
			    			            		ex.printStackTrace();
			    			            	}
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
			            	else
			            	{
			            	Common.tdelflag=false;
			            		try
			            		{
			            		
			            		  Thread t1 = new Thread()
						    	    {
						    	        public void run()
						    	        {

						    	        	    String resp = null;
												try
												{
													resp = Common.APICall("http://akul.cu.cc/undotrans.php?t="+id);
												} 
												catch (Exception e)
												{
													e.printStackTrace();
												}
						            			resp = resp.substring(4);
							            		if(resp.contains("ERR"))
							            		{
							            		}
							            		else
							            		{
							            			Common.tdelflag = true;
							            		}
							            		}
						                };
			            		  t1.start();
			            		  t1.join();
			            		if(Common.tdelflag)
			            		{
			            			Toast.makeText(Transactions.this, "Transaction Undone..", Toast.LENGTH_LONG).show();
			             			((TransactionsAdapter) lv.getAdapter()).remove(((TransactionsAdapter) lv.getAdapter()).getItem(arg2));
			             			((TransactionsAdapter) lv.getAdapter()).notifyDataSetChanged();
			             			lv.refreshDrawableState();
			            		}
			            		else
			            		{
			            			Toast.makeText(Transactions.this, "An unexpected error was encountered", Toast.LENGTH_LONG).show();
			             		}
			            		}
			            	catch(Exception e)
		            		{
		            			Toast.makeText(Transactions.this, "An unexpected error was encountered", Toast.LENGTH_LONG).show();
		            			e.printStackTrace();
		                	}
		                }
			         }
			        })
			        .show();
			          }
					return false;	
				}
			});
			lv.setAdapter(adapter);
			progress.dismiss();
		 }
		 }
		
	}


package com.akul.splitfare;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.afollestad.materialdialogs.MaterialDialog;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

public class Repahistory extends ActionBarActivity 
{

String gid;
String t;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		setTheme(ConfigHandler.getstyle()); 
		super.onCreate(savedInstanceState);
		 android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
		 Bundle b = getIntent().getExtras();
			gid = b.getString("gid");
			t = b.getString("t");
			if (toolbar != null) 
	        {
	    	    setSupportActionBar(toolbar);
	        }
			final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		setContentView(R.layout.activity_repahistory);
		actionBar.setTitle(t);
		Void params = null;
		new Fetch().execute(params);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.repahistory, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		int id = item.getItemId();
		return super.onOptionsItemSelected(item);
	}

	public class Fetch extends AsyncTask<Void,Void,Void>
{
	RepaymentsAdapter r;
	ListView l;
	MaterialDialog progress;
	
	private Handler handler = new Handler()
	{

	      public void handleMessage( Message msg )
	            {
	             Toast.makeText(Repahistory.this,"ERROR: "+msg.getData().getString( "message" ), Toast.LENGTH_LONG ).show();
	    	  	//Common.showerrdialog(getBaseContext(), "ERROR", msg.getData().getString( "message" ));
	             progress.dismiss();
	 	        }
	};

		@Override
		protected void onPreExecute()
		{
			 progress = new MaterialDialog.Builder(Repahistory.this)
		        .customView(R.layout.progressdlg2)
		        .cancelable(false)
		        .build();
		        progress.show();
		   r = new RepaymentsAdapter(getApplicationContext(), R.layout.listitem_rep);
			l = (ListView)findViewById(R.id.repa_lv_main);
		}
	@Override
	protected Void doInBackground(Void... arg0) 
	{
		try
		{
			Document d = Common.getdoc("http://akul.cu.cc/getrepahist.php?g="+gid+"&u="+ConfigHandler.getuid().trim());
			NodeList nl = d.getElementsByTagName("repayment");
			for(int x =0 ;x<nl.getLength();x++)
			{
				String name = nl.item(x).getAttributes().getNamedItem("name").getNodeValue().trim();
				String date = nl.item(x).getAttributes().getNamedItem("date").getNodeValue().trim();
				String amt = nl.item(x).getAttributes().getNamedItem("amt").getNodeValue().trim();
				r.add(new Repayment(name + " -> Me",amt,date));
			}
		}
		catch(final Exception e)
		{
			e.printStackTrace();
			  Thread t = new Thread()
	    	    {
	    	        public void run()
	    	        {

	    	            Message myMessage = new Message();
	    	            Bundle resBundle = new Bundle();
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
		l.setAdapter(r);
		progress.dismiss();
	 }
	}	
}


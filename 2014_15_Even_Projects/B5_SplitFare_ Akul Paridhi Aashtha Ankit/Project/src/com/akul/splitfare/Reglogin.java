package com.akul.splitfare;

import java.security.SecureRandom;
import java.util.Locale;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

public class Reglogin extends ActionBarActivity implements TabListener 
{
	SectionsPagerAdapter mSectionsPagerAdapter;
	ViewPager mViewPager;
	static Reglogin r;
	static void initafterlogin()
	{
    	Intent intent = new Intent(Reglogin.r , Groups.class);
    	intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    	Reglogin.r.startActivity(intent);
    	r.finish();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	
	{
		r =this;
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reglogin);

		// Set up the action bar.
		 android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
	        if (toolbar != null) 
	        {
	        	//if(ConfigHandler.getthm() !=0 )
	    	//	{
	    		//}
	    	    setSupportActionBar(toolbar);
	        }
	        if(Integer.parseInt(ConfigHandler.getuid()) != -1)
	        {
	        	Intent i = new Intent(this,Groups.class);
	        	startActivity(i);
	        	finish();
	        }
	        //860616284020750
		final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle("SplitFa₹e");
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
		actionBar.setIcon(R.drawable.ic_launcher);
		mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
				{
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) 
		{
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}
		
	
	}
	///////////////////////////////////////////
	void register()
	{
		
	}
	////////////////////////////////////////////
	@Override
	public void onTabSelected(Tab arg0,
			android.support.v4.app.FragmentTransaction arg1) 
	{
		mViewPager.setCurrentItem(arg0.getPosition());

		
	}
	@Override
	public void onTabReselected(Tab arg0,
			android.support.v4.app.FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTabUnselected(Tab arg0,
			android.support.v4.app.FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	/**
	private void setupTabs() {
		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(true);

		Tab tab1 = actionBar
		    .newTab()
		    .setText("Register")
		    .setTabListener(new SupportFragmentTabListener<FirstFragment>( this,
                        "Register", RegisterFragment.class));

		actionBar.addTab(tab1);
		actionBar.selectTab(tab1);

		Tab tab2 = actionBar
		    .newTab()
		    .setText("Login")
		    .setTabListener(new android.app.ActionBar.TabListener(R.id.flContainer, this,
                        "Login", LoginFragment.class));
		actionBar.addTab(tab2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reglogin, menu);
		return true;
	}**/

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
/**
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) 
	{
		mViewPager.setCurrentItem(tab.getPosition());
	}
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) 
	{
		mViewPager.setCurrentItem(tab.getPosition());
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter 
	{

		public SectionsPagerAdapter(FragmentManager fm) 
		{
			super(fm);
		}

		@Override
		public Fragment getItem(int position)
		{
			Fragment fragment = null;
			//return PlaceholderFragment.newInstance(position + 1);
		    switch(position)
		    {
		    case 0:
		        fragment = new RegisterFragment();
		        
		        break;
		    case 1:
		        fragment = new LoginFragment();
		        break;
		    }
			return fragment;

		}

		@Override
		public int getCount() 
		{
			return 2;
		}
		
		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position)
			{
			case 0:
				return "Register".toUpperCase(l);
			case 1:
				return "Login".toUpperCase(l);
			}
			return null;
		}
	}

	public static class RegisterFragment extends Fragment 
	{
		static View r;
		static MaterialDialog progress ;
		public RegisterFragment()
		{
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) 
		{
			View rootView = null ;
			rootView = inflater.inflate(R.layout.fragment_register,
					container, false);
			Button b = (Button) rootView.findViewById(R.id.btn_register);
			final View w = rootView;
			r =rootView;
			b.setOnClickListener(new View.OnClickListener() 
			{
	            public void onClick(View v) 
	            {
	            	if(validate(w))
	            	{
	            		EditText fn1 = (EditText) w.findViewById(R.id.editText3);
	        			EditText ln1 =(EditText) w.findViewById(R.id.editText4);
	        			EditText email1 =(EditText) w.findViewById(R.id.editText5);
	        			EditText pass1 =(EditText) w.findViewById(R.id.editText7);
	        			String fn =Common.gt(fn1);
	        			String ln =Common.gt(ln1);
	        			String email =Common.gt(email1);
	        			String salt =salt();
		    	     	String pass = Common.hash(Common.gt(pass1) +salt);
	    	        	register(fn,ln,email,pass,salt,Common.gt(pass1));
	    	       }
	            	else
	            	{
	            		
	            	}
	            }
	        });

			return rootView;
		}
		void register(String fn , String ln , String email , String pass , String salt , String ct)
		{
			 progress = new MaterialDialog.Builder(r.getContext())
		        .customView(R.layout.progressdlg)
		        .cancelable(false)
		        .build();
		        progress.show();
			GCMIntentService.reg(fn, ln, email, pass, salt , ct);
		}
			String salt()
		{
			SecureRandom random = new SecureRandom();
		      int a  = random.nextInt();
		      String s = ""+a;
			return s;
		}
	
		boolean validate(View v)
		{
			String emsg = "";
			EditText fn = (EditText) v.findViewById(R.id.editText3);
			EditText ln =(EditText) v.findViewById(R.id.editText4);
			EditText email =(EditText) v.findViewById(R.id.editText5);
			EditText pass =(EditText) v.findViewById(R.id.editText7);
			EditText pass2 =(EditText) v.findViewById(R.id.editText8);
			if(Common.gt(fn).matches(""))
			{
				emsg += "First Name cannot be empty \n";
			}
			if(Common.gt(ln).matches(""))
			{
				emsg += "Last Name cannot be empty \n";
			}
			if(Common.gt(email).matches(""))
			{
				emsg += "Email cannot be empty \n";
			}
			if(!Common.gt(email).matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
			{
				emsg += "Invalid email id \n";
			}
			if(Common.gt(pass).matches("") || Common.gt(pass2).matches(""))
			{
				emsg += "Password cannot be empty \n";
			}
			if(!Common.gt(pass).matches(Common.gt(pass2)))
			{
				emsg += "Entered Passwords do not match \n";
			}
			//emsg = emsg.substring(0, (emsg.length() -2));
			if(emsg != "")
			{
			Common.showerrdialog(getActivity(), "ERROR", emsg);
			return false;
			}
			else
			{
				return true;
			}
		}
	}

	public static class LoginFragment extends Fragment 
	{
		static View l;
		static MaterialDialog progress ;
	
		public LoginFragment()
		{
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) 
		{
			View rootView = null ;
			rootView = inflater.inflate(R.layout.fragment_login,
					container, false);
			final View w = rootView;
			l =rootView;
			Button b = (Button) rootView.findViewById(R.id.btn_login);
			b.setOnClickListener(new View.OnClickListener() 
			{
	            public void onClick(View v) 
	            {
	            	Void params = null;
					new Login().execute(params);
	            }
	        });

			return rootView;
		}
		
		class Login extends AsyncTask <Void, Void, Void>
		{
			String em ="";
			String pass ="";
			private Handler handler = new Handler()
			{

			      public void handleMessage( Message msg )
			            {
			             Toast.makeText( l.getContext(),"ERROR: "+msg.getData().getString( "message" ), Toast.LENGTH_LONG ).show();
			    	  	//Common.showerrdialog(getBaseContext(), "ERROR", msg.getData().getString( "message" ));
			             progress.dismiss();
			 	        }
			};

			@Override
			protected Void doInBackground(Void... arg0) 
			{
				String salt = null;
				 em.replace("@","%40");
				 try
				 {
				salt = Common.APICall("http://akul.cu.cc/getsalt.php?e="+em);
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
				if(salt.trim().contains("ERR"))
				{
					  Thread t = new Thread()
			    	    {
			    	        public void run()
			    	        {

			    	            Message myMessage = new Message();
			    	            Bundle resBundle = new Bundle();
			    	            resBundle.putString( "message", "Incorrect Email / Password" );
			    	            myMessage.setData( resBundle );
			    	            handler.sendMessage( myMessage );
			    	        }
			    	    };
			    	    t.start();
			  }
				else
				{
					pass += salt.trim().substring(4);
					pass = Common.hash(pass);
					final String p =pass;
					String resp = null;
					try
					{
					resp = Common.APICall("http://akul.cu.cc/login.php?e="+em+"&pass="+pass.trim());
					}
					catch (final Exception e)
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
					final String r =resp;
					resp = resp.substring(4);
					if(resp.trim().contains("ERR"))
					{
						  Thread t = new Thread()
				    	    {
				    	        public void run()
				    	        {

				    	            Message myMessage = new Message();
				    	            Bundle resBundle = new Bundle();
				    	            resBundle.putString( "message", "Incorrect Email / Password" );
						    	    myMessage.setData( resBundle );
				    	            handler.sendMessage( myMessage );
				    	        }
				    	    };
				    	    t.start();
					}
					else
					{
						ConfigHandler.setuid(resp.trim());
						try
						{
						ConfigHandler.setn(Common.APICall("http://akul.cu.cc/getname.php?id="+resp.trim()).substring(4));
						Document d = Common.getdoc("http://akul.cu.cc/getprefs.php?u="+ConfigHandler.getuid());
						NodeList nl = d.getElementsByTagName("Preference");
						String d1=nl.item(0).getAttributes().getNamedItem("d").getNodeValue();
						String acc=nl.item(0).getAttributes().getNamedItem("acc").getNodeValue();
						String curr=nl.item(0).getAttributes().getNamedItem("curr").getNodeValue();
						ConfigHandler.setacc(Integer.parseInt(acc.trim()));
						ConfigHandler.setcurr(curr.trim());
						ConfigHandler.setd((Integer.parseInt(d1.trim())==1?true:false));
						}
						catch(final Exception e)
						{
						}
						Reglogin.r.initafterlogin();
					}
				}
				return null;
			}
			 @Override
			  protected void onPreExecute() 
			   {
				 progress = new MaterialDialog.Builder(l.getContext())
			        .customView(R.layout.progressdlg1)
			        .cancelable(false)
			        .build();
			        progress.show();
			        EditText e = (EditText) l.findViewById(R.id.editText1);
			        EditText p = (EditText) l.findViewById(R.id.editText2);
			        em= Common.gt(e);
			        pass = Common.gt(p);
			    }

		       @Override
			    protected void onPostExecute(Void result) 
		       {
			        if (progress.isShowing()) 
			        {
			            progress.dismiss();
			        }
			    }
		}
	}
}

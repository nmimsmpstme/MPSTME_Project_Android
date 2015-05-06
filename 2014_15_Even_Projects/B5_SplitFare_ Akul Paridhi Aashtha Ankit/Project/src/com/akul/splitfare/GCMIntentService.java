package com.akul.splitfare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.util.Log;
import android.widget.Toast;

import com.akul.splitfare.Reglogin.RegisterFragment;
import com.google.android.gcm.GCMBaseIntentService;
import com.google.android.gcm.GCMRegistrar;

public class GCMIntentService extends GCMBaseIntentService
{
	public static final String SENDER_ID = "1059394923805";
	public static String fn;
	public static String ln;
	public static String email;
	public static String salt;
	public static String pass;
	public static String ct;
	public GCMIntentService() 
	{
		super(SENDER_ID);
	}
	
	public static void reg(String fn1 , String ln1 , String email1 , String pass1 , String salt1 , String ct1)
	{
		fn =fn1;
		ln =ln1;
		email = email1;
		pass =pass1;
		salt = salt1;
		ct = ct1;
		GCMRegistrar.checkDevice(Reglogin.r);
		GCMRegistrar.checkManifest(Reglogin.r);
		GCMRegistrar.register(Reglogin.r,GCMIntentService.SENDER_ID);
	}
	private Handler handler = new Handler()
	{

	      public void handleMessage( Message msg )
	            {
	             Toast.makeText( getBaseContext(),"ERROR: "+msg.getData().getString( "message" ), Toast.LENGTH_LONG ).show();
	 	        }
	};
	private void sendRegistrationIdToBackend(String regid) 
	{ 
		  URI url = null;
		  
		  try 
		  { 
			  String s = "http://akul.cu.cc/reg.php?f="+fn+"&l="+ln+"&e="+email+"&pass="+pass+"&salt="+salt+"&gcm="+ regid+"&c="+ct;
			  s.replace("@","%40");
			  url = new URI(s); 
		  } 
		  catch (Exception e)
		  { 
		   e.printStackTrace(); 
	  	   RegisterFragment.progress.dismiss();
	  	  }  
		  HttpClient httpclient = new DefaultHttpClient(); 
		  HttpGet request = new HttpGet(); 
		  request.setURI(url); 
		  try 
		  { 
	      HttpResponse execute=  httpclient.execute(request); 
	      InputStream content = execute.getEntity().getContent();
	      BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
	      String s = buffer.readLine();
		  if(s.toUpperCase().contains("ERR01"))
	      {
			  Thread t = new Thread()
	    	    {
	    	        public void run()
	    	        {

	    	            Message myMessage = new Message();
	    	            Bundle resBundle = new Bundle();
	    	            resBundle.putString( "message", "An Unexpected Error Was Encountered While Registering With The Server" );
	    	            myMessage.setData( resBundle );
	    	            handler.sendMessage( myMessage );
	    	        }
	    	    };
	    	    t.start();
	    	    RegisterFragment.progress.dismiss();
	      }
	      else if(s.toUpperCase().contains("ERR02"))
	       {
	    	 //Toast.makeText(Reglogin.r.getApplicationContext(), "TEST", Toast.LENGTH_LONG).show();
	    	  final Context MyContext = this;
	    	  Thread t = new Thread()
	    	    {
	    	        public void run()
	    	        {

	    	            Message myMessage = new Message();
	    	            Bundle resBundle = new Bundle();
	    	            resBundle.putString( "message", "The Email ID You have entered Is already In Use By Another Account.." );
	    	            myMessage.setData( resBundle );
	    	            handler.sendMessage( myMessage );
	    	        }
	    	    };
	    	    t.start();
	    	    RegisterFragment.progress.dismiss();
	       }
	       else
	    	{
	    		final int i =Integer.parseInt(s.trim());
	    	    ConfigHandler.setuid(s.trim());
	    	    ConfigHandler.setn(fn);
	    	    RegisterFragment.progress.dismiss();
		        Reglogin.r.initafterlogin();
	    	 }
	      
     	  // ConfigHandler.setreg(true);
		  } 
		  catch (Exception e)
		  {
		  RegisterFragment.progress.dismiss();
		   e.printStackTrace(); 
		  }
		 }

	
	@Override
	protected void onRegistered(Context context, String registrationId)
	{
		sendRegistrationIdToBackend(registrationId);
		Log.i(TAG, "onRegistered: registrationId=" + registrationId);
	}

	@Override
	protected void onUnregistered(Context context, String registrationId) 
	{
	}

	@Override
	protected void onMessage(Context context, Intent data) 
	{
		String message;
		message = data.getStringExtra("message");
		String notif = message.substring(0,message.indexOf('$'));
		String id = message.substring(message.indexOf('$')+1,message.indexOf('%'));
		////////////////////////////////////////////////////////
		Intent intent = new Intent(this, Reglogin.class);
		String grp = message.substring(message.indexOf('%')+1);
		PendingIntent pIntent = PendingIntent.getActivity(this,new Random().nextInt(), intent,0);
		Notification notification = new Notification.Builder(this)
				.setSmallIcon(R.drawable.ic_launcher)
				.setWhen(System.currentTimeMillis())
				.setContentTitle(grp)
				.setContentText("New Transaction")
				.setContentIntent(pIntent)
				.getNotification();
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		manager.notify(new Random().nextInt(), notification);

		{
			PowerManager pm = (PowerManager) context
					.getSystemService(Context.POWER_SERVICE);
			final PowerManager.WakeLock mWakelock = pm.newWakeLock(
					PowerManager.FULL_WAKE_LOCK
							| PowerManager.ACQUIRE_CAUSES_WAKEUP, "GCM_PUSH");
			mWakelock.acquire();

			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				public void run() {
					mWakelock.release();
				}
			};
			timer.schedule(task, 5000);
		}

	}

	@Override
	protected void onError(Context arg0, String errorId) {

		Log.e(TAG, "onError: errorId=" + errorId);
	}

}
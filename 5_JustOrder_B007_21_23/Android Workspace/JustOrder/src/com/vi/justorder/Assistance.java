package com.vi.justorder;



import java.util.ArrayList;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Assistance extends Activity {
	ImageButton callwaiterButton;
	Intent homeit;
	TextView text;
	Bundle g;
	String deviceId;
	public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	     
	        setContentView(R.layout.assist);
	        
	        g = getIntent().getExtras();
	        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	        StrictMode.setThreadPolicy(policy);
	        homeit = new Intent(getBaseContext(), JustOrderMain.class);
	        callwaiterButton = (ImageButton)findViewById(R.id.help);
	        callwaiterButton.setOnClickListener((OnClickListener) new callwaiterListener());
   }
	  private class callwaiterListener  implements OnClickListener {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				final TelephonyManager tm = (TelephonyManager) getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				final String tmDevice, tmSerial, tmPhone, androidId;
				if(tm.getDeviceId() != null){
				tmDevice = "" + tm.getDeviceId();
				tmSerial = "" + tm.getSimSerialNumber();
				androidId = "" + android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
				
				UUID deviceUuid = new UUID(androidId.hashCode(), ((long)tmDevice.hashCode() << 32) | tmSerial.hashCode());
				deviceId = deviceUuid.toString();
				Toast.makeText(getBaseContext(),"Device Id: "+deviceId, Toast.LENGTH_LONG).show();
				}
				if(tm.getDeviceId() == null){
				
					
					deviceId = "f924e50b-d8c4-3efa-8618-d3e13cfc40e4";
					
				}



				nameValuePairs.add(new BasicNameValuePair("deviceId", deviceId));
				System.out.println(deviceId);


				try
				{

				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost("http://192.168.43.230/justorderd/alert.php");
				httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				HttpResponse response = httpclient.execute(httppost);
				HttpEntity entity = response.getEntity();


				Toast.makeText(getApplicationContext(), "Calling Waiter...", Toast.LENGTH_LONG).show();
				}
				catch(Exception e)
				{
				Toast.makeText(getBaseContext(),"Error in http connection "+e.toString(), Toast.LENGTH_LONG).show();
				}
				finally{
				}

				}

			}
	  @Override
		public void onBackPressed() {
			homeit.putExtras(g);
			startActivity(homeit);
		   return;
		}
}
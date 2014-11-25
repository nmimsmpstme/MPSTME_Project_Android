package com.vi.justorder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FinalOrder extends Activity {
	
	Button  endButton;
	Intent homeit, menuit, orderit, helpit, endit;
	TextView taxText, totalText, disText;
	Bundle g;
	ListView lv1;
	ArrayList<menulist1> items = new ArrayList<menulist1>();
	
	@Override
	public void onBackPressed() {
    return;
    }
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalorder);
        
        
        g = getIntent().getExtras();
        
        
        endButton = (Button)findViewById(R.id.Button06);
        lv1 = (ListView)findViewById(R.id.ListView01); 
        taxText = (TextView)findViewById(R.id.TextView02);
        totalText = (TextView)findViewById(R.id.TextView03);
        disText = (TextView)findViewById(R.id.TextView04);
        
      
        menuit = new Intent(getBaseContext(), Menu.class);
        orderit = new Intent(getBaseContext(), ViewOrder.class);
        endit = new Intent(getBaseContext(), LoginActivity.class);
        
    
      
        endButton.setOnClickListener((OnClickListener) new endListener());
        
        
        int i,j;
        double tax=0, total=0;
		for(i=0;i<100;i++)
		{
			  if(g.getIntArray("tag")[i]==0)
				  break;
		}
		
		InputStream is=null;
        Writer writer= null;
	    
	
		
		for(j=0;j<i;j++)
		{
			int cat = g.getIntArray("tag")[j];
			String name = g.getStringArray("name")[j];
			int qty = g.getIntArray("qty")[j];

			if(cat==1)
        	{
				is = getResources().openRawResource(R.raw.appetizers);
	            writer = new StringWriter();
        	}
        else if(cat==2)
        	{
        	is = getResources().openRawResource(R.raw.beverages);
            writer = new StringWriter();
        	}
        else if(cat==3)
        	{
        	 is = getResources().openRawResource(R.raw.soups);
             writer = new StringWriter();
        	}
        else if(cat==4)
        	{
        	is = getResources().openRawResource(R.raw.maincourse);
            writer = new StringWriter();
        	}
        else if(cat==5)
        	{	
        	is = getResources().openRawResource(R.raw.salad);
            writer = new StringWriter();
        	}
        else if(cat==6)
        	{
        	is = getResources().openRawResource(R.raw.desserts);
            writer = new StringWriter();
        	}

			
			char[] buffer = new char[1024];
	        try {
	            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	            int n;
	            while ((n = reader.read(buffer)) != -1) {
	                writer.write(buffer, 0, n);
	            }
	        } catch (UnsupportedEncodingException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
			    try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

	        String jsonString = writer.toString();
			
			
			try
	    	{	
			JSONArray arr = new JSONArray(jsonString);
			String arrlen = Integer.toString(arr.length());

			for(int l=1;l<arr.length();l++)
			{
				JSONObject food = null;
				food = arr.getJSONObject(l);
				String name1 = food.getString("name");
				
				if(name.equals(name1))
				{
					String price = food.getString("price");
					int pri = Integer.parseInt(price);
					int amount = pri * qty;
					total = total + amount;
					menulist1 sr1 = new menulist1();
					sr1.setName(name);
				     sr1.setquantity(Integer.toString(qty));
				     sr1.setamount("Rs. " + Integer.toString(amount));
				     items.add(sr1);
					break;
				}
			}

		} catch (JSONException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		
		}
		
		}
		
		InputStream is1 = getResources().openRawResource(R.raw.rates);
        Writer writer1 = new StringWriter();

		
        char[] buffer1 = new char[1024];
		double taxrate=0, discount=0;
		String dis=null, tax1=null;
		
		try {
            Reader reader1 = new BufferedReader(new InputStreamReader(is1, "UTF-8"));
            int n;
            while ((n = reader1.read(buffer1)) != -1) {
                writer1.write(buffer1, 0, n);
            }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try {
				is1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

        String jsonString1 = writer1.toString();
			

		try
    	{	
		JSONArray arr = new JSONArray(jsonString1);
		String arrlen = Integer.toString(arr.length());
		
		JSONObject rates = null;
		rates = arr.getJSONObject(0);
		dis = rates.getString("discount");
		tax1 = rates.getString("tax");
		discount = Double.parseDouble(dis);
		taxrate = Double.parseDouble(tax1);
		
		

	} catch (JSONException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	
	}

		
		
		lv1.setAdapter(new orderadapter(this, items));
		
		double dis1 = (discount/100)*total;
		total = total - dis1;
        tax = (taxrate/100) * total;
        total = total + tax;
        disText.setText("Discount (@"+dis+"%) = Rs. "+Double.toString(dis1));
        taxText.setText("Tax (@12.5%) = Rs. " + Double.toString(tax));
        totalText.setText("Total = Rs. " + Double.toString(total));
        
        
    }
      	

	private class endListener  implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			Toast.makeText(getApplicationContext(), "Ending Session...", Toast.LENGTH_SHORT).show();
			startActivity(endit);
		}
    	
    }
    
}

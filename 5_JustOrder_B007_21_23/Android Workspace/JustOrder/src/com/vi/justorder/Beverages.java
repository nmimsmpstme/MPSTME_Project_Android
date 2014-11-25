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


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Beverages extends Activity  {
	
    /** Called when the activity is first created. */
	
	
	Intent  detailsit, menuit;
	ListView lv1;
	ArrayAdapter<String> adapter;
	Bundle g;


 	ArrayList<menulist> items = new ArrayList<menulist>();
	AlertDialog.Builder alert;
	boolean temp=true;
	int z;
	int argv;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menulist);   
        
        
        g = getIntent().getExtras();
  
       
        detailsit  = new Intent(getBaseContext(), FoodDetails.class);
        final ListView lv1 = (ListView) findViewById(R.id.menu);
        menuit = new Intent(getBaseContext(), Menu.class);
        
        InputStream is = getResources().openRawResource(R.raw.beverages);
        Writer writer = new StringWriter();
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
			JSONObject na = arr.getJSONObject(0);
			JSONArray ingna = na.getJSONArray("unavailable");
			String [] ingr = new String[ingna.length()];
			for(int k=0;k<ingna.length();k++)
			{
				JSONObject abc = ingna.getJSONObject(k);
				ingr[k] = abc.getString("ingredient");
			}
			for(int i=1;i<arr.length();i++)
			{
				JSONObject food = null;
				food = arr.getJSONObject(i);
				String name = food.getString("name");
				String description = food.getString("description");
				String rating = food.getString("rating");
				String price = food.getString("price");
				String cooktime = food.getString("cooktime");
				JSONArray ingredients = food.getJSONArray("ingredients");
				String [] ing = new String[ingredients.length()];
				for(int k=0;k<ingredients.length();k++)
				{
					JSONObject ingd = ingredients.getJSONObject(k);
					ing[k] = ingd.getString("ingredient");
				}
				
				int flag=0;
				
				for(int l=0;l<ing.length;l++)
				{
					for(int m=0;m<ingr.length;m++)
					{
						if(ing[l].matches(ingr[m])) flag=1;
					}
				}
				
				 
				if(flag==0)
				{

					menulist sr1 = new menulist();
					sr1.setName(name);
				     sr1.setdescription(description);
				     sr1.setprice("Rs. "+price);
				     items.add(sr1);
				    
					}
		
			}
		} catch (JSONException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		
		}	
    	
	       
        
		lv1.setAdapter(new menuadapter(this, items));
		lv1.setOnItemClickListener((OnItemClickListener) new Listener1());       
        
        
    }    
    
    
 

    
    public class Listener1 implements OnItemClickListener {
      	 public void onItemLongClick1(AdapterView<?> parent, View view,
                   int position, long id) {
        		
      	 }

   	@Override
   	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
   			long arg3) {
   		// TODO Auto-generated method stub
   		menulist sr1 = items.get(arg2);
   		
   		String nn=sr1.getName();
   		int cat = 2;
   	  
   		detailsit.putExtras(g);
   		detailsit.putExtra("category", cat);
   		detailsit.putExtra("food", nn);
   		
   		startActivity(detailsit);
   	}
      	
   }
    @Override
	public void onBackPressed() {
		menuit.putExtras(g);
		startActivity(menuit);
	   return;
	}
}
    


	


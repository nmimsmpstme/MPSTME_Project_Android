package com.vi.justorder;



import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FoodDetails extends Activity {
	
	
	Intent  menuit, testing, appetizerit, beveragesit, soupsit, maincourseit, saladit, dessertit;
	ImageView im1;
	private String[] filepath;
	public Bitmap downloadedBitmap;
	Bundle g;
	TextView nametext, ratingtext, detailstext, ingredientstext, cooktimetext, pricetext;
	EditText qty;
	Button add;
	int cat;
	String name;
	int price1;
	
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fooddetails); 
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        
    
        nametext = (TextView)findViewById(R.id.TextView01);
        ratingtext = (TextView)findViewById(R.id.TextView02);
        detailstext = (TextView)findViewById(R.id.TextView03);
        ingredientstext = (TextView)findViewById(R.id.TextView04);
        cooktimetext = (TextView)findViewById(R.id.TextView05);
        pricetext = (TextView)findViewById(R.id.TextView06);
        qty = (EditText)findViewById(R.id.EditText01);
        add = (Button)findViewById(R.id.Button06);
        
        appetizerit = new Intent(getBaseContext(), Appetizers.class);
        beveragesit = new Intent(getBaseContext(), Beverages.class);
        soupsit = new Intent(getBaseContext(), Soups.class);
        maincourseit = new Intent(getBaseContext(), MainCourse.class);
        saladit = new Intent(getBaseContext(), Salad.class);
        dessertit = new Intent(getBaseContext(), Dessert.class);
        
        
        g = getIntent().getExtras();
        
        cat = getIntent().getIntExtra("category", 0); 
        name = getIntent().getStringExtra("food");
        
        String categ = Integer.toString(cat);
        String iname = null;
        InputStream is=null;
        Writer writer= null;
        
        
        if(cat==1)
        	{
        	is = getResources().openRawResource(R.raw.appetizers);
            writer = new StringWriter();
           iname = "appetizers_";
        	}
        else if(cat==2)
        	{
        	 is = getResources().openRawResource(R.raw.beverages);
            writer = new StringWriter();
            iname = "beverages_";
        	}
        else if(cat==3)
        	{
        	 is = getResources().openRawResource(R.raw.soups);
            writer = new StringWriter();
            iname = "soups_";
        	}
        else if(cat==4)
        	{
        	 is = getResources().openRawResource(R.raw.maincourse);
             writer = new StringWriter();
             iname = "maincourse_";
        	}
        else if(cat==5)
        	{	
        	is = getResources().openRawResource(R.raw.salad);
            writer = new StringWriter();
           iname = "salads_";
        	}
        else if(cat==6)
        	{
        	 is = getResources().openRawResource(R.raw.desserts);
             writer = new StringWriter();
             iname = "desserts_";
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
		//String arrlen = Integer.toString(arr.length());
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
			String name1 = food.getString("name");
			
			if(name.equals(name1))
			{
				iname = iname + i;
				nametext.setText("Name : "+name);
				String description = food.getString("description");
				detailstext.setText("Description : "+description);
				String rating = food.getString("rating");
				String price = food.getString("price");
				price1 = Integer.parseInt(price);
				pricetext.setText("Price : Rs. "+price);
				ratingtext.setText("Rating : "+rating+" stars");
				String cooktime = food.getString("cooktime");
				cooktimetext.setText("Cooktime : "+cooktime);
				JSONArray ingredients = food.getJSONArray("ingredients");
				String [] ing = new String[ingredients.length()];
				for(int k=0;k<ingredients.length();k++)
				{
					JSONObject ingd = ingredients.getJSONObject(k);
					ing[k] = ingd.getString("ingredient");
				}	
				
				String ingre = "Ingredients:";
				
				for(int k=0;k<ing.length;k++)
				{
					if(k<(ing.length-1))
						ingre = ingre+" "+ing[k]+",";
					else
						ingre = ingre+" "+ing[k];
				}
				
				ingredientstext.setText(ingre);
				break;
			}
		}

	} catch (JSONException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	
	}	
        
        Bitmap bitmap = null;
        
        ImageView i = (ImageView)findViewById(R.id.ImageView02);        
        try 
		{
        	
        	i.setImageResource(getResources().getIdentifier(iname, "drawable", getPackageName()));
			
		} 
		catch (Exception e) 
		{
			im1.setImageResource(R.drawable.imagenotfound);
			
		}
		
		
        menuit = new Intent(getBaseContext(), Menu.class);
        
       
        im1 = (ImageView)findViewById(R.id.ImageView02);
       
        

        add.setOnClickListener((OnClickListener) new addListener());
        
        qty.setOnClickListener((OnClickListener) new qtyListener());
        
        
    }
   
    
    @Override
	public void onBackPressed() {
		
    	if(cat==1){
    		appetizerit.putExtras(g);
    		startActivity(appetizerit);
    	}
    	else if(cat==2){
    		beveragesit.putExtras(g);
    		startActivity(beveragesit);
    	}
    	else if(cat==3){
    		soupsit.putExtras(g);
    		startActivity(soupsit);
    	}
    	else if(cat==4){
    		maincourseit.putExtras(g);
    		startActivity(maincourseit);
    	}
    	else if(cat==5){
    		saladit.putExtras(g);
    		startActivity(saladit);
    	}
    	else if(cat==6){
    		dessertit.putExtras(g);
    		startActivity(dessertit);
    	}
		
	   return;
	}
	
    
	
	
	private class qtyListener  implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			
			qty.setText("");
		}
    	
    }
 

       

    
  
    
 
    
    private class addListener  implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			
			// TODO Auto-generated method stub
			String s = qty.getEditableText().toString();
			if((s.matches("[0]*[0-9]{3}") || s.matches("[0]*[0-9]{2}") || s.matches("[0]*[0-9]{1}")) && !(s.matches("[0]*")))
			{
				int av = Integer.parseInt(s);
				int flag2=0;
				if(av<100)
				{
					int z, flag=0;
					
					for(z=0;z<100;z++)
					{
						if(g.getIntArray("tag")[z]==0)
							break;
					}
					
					String quan=null;
					
					for(int k=0;k<z;k++)
					{
						if(name.equals(g.getStringArray("name")[k]))
						{
							Editable quant = qty.getText();
							quan = quant.toString();
							int qu = g.getIntArray("qty")[k] + Integer.parseInt(quan);
							int qu1 = Integer.parseInt(quan);
							if(qu<100)
							{
								quan = Integer.toString(qu1);
								g.getIntArray("tag")[k]=cat;
								g.getStringArray("name")[k]=name;
								g.getIntArray("qty")[k]=qu;
								g.getIntArray("amount")[k]=qu*price1;
								flag=1;
							}	
							else
							{
								Toast.makeText(getApplicationContext(),"Maximum quatity allowed is 99!",Toast.LENGTH_SHORT).show();
								flag=1;
								flag2=1;
							}
						}
					}
				
					if(flag==0)
					{
						Editable quant = qty.getText();
						quan = quant.toString();
						int qu = Integer.parseInt(quan);
						quan = Integer.toString(qu);
						g.getIntArray("tag")[z]=cat;
						g.getStringArray("name")[z]=name;
						g.getIntArray("qty")[z]=Integer.parseInt(quan);
						g.getIntArray("amount")[z]=qu*price1;
						
					}
					if(flag2==0)
					{
						if(Integer.parseInt(quan)==1)
							Toast.makeText(getApplicationContext(),"Added "+quan+" "+name+" to your order!",Toast.LENGTH_SHORT).show();
						else	
							Toast.makeText(getApplicationContext(),"Added "+quan+" "+name+"s to your order!",Toast.LENGTH_SHORT).show();
					}
					 
					menuit.putExtras(g);
					startActivity(menuit);
				}
				else
					Toast.makeText(getApplicationContext(),"Please enter quantity less than 100",Toast.LENGTH_SHORT).show();
			}
			
			else
			{
				Toast.makeText(getApplicationContext(),"Please enter a valid quantity",Toast.LENGTH_SHORT).show();
				
			}
			
		}
    	
    }    

}


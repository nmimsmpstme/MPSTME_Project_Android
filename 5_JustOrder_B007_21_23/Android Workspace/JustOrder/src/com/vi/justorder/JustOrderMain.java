package com.vi.justorder;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class JustOrderMain extends Activity {
    
	Button menub,orderb,assistance,info;
	DatabaseHelper dbHelper;
	String user_name;
	ModelClass loginModelClass;
	Bundle g = new Bundle();

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        g = getIntent().getExtras();
        Intent myintent = getIntent();
        Bundle extras = myintent.getExtras();
        user_name = extras.getString("cust_name");
        Toast.makeText(JustOrderMain.this, "Welcome " + user_name ,Toast.LENGTH_LONG ).show();
        
      
    
        menub=(Button)findViewById(R.id.Menu);
        
        orderb=(Button)findViewById(R.id.Order);
       
        assistance=(Button)findViewById(R.id.Assistance);
        
        info=(Button)findViewById(R.id.Info);
        
        
        ModelClass.createlist();
        info.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
			
				Intent i =new Intent(JustOrderMain.this,Info.class);
				i.putExtras(g);
				JustOrderMain.this.startActivity(i);
			}
		});
        menub.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
			
				Intent i =new Intent(JustOrderMain.this,Menu.class);
				i.putExtras(g);
				JustOrderMain.this.startActivity(i);
			}
		});
    
        assistance.setOnClickListener( new OnClickListener() {
			
			public void onClick(View v) {
				
				Intent i =new Intent(JustOrderMain.this,Assistance.class);
				i.putExtras(g);
				JustOrderMain.this.startActivity(i);
			}
		});
        orderb.setOnClickListener( new OnClickListener() {
			
			public void onClick(View v) {
			
				Intent i =new Intent(JustOrderMain.this,ViewOrder.class);
				i.putExtras(g);
				JustOrderMain.this.startActivity(i);
			}
		});
        
        loginModelClass = new ModelClass();
        
        try{
			dbHelper = new DatabaseHelper(JustOrderMain.this);
		   dbHelper.addCustomer(loginModelClass);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
 
    }
	
	public void onResume(){
		super.onResume();
		dbHelper = new DatabaseHelper(JustOrderMain.this);
		//cust_Helper.getWritableDatabase();
	}
	public void onStop(){
		super.onStop();
		dbHelper.close();
	
	}
	
}
package com.example.myfilofax;



import android.R.string;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	@SuppressLint("NewApi")
	SQLiteDatabase db;
	  char ch;
	  int c=0 ;
      int countrr=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		// Show the Up button in the action bar.
		setupActionBar();
		Button btn = (Button)findViewById(R.id.click);
		try
		{
		db = openOrCreateDatabase("DB", SQLiteDatabase.CREATE_IF_NECESSARY, null);
		db.execSQL("Create Table Abc(name VARCHAR,password VARCHAR,email VARCHAR,phone INTEGER)");
		}
		catch (SQLException e)
		{
			
		}
			
		
		btn.setOnClickListener(new View.OnClickListener(){
			 @Override
	         public void onClick(View v) {
	         // TODO Auto-generated method stub
	         EditText name=(EditText) findViewById(R.id.editText1);
	         EditText password=(EditText)findViewById(R.id.editText2);
	         EditText email=(EditText)findViewById(R.id.editText4);
	        
	         EditText phone=(EditText)findViewById(R.id.editText5);
	         ContentValues values=new ContentValues();
	         String k= name.getText().toString();
	         for(int rr=0;rr<k.length();rr++)
	         {
	             ch=k.charAt(rr);
	             if((ch>=65 && ch<=90) || (ch>=97 && ch<=122))
	             {
	                 countrr++;
	             }
	         }
	         if(countrr==k.length())
	         {
	        	values.put("name", name.getText().toString());
	         }
	         else
	         {  
	         name.setText("");
	         Toast.makeText(RegisterActivity.this, "Invalid Name", 2000).show();
	         c++ ;
	         }
	         
	         String p = password.getText().toString();
	         if(p.length() > 5)
	         { 
	        	 values.put("password", password.getText().toString());
	         }
	         else
	         {
	        	 
	        	 password.setText("");
		         Toast.makeText(RegisterActivity.this, "Invalid Password", 2000).show();
		         c++ ;
	         }
	         String e = email.getText().toString();
	         if( e.length()> 0)
	         {
	         values.put("email", email.getText().toString());
	         }
	         else {
	        	  email.setText("");      
		          Toast.makeText(RegisterActivity.this, "Invalid Email", 2000).show();
		          c++;	 
	         }
	         
	         String t = phone.getText().toString(); 
	         char cht;
	         int countrrt=0;
	         if (t.length()==10)
	         {
	             for(int rrt=0;rrt<t.length();rrt++)
	         {
	             cht=t.charAt(rrt);
	             if((cht>=48 && cht<=57))
	             {
	                 countrrt++;
	             }
	         }
	         if(countrrt==t.length())
	         {
	        	 values.put("phone", phone.getText().toString());
	         }
	              else
	         {
	          phone.setText("");      
	          Toast.makeText(RegisterActivity.this, "Invalid Character", 2000).show();
	         c++;
	         }
	         }        
	 else 
	         {
	           phone.setText("");      
	           Toast.makeText(RegisterActivity.this, "Invalid Number", 2000).show(); 
	           c++;
	         }
	         
	         if(c==0){
	         if((db.insert("Abc", null, values))!=-1)
	         {
	         Toast.makeText(RegisterActivity.this, "Record Successfully Inserted", 2000).show();
	         name.setText("");
	         password.setText("");
	         email.setText("");
	         phone.setText("");
	         c = 0;
	         Cursor cu=db.rawQuery("SELECT * FROM Abc",null);
	         cu.moveToFirst();
	         while(!cu.isAfterLast())
	         {
	         Toast.makeText(RegisterActivity.this,cu.getString(0)+ " "+cu.getString(1),1000).show();
	         cu.moveToNext();
	         }
	         cu.close();
	         }
	         }
	         else
	         {
	         Toast.makeText(RegisterActivity.this, "Insert Error", 2000).show();
	         
	         name.setText("");
	         password.setText("");
	         email.setText("");
	         phone.setText("");
	         c = 0;
	         }
	         
	         }
	});
	
		}
	
	

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}

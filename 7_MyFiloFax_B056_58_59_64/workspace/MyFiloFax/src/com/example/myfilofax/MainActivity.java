package com.example.myfilofax;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	SQLiteDatabase db;
	Cursor cu ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText name=(EditText) findViewById(R.id.Textname);
        final EditText password=(EditText)findViewById(R.id.Textpass);
		Button btnAdd = (Button) findViewById(R.id.click);
		try
		{
		db = openOrCreateDatabase("DB", SQLiteDatabase.CREATE_IF_NECESSARY, null);
		db.execSQL("Create Table Abc(name VARCHAR,password VARCHAR,email VARCHAR,phone INTEGER)");
		}
		catch (SQLException e)
		{
			
		}
		btnAdd.setOnClickListener(new OnClickListener(){
        public void onClick(View v){
        	String o = name.getText().toString();
        	String x = password.getText().toString();
        	String[] po = {o,x};
        	String selection = "name=? AND password=?" ;
        	try{
        	cu=db.query(DBHelper.tableName,null,selection,po,null,null,null);
        	String l =  cu.getString(0);
            String m =  cu.getString(1);
            startManagingCursor(cu);
        	} catch(Exception e){
        	    e.printStackTrace();
        	}
        	int numberOfRows = cu.getCount();
        	if(numberOfRows <= 0){
        	    Toast.makeText(getApplicationContext(), "Invalid Username Or Password", Toast.LENGTH_SHORT).show();
        	    name.setText("");
        	    password.setText("");
        	    }    
        	else{
        	Intent intent =new Intent(v.getContext(),HomeActivity.class);
            startActivityForResult(intent,0);}
        }
        	
        });
		

	}
	public void press(View v)
	{
	  Intent i = new Intent(this,RegisterActivity.class);	
	 startActivity(i);	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void pot(View view)
	{
	Intent p = new Intent(this,HomeActivity.class );
	startActivity(p);
	}
	


}

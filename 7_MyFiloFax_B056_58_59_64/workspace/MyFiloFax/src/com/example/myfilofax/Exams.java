package com.example.myfilofax;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Exams extends Activity {
	SQLiteDatabase db;
	EditText sub,date,tym,task,not;
	Button set;
	int rowId;
	RegistrationAdapter regadapter;
	long f;
	Cursor c ;
	RegistrationAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exams);
		sub =(EditText)findViewById(R.id.sub); 
		task =(EditText)findViewById(R.id.type);
		date =(EditText)findViewById(R.id.date);
		tym =(EditText)findViewById(R.id.time);
		not =(EditText)findViewById(R.id.notes);
		set = (Button)findViewById(R.id.sett);
		Bundle showData = getIntent().getExtras();
        rowId = showData.getInt("keyid");
        // Toast.makeText(getApplicationContext(), Integer.toString(rowId),
        // 500).show();
        regadapter = new RegistrationAdapter(this);
 
        c = regadapter.queryAll(rowId);
 
        if (c.moveToFirst()) {
            do {
                task.setText(c.getString(1));
                sub.setText(c.getString(2));
                date.setText(c.getString(3));
                tym.setText(c.getString(4));
                not.setText(c.getString(5));
            } while (c.moveToNext());
        }
        
        set.setOnClickListener(new OnClickListener() {
        	 
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
            	c = regadapter.queryAll(rowId);
            	 
                f = regadapter.updateldetail(rowId,task.getText().toString(),sub.getText().toString(),date.getText().toString(),tym.getText().toString(),not.getText().toString());
                if(f > 0)
                {
                	Toast.makeText(Exams.this, "Record Successfully Updated", 2000).show();
                	
                }
                finish();
                
            }
        });
		// Show the Up button in the action bar.
		setupActionBar();
     Button btn = (Button)findViewById(R.id.sett);
		try
		{
		db = openOrCreateDatabase("DB", SQLiteDatabase.CREATE_IF_NECESSARY, null);
		db.execSQL("Create Table Pattt(_id integer primary key autoincrement,task VARCHAR,subject VARCHAR,date DATETIME,time DATETIME,notes VARCHAR)");
		}
		catch (SQLException e)
		{
			
		}
			
		
		btn.setOnClickListener(new View.OnClickListener(){
			 @Override
	         public void onClick(View v) {
	         // TODO Auto-generated method stub
	         EditText sub=(EditText) findViewById(R.id.type);
	         EditText type=(EditText)findViewById(R.id.sub);
	         EditText date=(EditText)findViewById(R.id.date);
	         EditText time=(EditText)findViewById(R.id.time);
	         EditText notes=(EditText)findViewById(R.id.notes);
	         ContentValues values=new ContentValues();
	         values.put("task", sub.getText().toString());
	         values.put("subject", type.getText().toString());
	         values.put("date", date.getText().toString());
	         values.put("time", time.getText().toString());
	         values.put("notes", notes.getText().toString());
	         if((db.insert("Pattt", null, values))!=-1)
	         {
	         Toast.makeText(Exams.this, "Record Successfully Inserted", 2000).show();
	         }
	         else
	         {
	         Toast.makeText(Exams.this, "Insert Error", 2000).show();
	         }
	         sub.setText("");
	         type.setText("");
	         date.setText("");
	         time.setText("");
	         notes.setText("");
	         Cursor c=db.rawQuery("SELECT * FROM Pattt",null);
	         c.moveToFirst();
	         while(!c.isAfterLast())
	         {
	         Toast.makeText(Exams.this,c.getString(0)+ " "+c.getString(1)+" "+c.getString(2)+" "+c.getString(3),1000).show();
	         c.moveToNext();
	         }
	         c.close();
	         }
	});
	
	
	
	
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.exams, menu);
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

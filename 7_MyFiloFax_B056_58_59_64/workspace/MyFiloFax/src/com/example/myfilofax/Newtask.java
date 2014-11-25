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

public class Newtask extends Activity {
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
		setContentView(R.layout.activity_newtask);

 
		// Show the Up button in the action bar.
		setupActionBar();
		Button btn = (Button)findViewById(R.id.set);
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
	         EditText task=(EditText) findViewById(R.id.task);
	         EditText subject=(EditText)findViewById(R.id.subject);
	         EditText notes=(EditText)findViewById(R.id.notes);
	         EditText date=(EditText)findViewById(R.id.dt);
	         EditText time=(EditText)findViewById(R.id.dt2);
	         String tak = task.getText().toString();
	         String sub = subject.getText().toString();
	         String not = notes.getText().toString();
	         String dat = date.getText().toString();
	         String tym = time.getText().toString();
	         /*long val = adapter.insertDetails(tak,sub,dat,tym,not);*/
	        ContentValues values=new ContentValues();
	         values.put("task", task.getText().toString());
	         values.put("subject", subject.getText().toString());
	         values.put("date", date.getText().toString());
	         values.put("time", time.getText().toString());
	         values.put("notes", notes.getText().toString());
	         if((db.insert("Pattt", null, values))!=-1)
	         {
	         Toast.makeText(Newtask.this, "Record Successfully Inserted", 2000).show();
	         }
	         else
	         {
	         Toast.makeText(Newtask.this, "Insert Error", 2000).show();
	         }
	         task.setText("");
	         subject.setText("");
	         notes.setText("");
	         Cursor c=db.rawQuery("SELECT * FROM Pattt",null);
	         c.moveToFirst();
	         while(!c.isAfterLast())
	         {
	         Toast.makeText(Newtask.this,c.getString(0)+ " "+c.getString(1),1000).show();
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
		getMenuInflater().inflate(R.menu.newtask, menu);
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

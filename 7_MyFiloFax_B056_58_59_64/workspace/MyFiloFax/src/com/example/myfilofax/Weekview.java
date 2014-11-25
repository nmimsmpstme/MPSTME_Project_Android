package com.example.myfilofax;




import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class Weekview extends ListActivity {
	RegistrationAdapter adapter_ob;
    DBHelper helper_ob;
    SQLiteDatabase db;
    ListView nameList;
    Button registerBtn;
    Cursor cursor;
    Cursor cu;
	
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weekview);
		// Find the LinearLayout within and enable the divider
	   
		
		nameList = (ListView) findViewById(android.R.id.list);
		adapter_ob = new RegistrationAdapter(this);
		String[] from = { helper_ob.KEY_ID,helper_ob.KEY_TASK, helper_ob.KEY_SBJ, helper_ob.KEY_DATE, helper_ob.KEY_TIME, helper_ob.KEY_NOT };
        int[] to = { R.id.id,R.id.tev_tk, R.id.tev_sb, R.id.tev_dat, R.id.tev_tym, R.id.tev_not };
        cursor = adapter_ob.queryName();
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this,R.layout.rooww, cursor, from, to);
        nameList.setAdapter(cursorAdapter);
        nameList.setOnItemClickListener(new OnItemClickListener() {
        	 
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int arg2,
                    long arg3) {
                // TODO Auto-generated method stub
              
            	
            	Bundle passdata = new Bundle();
                Cursor listCursor = (Cursor) arg0.getItemAtPosition(arg2);
                int nameId = listCursor.getInt(listCursor.getColumnIndex(helper_ob.KEY_ID));
                // Toast.makeText(getApplicationContext(),
                // Integer.toString(nameId), 500).show();
                passdata.putInt("keyid", nameId);
                Intent passIntent = new Intent(Weekview.this,Exams.class);
                passIntent.putExtras(passdata);
                startActivity(passIntent);
            }
        });
     


       
       
     
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.weekview, menu);
		return true;
	}

}

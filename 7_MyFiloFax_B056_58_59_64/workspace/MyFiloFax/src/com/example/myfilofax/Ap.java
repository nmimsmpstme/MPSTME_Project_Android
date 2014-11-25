package com.example.myfilofax;

import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class Ap extends Activity {
	SQLiteDatabase db;
	private byte[] img=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ap);
		// Show the Up button in the action bar.
		setupActionBar();
		ImageView imageview= (ImageView)findViewById(R.id.iim);
		try
		{
		db = openOrCreateDatabase("DB", SQLiteDatabase.CREATE_IF_NECESSARY, null);
		db.execSQL("Create Table Img(image blob)");
		}
		catch (SQLException e)
		{
			
		}
		
		String[] col={"image"};
		Cursor c=db.rawQuery("SELECT * FROM Img",null);
        
        if(c!=null){
            c.moveToFirst();
            do{
                img=c.getBlob(c.getColumnIndex("image"));
            }while(c.moveToNext());
        }
        Bitmap b1=BitmapFactory.decodeByteArray(img, 0, img.length);
      
         imageview.setImageBitmap(b1);
         Toast.makeText(this, "Retrive successfully", Toast.LENGTH_SHORT).show();
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
		getMenuInflater().inflate(R.menu.ap, menu);
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

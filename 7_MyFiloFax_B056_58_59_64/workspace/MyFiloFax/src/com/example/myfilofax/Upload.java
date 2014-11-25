package com.example.myfilofax;

import java.io.ByteArrayOutputStream;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Upload extends Activity {
	ImageAdapter p = new ImageAdapter(this);
	private static int RESULT_LOAD_IMAGE = 1;
	SQLiteDatabase db;
	private byte[] img=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_upload);
		// Show the Up button in the action bar.
		setupActionBar();
	
	GridView gridview = (GridView)findViewById(R.id.gridView1);
	gridview.setAdapter(new ImageAdapter(this));
	Button btn = (Button)findViewById(R.id.upl);
	
	int l = p.mThumbIds.length;
	try
	{
	db = openOrCreateDatabase("DB", SQLiteDatabase.CREATE_IF_NECESSARY, null);
	db.execSQL("Create Table Img(image blob)");
	}
	catch (SQLException e)
	{
		
	}
	btn.setOnClickListener(new View.OnClickListener(){
		 @Override
        public void onClick(View v) {
        // TODO Auto-generated method stub
		
		Bitmap b=BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.PNG, 100, bos);
        img=bos.toByteArray();
        ContentValues values=new ContentValues();
        values.put("image", img);
        if((db.insert("Img", null, values))!=-1)
        {
        Toast.makeText(Upload.this, "Record Successfully Inserted", 2000).show();
        }
        else
        {
        Toast.makeText(Upload.this, "Insert Error", 2000).show();
        }
		
        Cursor c=db.rawQuery("SELECT * FROM Img",null);
        c.moveToFirst();
        while(!c.isAfterLast())
        {
        Toast.makeText(Upload.this,"Image Inserted",1000).show();
        c.moveToNext();
        }
        c.close();
        Intent in = new Intent(Upload.this,Ap.class);
        startActivity(in);
        }
});

	
	 ImageButton buttonLoadImage = (ImageButton) findViewById(R.id.gallery);
     buttonLoadImage.setOnClickListener(new View.OnClickListener() {

         @Override
         public void onClick(View arg0) {

             Intent i = new Intent(
                     Intent.ACTION_PICK,
                     android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

             startActivityForResult(i, RESULT_LOAD_IMAGE);
         }
     });
	}
	
	
	  @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	        super.onActivityResult(requestCode, resultCode, data);

	        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
	            Uri selectedImage = data.getData();
	            String[] filePathColumn = { MediaStore.Images.Media.DATA };

	            Cursor cursor = getContentResolver().query(selectedImage,
	                    filePathColumn, null, null, null);
	            cursor.moveToFirst();

	            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
	            String picturePath = cursor.getString(columnIndex);
	            cursor.close();
	            
	            GridView gridview = (GridView)findViewById(R.id.gridView1);
	        	gridview.setAdapter(new ImageAdapter(this));
	           // ImageView imageView = (ImageView) findViewById(R.id.imageView1);
	            Bitmap b = BitmapFactory.decodeFile(picturePath);
	           // p.sendImage(b);
	       /*
	        *     public  Bitmap sendImage(Bitmap b){
    	int j =0;
    	int l = mThumbIds.length;
    	for  (int i = 0 ; i<l ; i++)
    	{
    		if(mThumbIds[i]!=null)
    		{
    		 	j++;
    		}
    		
    	}
    	
    	mThumbIds[j+1]=b;
    	return mThumbIds[j+1];
    }     
	        */
	        }}
	    


	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}
	
	public void root(View view)
	 {
		 Intent re = new Intent(this, Newphoto.class);
		 startActivity(re);
		 
	 }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.upload, menu);
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

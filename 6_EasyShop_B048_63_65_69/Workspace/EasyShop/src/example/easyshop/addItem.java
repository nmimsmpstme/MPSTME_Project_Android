package example.easyshop;



import example.easyshop.R;

import android.app.Activity;
import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addItem extends Activity {
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.items);
         
	    
	    try{
	        db=openOrCreateDatabase("DB",SQLiteDatabase.CREATE_IF_NECESSARY,null);
	        db.execSQL("Create Table Entry(W_ID INTEGER PRIMARY KEY AUTOINCREMENT, name text,quantity integer)");
	        }catch(SQLException e)
	        {
	        }
	    Button additem = (Button) findViewById(R.id.Add_item);
	    additem.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			EditText name=(EditText) findViewById(R.id.NameOfItem);
            EditText qty=(EditText)findViewById(R.id.QtyOfItem);
            ContentValues values=new ContentValues();
            values.put("name", name.getText().toString());
            values.put("quantity", qty.getText().toString());
            if((db.insert("Entry", null, values))!=-1)
            {
            Toast.makeText(addItem.this, "Record Successfully Inserted", 2000).show();
            }
            else
            {
            Toast.makeText(addItem.this, "Insert Error", 2000).show();
            }
            name.setText("");
            qty.setText("");
           
			
		}

	    });
	    
	    Button drop = (Button) findViewById(R.id.del);
	    drop.setOnClickListener(new OnClickListener() {
	    
	    	public void onClick(View arg0) {

	    	    try{
	    	        db=openOrCreateDatabase("DB",SQLiteDatabase.CREATE_IF_NECESSARY,null);
	    	        db=openOrCreateDatabase("DB",SQLiteDatabase.CREATE_IF_NECESSARY,null);
	    	        db.execSQL("DELETE FROM ENTRY WHERE name != NULL;");
	    	        }catch(SQLException e)
	    	        {
	    	        }

	    	};
	    });
	}

}

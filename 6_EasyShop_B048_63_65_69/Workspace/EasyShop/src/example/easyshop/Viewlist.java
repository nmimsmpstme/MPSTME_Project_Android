package example.easyshop;

import java.util.ArrayList;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;
 
public class Viewlist extends ListActivity {
     
    private ArrayList<String> results = new ArrayList<String>();
    private String tableName = DBHelper.tableName;
    private SQLiteDatabase newDB;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openAndQueryDatabase();
         
        displayResultList();
         
         
    }
    private void displayResultList() {
        TextView tView = new TextView(this);
        tView.setText("List of Shopping Items");
        getListView().addHeaderView(tView);
         
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, results));
        getListView().setTextFilterEnabled(true);
         
    }
    private void openAndQueryDatabase() {
        try {
            DBHelper dbHelper = new DBHelper(this.getApplicationContext());
            newDB = dbHelper.getWritableDatabase();
            Cursor c = newDB.rawQuery("SELECT name , quantity  FROM " +
                    tableName , null);
 
            if (c != null ) {
                if  (c.moveToFirst()) {
                    do {
                        String name = c.getString(c.getColumnIndex("name"));
                        String quantity = c.getString(c.getColumnIndex("quantity"));
                        results.add("Item Name: " + name + ", Quantity: " +quantity);
                    }while (c.moveToNext());
                } 
            }           
        } catch (SQLiteException se ) {
            Log.e(getClass().getSimpleName(), "Could not create or Open the database");
        } 
 
    }
    
} 
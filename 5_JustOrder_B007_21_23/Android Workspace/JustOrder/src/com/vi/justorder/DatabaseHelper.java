package com.vi.justorder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper{
	private static final String DATA_BASE_NAME ="restaurant";
	SQLiteDatabase db;
	
	private static final int DATA_BASE_VERSION = 18;

	//SQLiteDatabase db = this.getWritableDatabase();
	Cursor cursor;
	
	//table name
	public static final String CUSTOMER_TABLE = "cust_tab";

	
	//column name of cust_tab
	public static final String C_ID ="_id";
	public static final String C_NAME = "cust_name";
	public static final String C_PHONE = "cust_phone";
	public static final String C_EMAIL = "cust_email";
	public static final String C_ADDR = "cust_address";
	

		
	
	
	String CREATE_C_TABLE = "CREATE TABLE " + CUSTOMER_TABLE + "("
			+ C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ C_NAME + " TEXT NOT NULL,"
			+ C_PHONE + " TEXT," + C_EMAIL + " TEXT,"
			+ C_ADDR + " TEXT );";
	

	
	 
	public DatabaseHelper(Context context) {
		super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
		// db = this.getWritableDatabase();
		
	}
	@Override
	public void onOpen(SQLiteDatabase db) {
	    super.onOpen(db);
	    if (!db.isReadOnly()) {
	        // Enable foreign key constraints
	    	//Log.e("in onOPen", "foreign key is enable");
	        db.execSQL("PRAGMA foreign_keys=ON;");
	    }
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_C_TABLE);
		//Log.e("db on create call","called");
	
	}
	

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
				db.execSQL("DROP TABLE IF EXISTS " + CUSTOMER_TABLE);
				// Create tables again
				
				
				onCreate(db);
	}

	//insert value
		public void addCustomer(ModelClass myClass){
			
			ContentValues cv = new ContentValues();
			cv.put(C_NAME, myClass.getName());
			cv.put(C_PHONE, myClass.getPhone());
			cv.put(C_EMAIL, myClass.getEmail());
			cv.put(C_ADDR, myClass.getAddress());

			//insert row
			db=this.getWritableDatabase();
			db.insert(CUSTOMER_TABLE, null, cv);
			db.close();
			
		}
		
		public boolean validateUser(String userName,String mphone){
			// dbread=getReadableDatabase();
			db=this.getWritableDatabase();
			cursor =db.rawQuery("SELECT * FROM " + CUSTOMER_TABLE + " WHERE "
	                + C_NAME + "='" + userName +"'AND "+C_PHONE+"='"+mphone+"'" ,  null);
			 if(cursor.getCount() > 0)
				 return true;
			 
			return false;
			
		}
		
		
}
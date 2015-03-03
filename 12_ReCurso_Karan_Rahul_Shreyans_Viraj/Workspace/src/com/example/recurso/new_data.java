package com.example.recurso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class new_data extends SQLiteOpenHelper 
{ 
	private static String TAG = "DataBaseHelper";  
	private static String DB_PATH = "";  
	private static String DB_NAME ="WORDS";
	private SQLiteDatabase mDataBase;  
	private final Context mContext; 
	InputStream mInput; 
	String outFileName;
	OutputStream mOutput;
	
	
	public new_data(Context context)  
	{ 
	    super(context, DB_NAME, null, 1); 
	    DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
	    this.mContext = context;
	    
	}    
	 
		void copyDataBase() throws IOException 
	    { 
	        mInput = mContext.getAssets().open("German"); 
	        outFileName = DB_PATH + "German"; 
	        mOutput = new FileOutputStream(outFileName); 
	        byte[] mBuffer = new byte[1024]; 
	        int mLength; 
	        while ((mLength = mInput.read(mBuffer))>0) 
	        { 
	            mOutput.write(mBuffer, 0, mLength); 
	        } 
	        mOutput.flush(); 
	        mOutput.close(); 
	        mInput.close();
	        
	        mInput = mContext.getAssets().open(DB_NAME); 
	        outFileName = DB_PATH + DB_NAME; 
	        mOutput = new FileOutputStream(outFileName); 
	        byte[] mBuffer1 = new byte[1024]; 
	        int mLength1; 
	        while ((mLength1 = mInput.read(mBuffer1))>0) 
	        { 
	            mOutput.write(mBuffer1, 0, mLength1); 
	        } 
	        mOutput.flush(); 
	        mOutput.close(); 
	        mInput.close(); 
	        
	        mInput = mContext.getAssets().open("French"); 
	        outFileName = DB_PATH + "French"; 
	        mOutput = new FileOutputStream(outFileName); 
	        byte[] mBuffer2 = new byte[1024]; 
	        int mLength2; 
	        while ((mLength2 = mInput.read(mBuffer2))>0) 
	        { 
	            mOutput.write(mBuffer2, 0, mLength2); 
	        } 
	        mOutput.flush(); 
	        mOutput.close(); 
	        mInput.close(); 
	        
	        mInput = mContext.getAssets().open("Italian"); 
	        outFileName = DB_PATH + "Italian"; 
	        mOutput = new FileOutputStream(outFileName); 
	        byte[] mBuffer3 = new byte[1024]; 
	        int mLength3; 
	        while ((mLength3 = mInput.read(mBuffer3))>0) 
	        { 
	            mOutput.write(mBuffer3, 0, mLength3); 
	        } 
	        mOutput.flush(); 
	        mOutput.close(); 
	        mInput.close(); 
	    }

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
		} 
	 
	    	} 

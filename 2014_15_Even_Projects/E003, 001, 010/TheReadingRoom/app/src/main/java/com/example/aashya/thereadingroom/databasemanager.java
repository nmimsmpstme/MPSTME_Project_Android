package com.example.aashya.thereadingroom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aashya on 21/03/15.
 */

public class databasemanager extends SQLiteOpenHelper {

    String foundName= null;
    String foundAuthor= null;
    String foundLibrary= null;
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "booksManager";

    // Contacts table name
    private static final String TABLE_BOOKS = "books";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_LIBRARY = "library";

    public databasemanager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DB Manager: ", "oncreate");

        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_BOOKS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_AUTHOR + " TEXT, " + KEY_LIBRARY + " TEXT"+ ")";
        db.execSQL(CREATE_CONTACTS_TABLE);


        Log.d("DB Manager: ", "oncreate exit");

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKS);

        // Create tables again
        onCreate(db);

    }


    // Adding new book
    public void addBook(books book) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, book.getName()); // book Name
        values.put(KEY_AUTHOR, book.getauthor()); // author name
        values.put(KEY_LIBRARY, book.getlibrary()); // library Name
        // Inserting Row
        db.insert(TABLE_BOOKS, null, values);
        db.close(); // Closing database connection
    }




    // Getting single book
    public books getBook(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_BOOKS, new String[]{KEY_ID,
                        KEY_NAME, KEY_AUTHOR,KEY_LIBRARY}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        books book = new books(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3));
        // return contact
        return book;
    }

    // make a new function that accepts string input
   // public void search(String s)
    //{
       // EditText a =(EditText)findViewById(R.id.wishlist);
       // s = a.getText().toString();
       // String selectQuery = "SELECT" + s + "FROM" + TABLE_BOOKS;

    //}


    // Getting All books
    public List<books> getAllbooks(String que) {
        List<books> bookList = new ArrayList<books>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_BOOKS + " WHERE name='" + que + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        String one = null;
        String two = null;
        String tre = null;
        if (cursor.moveToFirst()) {
            do {
                books book = new books();
                book.setID(Integer.parseInt(cursor.getString(0)));
                book.setName(cursor.getString(1));
                book.setauthor(cursor.getString(2));
                book.setlibrary(cursor.getString(3));
                // Adding book to list
                bookList.add(book);
                one = cursor.getString(1);
                two = cursor.getString(2);
                tre = cursor.getString(3);
            } while (cursor.moveToNext());
        }
        Log.d("FOUND IT HERE:", one);
        foundName=one;
        foundAuthor=two;
        foundLibrary=tre;
        // return books list
        return bookList;
    }


    public int getBooksCount()
    {
        String countq = "SELECT * FROM " + TABLE_BOOKS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countq, null);
        int a =cursor.getCount();
        cursor.close();
        return a;
    }

    public String getFoundName()
    {
        return this.foundName;
    }
    public String getFoundAuthor()
    {
        return this.foundAuthor;
    }
    public String getFoundLibrary()
    {
        return this.foundLibrary;
    }
}


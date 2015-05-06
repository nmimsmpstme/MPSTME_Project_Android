package com.example.aashya.thereadingroom;

/**
 * Created by aashya on 27/03/15.
 */

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class search extends ActionBarActivity {

    // List view
    private ListView lv;

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;


    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputSearch = (EditText) findViewById(R.id.search);

    /**
     * Enabling Search Filter
     * */

     inputSearch.addTextChangedListener(new TextWatcher() {

        @Override
        public void onTextChanged (CharSequence cs,int arg1, int arg2, int arg3){
            // When user changed the Text
        Log.d("TETX CH: ", "fasfa");
        }

        @Override
        public void beforeTextChanged (CharSequence arg0,int arg1, int arg2,
        int arg3){
            // TODO Auto-generated method stub

        }

        @Override
        public void afterTextChanged (Editable arg0){
            // TODO Auto-generated method stub
        }
    }

    );

}

    public void seary(View v)
    {
        databasemanager db = new databasemanager(this);
        List<books> som = new ArrayList<books>();
        som=db.getAllbooks(inputSearch.getText().toString());
        String name;
        name=db.getFoundName();
        String author;
        author=db.getFoundAuthor();
        String lib;
        lib=db.getFoundLibrary();
        Log.d("Found here too!: ", "" + name);

        TextView a = (TextView) findViewById(R.id.Namef);
        a.setText(name + " found!");
        TextView b = (TextView) findViewById(R.id.Authorf);
        b.setText(author + " found!");
        TextView c = (TextView) findViewById(R.id.Libraryf);
        c.setText(lib + " found!");
    }
}

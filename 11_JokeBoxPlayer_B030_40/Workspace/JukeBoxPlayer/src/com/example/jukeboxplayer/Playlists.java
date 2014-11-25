package com.example.jukeboxplayer;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Playlists extends ListActivity {
    // Songs list
    public ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
    Intent intent;
    Bundle g;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
        ArrayList<HashMap<String, String>> songsListData = new ArrayList<HashMap<String, String>>();
        intent  = new Intent(getBaseContext(), MainActivity.class);
        MusicRetriever plm = new MusicRetriever();
        this.songsList = plm.getPlayList(this);
       
        // looping through playlist
        for (int i = 0; i < songsList.size(); i++) {

            // creating new HashMap
            HashMap<String, String> song = songsList.get(i);
    		
            // adding HashList to ArrayList
            songsListData.add(song);
           
        }
 
        // Adding menuItems to ListView
        ListAdapter adapter = new SimpleAdapter(this, songsListData,
                R.layout.playlist_item, new String[] { "songTitle" }, new int[] {
                        R.id.songTitle });
 
        setListAdapter(adapter);
 
        // selecting single ListView item
        ListView lv = getListView();
        // listening to single listitem click
        lv.setOnItemClickListener(new OnItemClickListener() {
 
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                // getting listitem index
                int songIndex = position;
 
                // Starting new intent
                Intent in = new Intent(getApplicationContext(), Pplayer.class);
                // Sending songIndex to PlayerActivity
                in.putExtra("songIndex", songIndex);
            
                startActivity(in);
                // Closing PlayListView
                finish();
            }
        });
    }
    
    @Override
    public void onBackPressed(){
	    // Add data to your intent
	    finish();
	    return;
	}
}
package info.androidhive.slidingmenu;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import info.androidhive.slidingmenu.AndroidBuildingMusicPlayerActivity;
import info.androidhive.slidingmenu.SongsManager;

public class HomeFragment extends ListFragment {
	public ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String,                   String>>();

	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.playlist, container, false);
       
        return rootView;
    }
	@Override 	
	public void onActivityCreated(Bundle savedInstanceState){ 		
		super.onActivityCreated(savedInstanceState); 			
		 ArrayList<HashMap<String, String>> songsListData = new ArrayList<HashMap<String,     String>>();
		 Context cont;
		 cont=getActivity();
	
	    	SongsManager plm = new SongsManager();
	    	// get all songs from sdcard
	    	this.songsList = plm.getPlayList(cont);

	    	// looping through playlist
	    	for (int i = 0; i < songsList.size(); i++) {
	    	    // creating new HashMap
	    	    HashMap<String, String> song = songsList.get(i);

	    	    // adding HashList to ArrayList
	    	    songsListData.add(song);
	    	}

	    	// Adding menuItems to ListView
	    	ListAdapter adapter = new SimpleAdapter(this.getActivity(), songsListData,
	    	        R.layout.playlist_item, new String[] { "songTitle","songArtist"}, new int[] {
	    	                R.id.songTitle, R.id.songArtis });

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
	    	        Intent in = new Intent(getActivity(),
	    	        		AndroidBuildingMusicPlayerActivity.class);

	    	        // Sending songIndex to PlayerActivity
	    	        in.putExtra("songIndex", songIndex);
                    startActivity(in);
	    	     

	    	      

	    	    }
	    	});
	}
	
}

package info.androidhive.slidingmenu;

import info.androidhive.slidingmenu.R;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class AndroidBuildingMusicPlayerActivity extends Activity implements OnCompletionListener, SeekBar.OnSeekBarChangeListener {

	private ImageButton btnPlay;
	private ImageButton btnForward;
	private ImageButton btnBackward;
	private ImageButton btnNext;
	private ImageButton btnPrevious;
	private ImageButton btnPlaylist;
	private ImageButton btnRepeat;
	private ImageButton btnShuffle;
	private ImageView songAlbumArt;
	private Drawable img;
	private SeekBar songProgressBar;
	private TextView songTitleLabel;
	private TextView songAlbum;
	private TextView songCurrentDurationLabel;
	private TextView songTotalDurationLabel;
	// Media Player
	private  MediaPlayer mp;
	// Handler to update UI timer, progress bar etc,.
	private Handler mHandler = new Handler();;
	private SongsManager songManager;
	private Utilities utils;
	private int seekForwardTime = 5000; // 5000 milliseconds
	private int seekBackwardTime = 5000; // 5000 milliseconds
	private int currentSongIndex = 0; 
	private boolean isShuffle = false;
	private boolean isRepeat = false;
	private ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
	   Bundle g;

@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);



setContentView(R.layout.player);

btnPlay = (ImageButton) findViewById(R.id.btnPlay);
btnForward = (ImageButton) findViewById(R.id.btnForward);
btnBackward = (ImageButton) findViewById(R.id.btnBackward);
btnNext = (ImageButton) findViewById(R.id.btnNext);
btnPrevious = (ImageButton) findViewById(R.id.btnPrevious);
btnPlaylist = (ImageButton) findViewById(R.id.btnPlaylist);
btnRepeat = (ImageButton) findViewById(R.id.btnRepeat);
btnShuffle = (ImageButton) findViewById(R.id.btnShuffle);
songProgressBar = (SeekBar) findViewById(R.id.songProgressBar);
songTitleLabel = (TextView) findViewById(R.id.songTitle);
songAlbum = (TextView) findViewById(R.id.songAlbum);
songCurrentDurationLabel = (TextView) findViewById(R.id.songCurrentDurationLabel);
songTotalDurationLabel = (TextView) findViewById(R.id.songTotalDurationLabel);
songAlbumArt = (ImageView) findViewById(R.id.songAlbumArt);
g = getIntent().getExtras();
    mp = new MediaPlayer();
    songManager = new SongsManager();
    utils = new Utilities();

    // Listeners
    songProgressBar.setOnSeekBarChangeListener(this); // Important
    mp.setOnCompletionListener(this); // Important

    // Getting all songs list
    songsList = songManager.getPlayList(this);

    // By default play first song
    //playSong(0);
    if(g != null) {
	    
    	currentSongIndex = g.getInt("songIndex");
       
        playSong(currentSongIndex);

	
}
		

btnPlay.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {
            // check for already playing
            if(mp.isPlaying()){

                if(mp!=null){
                    mp.pause();

                    btnPlay.setImageResource(R.drawable.btn_play);
                }
            }else{
                // Resume song
                if(mp!=null){
                    mp.start();
                    // Changing button image to pause button
                    btnPlay.setImageResource(R.drawable.btn_pause);
                }
            }

        }
    });

btnNext.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {

            if(isShuffle){
                Random rand = new Random();
                currentSongIndex = rand.nextInt((songsList.size() - 1) - 0 + 1) + 0;
                playSong(currentSongIndex);
            }
            else{
                        // check if next song is there or not
                    if(currentSongIndex < (songsList.size() - 1)){
                        playSong(currentSongIndex + 1);
                        currentSongIndex = currentSongIndex + 1;
                    }else{
                        // play first song
                        playSong(0);
                        currentSongIndex = 0;
                        }   
            }

        }
    });

    /**
     * Back button click event
     * Plays previous song by currentSongIndex - 1
     * */
btnPrevious.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {
            if(currentSongIndex > 0){
                playSong(currentSongIndex - 1);
                currentSongIndex = currentSongIndex - 1;
            }else{
                // play last song
                playSong(songsList.size() - 1);
                currentSongIndex = songsList.size() - 1;
            }

        }
    });

btnRepeat.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		if(isRepeat){
			isRepeat = false;
			Toast.makeText(getApplicationContext(), "Repeat is OFF", Toast.LENGTH_SHORT).show();
			btnRepeat.setImageResource(R.drawable.btn_repeat);
		}else{
			// make repeat to true
			isRepeat = true;
			Toast.makeText(getApplicationContext(), "Repeat is ON", Toast.LENGTH_SHORT).show();
			// make shuffle to false
			isShuffle = false;
			btnRepeat.setImageResource(R.drawable.btn_repeat_focused);
			btnShuffle.setImageResource(R.drawable.btn_shuffle);
		}	
	}
});

/**
 * Button Click event for Shuffle button
 * Enables shuffle flag to true
 * */
btnShuffle.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		if(isShuffle){
			isShuffle = false;
			Toast.makeText(getApplicationContext(), "Shuffle is OFF", Toast.LENGTH_SHORT).show();
			btnShuffle.setImageResource(R.drawable.btn_shuffle);
		}else{
			// make repeat to true
			isShuffle= true;
			Toast.makeText(getApplicationContext(), "Shuffle is ON", Toast.LENGTH_SHORT).show();
			// make shuffle to false
			isRepeat = false;
			btnShuffle.setImageResource(R.drawable.btn_shuffle_focused);
			btnRepeat.setImageResource(R.drawable.btn_repeat);
		}	
	}
});

/**
 * Button Click event for Play list click event
 * Launches list activity which displays list of songs
 * */
btnPlaylist.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		Intent i = new Intent(getApplicationContext(), PlayListActivity.class);
		startActivityForResult(i, 100);			
	}
});

}


protected void onActivityResult(int requestCode, int resultCode, Intent data) {
super.onActivityResult(requestCode, resultCode, data);

    currentSongIndex = data.getExtras().getInt("songIndex");
    // play selected song
    playSong(currentSongIndex);



} // end

/**
 * Function to play a song
 * */
public void  playSong(int songIndex){
// Play song
try {
    mp.reset();
    mp.setDataSource(songsList.get(songIndex).get("songPath"));
    mp.prepare();
    mp.start();
    // Displaying Song title
    String songTitle = songsList.get(songIndex).get("songTitle");
    songTitleLabel.setText(songTitle);
    String songAlbum2 = songsList.get(songIndex).get("songArtist");
    songAlbum.setText(songAlbum2);
    //String coverArt2 = songsList.get(songIndex).get("coverArt");
    //Drawable img = Drawable.createFromPath(coverArt2);  
    //songAlbumArt.setImageDrawable(img);
 
   
 // Changing Button Image to pause image
 			btnPlay.setImageResource(R.drawable.btn_pause);
 			
 			// set Progress bar values
 			songProgressBar.setProgress(0);
 			songProgressBar.setMax(100);
 			
 			// Updating progress bar
 			updateProgressBar();			
 		} catch (IllegalArgumentException e) {
 			e.printStackTrace();
 		} catch (IllegalStateException e) {
 			e.printStackTrace();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
 	}

@Override
public void onCompletion(MediaPlayer arg0) {

// check for repeat is ON or OFF
if(isRepeat){
    // repeat is on play same song again
    playSong(currentSongIndex);
} else if(isShuffle){
    // shuffle is on - play a random song
    Random rand = new Random();
    currentSongIndex = rand.nextInt((songsList.size() - 1) - 0 + 1) + 0;
    playSong(currentSongIndex);
} else{
    // no repeat or shuffle ON - play next song
    if(currentSongIndex < (songsList.size() - 1)){
        playSong(currentSongIndex + 1);
        currentSongIndex = currentSongIndex + 1;
    }else{
        // play first song
        playSong(0);
        currentSongIndex = 0;
    }
}
}
public void updateProgressBar() {
    mHandler.postDelayed(mUpdateTimeTask, 100);        
}	

/**
 * Background Runnable thread
 * */
private Runnable mUpdateTimeTask = new Runnable() {
	   public void run() {
		   long totalDuration = mp.getDuration();
		   long currentDuration = mp.getCurrentPosition();
		  
		   // Displaying Total Duration time
		   songTotalDurationLabel.setText(""+utils.milliSecondsToTimer(totalDuration));
		   // Displaying time completed playing
		   songCurrentDurationLabel.setText(""+utils.milliSecondsToTimer(currentDuration));
		   
		   // Updating progress bar
		   int progress = (int)(utils.getProgressPercentage(currentDuration, totalDuration));
		   //Log.d("Progress", ""+progress);
		   songProgressBar.setProgress(progress);
		   
		   // Running this thread after 100 milliseconds
	       mHandler.postDelayed(this, 100);
	   }
	};
	
@Override
public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {
	
}

/**
 * When user starts moving the progress handler
 * */
@Override
public void onStartTrackingTouch(SeekBar seekBar) {
	// remove message Handler from updating progress bar
	mHandler.removeCallbacks(mUpdateTimeTask);
}

/**
 * When user stops moving the progress hanlder
 * */
@Override
public void onStopTrackingTouch(SeekBar seekBar) {
	mHandler.removeCallbacks(mUpdateTimeTask);
	int totalDuration = mp.getDuration();
	int currentPosition = utils.progressToTimer(seekBar.getProgress(), totalDuration);
	
	// forward or backward to certain seconds
	mp.seekTo(currentPosition);
	
	// update timer progress again
	updateProgressBar();
}

@Override
public void onDestroy(){
super.onDestroy();
   mp.release();
   mHandler.removeCallbacks(mUpdateTimeTask);
   mHandler = null;
}
 }
	
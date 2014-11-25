package com.example.jukeboxplayer;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MusicPlayerActivity extends Activity implements OnCompletionListener, SeekBar.OnSeekBarChangeListener {

	private ImageButton btnPlay;
	private ImageButton btnForward;
	private ImageButton btnBackward;
	private ImageButton btnNext;
	private ImageButton btnPrevious;
	private ImageButton btnPlaylist;
	private ImageButton btnRepeat;
	private ImageButton btnShuffle;
	private SeekBar songProgressBar;
	private TextView songTitleLabel;
	private TextView songCurrentDurationLabel;
	private TextView songTotalDurationLabel;
	private MediaMetadataRetriever dataRetriever;
	// Media Player
	private  MediaPlayer mediaPlayer;
	private ImageView artCover;
	// Handler to update UI timer, progress bar etc,.
	private Handler mHandler = new Handler();;
	private MusicRetriever songManager;
	//Database
	private DBAdapter database;
	private Utilities utils;
	private int seekForwardTime = 5000; // 5000 milliseconds
	private int seekBackwardTime = 5000; // 5000 milliseconds
	private int currentSongIndex = 0; 
	private boolean isShuffle = false;
	private boolean isRepeat = false;
	private ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
    Intent intent;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.player);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		// All player buttons
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
		songCurrentDurationLabel = (TextView) findViewById(R.id.songCurrentDurationLabel);
		songTotalDurationLabel = (TextView) findViewById(R.id.songTotalDurationLabel);
		artCover = (ImageView) findViewById(R.id.artCover);
		database = new DBAdapter(getApplicationContext());
	
		// Mediaplayer
		mediaPlayer = new MediaPlayer();
		songManager = new MusicRetriever();
		utils = new Utilities();
		intent  = new Intent(getBaseContext(), MainActivity.class);
		// Listeners
		songProgressBar.setOnSeekBarChangeListener(this); 
		mediaPlayer.setOnCompletionListener(this);
		
		// Getting all songs list
		songsList = songManager.getPlayList(this);
		
		//Create MediaMetaDataReceiver to get information about audio file
		dataRetriever = new MediaMetadataRetriever();
		
		//Create and add songs to database
		storeDB();
		
	     
		   
				
		/**
		 * Play button click event
		 * plays a song and changes button to pause image
		 * pauses a song and changes button to play image
		 * */
		btnPlay.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// check for already playing
				if(mediaPlayer.isPlaying()){
					if(mediaPlayer!=null){
						mediaPlayer.pause();
						// Changing button image to play button
						btnPlay.setImageResource(R.drawable.btn_play);
					}
				}else{
					// Resume song
					if(mediaPlayer!=null){
						mediaPlayer.start();
						// Changing button image to pause button
						btnPlay.setImageResource(R.drawable.btn_pause);
					}
				}
				
			}
		});
		
		/**
		 * Forward button click event
		 * Forwards song specified seconds
		 * */
		btnForward.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// get current song position				
				int currentPosition = mediaPlayer.getCurrentPosition();
				// check if seekForward time is lesser than song duration
				if(currentPosition + seekForwardTime <= mediaPlayer.getDuration()){
					// forward song
					mediaPlayer.seekTo(currentPosition + seekForwardTime);
				}else{
					// forward to end position
					mediaPlayer.seekTo(mediaPlayer.getDuration());
				}
			}
		});
		
		/**
		 * Backward button click event
		 * Backward song to specified seconds
		 * */
		btnBackward.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// get current song position				
				int currentPosition = mediaPlayer.getCurrentPosition();
				// check if seekBackward time is greater than 0 sec
				if(currentPosition - seekBackwardTime >= 0){
					// forward song
					mediaPlayer.seekTo(currentPosition - seekBackwardTime);
				}else{
					// backward to starting position
					mediaPlayer.seekTo(0);
				}
				
			}
		});
		
		/**
		 * Next button click event
		 * Plays next song by taking currentSongIndex + 1
		 * */
		btnNext.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// check if next song is there or not
				if(currentSongIndex < (database.getNumberofSongs() - 1)){
					playSong(currentSongIndex + 1);
					currentSongIndex = currentSongIndex + 1;
				}else{
					// play first song
					playSong(0);
					currentSongIndex = 0;
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
					playSong(database.getNumberofSongs() - 1);
					currentSongIndex = database.getNumberofSongs() - 1;
				}
				
			}
		});
		
		/**
		 * Button Click event for Repeat button
		 * Enables repeat flag to true
		 * */
		btnRepeat.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(isRepeat){
					isRepeat = false;
					Toast.makeText(getApplicationContext(), "Current Song REPEAT OFF", Toast.LENGTH_SHORT).show();
					btnRepeat.setImageResource(R.drawable.btn_repeat);
				}else{
					// make repeat to true
					isRepeat = true;
					Toast.makeText(getApplicationContext(), "Current Song REPEAT ON", Toast.LENGTH_SHORT).show();
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
		/*btnPlaylist.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(getApplicationContext(), PlayListActivity.class);
				startActivityForResult(i, 100);			
			}
		});*/
		
	}
	
	/**
	 * Receiving song index from playlist view
	 * and play the song
	 * */
	@Override
    protected void onActivityResult(int requestCode,
                                     int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 100){
         	 currentSongIndex = data.getExtras().getInt("songIndex");
         	 // play selected song
             playSong(currentSongIndex);
        }
 
    }
	
	/**
	 * Receiving song path from database
	 * and get the album art work of selected song
	 * @param songIndex
	 * */
	public void getAlbumArtWork(int songIndex){
		String filePath = database.getFilePath(songIndex + 1);
		dataRetriever.setDataSource(filePath);
		byte [] image = dataRetriever.getEmbeddedPicture();
		if(image != null){
			artCover.setImageBitmap(BitmapFactory.decodeByteArray(image, 0,image.length));
		} else {
			artCover.setImageDrawable(getResources().getDrawable(R.drawable.adele));
		}
		
	}
	
	 /**
	 * Function to play a song
	 * @param songIndex - index of song
	 * */
	public void  playSong(int songIndex){
		
		// Play song
		try {
        	mediaPlayer.reset();
			mediaPlayer.setDataSource(database.getFilePath(songIndex + 1));
			mediaPlayer.prepare();
			mediaPlayer.start();
			// Displaying Song title
			String songTitle = database.getSongTitle(songIndex + 1);
        	songTitleLabel.setText(songTitle);
			
        	// Changing Button Image to pause image
			btnPlay.setImageResource(R.drawable.btn_pause);

			// set Progress bar values
			songProgressBar.setProgress(0);
			songProgressBar.setMax(100);
			
			//Display album art work
			getAlbumArtWork(songIndex);
			
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
	
	/**
	 * Update timer on seekbar
	 * */
	public void updateProgressBar() {
        mHandler.postDelayed(mUpdateTimeTask, 100);        
    }	
	
	/**
	 * Background Runnable thread
	 * */
	private Runnable mUpdateTimeTask = new Runnable() {
		   public void run() {
			   long totalDuration = mediaPlayer.getDuration();
			   long currentDuration = mediaPlayer.getCurrentPosition();
			  
			   // Displaying Total Duration time
			   songTotalDurationLabel.setText(""+utils.milliSecondsToTimer(totalDuration));
			   // Displaying time completed playing
			   songCurrentDurationLabel.setText(""+utils.milliSecondsToTimer(currentDuration));
			   
			   // Updating progress bar
			   int progress = (int)(utils.getProgressPercentage(currentDuration, totalDuration));
			   
			   // Running this thread after 100 milliseconds
		       mHandler.postDelayed(this, 100);
		   }
		};
		
	/**
	 * 
	 * */
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
	 * When user stops moving the progress handler
	 * */
	@Override
    public void onStopTrackingTouch(SeekBar seekBar) {
		mHandler.removeCallbacks(mUpdateTimeTask);
		int totalDuration = mediaPlayer.getDuration();
		int currentPosition = utils.progressToTimer(seekBar.getProgress(), totalDuration);
		
		// forward or backward to certain seconds
		mediaPlayer.seekTo(currentPosition);
		
		// update timer progress again
		updateProgressBar();
    }

	/**
	 * On Song Playing completed
	 * if repeat is ON play same song again
	 * if shuffle is ON play random song
	 * */
	@Override
	public void onCompletion(MediaPlayer arg0) {
		
		// check for repeat is ON or OFF
		if(isRepeat){
			// repeat is on play same song again
			playSong(currentSongIndex);
		} else if(isShuffle){
			// shuffle is on - play a random song
			Random rand = new Random();
			currentSongIndex = rand.nextInt((database.getNumberofSongs() - 1) - 0 + 1) + 0;
			playSong(currentSongIndex);
		} else{
			// no repeat or shuffle ON - play next song
			if(currentSongIndex < (database.getNumberofSongs() - 1)){
				playSong(currentSongIndex + 1);
				currentSongIndex = currentSongIndex + 1;
			}else{
				// play first song
				playSong(0);
				currentSongIndex = 0;
			}
		}
	}
    
	@Override
	 public void onDestroy(){
	 super.onDestroy();
	    mediaPlayer.release();
	 }
	
	/** Store all the songs from ArrayList
	 * to database
	 * */
	public void storeDB(){
		database.open();
		for (int i = 0; i < songsList.size(); i++) {
			database.addSong(songsList.get(i).get("songTitle"), songsList.get(i).get("songPath"));
		}
		database.close();
	}
	
	 
	
	@Override
	public void onBackPressed(){
	    // Add data to your intent
		super.onBackPressed();
		mHandler.removeCallbacks(mUpdateTimeTask);

	
	    
	}
	
}
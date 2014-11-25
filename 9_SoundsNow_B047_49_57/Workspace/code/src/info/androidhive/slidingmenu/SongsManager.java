package info.androidhive.slidingmenu;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;

public class SongsManager {

private ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String,     String>>();

public SongsManager(){

}


public ArrayList<HashMap<String, String>> getPlayList(Context c) {

final Cursor mCursor = c.getContentResolver().query(
        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
        new String[] { MediaStore.Audio.Media.DISPLAY_NAME
                    ,MediaStore.Audio.Media.ARTIST
                    ,MediaStore.Audio.Media.DURATION
                    ,MediaStore.Audio.Media.ALBUM_ID
                    ,MediaStore.Audio.Media.DATA
                    ,MediaStore.Audio.Media.MIME_TYPE 
                    ,MediaStore.Audio.Media.ALBUM}
                    , null
                    , null,
                    "LOWER(" + MediaStore.Audio.Media.TITLE + ") ASC");


String songs_name = "";
String song_artist= "";
String song_duration= "";
String song_album_id= "";
String mAudioPath = "";
String song_album = "";
//String coverPath1 = " ";

/* run through all the columns we got back and save the data we need into the arraylist for our listview*/
if (mCursor.moveToFirst()) {
    do {

    String file_type = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.MIME_TYPE));


        songs_name = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME));
        song_artist = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
        song_duration = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));
        song_album_id= mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID));
        song_album= mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));
       // coverPath1 = mCursor.getString(mCursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ART));
        mAudioPath = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
        HashMap<String, String> song = new HashMap<String, String>();
        song.put("songTitle", songs_name.substring(0, (songs_name.length() - 4)));
        //song.put("songTitle", songs_name);
        song.put("songArtist", song_artist);
        song.put("songDuration",song_duration);
        song.put("songAlbumId", song_album_id);
        //song.put("coverPath", coverPath1);
        song.put("songPath", mAudioPath);
        song.put("songAlbum", song_album);
        songsList.add(song);

    } while (mCursor.moveToNext());
}   

mCursor.close();
return songsList;
 }   
 }


/*public class SongsManager {
	// SDCard Path
	//final String MEDIA_PATH = new String(Environment.getExternalStorageDirectory() +"/Music/");
	private ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
	
	// Constructor
	public SongsManager(){
		
	}
	
	*//**
	 * Function to read all mp3 files from sdcard
	 * and store the details in ArrayList
	 * *//*
	public ArrayList<HashMap<String, String>> getPlayList(){
		//File home = new File(MEDIA_PATH);
		File home = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
		
		if (home.listFiles(new FileExtensionFilter()).length > 0) {
			for (File file : home.listFiles(new FileExtensionFilter())) {
				HashMap<String, String> song = new HashMap<String, String>();
				song.put("songTitle", file.getName().substring(0, (file.getName().length() - 4)));
				song.put("songPath", file.getPath());
				
				// Adding each song to SongList
				songsList.add(song);
			}
		}
		// return songs list array
		return songsList;
	}
	
	*//**
	 * Class to filter files which are having .mp3 extension
	 * *//*
	class FileExtensionFilter implements FilenameFilter {
		public boolean accept(File dir, String name) {
			return (name.endsWith(".mp3") || name.endsWith(".MP3"));
		}
	}
}*/

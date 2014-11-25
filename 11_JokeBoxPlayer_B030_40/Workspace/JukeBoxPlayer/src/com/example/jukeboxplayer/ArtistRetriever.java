package com.example.jukeboxplayer;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;

public class ArtistRetriever {

private ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String,     String>>();
private ArrayList<HashMap<String, String>> genreList = new ArrayList<HashMap<String,     String>>();

public ArtistRetriever(){

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
                    ,MediaStore.Audio.Media.ALBUM

                    }
                    , null
                    , null,
                    "LOWER(" + MediaStore.Audio.Media.TITLE + ") ASC");


String songs_name = "";
String song_artist= "";
String song_duration= "";
String song_album_id= "";
String mAudioPath = "";
String song_album = "";


/* run through all the columns we got back and save the data we need into the arraylist for our listview*/
if (mCursor.moveToFirst()) {
    do {

    String file_type = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.MIME_TYPE));


        songs_name = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME));
        song_artist = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
        song_duration = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));
        song_album_id= mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID));
     
        mAudioPath = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
        song_album= mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));
      
        HashMap<String, String> song = new HashMap<String, String>();
        song.put("songTitle", songs_name.substring(0, (songs_name.length() - 4)));

        song.put("songArtist", song_artist);
        song.put("songDuration",song_duration);
        song.put("songAlbumId", song_album_id);
      
        song.put("songPath", mAudioPath);
        song.put("songAlbum", song_album);

        songsList.add(song);

    } while (mCursor.moveToNext());
}   

mCursor.close();
return songsList;
 }   
public ArrayList<HashMap<String, String>> getGenre(Context c) {

final Cursor mCursor = c.getContentResolver().query(
		MediaStore.Audio.Genres.EXTERNAL_CONTENT_URI,
        new String[] { MediaStore.Audio.Genres._ID

                   ,MediaStore.Audio.Genres.NAME
                    }
                    , null
                    , null,
                    "LOWER(" + MediaStore.Audio.Genres.NAME + ") ASC");


String genre_id = "";
String genre_name= "";



/* run through all the columns we got back and save the data we need into the arraylist for our listview*/
if (mCursor.moveToFirst()) {
    do {

   


        genre_id = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Genres._ID));
        genre_name= mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Genres.NAME));
        HashMap<String, String> song = new HashMap<String, String>();
        song.put("songGenreid", genre_id);

        song.put("songGenre", genre_name);
      

        genreList.add(song);

    } while (mCursor.moveToNext());
}   

mCursor.close();
return genreList;
 }   
 }
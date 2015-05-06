

// Package
package com.TRAXter;

import android.app.Application;
import com.TRAXter.persistance.turtle.db.TurtleDatabase;
import com.TRAXter.player.ObservableOutput;
import com.TRAXter.player.PlayerServiceConnector;
import com.TRAXter.playlist.Playlist;

public class TRAXter extends Application
{
	public final ObservableOutput player;
	public Playlist playlist;
	public TurtleDatabase db;

	private static TRAXter instance = null;

	public TRAXter()
	{
		player = new PlayerServiceConnector(this);
		/*mp = new MediaPlayer();
		playlist = new Playlist();
		isPaused = true;
		isInitialised = false;
		currentlyPlaying = new Track();*/
	}

	@Override
	public void onCreate()
	{
		instance = this;
	}

	public static TRAXter getStaticInstance()
	{
		if(instance == null){
			throw new IllegalStateException("Not initialized yet");
		}
		return instance;
	}
}

package com.TRAXter.playlist.playorder;

import com.TRAXter.model.Track;
import com.TRAXter.persistance.framework.executor.OperationExecutor;
import com.TRAXter.persistance.framework.sort.RandomOrder;
import com.TRAXter.persistance.source.sql.First;
import com.TRAXter.persistance.source.sqlite.QuerySqlite;
import com.TRAXter.persistance.turtle.db.TurtleDatabase;
import com.TRAXter.persistance.turtle.db.structure.Tables;
import com.TRAXter.persistance.turtle.mapping.TrackCreator;
import com.TRAXter.playlist.Playlist;

public class PlayOrderRandom implements PlayOrderStrategy
{

	private final Playlist playlist;
	private final TurtleDatabase db;

	public PlayOrderRandom(TurtleDatabase db,
								  Playlist playlist)
	{
		this.playlist = playlist;
		this.db = db;
	}

	public Track getNext(Track currTrack)
	{
		return get();
	}

	public Track getPrevious(Track currTrack)
	{
		return get();
	}

	private Track get()
	{
		return OperationExecutor.execute(db,
				  new QuerySqlite<Tables.Tracks, Tables.Tracks, Track>(
							 playlist.getCompressedFilter(),
							 new RandomOrder<Tables.Tracks>(),
							 new First<Track>(Tables.TRACKS, new TrackCreator())));
	}
}

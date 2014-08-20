package com.tanmay.messsch;
import java.util.ArrayList;

import com.obscuresoftware.texttimer.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class QueueList extends Activity
{
	public static ArrayList<String> listItems=new ArrayList<String>();
	ArrayAdapter<String> adapter;
	public static int count =0;
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.queue);
		ListView lv = (ListView) findViewById(R.id.queue_list);
		adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
		lv.setAdapter(adapter);
	}
	
	public static void addToList(String s)
	{
		listItems.add(count, s);
		upCount();
	}
	
	private static void upCount()
	{
		count++;
	}


}

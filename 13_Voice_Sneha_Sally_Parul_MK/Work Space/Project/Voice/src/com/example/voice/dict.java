package com.example.voice;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.support.v4.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

public class dict extends Activity implements OnClickListener {
	
	 ExpandableListAdapter listAdapter;
	    ExpandableListView expListView;
	    List<String> listDataHeader;
	    HashMap<String, List<String>> listDataChild;
	    
	    Dialog d1,d2,d3,dialog;

	ArrayList <String> comps1ppr;
	
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dict);
        
     // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
 
        // preparing list data
        prepareListData();
 
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
 
        // setting list adapter
        expListView.setAdapter(listAdapter);
        
             
     // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {
 
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                    int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                        listDataHeader.get(groupPosition)).get(
                                        childPosition), Toast.LENGTH_SHORT)
                        .show();
                
                
                if(groupPosition == 0 && childPosition == 0)
                {
                	


                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				
                				
                			//	int resID = getResources().getIdentifier(drawname, "drawable", getPackageName());
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.red);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 0 && childPosition == 1)
                {
                	


                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				
                				
                			//	int resID = getResources().getIdentifier(drawname, "drawable", getPackageName());
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.blue);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 0 && childPosition == 2)
                {
                	


                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				
                				
                			//	int resID = getResources().getIdentifier(drawname, "drawable", getPackageName());
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.green);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 0 && childPosition == 3)
                {
                	


                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				
                				
                			//	int resID = getResources().getIdentifier(drawname, "drawable", getPackageName());
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.yellow);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 0 && childPosition == 4)
                {
                	


                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				
                				
                			//	int resID = getResources().getIdentifier(drawname, "drawable", getPackageName());
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.black);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 0 && childPosition == 5)
                {
                	


                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				
                				
                			//	int resID = getResources().getIdentifier(drawname, "drawable", getPackageName());
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.white);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 0 && childPosition == 6)
                {
                	


                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				
                				
                			//	int resID = getResources().getIdentifier(drawname, "drawable", getPackageName());
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.pink);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                
                if(groupPosition == 1 && childPosition == 0)
                {
                	


                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				
                				
                			//	int resID = getResources().getIdentifier(drawname, "drawable", getPackageName());
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.mom);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 1 && childPosition == 1)
                {
                	


                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				
                				
                			//	int resID = getResources().getIdentifier(drawname, "drawable", getPackageName());
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.dad);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 1 && childPosition == 2)
                {
                	


                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				
                				
                			//	int resID = getResources().getIdentifier(drawname, "drawable", getPackageName());
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.grandma);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }

                if(groupPosition == 1 && childPosition == 3)
                {
                	


                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				
                				
                			//	int resID = getResources().getIdentifier(drawname, "drawable", getPackageName());
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.grandpa);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 2 && childPosition == 0)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.apple);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }

                if(groupPosition == 2 && childPosition == 1)
                {
                	


                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				
                				
                			//	int resID = getResources().getIdentifier(drawname, "drawable", getPackageName());
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.cake);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 2 && childPosition == 2)
                {
                	


                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				
                				
                			//	int resID = getResources().getIdentifier(drawname, "drawable", getPackageName());
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.cheese);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 2 && childPosition == 3)
                {
                	


                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				
                				
                			//	int resID = getResources().getIdentifier(drawname, "drawable", getPackageName());
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.cookie);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 3 && childPosition == 0)
                {
                	


                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				
                				
                			//	int resID = getResources().getIdentifier(drawname, "drawable", getPackageName());
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.push);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 3 && childPosition == 1)
                {
                	


                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				
                				
                			//	int resID = getResources().getIdentifier(drawname, "drawable", getPackageName());
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.pull);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 3 && childPosition == 2)
                {
                	


                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				
                				
                			//	int resID = getResources().getIdentifier(drawname, "drawable", getPackageName());
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.twist);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 3 && childPosition == 3)
                {
                	


                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				
                				
                			//	int resID = getResources().getIdentifier(drawname, "drawable", getPackageName());
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.spin);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 3 && childPosition == 4)
                {
                	


                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				
                				
                			//	int resID = getResources().getIdentifier(drawname, "drawable", getPackageName());
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.turn);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }

                if(groupPosition == 4 && childPosition == 0)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.airplane);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 1)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.ball);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 2)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.cake);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 3)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.dog);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 4)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.egg);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 5)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.fish);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 6)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.gate);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 7)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.house);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 8)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.icecream);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 9)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.juice);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 10)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.kite);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 11)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.lamp);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 12)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.money);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 13)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.nuts);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 14)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.oranges);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 15)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.pen);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 16)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.queen);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 17)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.rainbow);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 18)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.shampoo);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 19)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.table);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 20)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.umbrella);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 21)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.vegetable);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 22)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.watch);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 23)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.xylophone);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 24)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.yogurt);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
                if(groupPosition == 4 && childPosition == 25)
                {
                	dialog=new Dialog(dict.this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);              //android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                				dialog.setContentView(R.layout.dialogbox);
                				Button text = (Button) dialog.findViewById(R.id.buttonWallpaper);
                				text.setBackgroundResource(R.drawable.zoo);
                				text.setOnClickListener(dict.this);
                				dialog.show();
                }
				return false;
                
                
                
                
            }
        }); 
  
    }
    
    private void prepareListData() {
		// TODO Auto-generated method stub
    	listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
 
        // Adding child data
        listDataHeader.add("Colours");
        listDataHeader.add("Family");
        listDataHeader.add("Food");
        listDataHeader.add("Action");
        listDataHeader.add("CompleteDictionary");
 
        // Adding child data
        List<String> Colours = new ArrayList<String>();
        Colours.add("red");
        Colours.add("blue");
        Colours.add("green");
        Colours.add("yellow");
        Colours.add("black");
        Colours.add("white");
        Colours.add("pink");
 
        List<String> Family = new ArrayList<String>();
        Family.add("mom");
        Family.add("dad");
        Family.add("grandma");
        Family.add("grandpa");
      
 
        List<String> Food = new ArrayList<String>();
        Food.add("apple");
        Food.add("cake");
        Food.add("cheese");
        Food.add("cookie");
   
        List<String> Action = new ArrayList<String>();
        Action.add("push");
        Action.add("pull");
        Action.add("twist");
        Action.add("spin");
        Action.add("turn");
        
        List<String> CompleteDictionary = new ArrayList<String>();
        CompleteDictionary.add("A-airplane");
        CompleteDictionary.add("B-ball");
        CompleteDictionary.add("C-cake");
        CompleteDictionary.add("D-dog");
        CompleteDictionary.add("E-egg");
        CompleteDictionary.add("F-fish");
        CompleteDictionary.add("G-gate");
        CompleteDictionary.add("H-house");
        CompleteDictionary.add("I-icecream");
        CompleteDictionary.add("J-juice");
        CompleteDictionary.add("K-kite");
        CompleteDictionary.add("L-ladder");
        CompleteDictionary.add("M-money");
        CompleteDictionary.add("N-nuts");
        CompleteDictionary.add("O-oranges");
        CompleteDictionary.add("P-pen");
        CompleteDictionary.add("Q-queen");
        CompleteDictionary.add("R-rainbow");
        CompleteDictionary.add("S-shampoo");
        CompleteDictionary.add("T-table");
        CompleteDictionary.add("U-umbrella");
        CompleteDictionary.add("V-vegetable");
        CompleteDictionary.add("W-watch");
        CompleteDictionary.add("X-xylophone");
        CompleteDictionary.add("Y-yogurt");
        CompleteDictionary.add("Z-zoo");
        
        listDataChild.put(listDataHeader.get(0), Colours); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Family);
        listDataChild.put(listDataHeader.get(2), Food);
        listDataChild.put(listDataHeader.get(3), Action);
        listDataChild.put(listDataHeader.get(4), CompleteDictionary);
		
	}
    



	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		dialog.dismiss();
		
		
	}
    
}
        	
        
     

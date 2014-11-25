package com.ara.aroundme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Station extends Activity {
	String name[]={"Andheri","Ambernath","BCT","Bandra","Bhandup","Byculla","Cotton Green" ,"Churchgate"
		    ,"Chembur"
		    ,"Dadar"
		    ,"Dombivali"
		    ,"Matunga"
		    ,"Marine lines" 
		    ,"Mahalaxmi"
		    ,"Sandhurst Road"
		    ,"Santacruz"
		    ,"Vikroli" };
	Double latitude[]={19.117233,19.210164,18.969834,19.054735,19.14229,18.976175,18.986777,18.935313,19.061966,19.018822,19.21836,19.027373,18.945755,18.982354,18.961443,19.082671,19.112123}; 
	Double longitude[]={72.846553,73.184436,72.818688,72.840704,72.937625,72.832831,72.842785,72.827295,72.900851,72.843238,73.086825,72.850126,72.823786,72.823958,72.839987,72.841714,72.92808};
	
ListView list;
/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_station);
list = (ListView)findViewById(R.id.listView1);
//list.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,items));
ArrayAdapter<String> ar=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name);
list.setAdapter(ar);

list.setOnItemClickListener(new OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
	// TODO Auto-generated method stub
	//Toast.makeText(this,"You are at "+latitude[position]+" , "+longitude[position],Toast.LENGTH_SHORT).show();
	Log.i("MO", "onItemClick");
	Intent i=new Intent(Station.this,Stationmap.class);
	i.putExtra("lat", latitude[position]);
	i.putExtra("lon", longitude[position]);
	i.putExtra("name", name[position]);
	Log.i("MO", "lat"+latitude[position]);
	startActivity(i);

}});
}}
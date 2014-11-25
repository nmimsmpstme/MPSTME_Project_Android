package com.ara.aroundme;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Custom_Adapter extends ArrayAdapter<Dataset> {
Context context2;
ArrayList<Dataset> values ;
	public Custom_Adapter(Context context, int textViewResourceId, ArrayList<Dataset> values) {
		super(context, textViewResourceId,values);
		context2 = context;
		this.values = values;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView==null){
			LayoutInflater in = (LayoutInflater) context2.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = in.inflate(R.layout.row,null);
			
			
		}
		
		TextView txt = (TextView)convertView.findViewById(R.id.textView1);
		TextView txt2 = (TextView)convertView.findViewById(R.id.textView2);
		TextView txt3 = (TextView)convertView.findViewById(R.id.textView3);
		
	//	ImageView img = (ImageView)convertView.findViewById(R.id.imageView1);
		
		Dataset data = values.get(position);
		txt.setText(data.head);
		txt2.setText(data.subhead);
	//	txt3.setText(data.distance);
		//String x=Double.toString(data.latitude);
		//x=x+" "+Double.toString(data.longitude);
		//String x=" Ex";
		//Log.i("MO","x created:"+x);
		//txt3.setText(x);
		
	//	img.setImageResource(data.image);
		
		
		
		
		
		return convertView;
	}
	
	
	
	

}

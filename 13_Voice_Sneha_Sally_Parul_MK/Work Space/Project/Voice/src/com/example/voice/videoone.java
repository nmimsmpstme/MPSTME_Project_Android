package com.example.voice;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;
import android.app.Activity;
import android.content.Intent;
public class videoone extends Activity implements OnClickListener {
	Button practice;
	VideoView vv;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.videoone);
		 vv = (VideoView)this.findViewById(R.id.videoView);
		
		String fileName = "android.resource://" + getPackageName() + "/" + R.raw.alpha;
		
		vv.setVideoURI(Uri.parse(fileName));
		
		vv.start();
		vv.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
}

	


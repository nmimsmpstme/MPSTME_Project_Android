package com.example.voice;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class letteractivity extends Activity implements OnClickListener {
	
	Button A,B,C,D,E,F,G,H,I,J, K, L,M,N,O,P,Q,RR,S,T,U,V,W,X,Y,Z;
	Intent play1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.letters_main);
		A=(Button) findViewById(R.id.Ba);
		B=(Button) findViewById(R.id.Bb);
		C=(Button) findViewById(R.id.Bc);
		D=(Button) findViewById(R.id.Bd);
		E=(Button) findViewById(R.id.Be);
		F=(Button) findViewById(R.id.Bf);
		G=(Button) findViewById(R.id.Bg);
		H=(Button) findViewById(R.id.Bh);
		I=(Button) findViewById(R.id.Bi);
		J=(Button) findViewById(R.id.Bj);
		K=(Button) findViewById(R.id.Bk);
		L=(Button) findViewById(R.id.Bl);
		M=(Button) findViewById(R.id.Bm);
		N=(Button) findViewById(R.id.Bn);
		O=(Button) findViewById(R.id.Bo);
		P=(Button) findViewById(R.id.Bp);
		Q=(Button) findViewById(R.id.Bq);
		RR=(Button) findViewById(R.id.Br);
		S=(Button) findViewById(R.id.Bs);
		T=(Button) findViewById(R.id.Bt);
		U=(Button) findViewById(R.id.Bu);
		V=(Button) findViewById(R.id.Bv);
		W=(Button) findViewById(R.id.Bw);
		X=(Button) findViewById(R.id.Bx);
		Y=(Button) findViewById(R.id.By);
		Z=(Button) findViewById(R.id.Bz);
		
		A.setOnClickListener(this);
		B.setOnClickListener(this);
		C.setOnClickListener(this);
		D.setOnClickListener(this);
		E.setOnClickListener(this);
		F.setOnClickListener(this);
		G.setOnClickListener(this);
		H.setOnClickListener(this);
		I.setOnClickListener(this);
		J.setOnClickListener(this);
		K.setOnClickListener(this);
		L.setOnClickListener(this);
		M.setOnClickListener(this);
		N.setOnClickListener(this);
		O.setOnClickListener(this);
		P.setOnClickListener(this);
		Q.setOnClickListener(this);
		RR.setOnClickListener(this);
		S.setOnClickListener(this);
		T.setOnClickListener(this);
		U.setOnClickListener(this);
		V.setOnClickListener(this);
		W.setOnClickListener(this);
		X.setOnClickListener(this);
	    Y.setOnClickListener(this);
		Z.setOnClickListener(this);
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
switch (v.getId()){
		
		case R.id.Ba:
				play1=new Intent(this,image.class);
				play1.putExtra("word", "a");
			startActivity(play1);
			
			break;
			
		case R.id.Bb:
			 play1=new Intent(this,image.class);
			play1.putExtra("word", "b");
						startActivity(play1);
						break;
						
		case R.id.Bc:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "c");			
						startActivity(play1);
						break;
		case R.id.Bd:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "d");			
			startActivity(play1);
						break;
		case R.id.Be:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "e");	
						startActivity(play1);
						break;
		case R.id.Bf:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "f");	
						startActivity(play1);
						break;
		case R.id.Bg:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "g");	
						startActivity(play1);
						break;
		case R.id.Bh:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "h");	
						startActivity(play1);
						break;
		case R.id.Bi:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "i");	
						startActivity(play1);
						break;
		case R.id.Bj:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "j");	
						startActivity(play1);
						break;
		case R.id.Bk:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "k");	
						startActivity(play1);
						break;
		case R.id.Bl:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "l");	
						startActivity(play1);
						break;
		case R.id.Bm:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "m");	
						startActivity(play1);
						break;
		case R.id.Bn:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "n");	
						startActivity(play1);
						break;
		case R.id.Bo:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "o");	
						startActivity(play1);
						break;
		case R.id.Bp:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "p");	
						startActivity(play1);
						break;
		case R.id.Bq:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "q");	
						startActivity(play1);
						break;
		case R.id.Br:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "r");	
						startActivity(play1);
						break;
		case R.id.Bs:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "s");	
						startActivity(play1);
						break;
		
		case R.id.Bt:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "t");	
						startActivity(play1);
						break;
		case R.id.Bu:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "u");	
						startActivity(play1);
						break;
		case R.id.Bv:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "v");	
						startActivity(play1);
						break;
		case R.id.Bw:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "w");	
						startActivity(play1);
						break;
		case R.id.Bx:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "x");	
						startActivity(play1);
						break;
		case R.id.By:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "y");	
						startActivity(play1);
						break;
		case R.id.Bz:
			play1=new Intent(this,image.class);
			play1.putExtra("word", "z");	
						startActivity(play1);
						break;
		

						
						
						
						
	}

}
}
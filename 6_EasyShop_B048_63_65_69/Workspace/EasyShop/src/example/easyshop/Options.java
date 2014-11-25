package example.easyshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Options extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.options);
	
	TextView dn = (TextView) findViewById(R.id.displayname);
	Button al = (Button) findViewById(R.id.addItem);
	Button vl = (Button) findViewById(R.id.viewlist);
	Button s = (Button) findViewById(R.id.shopping);
	Button b = (Button) findViewById(R.id.barcode);
	dn.setText(getIntent().getExtras().getString("nametext"));
	
	al.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			startActivity(new Intent(Options.this, addItem.class));
			
		}
	});
	
	
	
	
	vl.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			startActivity(new Intent(Options.this, Viewlist.class));
			
		}
	});
	
	

	s.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			startActivity(new Intent(Options.this, Shopping.class));
			
		}
	});
	
	
b.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			startActivity(new Intent(Options.this, Barcode.class));
			
		}
	});
	
	
	}
}

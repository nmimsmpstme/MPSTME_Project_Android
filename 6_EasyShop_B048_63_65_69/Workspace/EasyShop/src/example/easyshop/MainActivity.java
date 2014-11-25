package example.easyshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends 
Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

Button g = (Button) findViewById(R.id.go);

g.setOnClickListener(new OnClickListener() {


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		startActivity(new Intent(MainActivity.this, Name.class));
	}
});
	}

}

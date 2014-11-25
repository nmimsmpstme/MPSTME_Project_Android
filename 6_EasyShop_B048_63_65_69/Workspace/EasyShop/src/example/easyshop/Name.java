package example.easyshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Name extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.name);
	
	final EditText et = (EditText) findViewById(R.id.user_name);
Button p = (Button) findViewById(R.id.proceed);

p.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent1 = new Intent(Name.this, Options.class);
		intent1.putExtra("nametext", et.getText().toString());
		startActivity(intent1);
	}
});
	
	
	}
}

package example.easyshop;

import android.app.Activity;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Addlist extends Activity {
	SQLiteDatabase db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
    
	setContentView(R.layout.addlist);
	

EditText ln = (EditText) findViewById(R.id.liname);

Button alist = (Button) findViewById(R.id.savelist);

alist.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
	}
        
});

	}
	
}

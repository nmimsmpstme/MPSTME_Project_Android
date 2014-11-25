package com.vi.justorder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.UUID;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Menu extends Activity {
	
	Button  orderButton, appetizerButton, beveragesButton, soupsButton, maincourseButton, saladButton, dessertButton;
	Intent  homeit, orderit, appetizerit, beveragesit, soupsit, maincourseit, saladit, dessertit;
	Bundle g;
	

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        
        g = getIntent().getExtras();
        
        orderButton = (Button)findViewById(R.id.Button03);
        appetizerButton = (Button)findViewById(R.id.Button06);
        beveragesButton = (Button)findViewById(R.id.Button07);
        soupsButton = (Button)findViewById(R.id.Button08);
        maincourseButton = (Button)findViewById(R.id.Button09);
        saladButton = (Button)findViewById(R.id.Button10);
        dessertButton = (Button)findViewById(R.id.Button11);
     
        homeit = new Intent(getBaseContext(), JustOrderMain.class);
        orderit = new Intent(getBaseContext(), ViewOrder.class);
        appetizerit = new Intent(getBaseContext(), Appetizers.class);
        beveragesit = new Intent(getBaseContext(), Beverages.class);
        soupsit = new Intent(getBaseContext(), Soups.class);
        maincourseit = new Intent(getBaseContext(), MainCourse.class);
        saladit = new Intent(getBaseContext(), Salad.class);
        dessertit = new Intent(getBaseContext(), Dessert.class);
        
      
        appetizerButton.setOnClickListener((OnClickListener) new appetizerListener());
        beveragesButton.setOnClickListener((OnClickListener) new beveragesListener());
        soupsButton.setOnClickListener((OnClickListener) new soupsListener());
        maincourseButton.setOnClickListener((OnClickListener) new maincourseListener());
        saladButton.setOnClickListener((OnClickListener) new saladListener());
        dessertButton.setOnClickListener((OnClickListener) new dessertListener());
        orderButton.setOnClickListener((OnClickListener) new orderListener());
        
    }

	 
    private class orderListener  implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			Toast.makeText(getApplicationContext(), "Loading your current Order...", Toast.LENGTH_SHORT).show();
			orderit.putExtras(g);
			startActivity(orderit);
		}
    	
    }
 
    
    private class appetizerListener  implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			Toast.makeText(getApplicationContext(), "Loading Appetizers...", Toast.LENGTH_SHORT).show();
			appetizerit.putExtras(g);
			startActivity(appetizerit);
		}
    	
    }

    private class beveragesListener  implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			Toast.makeText(getApplicationContext(), "Loading Beverages...", Toast.LENGTH_SHORT).show();
			beveragesit.putExtras(g);
			startActivity(beveragesit);
		}
    	
    }
    
    private class soupsListener  implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			Toast.makeText(getApplicationContext(), "Loading Soups...", Toast.LENGTH_SHORT).show();
			soupsit.putExtras(g);
			startActivity(soupsit);
		}
    	
    }
    
    private class maincourseListener  implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			Toast.makeText(getApplicationContext(), "Loading Main Course...", Toast.LENGTH_SHORT).show();
			maincourseit.putExtras(g);
			startActivity(maincourseit);
		}
    	
    }

    private class saladListener  implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			Toast.makeText(getApplicationContext(), "Loading Salads...", Toast.LENGTH_SHORT).show();
			saladit.putExtras(g);
			startActivity(saladit);
		}
    	
    }
    private class dessertListener  implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			Toast.makeText(getApplicationContext(), "Loading Desserts...", Toast.LENGTH_SHORT).show();
			dessertit.putExtras(g);
			startActivity(dessertit);
		}
		
    	
    }

    @Override
	 public void onBackPressed() {
		homeit.putExtras(g);
		startActivity(homeit);
		return;
	}
    
}

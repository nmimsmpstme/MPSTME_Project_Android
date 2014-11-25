package com.example.festipedia_logo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;



//import com.example.festipedia_logo.adding.CreateNewProduct;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
//import MainActivity.CreateNewProduct;
public class adding extends SherlockFragment {
	//Fragment Add = new home1(); 
	private ProgressDialog pDialog;
	JSONParser jsonParser = new JSONParser();
	EditText ingooglemap;
	EditText ineventwebsite;
	EditText ineventname;
	EditText inlocation;
	EditText istartdate;
	EditText ienddate;
	ArrayAdapter<String> adapter;
	String[] category;
	Spinner spinner;
	EditText incollegename;
	String icategory;
	int f=0,f1=0;
	int syear,smonth,sday,eyear,emonth,eday;
	Calendar myCalendar = Calendar.getInstance();
	EditText mEdit,mEdit1;
	Button b2,b3;
	private static String url_create_product = new Global().getcon()+"create_product.php";

	private static final String TAG_SUCCESS = "success";

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			
			Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.second);
		
		View rootView = inflater.inflate(R.layout.addevent, container, false);
		// Edit Text
		ineventname = (EditText) rootView.findViewById(R.id.editText1);
		 mEdit = (EditText)rootView.findViewById(R.id.editText6);
		 mEdit1= (EditText)rootView.findViewById(R.id.editText7);
		ineventwebsite = (EditText) rootView.findViewById(R.id.editText2);
		incollegename = (EditText) rootView.findViewById(R.id.editText3);
		ingooglemap = (EditText) rootView.findViewById(R.id.editText5);
		inlocation = (EditText) rootView.findViewById(R.id.editText4);
		istartdate = (EditText) rootView.findViewById(R.id.editText6);
		ienddate = (EditText) rootView.findViewById(R.id.editText7);
		
		Button button1 = (Button) rootView.findViewById(R.id.button1);
		b2 = (Button) rootView.findViewById(R.id.button2);
		b3 = (Button) rootView.findViewById(R.id.button3);
		 spinner = (Spinner)rootView.findViewById(R.id.spinner1);
		 category = new String[] { "Cultural", "Technical",
					"Sports"};

		 adapter = new ArrayAdapter<String>(getActivity(),
				  android.R.layout.simple_spinner_dropdown_item,category
				  );

		    

		    spinner.setAdapter(adapter);
		    b2.setOnClickListener(new View.OnClickListener(){
		    	public void onClick(View view) {
					// creating new product in background thread
					f=1;f1=0;
		    		syear=myCalendar.get(Calendar.YEAR);
		    		smonth=myCalendar.get(Calendar.MONTH);
		    		sday=myCalendar.get(Calendar.DAY_OF_MONTH);
					new DatePickerDialog(getActivity(), date, myCalendar
		                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
		                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
				}
			});
		    b3.setOnClickListener(new View.OnClickListener(){
		    	public void onClick(View view) {
					// creating new product in background thread
					f1=1;f=0;
					eyear=myCalendar.get(Calendar.YEAR);
		    		emonth=myCalendar.get(Calendar.MONTH);
		    		eday=myCalendar.get(Calendar.DAY_OF_MONTH);
		    		new DatePickerDialog(getActivity(), date, myCalendar
		                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
		                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
				}
			});
		    
		    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { 
			    	icategory=spinner.getSelectedItem().toString();}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}

//				@Override
			}); 

		// button click event
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// creating new product in background thread
				//boolean r=validate();
			   // Log.d("check",q);
				int flag3=0;
				Log.d("check","Hello"+ineventname.getText().toString());
				boolean r1=URLUtil.isValidUrl(ineventwebsite.getText().toString());
				boolean r2=URLUtil.isValidUrl(ingooglemap.getText().toString());
				if(eyear<syear){
					flag3=1;
				}
				else if((eyear==syear)&&(emonth<smonth))
				{
					flag3=1;
				}
				else if((eyear==syear)&&(emonth==smonth)&&(eday<sday))
				{
					flag3=1;
				}
				//URLUtil.isValidUrl(ingooglemap.getText().toString());
				if(ineventname.getText().toString().equals("")||ineventwebsite.getText().toString().equals("")||incollegename.getText().toString().equals("")||ingooglemap.getText().toString().equals("")||inlocation.getText().toString().equals("")||istartdate.getText().toString().equals("")||ienddate.getText().toString().equals("")){
					AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
		            builder1.setMessage("Please fill the fields");
		            builder1.setCancelable(false);
		            builder1.setPositiveButton("Ok",
		                    new DialogInterface.OnClickListener() {
		                public void onClick(DialogInterface dialog, int id) {
		                    dialog.cancel();
		                }
		            });		        
		            AlertDialog alert11 = builder1.create();
		            alert11.show();
				}
				else if(r1==false||r2==false){
					AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
		            builder1.setMessage("Enter valid url");
		            builder1.setCancelable(false);
		            builder1.setPositiveButton("Ok",
		                    new DialogInterface.OnClickListener() {
		                public void onClick(DialogInterface dialog, int id) {
		                    dialog.cancel();
		                }
		            });		        
		            AlertDialog alert11 = builder1.create();
		            alert11.show();
				}
				else if(flag3==1){
					AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
		            builder1.setMessage("Enter valid start/end date");
		            builder1.setCancelable(false);
		            builder1.setPositiveButton("Ok",
		                    new DialogInterface.OnClickListener() {
		                public void onClick(DialogInterface dialog, int id) {
		                    dialog.cancel();
		                }
		            });		        
		            AlertDialog alert11 = builder1.create();
		            alert11.show();
				}
				else{
					new CreateNewProduct().execute();
					FragmentTransaction ft = getFragmentManager().beginTransaction();
					ft.replace(R.id.content_frame, new ack());
					ft.commit();
					
				}
			}
		});
return rootView;
	
	}
	private boolean checkEmail(String email) {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
}
	public final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
	          "/((([A-Za-z]{3,9}:(?:\\/\\/)?)(?:[-;:&=\\+\\$,\\w]+@)?[A-Za-z0-9.-]+(:[0-9]+)?|(?:ww‌​w.|[-;:&=\\+\\$,\\w]+@)[A-Za-z0-9.-]+)((?:\\/[\\+~%\\/.\\w-_]*)?\\??(?:[-\\+=&;%@.\\w_]*)#?‌​(?:[\\w]*))?)/"
	      );

	class CreateNewProduct extends AsyncTask<String, String, String> {
		
		
		
		protected String doInBackground(String... args) {
			String eventname = ineventname.getText().toString();
			String collegename = incollegename.getText().toString();
			String location= inlocation.getText().toString();
			String googlemap = ingooglemap.getText().toString();
			String eventwebsite = ineventwebsite.getText().toString();
			String startdate = istartdate.getText().toString();
			String enddate = ienddate.getText().toString();
			//String description = inputDesc.getText().toString();

			// Building Parameters
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("eventname", eventname));
			params.add(new BasicNameValuePair("googlemap", googlemap));
			params.add(new BasicNameValuePair("collegename", collegename));
			params.add(new BasicNameValuePair("eventwebsite",eventwebsite));
			params.add(new BasicNameValuePair("location", location));
			params.add(new BasicNameValuePair("category", icategory));
			params.add(new BasicNameValuePair("startdate", startdate));
			params.add(new BasicNameValuePair("enddate", enddate));

			//params.add(new BasicNameValuePair("description", description));

			// getting JSON Object
			// Note that create product url accepts POST method
			JSONObject json = jsonParser.makeHttpRequest(url_create_product,
					"POST", params);
			
			return null;


}


}	
	DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

	    @Override
	    public void onDateSet(DatePicker view, int year, int monthOfYear,
	            int dayOfMonth) {
	        // TODO Auto-generated method stub
	        myCalendar.set(Calendar.YEAR, year);
	        myCalendar.set(Calendar.MONTH, monthOfYear);
	        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
	        updateLabel();
	    }

	};
	private void updateLabel() {

	    String myFormat = "dd/MM/yyyy"; //In which you need put here
	    SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
	    if(f==1)
	    {
	    	f=0;
	    	mEdit.setText(sdf.format(myCalendar.getTime()));
	    	syear=myCalendar.get(Calendar.YEAR);
	    	smonth=myCalendar.get(Calendar.MONTH);
	    	sday=myCalendar.get(Calendar.DAY_OF_MONTH);
	    }
	    if(f1==1)
	    {
	    	f1=0;
	    	mEdit1.setText(sdf.format(myCalendar.getTime()));
	    	eyear=myCalendar.get(Calendar.YEAR);
	    	emonth=myCalendar.get(Calendar.MONTH);
	    	eday=myCalendar.get(Calendar.DAY_OF_MONTH);
	    }
	    }

}
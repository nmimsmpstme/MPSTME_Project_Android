package org.mazzarellialessio.studenttimetable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TabActivity;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TimePicker;

/** Workaround for use only one activity with more tab*/
public class main extends TabActivity implements OnTabChangeListener{
	
	private static final String MONDAY_TAB_TAG = "Monday";
	private static final String TUESDAY_TAB_TAG = "Tuesday";
	private static final String WEDNESDAY_TAB_TAG = "Wednesday";
	private static final String THURSDAY_TAB_TAG = "Thursday";
	private static final String FRIDAY_TAB_TAG = "Friday";
	private static TabHost tabHost;
	private static ListView mondayLW;
	private static ListView tuesdayLW;
	private static ListView wednesdayLW;
	private static ListView thursdayLW;
	private static ListView fridayLW;
	private static ListView currentLW;
	private static MyDBManager dm;
	private static ArrayList<HashMap<String, Object>> results;
	private static SimpleAdapter simpleAdapter;
	private static String[] from = {"SName","STeacher","HClass","HStart","HEnd"};
    private static int[] to = {R.id.SName,R.id.STeacher,R.id.HClass,R.id.HStart,R.id.HEnd};
    private static int currentDay;
    private static Intent intent;
    private static Dialog addDialog;
    private static EditText HClass;
    private static String[] arraydays;
    private static ArrayAdapter<String> Sarrayadapter;
    private static ArrayAdapter<String> arrayadapter;
    private static String selectedDay;
    private static TimePickerDialog fromDialog;
    private static TimePickerDialog toDialog;
    private static TextView start;
    private static TextView end;
    private static String[] arraySubjects;
    private static Spinner SName;
    private static Spinner HDay;
    private static String selectedSubject;
    private static String colorVet[];
    private static String action = "insert";
    private static String OLDSName;
    private static String OLDHClass;
    private static int OLDHDay;
    private static String OLDHStart;
    private static String OLDHEnd;
    private static AlertDialog.Builder builder;
    private static AlertDialog.Builder builder2;
    private static AlertDialog alert;
    private static AlertDialog alert2;
    private static Dialog aboutDialog;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //remove app title
        setContentView(R.layout.main);
        
        
        dm = new MyDBManager(this); //Create DB
        
        //setup tab host
        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();
        tabHost.setOnTabChangedListener(this);
        
        //setup lists
        mondayLW = (ListView) findViewById(R.id.monday);
        tuesdayLW = (ListView) findViewById(R.id.tuesday);
        wednesdayLW = (ListView) findViewById(R.id.wednesday);
        thursdayLW = (ListView) findViewById(R.id.thursday);
        fridayLW = (ListView) findViewById(R.id.friday);
        
        // add views to tab host
        tabHost.addTab(tabHost.newTabSpec(MONDAY_TAB_TAG)
        		.setIndicator(MONDAY_TAB_TAG)
        		.setContent(new TabContentFactory() {
        			public View createTabContent(String arg0) {
        				return mondayLW;
        			}
        }));
        tabHost.addTab(tabHost.newTabSpec(TUESDAY_TAB_TAG)
        		.setIndicator(TUESDAY_TAB_TAG)
        		.setContent(new TabContentFactory() {
        			public View createTabContent(String arg0) {
        				return tuesdayLW;
        			}
        }));
        tabHost.addTab(tabHost.newTabSpec(WEDNESDAY_TAB_TAG)
        		.setIndicator(WEDNESDAY_TAB_TAG)
        		.setContent(new TabContentFactory() {
        			public View createTabContent(String arg0) {
        				return wednesdayLW;
        			}
        }));
        tabHost.addTab(tabHost.newTabSpec(THURSDAY_TAB_TAG)
        		.setIndicator(THURSDAY_TAB_TAG)
        		.setContent(new TabContentFactory() {
        			public View createTabContent(String arg0) {
        				return thursdayLW;
        			}
        }));
        tabHost.addTab(tabHost.newTabSpec(FRIDAY_TAB_TAG)
        		.setIndicator(FRIDAY_TAB_TAG)
        		.setContent(new TabContentFactory() {
        			public View createTabContent(String arg0) {
        				return fridayLW;
        			}
        }));
        
        currentDay = getCurrentDayofWeek();
        tabHost.setCurrentTab(currentDay);
	    currentLW = mondayLW;
	    update();
	    
	    intent = new Intent(getApplicationContext(), AddSubjects.class);
	    
    	builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to delete all lessons?")
               .setCancelable(false)
               .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   dm.deleteAllHours();
                       update();
                   }
               })
               .setNegativeButton("No", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                   }
               });
        alert = builder.create();
        
    	builder2 = new AlertDialog.Builder(this);
        builder2.setMessage("Are you sure you want to delete this lesson?")
               .setCancelable(false)
               .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   dm.deleteHour(OLDSName, OLDHDay, OLDHClass, OLDHStart, OLDHEnd);
                       update();
                   }
               })
               .setNegativeButton("No", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                   }
               });
        alert2 = builder2.create();
        
        aboutDialog = new Dialog(this);
        aboutDialog.setContentView(R.layout.aboutdialog);
        aboutDialog.setTitle("About");
        aboutDialog.setCancelable(true);
        Button buttonDialog = (Button) aboutDialog.findViewById(R.id.Button01);
        buttonDialog.setOnClickListener(new OnClickListener() {
        	
        	public void onClick(View v) {
        			aboutDialog.cancel();
        	}
        });
    }
    
    public static int getCurrentDayofWeek() {
    	
    	Calendar c = Calendar.getInstance();
    	int currentDay = c.get(Calendar.DAY_OF_WEEK);
    	switch (currentDay) 
    	{
    	case 1:
    		/*Sunday*/
    		currentLW = mondayLW;
    		currentDay = 0;
    		break;
    	case 2:
    		/*Monday*/
    		currentLW = mondayLW;
    		currentDay -= 2;
    		break;
    	case 3:
    		/*Tuesday*/
    		currentLW = tuesdayLW;
    		currentDay -= 2;
    		break;
    	case 4:
    		/*Wednesday*/
    		currentLW = wednesdayLW;
    		currentDay -= 2;
    		break;
    	case 5:
    		/*Thursday*/
    		currentLW = thursdayLW;
    		currentDay -= 2;
    		break;
    	case 6:
    		/*Friday*/
    		currentLW = fridayLW;
    		currentDay -= 2;
    		break;
    	case 7:
    		/*Saturday*/
    		currentLW = mondayLW;
    		currentDay = 0;
    		break;
    	}
		return currentDay;
    }

	public void onTabChanged(String tabName) {
		/** Change the tab content to the appropriated one*/
		
    	if(tabName.equals(MONDAY_TAB_TAG)) {
    		currentLW = mondayLW;
    		currentDay = 0;
    	}
    	else if(tabName.equals(TUESDAY_TAB_TAG)) {
    		currentLW = tuesdayLW;
    		currentDay = 1;
    	}
    	else if(tabName.equals(WEDNESDAY_TAB_TAG)) {
    		currentLW = wednesdayLW;
    		currentDay = 2;
    	}
    	else if(tabName.equals(THURSDAY_TAB_TAG)) {
    		currentLW = thursdayLW;
    		currentDay = 3;
    	}
    	else if(tabName.equals(FRIDAY_TAB_TAG)) {
    		currentLW = fridayLW;
    		currentDay = 4;
    	}
    	update();
    	
        registerForContextMenu(mondayLW);
        registerForContextMenu(tuesdayLW);
        registerForContextMenu(wednesdayLW);
        registerForContextMenu(thursdayLW);
        registerForContextMenu(fridayLW);
    	
    	addDialog = new Dialog(this);
	    addDialog.setCancelable(false);
	    action = "insert";
	    addDialog.setTitle("Add Lesson");
	    addDialog.setContentView(R.layout.addhour);
	    
	    HClass = (EditText) addDialog.findViewById(R.id.classroomEdit);
	    arraydays = new String []{"Monday","Tuesday","Wednesday","Thursday","Friday"};
        HDay = (Spinner) addDialog.findViewById(R.id.day);
        arrayadapter = new ArrayAdapter<String>(this,
        		android.R.layout.simple_spinner_item, arraydays);
        arrayadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        HDay.setAdapter(arrayadapter);
        HDay.setOnItemSelectedListener(new OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {                    
                 selectedDay = arraydays[position];               
            }

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
        });
        
        fromDialog = new TimePickerDialog(this, fromTimeSetListener, 12, 0, true);
        toDialog = new TimePickerDialog(this, toTimeSetListener, 12, 0, true);
        
        SName = (Spinner) addDialog.findViewById(R.id.SName);
        SName.setOnItemSelectedListener(new OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {                    
                 selectedSubject = arraySubjects[position];               
            }

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
        });
        
        Button buttonFrom = (Button) addDialog.findViewById(R.id.buttonFrom);
        buttonFrom.setOnClickListener(new View.OnClickListener() {			
			public void onClick(View v) {
				fromDialog.show();
			}
		});
        
        Button buttonTo = (Button) addDialog.findViewById(R.id.buttonTo);
        buttonTo.setOnClickListener(new View.OnClickListener() {			
			public void onClick(View v) {
				toDialog.show();
			}
		}); 
	    
        start = (TextView) addDialog.findViewById(R.id.start);
	    end = (TextView) addDialog.findViewById(R.id.end);
	    
	    Button cancel = (Button) addDialog.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
                       
        	public void onClick(View v) {
        		addDialog.cancel();
        		fromDialog.updateTime(12, 0);
        		toDialog.updateTime(12, 0);
        		start.setText("--:--");
        		end.setText("--:--");
        		HClass.setText(null);
            }
        	
        });
        
        Button ok = (Button) addDialog.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
                       
        	public void onClick(View v) {                              
        		int HDay = SDay2IDay(selectedDay);
        		if(action.equals("insert"))
        			dm.insertIntoHours(selectedSubject, HDay, HClass.getText().toString(), start.getText().toString(), end.getText().toString());
        		else if(action.equals("edit")) {
        			dm.updateHours(OLDSName, OLDHClass, OLDHDay, OLDHStart, OLDHEnd, selectedSubject, HDay, HClass.getText().toString(), start.getText().toString(), end.getText().toString());
        		}
        		addDialog.cancel();
        		fromDialog.updateTime(12, 0);
        		toDialog.updateTime(12, 0);
        		start.setText("--:--");
        		end.setText("--:--");
        		HClass.setText(null);
        		update();
            }
                        	
        });
        
	}
	
    private TimePickerDialog.OnTimeSetListener fromTimeSetListener =
    	new TimePickerDialog.OnTimeSetListener() {

			public void onTimeSet(TimePicker view, int hour,
					int minute) {
				
				StringBuilder sb = new StringBuilder();
				
				if(hour<10)
					sb.append("0");
				sb.append(hour+":");
				if(minute<10)
					sb.append("0");
				sb.append(minute);
				
				start.setText(sb);
			}

    };
    
    private TimePickerDialog.OnTimeSetListener toTimeSetListener =
    	new TimePickerDialog.OnTimeSetListener() {

			public void onTimeSet(TimePicker view, int hour,
					int minute) {
				
				StringBuilder sb = new StringBuilder();
				
				if(hour<10)
					sb.append("0");
				sb.append(hour+":");
				if(minute<10)
					sb.append("0");
				sb.append(minute);
				
				end.setText(sb);
			}
    };
    
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result = super.onCreateOptionsMenu(menu);
        menu.add(0, 0, 0, "Manage Subjects").setIcon(android.R.drawable.ic_menu_manage);
        menu.add(1, 1, 1, "Add Lesson").setIcon(android.R.drawable.ic_menu_add);
        menu.add(1, 2, 2, "Delete All").setIcon(android.R.drawable.ic_menu_delete);
        menu.add(2, 3, 3, "About").setIcon(android.R.drawable.ic_menu_info_details);
        return result;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
            	startActivityForResult(intent, 0);
                break;
            case 1:
            	action = "insert";
            	ArrayList<HashMap<String, Object>> arrayS = dm.selectSubjects();
            	arraySubjects = new String [arrayS.size()];
                Iterator<HashMap<String, Object>> it = arrayS.iterator();
                int i = 0;
                while(it.hasNext()) {
                	HashMap<String, Object> hm = it.next();
                	arraySubjects[i] = hm.get("SName").toString();
                	i++;
                }
                Sarrayadapter = new ArrayAdapter<String>(this,
                		android.R.layout.simple_spinner_item, arraySubjects);
                Sarrayadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                SName.setAdapter(Sarrayadapter);
                addDialog.setTitle("Add Lesson");
            	addDialog.show();
            	break;
            case 2:
            	alert.show();
            	break;
            case 3:
            	aboutDialog.show();
        }
        return true;
    }
    
    private int SDay2IDay(String selectedDay) {
    	
    	if(selectedDay.equals("Tuesday"))
    		return 1;
    	else if(selectedDay.equals("Wednesday"))
    		return 2;
    	else if(selectedDay.equals("Thursday"))
    		return 3;
    	else if(selectedDay.equals("Friday"))
    		return 4;
    	
    	return 0;
    }
    
    private String IDay2SDay(int selectedDay) {
    	
    	if(selectedDay == 1)
    		return "Tuesday";
    	else if(selectedDay == 2)
    		return "Wednesday";
    	else if(selectedDay == 3)
    		return "Thursday";
    	else if(selectedDay == 4)
    		return "Friday";
    	
    	return "Monday";
    }
    
    private void update() {
    	
    	results = dm.selectAllFromDay(currentDay);
		colorVet = new String[results.size()];
	    for(int i=0;i<results.size();i++) {
	    	HashMap<String, Object> color = 
	    		new HashMap<String, Object>();
	    	color = results.get(i);
	    	colorVet[i] = (String) color.get("SColor");
	    }
	    simpleAdapter = new myAdapter(this, results, R.layout.daylist, from, to, colorVet);
	    currentLW.setAdapter(simpleAdapter); 
    }
    
	public class myAdapter extends SimpleAdapter{
        
		String[] colors;
        public myAdapter(Context context, List<? extends Map<String, ?>> data,
        	int resource, String[] from, int[] to, String[] col) {
            	super(context, data, resource, from, to);
                colors = col;
        	}
            public View getView(int position, View convertView, ViewGroup parent ) {
            	View view = super.getView(position, convertView, parent);
            	View label = view.findViewById(R.id.colorLabel);
                label.setBackgroundColor(Color.parseColor(colors[position]));
                return view;
            }
    }
	
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
    	super.onCreateContextMenu(menu, v, menuInfo);
    	menu.add(0, 1, 0, "Edit");
    	menu.add(0, 2, 0, "Delete");
    	menu.setHeaderTitle("Options");	
    }
    
    public boolean onContextItemSelected(MenuItem item) {
    	
    	AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
    	String course = results.get(info.position).get("SName").toString();
    	String classroom = results.get(info.position).get("HClass").toString();
    	String startH = results.get(info.position).get("HStart").toString();
    	String endH = results.get(info.position).get("HEnd").toString();
    	int day = currentDay;
    	
    	switch (item.getItemId()) {
        	case 1:
        		action = "edit";
            	ArrayList<HashMap<String, Object>> arrayS = dm.selectSubjects();
            	arraySubjects = new String [arrayS.size()];
                Iterator<HashMap<String, Object>> it = arrayS.iterator();
                int i = 0;
                while(it.hasNext()) {
                	HashMap<String, Object> hm = it.next();
                	arraySubjects[i] = hm.get("SName").toString();
                	i++;
                }
                Sarrayadapter = new ArrayAdapter<String>(this,
                		android.R.layout.simple_spinner_item, arraySubjects);
                Sarrayadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                SName.setAdapter(Sarrayadapter);
        		SName.setSelection(Sarrayadapter.getPosition(course));
        		String dayS = IDay2SDay(day);
        		HDay.setSelection(arrayadapter.getPosition(dayS));
            	CharSequence fhour = startH.subSequence(0, 2);
            	CharSequence fminutes = startH.subSequence(3, 5);
            	CharSequence thour = endH.subSequence(0, 2);
            	CharSequence tminutes = endH.subSequence(3, 5);
            	int fhourInt;
            	int fminutesInt;
            	try{
                	fhourInt = Integer.parseInt((String)fhour);
                	fminutesInt = Integer.parseInt((String)fminutes);
            	} catch(Exception e) {
            		fhourInt = 12;
                	fminutesInt = 0;
            	}
            	int thourInt;
            	int tminutesInt;
            	try{
                	thourInt = Integer.parseInt((String)thour);
                	tminutesInt = Integer.parseInt((String)tminutes);
            	} catch(Exception e) {
            		thourInt = 12;
                	tminutesInt = 0;
            	}
        		fromDialog.updateTime(fhourInt, fminutesInt);
        		toDialog.updateTime(thourInt, tminutesInt);
        		start.setText(startH);
        		end.setText(endH);
        		HClass.setText(classroom);
        		addDialog.setTitle("Edit Lesson");
        		OLDSName = course;
        		OLDHClass = classroom;
        		OLDHDay = day;
        		OLDHStart = startH;
        		OLDHEnd = endH;
        		addDialog.show();
        		break;
        	case 2:
        		OLDSName = course;
        		OLDHClass = classroom;
        		OLDHDay = day;
        		OLDHStart = startH;
        		OLDHEnd = endH;
        		alert2.show();
        		break;
    	}
    	update();
    	return true;
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		update();
	}
    
}
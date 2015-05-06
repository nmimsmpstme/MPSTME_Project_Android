package com.example.skinani.reachsafe;

import android.app.Activity;
    import android.os.Bundle;
    import android.content.Intent;
    import android.view.View;
    import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.Button;
    import android.view.Menu;
    import android.view.MenuInflater;
    import android.view.MenuItem;
    import android.widget.Toast;

import java.lang.reflect.Field;

public class Menu2 extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.menu);

            Button s = (Button) findViewById(R.id.button1);
            Button m = (Button) findViewById(R.id.button2);
            s.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.button1:
                            startActivity(new Intent(Menu2.this, Contact.class));
                            break;
                        case R.id.button2:
                            break;
                    }


                }
            });
            m.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.button1:
                            break;
                        case R.id.button2:
                            startActivity(new Intent(Menu2.this, Multimode.class));
                            break;
                    }


                }
            });
        }
            private void getOverflowMenu() {

                try {
                    ViewConfiguration config = ViewConfiguration.get(this);
                    Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
                    if(menuKeyField != null) {
                        menuKeyField.setAccessible(true);
                        menuKeyField.setBoolean(config, false);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.items, menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            super.onOptionsItemSelected(item);

            switch (item.getItemId()) {
                case R.id.help:
                    Toast.makeText(getBaseContext(), "Help", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.settings:
                    Toast.makeText(getBaseContext(), "Settings", Toast.LENGTH_SHORT).show();
                    break;


            }
            return true;


        }
            }




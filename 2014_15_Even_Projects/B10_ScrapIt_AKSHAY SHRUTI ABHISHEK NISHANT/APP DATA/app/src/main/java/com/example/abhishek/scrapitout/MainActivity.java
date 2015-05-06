package com.example.abhishek.scrapitout;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginscreen.R;

import static com.example.loginscreen.R.id.button1;
import static com.example.loginscreen.R.id.button2;

public class MainActivity extends Activity implements View.OnClickListener {

    private EditText  username=null;
    private EditText  password=null;
    private TextView attempts;
    private Button button1;
    private Button button2;
    private Button start;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.editText1);
        password = (EditText)findViewById(R.id.editText2);
        button1 = (Button)findViewById(R.id.button1);
        Button b = (Button) findViewById(R.id.button2);


        b.setOnClickListener(this);
        TextView txt = (TextView) findViewById(R.id.custom_font);
        Typeface font = Typeface.createFromAsset(getAssets(), "Archistico_Bold.ttf");
        txt.setTypeface(font);



    }



    private void findViewById(Button button2) {
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }






    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, registration.class);

        // calling an activity using <intent-filter> action name
        //  Intent inent = new Intent("com.hmkcode.android.ANOTHER_ACTIVITY");

        startActivity(intent);
    }


}

package com.example.smitd.appproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class second_page extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);

        TextView textView=(TextView) findViewById(R.id.textView1);

        String passedArg = getIntent().getExtras().getString("arg");
        textView.setText(passedArg);

    }
}

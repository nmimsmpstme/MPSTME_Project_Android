package com.example.abhishek.scrapitout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginscreen.R;

public class registration extends MainActivity implements View.OnClickListener{
    Button button1;
    EditText rName, rAddress, rPhone, rUsername, rPassword, rConfirm, rEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeration);

        Button b=(Button)findViewById(R.id.button1);
        b.setOnClickListener(this);
        TextView txt = (TextView) findViewById(R.id.textView1);
        Typeface font = Typeface.createFromAsset(getAssets(), "Archistico_Bold.ttf");
        txt.setTypeface(font);

    }
    @Override
    public void onClick(View v){
        Intent i = new Intent(this, homepage.class);
        startActivity(i);
    }

}

package com.example.samarth.zippyfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class welcome1 extends ActionBarActivity {

    EditText name;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome1);

        name = (EditText)findViewById(R.id.nameEdit);
        send = (Button)findViewById(R.id.sendButton);


        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(name.getText() != null || !name.getText().equals("")){
                    Intent intent = new Intent(welcome1.this, welcome2.class);
                    intent.putExtra("NAME", name.getText().toString());
                    name.setText("");
                    startActivity(intent);
                }
            }
        });
    }
}
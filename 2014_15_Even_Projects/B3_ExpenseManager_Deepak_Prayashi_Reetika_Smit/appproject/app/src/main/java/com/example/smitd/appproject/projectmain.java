package com.example.smitd.appproject;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class projectmain extends ActionBarActivity {
    EditText e1,e2,e3;
    Button b1,b2;
    static projectmain p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectmain);
         p=this;
        e1=(EditText)findViewById(R.id.income);
        e2=(EditText)findViewById(R.id.expense);
        e3=(EditText)findViewById(R.id.balance);
        b1=(Button)findViewById(R.id.btncalc);
        b2=(Button)findViewById(R.id.nextpage);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(e1.getText().toString());
                int y = Integer.parseInt(e2.getText().toString());
                if(x>=y)
                {
                    int z = x - y;
                    e3.setText(Integer.toString(z));
                }
                else
                {
                    Toast.makeText(projectmain.this, "Expense higher than income", Toast.LENGTH_LONG).show();
                }

            }
        });
        final Context context=(Context) this;
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent i = new Intent(getApplicationContext(), MainActivity2.class);

                startActivityForResult(i,101);*/

                Intent i=new Intent(projectmain.this,MainActivity2.class);
                String bal=e3.getText().toString();
                i.putExtra("secpg",bal);
                startActivity(i);
            }
        });
}
    }

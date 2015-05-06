package com.example.shreyalgelani.gmal;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.content.DialogInterface;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Thread.sleep;


public class form1 extends ActionBarActivity implements View.OnClickListener {
    TextView textFile;
    private static final int PICKFILE_RESULT_CODE = 1;


    EditText from, to, reason, load;
    Button submit;
    RadioButton r1, r2, r3;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form1);
        Button buttonPick = (Button) findViewById(R.id.button6);
        textFile = (TextView) findViewById(R.id.editText15);

        submit = (Button) findViewById(R.id.button);
        from = (EditText) findViewById(R.id.editText12);
        to = (EditText) findViewById(R.id.editText13);
        reason = (EditText) findViewById(R.id.editText14);
        load = (EditText) findViewById(R.id.editText15);

        rg = (RadioGroup) findViewById(R.id.rg1);
        r1 = (RadioButton) findViewById(R.id.crbtn);
        r2 = (RadioButton) findViewById(R.id.srbtn);
        r3 = (RadioButton) findViewById(R.id.drbtn);

        buttonPick.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("file/*");
                startActivityForResult(intent, PICKFILE_RESULT_CODE);

            }
        });
        submit.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        switch (requestCode) {
            case PICKFILE_RESULT_CODE:
                if (resultCode == RESULT_OK) {
                    String FilePath = data.getData().getPath();
                    textFile.setText(FilePath);
                }
                break;

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View arg0) {
        boolean didItWork = true;

        try {

            String fromd = from.getText().toString();
            String tod = to.getText().toString();
            String reas = reason.getText().toString();
            String ld = load.getText().toString();
            String status = "pending";
            int srd = rg.getCheckedRadioButtonId();
            FM1 entry = new FM1(form1.this);
            entry.open();
            entry.createEntry(fromd, tod, reas, ld, srd,status);
            entry.close();

        } catch (Exception e) {
            didItWork = false;
        }
        finally {
            if(didItWork){
                Dialog d =new Dialog(this);
                d.setTitle("SUBMITTED");
                TextView tv = new TextView(this);
                tv.setText("PENDING");
                d.setContentView(tv);

                Context context = getApplicationContext();
                Toast toast=Toast.makeText(context , "SUBMITTED",Toast.LENGTH_LONG);
                toast.show();
                Intent intent = new Intent(this, Fac_inbox.class);

                startActivity(intent);
            }
        }
    }
}
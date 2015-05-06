package com.dummies.android.taskreminder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by Sashank on 23-03-2015.
 */
public class TaskList extends Activity {
    protected RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.task_list);
        radioGroup = (RadioGroup) findViewById(R.id.myRadioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.radioButton5)
                {
                    Intent in=new Intent(getApplicationContext(),ReminderEditActivity.class);
                }
                RadioButton rd=(RadioButton)findViewById(checkedId);
                String title=rd.getText().toString();
                Intent in=new Intent(getApplicationContext(),ReminderEditActivity.class);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                in.putExtra("title",title);
                startActivity(in);
                finish();
            }
        });

            }

    @Override
    protected void onResume() {
        super.onResume();

    }


}








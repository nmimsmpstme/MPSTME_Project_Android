package com.example.samarth.zippyfood;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class welcome2 extends ActionBarActivity {

    TextView nameText;
    Button button38;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome2);

        button38 = (Button) findViewById(R.id.button38);
        button38.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                nameText = (TextView) findViewById(R.id.nameText);
                Intent intent = getIntent();
                String name = intent.getStringExtra("NAME");
                nameText.setText(name);

                Intent intent1 = new Intent(v.getContext(), menu.class);
                startActivityForResult(intent1, 0);

                            }


    });

}
}

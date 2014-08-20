package com.example.scoreit;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
 
public class angry extends Activity implements
        OnRatingBarChangeListener {
    RatingBar getRatingBar;
    RatingBar setRatingBar;
    TextView countText;
    ImageButton btn;
    int count;
    float curRate;
    Intent intent;
 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.angrybirds);
 
        findViewsById();
 
        setRatingBar.setRating(curRate);
        getRatingBar.setOnRatingBarChangeListener(this);
        btn=(ImageButton)findViewById(R.id.downloadButton);
        
        btn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("market://details?id=com.rovio.angrybirds"));
				startActivity(intent);
			}
        });
		
    }
 
    private void findViewsById() {
        getRatingBar = (RatingBar) findViewById(R.id.getRating);
        setRatingBar = (RatingBar) findViewById(R.id.setRating);
        countText = (TextView) findViewById(R.id.countText);
    }
 
    public void onRatingChanged(RatingBar rateBar, float rating,
            boolean fromUser) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        curRate = Float.valueOf(decimalFormat.format((curRate * count + rating)
                / ++count));
        Toast.makeText(angry.this,
                "New Rating: " + curRate, Toast.LENGTH_SHORT).show();
        setRatingBar.setRating(curRate);
        countText.setText(count + " Ratings");
    }
    
}
package com.example.voice;




import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
public class ResultActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		//get rating bar object
		RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1); 
		bar.setNumStars(5);
		bar.setStepSize(0.5f);
		//get text view
		TextView t=(TextView)findViewById(R.id.textResult);
		//get score
		Bundle b = getIntent().getExtras();
		int score= b.getInt("score");
		
		Toast.makeText(this, score+"", Toast.LENGTH_SHORT).show();
		//display score
		bar.setRating(score);
		switch (score)
		{
		case 1:
		case 2: t.setText(" Better Luck next time!");
		break;
		case 3:t.setText("Good job!");
		break;
		case 4:
		case 5:t.setText("Your a champion!");
		break;
		}
	}
	
}

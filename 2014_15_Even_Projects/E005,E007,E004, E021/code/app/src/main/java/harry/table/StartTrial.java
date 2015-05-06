package harry.table;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.graphics.Outline;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class StartTrial extends Activity{
    private RadioGroup radioGroup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firsttrial);
        Animation vanish = AnimationUtils.loadAnimation(this, R.anim.anim);
        findViewById(R.id.buttonOpenDB).startAnimation(vanish);
        findViewById(R.id.radioGroupDays).startAnimation(vanish);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupDays);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId == R.id.rMon) {
              Toast.makeText(getApplicationContext(), "Day of the week: Monday",
                      Toast.LENGTH_SHORT).show();
            } else if(checkedId == R.id.rTues) {
              Toast.makeText(getApplicationContext(), "Day of the week: Tuesday",
                      Toast.LENGTH_SHORT).show();
            } else if(checkedId == R.id.rWed) {
                Toast.makeText(getApplicationContext(), "Day of the week: Wednesday",
                        Toast.LENGTH_SHORT).show();
            } else if(checkedId == R.id.rThurs) {
                Toast.makeText(getApplicationContext(), "Day of the week: Thursday",
                        Toast.LENGTH_SHORT).show();
            } else if(checkedId == R.id.rFri) {
                Toast.makeText(getApplicationContext(), "Day of the week: Friday",
                        Toast.LENGTH_SHORT).show();
            } else {
              Toast.makeText(getApplicationContext(), "Day of the week: Saturday",
                      Toast.LENGTH_SHORT).show();
              }
            }

        });

    }

    public void onClick(View v){

        if(v.getId()==R.id.buttonOpenDB){
            Log.d("harry","click hua");
            Intent i = new Intent(this, DbMain.class);
            startActivity(i);
        }
    }
}

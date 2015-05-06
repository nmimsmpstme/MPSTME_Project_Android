package com.example.mihirsaxena.myproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.DialogPreference;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class color extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        final TextView color = (TextView)findViewById(R.id.color);
        final Button color1 = (Button)findViewById(R.id.color1);
        final Button color2 = (Button)findViewById(R.id.color2);
        final Button color3 = (Button)findViewById(R.id.color3);

        int x = 1;
        final int[] correct = {0};
        color.setText("Green");
        color1.setBackgroundResource(R.drawable.red);
        color2.setBackgroundResource(R.drawable.green);
        color3.setBackgroundResource(R.drawable.black);
/*        while(x<9) {
            if (color.getText() == "Green") {
                color2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        color.setText("Black");
                        color1.setBackgroundResource(R.drawable.yellow);
                        color2.setBackgroundResource(R.drawable.green);
                        color3.setBackgroundResource(R.drawable.black);
                        correct[0]++;

                    }
                });
                color1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                        color.setText("Black");
                        color1.setBackgroundResource(R.drawable.yellow);
                        color2.setBackgroundResource(R.drawable.green);
                        color3.setBackgroundResource(R.drawable.black);
                    }
                });

                color3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                        color.setText("Black");
                        color1.setBackgroundResource(R.drawable.yellow);
                        color2.setBackgroundResource(R.drawable.green);
                        color3.setBackgroundResource(R.drawable.black);
                    }
                });
            } else if (color.getText() == "Black") {
                color3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        color.setText("Red");
                        color1.setBackgroundResource(R.drawable.red);
                        color2.setBackgroundResource(R.drawable.blue);
                        color3.setBackgroundResource(R.drawable.yellow);
                        correct[0]++;
                    }
                });

                color1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                        color.setText("Red");
                        color1.setBackgroundResource(R.drawable.red);
                        color2.setBackgroundResource(R.drawable.blue);
                        color3.setBackgroundResource(R.drawable.yellow);
                    }
                });

                color2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                        color.setText("Red");
                        color1.setBackgroundResource(R.drawable.red);
                        color2.setBackgroundResource(R.drawable.blue);
                        color3.setBackgroundResource(R.drawable.yellow);
                    }
                });
            } else if (color.getText() == "Red") {
                color1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        color.setText("Blue");
                        color1.setBackgroundResource(R.drawable.blue);
                        color2.setBackgroundResource(R.drawable.green);
                        color3.setBackgroundResource(R.drawable.red);
                        correct[0]++;
                    }
                });

                color2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                        color.setText("Blue");
                        color1.setBackgroundResource(R.drawable.blue);
                        color2.setBackgroundResource(R.drawable.green);
                        color3.setBackgroundResource(R.drawable.red);
                    }
                });

                color3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                        color.setText("Blue");
                        color1.setBackgroundResource(R.drawable.blue);
                        color2.setBackgroundResource(R.drawable.green);
                        color3.setBackgroundResource(R.drawable.red);
                    }
                });
            } else if (color.getText() == "Blue") {
                color1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        color.setText("Yellow");
                        color1.setBackgroundResource(R.drawable.brown);
                        color2.setBackgroundResource(R.drawable.black);
                        color3.setBackgroundResource(R.drawable.yellow);
                        correct[0]++;
                    }
                });

                color2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                        color.setText("Yellow");
                        color1.setBackgroundResource(R.drawable.brown);
                        color2.setBackgroundResource(R.drawable.black);
                        color3.setBackgroundResource(R.drawable.yellow);
                    }
                });

                color3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                        color.setText("Yellow");
                        color1.setBackgroundResource(R.drawable.brown);
                        color2.setBackgroundResource(R.drawable.black);
                        color3.setBackgroundResource(R.drawable.yellow);
                    }
                });
            } else if (color.getText() == "Yellow") {
                color3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        color.setText("Pink");
                        color1.setBackgroundResource(R.drawable.orange);
                        color2.setBackgroundResource(R.drawable.pink);
                        color3.setBackgroundResource(R.drawable.red);
                        correct[0]++;
                    }
                });

                color1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                        color.setText("Pink");
                        color1.setBackgroundResource(R.drawable.orange);
                        color2.setBackgroundResource(R.drawable.pink);
                        color3.setBackgroundResource(R.drawable.red);
                    }
                });

                color2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                        color.setText("Pink");
                        color1.setBackgroundResource(R.drawable.orange);
                        color2.setBackgroundResource(R.drawable.pink);
                        color3.setBackgroundResource(R.drawable.red);
                    }
                });
            } else if (color.getText() == "Pink") {
                color2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        color.setText("Brown");
                        color1.setBackgroundResource(R.drawable.brown);
                        color2.setBackgroundResource(R.drawable.orange);
                        color3.setBackgroundResource(R.drawable.black);
                        correct[0]++;
                    }
                });

                color1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                        color.setText("Black");
                        color1.setBackgroundResource(R.drawable.brown);
                        color2.setBackgroundResource(R.drawable.orange);
                        color3.setBackgroundResource(R.drawable.black);

                    }
                });

                color3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                        color.setText("Black");
                        color1.setBackgroundResource(R.drawable.brown);
                        color2.setBackgroundResource(R.drawable.orange);
                        color3.setBackgroundResource(R.drawable.black);

                    }
                });
            } else if (color.getText() == "Brown") {
                color1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        color.setText("Orange");
                        color1.setBackgroundResource(R.drawable.pink);
                        color2.setBackgroundResource(R.drawable.blue);
                        color3.setBackgroundResource(R.drawable.orange);
                        correct[0]++;
                    }
                });

                color2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                        color.setText("Orange");
                        color1.setBackgroundResource(R.drawable.pink);
                        color2.setBackgroundResource(R.drawable.blue);
                        color3.setBackgroundResource(R.drawable.orange);
                    }
                });

                color3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                        color.setText("Orange");
                        color1.setBackgroundResource(R.drawable.pink);
                        color2.setBackgroundResource(R.drawable.blue);
                        color3.setBackgroundResource(R.drawable.orange);
                    }
                });
            } else if (color.getText() == "Orange") {
                color2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        correct[0]++;

                        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                        builder.setTitle("SCORECARD")
                                .setMessage("Your Score is : " + correct[0])
                                .setNeutralButton("Play Again", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent i = new Intent(color.this, menu.class);
                                        color.this.startActivity(i);
                                    }
                                });
                    }
                });

                color1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                        builder.setTitle("SCORECARD")
                                .setMessage("Your Score is : " + correct[0])
                                .setNeutralButton("Play Again", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent i = new Intent(color.this, menu.class);
                                        color.this.startActivity(i);
                                    }
                                });
                    }
                });

                color3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                        builder.setTitle("SCORECARD")
                                .setMessage("Your Score is : " + correct[0])
                                .setNeutralButton("Play Again", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent i = new Intent(color.this, menu.class);
                                        color.this.startActivity(i);
                                    }
                                });
                    }
                });
            }
            x++;
        }
*/

        color1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(color.getText() == "Red")
                {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    color.setText("Blue");
                    color1.setBackgroundResource(R.drawable.blue);
                    color2.setBackgroundResource(R.drawable.green);
                    color3.setBackgroundResource(R.drawable.red);
                    correct[0]++;
                }
                else if(color.getText() == "Blue")
                {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    color.setText("Yellow");
                    color1.setBackgroundResource(R.drawable.brown);
                    color2.setBackgroundResource(R.drawable.black);
                    color3.setBackgroundResource(R.drawable.yellow);
                    correct[0]++;
                }
                else if(color.getText() == "Brown")
                {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    color.setText("Orange");
                    color1.setBackgroundResource(R.drawable.pink);
                    color2.setBackgroundResource(R.drawable.orange);
                    color3.setBackgroundResource(R.drawable.red);
                    correct[0]++;
                }

                else if(color.getText() == "Green")
                {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    color.setText("Black");
                    color1.setBackgroundResource(R.drawable.yellow);
                    color2.setBackgroundResource(R.drawable.green);
                    color3.setBackgroundResource(R.drawable.black);
                }

                else if(color.getText() == "Black")
                {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    color.setText("Red");
                    color1.setBackgroundResource(R.drawable.red);
                    color2.setBackgroundResource(R.drawable.blue);
                    color3.setBackgroundResource(R.drawable.yellow);
                }

                else if(color.getText() == "Orange")
                {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                    builder.setTitle("SCORECARD")
                            .setMessage("Your Score is : " + correct[0])
                            .setNeutralButton("Play Again", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent(color.this, menu.class);
                                    color.this.startActivity(i);
                                }
                            });
                }

                else if(color.getText() == "Pink")
                {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    color.setText("Brown");
                    color1.setBackgroundResource(R.drawable.brown);
                    color2.setBackgroundResource(R.drawable.orange);
                    color3.setBackgroundResource(R.drawable.black);
                }

                else if(color.getText() == "Yellow")
                {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    color.setText("Pink");
                    color1.setBackgroundResource(R.drawable.orange);
                    color2.setBackgroundResource(R.drawable.pink);
                    color3.setBackgroundResource(R.drawable.red);
                }
            }
        });
        color2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(color.getText() == "Green")
                {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    color.setText("Black");
                    color1.setBackgroundResource(R.drawable.yellow);
                    color2.setBackgroundResource(R.drawable.green);
                    color3.setBackgroundResource(R.drawable.black);
                    correct[0]++;
                }
                else if(color.getText() == "Red")
                {

                        Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                        color.setText("Blue");
                        color1.setBackgroundResource(R.drawable.blue);
                        color2.setBackgroundResource(R.drawable.green);
                        color3.setBackgroundResource(R.drawable.red);

                }

                else if(color.getText() == "Pink")
                {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    color.setText("Brown");
                    color1.setBackgroundResource(R.drawable.brown);
                    color2.setBackgroundResource(R.drawable.orange);
                    color3.setBackgroundResource(R.drawable.black);
                    correct[0]++;
                }

                else if(color.getText() == "Orange")
                {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    correct[0]++;

                    AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                    builder.setTitle("SCORECARD")
                            .setMessage("Your Score is : " + correct[0])
                            .setNeutralButton("Play Again", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent(color.this, menu.class);
                                    color.this.startActivity(i);
                                }
                            });

                }

                else if(color.getText() == "Black")
                {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    color.setText("Red");
                    color1.setBackgroundResource(R.drawable.red);
                    color2.setBackgroundResource(R.drawable.blue);
                    color3.setBackgroundResource(R.drawable.yellow);
                }

                else if(color.getText() == "Brown")
                {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    color.setText("Orange");
                    color1.setBackgroundResource(R.drawable.pink);
                    color2.setBackgroundResource(R.drawable.orange);
                    color3.setBackgroundResource(R.drawable.blue);
                }

                else if(color.getText() == "Blue")
                {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    color.setText("Yellow");
                    color1.setBackgroundResource(R.drawable.brown);
                    color2.setBackgroundResource(R.drawable.black);
                    color3.setBackgroundResource(R.drawable.yellow);
                }

                else if(color.getText() == "Yellow")
                {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    color.setText("Pink");
                    color1.setBackgroundResource(R.drawable.orange);
                    color2.setBackgroundResource(R.drawable.pink);
                    color3.setBackgroundResource(R.drawable.red);
                }
            }
        });

        color3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(color.getText() == "Black")
                {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    color.setText("Red");
                    color1.setBackgroundResource(R.drawable.red);
                    color2.setBackgroundResource(R.drawable.blue);
                    color3.setBackgroundResource(R.drawable.yellow);
                    correct[0]++;
                }
                else if(color.getText() == "Red")
                {
                        Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                        color.setText("Blue");
                        color1.setBackgroundResource(R.drawable.blue);
                        color2.setBackgroundResource(R.drawable.green);
                        color3.setBackgroundResource(R.drawable.red);

                }
                else if(color.getText() == "Yellow")
                {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    color.setText("Pink");
                    color1.setBackgroundResource(R.drawable.orange);
                    color2.setBackgroundResource(R.drawable.pink);
                    color3.setBackgroundResource(R.drawable.red);
                    correct[0]++;
                }

                else if(color.getText() == "Brown")
                {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    color.setText("Orange");
                    color1.setBackgroundResource(R.drawable.pink);
                    color2.setBackgroundResource(R.drawable.orange);
                    color3.setBackgroundResource(R.drawable.blue);
                }

                else if(color.getText() == "Orange")
                {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                    builder.setTitle("SCORECARD")
                            .setMessage("Your Score is : " + correct[0])
                            .setNeutralButton("Play Again", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent(color.this, menu.class);
                                    color.this.startActivity(i);
                                }
                            });

                }

                else if(color.getText() == "Pink")
                {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    color.setText("Brown");
                    color1.setBackgroundResource(R.drawable.brown);
                    color2.setBackgroundResource(R.drawable.orange);
                    color3.setBackgroundResource(R.drawable.black);
                }

                else if(color.getText() == "Blue")
                {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    color.setText("Yellow");
                    color1.setBackgroundResource(R.drawable.brown);
                    color2.setBackgroundResource(R.drawable.black);
                    color3.setBackgroundResource(R.drawable.yellow);
                }

                else if(color.getText() == "Green")
                {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    color.setText("Black");
                    color1.setBackgroundResource(R.drawable.yellow);
                    color2.setBackgroundResource(R.drawable.green);
                    color3.setBackgroundResource(R.drawable.black);
                }
            }
        });


/*        color1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(color.getText() == "Green")
                {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    color.setText("Black");
                    color1.setBackgroundResource(R.drawable.yellow);
                    color2.setBackgroundResource(R.drawable.green);
                    color3.setBackgroundResource(R.drawable.black);
                }
                else if(color.getText() == "Black")
                {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    color.setText("Black");
                    color1.setBackgroundResource(R.drawable.yellow);
                    color2.setBackgroundResource(R.drawable.blue);
                    color3.setBackgroundResource(R.drawable.black);
                }
            }
        });

        color2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(color.getText() == "Green")
                {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    color.setText("Black");
                    color1.setBackgroundResource(R.drawable.black);
                    color2.setBackgroundResource(R.drawable.green);
                    color3.setBackgroundResource(R.drawable.black);
                }
                else if(color.getText() == "Black")
                {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    color.setText("Black");
                    color1.setBackgroundResource(R.drawable.yellow);
                    color2.setBackgroundResource(R.drawable.blue);
                    color3.setBackgroundResource(R.drawable.black);
                }
            }
        });
        */
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_color, menu);
        return true;
    }

}

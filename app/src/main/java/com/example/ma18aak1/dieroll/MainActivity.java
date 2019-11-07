package com.example.ma18aak1.dieroll;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView title;
    private EditText userinput;
    private int counter = 0;
    private TextView userpoints;
    private TextView info;
    private Button dieroll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        info = (TextView) findViewById(R.id.info);
        title = (TextView) findViewById(R.id.title);
        userinput = (EditText) findViewById(R.id.userInput);
        userpoints = (TextView) findViewById(R.id.userpoints);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void on_button_click(View view) {
        //Rollind the die/button
        TextView tv = (TextView) this.findViewById(R.id.dieroll);
        Random r = new Random();
        int number = r.nextInt(6) + 1;
        tv.setText(Integer.toString(number));

        //UserInput casted to Integer
        int n = Integer.parseInt(userinput.getText().toString());

        if (n < 1 || n > 6) {

            //UserInput validation
            Toast.makeText(this, "Error, Please Input a number between 1 - 6", Toast.LENGTH_SHORT).show();
        } else if (n == number) {
            //correct answer
            Toast.makeText(this, "Congratulations, you guessed the right number!", Toast.LENGTH_SHORT).show();
            counter = counter + 1;
            userpoints.setText(Integer.toString(counter));


        }
    }

    public void on_button_icebreaker(View view) {

        Random r = new Random();
        int number = r.nextInt(6) + 1;

        if (number == 1) {
            Toast.makeText(this, "If you could go anywhere in the world, where would you go?", Toast.LENGTH_SHORT).show();
        }
        else if (number ==2){
            Toast.makeText(this, "If you were stranded on a desert island, what three things would you want to take with you?", Toast.LENGTH_SHORT).show();
        }
        else if (number ==3){
            Toast.makeText(this, "If you could eat only one food for the rest of your life, what would that be?", Toast.LENGTH_SHORT).show();
        }
        else if (number ==4){
            Toast.makeText(this, "If you won a million dollars, what is the first thing you would buy?", Toast.LENGTH_SHORT).show();
        }
        else if (number ==5){
            Toast.makeText(this, "If you could spaned the day with one fictional character, who would it be?", Toast.LENGTH_SHORT).show();
        }
        else if (number ==6){
            Toast.makeText(this, "If you found a magic lantern and a genie gave you three wishes, what would you wish?", Toast.LENGTH_SHORT).show();
        }
    }

    public void newicebreaker(View view){}

}
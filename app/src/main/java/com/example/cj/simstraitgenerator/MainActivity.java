package com.example.cj.simstraitgenerator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    int chance = 0; //randomization modifier
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Start

        //Drop down menu
        Spinner spinner = (Spinner) findViewById(R.id.age_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.age_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        //Set the randomization chance
        Object x = parent.getItemAtPosition(pos);
        String mark = x.toString();
        switch(mark){
            case "Birth": chance = 1; break;
            case "Child": chance = 2; break;
            case "Teen": chance = 3; break;
            default: chance = 4; break;
        }
        showOdds();
        //Toast.makeText(getApplicationContext(), mark, Toast.LENGTH_SHORT).show();
}

    private void showOdds() {
        TextView t = (TextView) findViewById(R.id.odds);
        switch(chance){
            case 1:
                t.setText("Odds:     Parent: 50%     Random: 50%");
                break;
            case 2:
                t.setText("Odds:     Parent: 40%     Skill: 30%     Random: 40%");
                break;
            case 3:
                t.setText("Odds:     Parent: 30%     Skill: 30%     Random: 40%");
                break;
            default:
                t.setText("Odds:     Parent: 20%     Skill: 40%     Random: 40%");
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void generation(View view){
        int choice = rand.nextInt(10) + 1;
        switch (chance){
            case 1:
                if (choice <= 5){
                    display(1); //parent - 50%
                }
                else{
                    display(3); //random - 50%
                }
                break;
            case 2:
                if (choice <= 4){
                    display(1); //parent - 40%
                }
                else if (choice <= 7){
                    display(2); //skill - 30%
                }
                else{
                    display(3); //random - 30%
                }
                break;
            case 3:
                if (choice <= 3){
                    display(1); //parent - 30%
                }
                else if (choice <= 6){
                    display(2); //skill - 30%
                }
                else{
                    display(3); //random - 40%
                }
                break;
            default:
                if (choice <= 2){
                    display(1); //parent - 20%
                }
                else if (choice <= 6){
                    display(2); //skill - 40%
                }
                else{
                    display(3); //random - 40%
                }
                break;
        }
        //Toast.makeText(getApplicationContext(), "Button Pressed", Toast.LENGTH_SHORT).show();
    }

    public void display(int result){
        TextView tv = (TextView) findViewById(R.id.result_view);
        switch(result){
            case 1:
                tv.append("Look to the parent's traits!\n"); break;
            case 2:
                tv.append("Look to the skills!\n"); break;
            default:
                tv.append("Randomize it!\n"); break;
        }
    }

    public void clear(View view){
        TextView tv = (TextView) findViewById(R.id.result_view);
        tv.setText("Results\n");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.trait_menu, menu);
        inflater.inflate(R.menu.menu_main, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){
            case R.id.generator:
                mainActivity();
                return true;
            case R.id.determiner:
                chooseActivity();
                return true;
            case R.id.choose_action_button:
                chooseActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

        /*
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);*/
    }

    private void mainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void chooseActivity() {
        Intent intent = new Intent(this, ChooseActivity.class);
        startActivity(intent);
    }
}

package com.example.cj.simstraitgenerator;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Vector;


public class ChooseActivity extends ActionBarActivity {

    Vector<String> vector = new Vector<String>();
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        /*
        EditText editText = (EditText) findViewById(R.id.trait_field);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND){
                    addTrait(this);
                    handled = true;
                }
                return handled;
            }
        })*/
    }

    public void addTrait(View view) {
        EditText editText = (EditText) findViewById(R.id.trait_field);
        String a = editText.getText().toString();
        vector.add(a);
        TextView t = (TextView) findViewById(R.id.trait_view);
        t.append(a + "\n");
        editText.selectAll();
        Toast.makeText(getApplicationContext(), a, Toast.LENGTH_SHORT).show();
    }

    public void reset(View view){
        vector.clear();
        TextView tv = (TextView) findViewById(R.id.trait_view);
        tv.setText(R.string.trait_label);
        Toast.makeText(getApplicationContext(), "Cleared", Toast.LENGTH_SHORT).show();
    }

    public void determine(View v)
    {
        int choice = rand.nextInt(vector.size());
        TextView tv = (TextView) findViewById(R.id.winner_view);
        tv.setText("Winner: " + vector.get(choice));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.trait_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){
            case R.id.main_action_button:
                mainActivity();
                return true;
            case R.id.choose_action_button:
                //chooseActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void mainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /* Don't need this anymore
    private void chooseActivity() {
        Intent intent = new Intent(this, ChooseActivity.class);
        startActivity(intent);
    }*/
}

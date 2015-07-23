package com.example.cj.simstraitgenerator;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class TraitListActivity extends ListActivity {
    ArrayList<String> chosen = new ArrayList<String>();
    int traitCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_trait_list);

        //final ListView listView = (ListView) findViewById(this)
        String[] traits = {"Absent-Minded", "Adventurous", "Ambitious", "Angler", "Animal Lover", "Artistic",
           "Athletic", "Avant Garde", "Bookworm", "Born Salesman", "Brave", "Can’t Stand Art", "Cat Person",
           "Charismatic", "Childish", "Clumsy", "Commitment Issues", "Computer Whiz", "Couch Potato",
           "Coward", "Daredevil", "Disciplined", "Dislikes Children", "Dog Person", "Easily Impressed",
           "Eccentric", "Eco-Friendly", "Equestrian", "Evil", "Excitable", "Family Oriented", "Flirty",
           "Friendly", "Frugal", "Genius", "Good", "Good Sense of Humor", "Great Kisser", "Green Thumb",
           "Grumpy", "Handy", "Hates the Outdoors", "Heavy Sleeper", "Hopeless Romantic", "Hot Headed",
           "Inappropriate", "Insane", "Irresistible", "Kleptomaniac", "Light Sleeper", "Loner", "Loser",
           "Loves the Cold", "Loves the Heat", "Loves the Outdoors", "Lucky", "Mean Spirited", "Mooch",
           "Natural Cook", "Neat", "Neurotic", "Never Nude", "No Sense of Humor", "Nurturing",
           "Over-Emotional", "Party Animal", "Perceptive", "Perfectionist", "Photographer’s Eye",
           "Rebellious", "Savvy Sculptor", "Schmoozer", "Shy", "Slob", "Snob", "Socially Awkward",
           "Star Quality", "Technophobe", "Unflirty", "Unlucky", "Vegetarian", "Vehicle Enthusiast",
           "Virtuoso", "Workaholic"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, traits);
        //ListView listView = (ListView) findViewById(R.id.listview);
        setListAdapter(adapter);
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE); //allows multiple choice
        final Button doneButton = new Button(this);
        doneButton.setText("Done");
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putStringArrayListExtra("TRAITS", chosen);
                setResult(1, intent);
                finish();
            }
        });
        getListView().addFooterView(doneButton);


    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        String item = (String) getListAdapter().getItem(position); //gets the trait selected
        if (chosen.contains(item))
            chosen.remove(item);
        else{
            chosen.add(item);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_trait_list, menu);
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
}

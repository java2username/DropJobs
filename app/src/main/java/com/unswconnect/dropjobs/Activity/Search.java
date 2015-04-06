package com.unswconnect.dropjobs.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.unswconnect.dropjobs.R;


public class Search extends ActionBarActivity {

    EditText searchBox;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchBox = (EditText) findViewById(R.id.searchBox);
        searchButton = (Button) findViewById(R.id.searchButton);
    }

    private View.OnClickListener searchListener = new View.OnClickListener() {
        public void onClick(View v) {

            String jobName = searchButton.getText().toString();
            Intent i = new Intent(Search.this, SearchList.class);
            i.putExtra("jobName", jobName);
            startActivity(i);
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
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

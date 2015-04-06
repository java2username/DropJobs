package com.unswconnect.dropjobs.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.unswconnect.dropjobs.Activity.Domain.Job;
import com.unswconnect.dropjobs.Activity.Service.SearchService;
import com.unswconnect.dropjobs.R;

import java.util.List;

public class SearchList extends Activity {

    private SearchService searchService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);

        Intent intent = getIntent();
        String jobName = intent.getExtras().getString("jobName");

        searchService = new SearchService();
        new JobSearchTask().execute(jobName);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_list, menu);
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

    private class JobSearchTask extends AsyncTask<String, Void, List<Job>> {

        @Override
        protected List<Job> doInBackground(String... params) {
            return searchService.searchJobsByName(params[0]);
        }

        @Override
        protected void onPostExecute(List<Job> data) {
            //hangoutList is needed here so that notifydatasetchanged works with add() method for arraylist.
            for (Mate mate : data) {
                matesList.add(mate);
            }
            adapter.notifyDataSetChanged();
        }
    }
}

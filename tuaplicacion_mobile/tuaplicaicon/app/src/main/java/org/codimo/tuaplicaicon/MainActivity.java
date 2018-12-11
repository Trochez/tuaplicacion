package org.codimo.tuaplicaicon;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static org.codimo.tuaplicaicon.apiMethods.listJsonUsers;

public class MainActivity extends AppCompatActivity {

    //create gui element
    ListView list;

    //create objects to show list of users
    public static ArrayList<usuarios> titles = new ArrayList<>();
    public static ArrayAdapter arrayAdapter;

    //create this class element to use to change of activity
    public MainActivity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set this class element
        activity = this;

        //define adapter to join list of user with list gui
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,titles);

        //join list object with visual element
        list = findViewById(R.id.users);

        //set adapater to list
        list.setAdapter(arrayAdapter);

        //define selecte click item of list event
        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener(){


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //debug
                System.out.println("-------------- change activity");

                //change to second activity
                Intent us = new Intent(activity,
                        userSelected.class);
                startActivity(us);

            }
        };

        //add click event to list
        list.setOnItemClickListener (listener);

        //start asynchronous thread to get list of user from url
        new HttpAsyncTask().execute("https://randomapi.com/api/6de6abfedb24f889e0b5f675edc50deb");

    }

    //class to create asynchronous thread that get the list of users
    public static class HttpAsyncTask extends AsyncTask<String, Void, ArrayList<usuarios>> {
        @Override
        protected ArrayList<usuarios> doInBackground(String... urls) {

            //get list of users
            return listJsonUsers(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(ArrayList<usuarios> result) {

            //when list of users is ready, add this list to gui list

            titles.clear();
            titles.addAll(result);
            arrayAdapter.notifyDataSetChanged();

        }
    }


}

package com.deltaappdev.inductions18.fifafixturesmanager;

import android.app.Application;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewFixtureList;
    Button buttonAddMain, buttonDeleteMain;

    private RecyclerViewAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private List<matchFixtures> matchDataArrayList= new ArrayList<>();

    private matchFixtures matchData;

    //public static DatabaseHelper sqlLiteHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialise();

        //loadMatchFixtures();

        buttonAddMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFixture();
            }
        });



    }


    public void initialise() {

        //recyclerViewFixtureList = (RecyclerView)findViewById(R.id.recyclerViewFixtureList);

        buttonAddMain= (Button)findViewById(R.id.buttonAddMain);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewFixtureList);

        mAdapter = new RecyclerViewAdapter(matchDataArrayList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setAdapter(mAdapter);


    }

    public void addFixture() {

        Intent intentA = new Intent(this, AddActivity.class);
        startActivity(intentA);

    }

    public void editFixture() {

        Intent intentE = new Intent(this, EditActivity.class);
        startActivity(intentE);

    }

    public void deleteFixture() {

    }

    public void loadMatchFixtures() {
        AddActivity.sqlLiteHelper = new DatabaseHelper(this, "MatchFixturesDB.sqllite", null, 1);
        //sqlLiteHelper = new DatabaseHelper(this, "MatchFixturesDB.sqllite", null, 1);
        Cursor cursor = AddActivity.sqlLiteHelper.getData("SELECT * FROM fixtures_table");
        matchDataArrayList.clear();

        while (cursor.moveToNext()) {

            int id = cursor.getInt(0);
            String tAname = cursor.getString(1);
            String tBname = cursor.getString(2);
            String venue = cursor.getString(3);
            String mDate = cursor.getString(4);
            String mTime = cursor.getString(5);
            byte[] tAicon = cursor.getBlob(6);
            byte[] tBicon = cursor.getBlob(7);

            matchDataArrayList.add(new matchFixtures(tAname, tBname, mDate, mTime, venue, tAicon, tBicon));
        }

        mAdapter.notifyDataSetChanged();
    }



}

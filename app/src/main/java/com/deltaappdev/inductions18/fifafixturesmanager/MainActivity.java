package com.deltaappdev.inductions18.fifafixturesmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewFixtureList;
    Button buttonAddMain, buttonDeleteMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialise();

        buttonAddMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFixture();
            }
        });



    }


    public void initialise() {

        recyclerViewFixtureList = (RecyclerView)findViewById(R.id.recyclerViewFixtureList);

        buttonAddMain= (Button)findViewById(R.id.buttonAddMain);

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



}

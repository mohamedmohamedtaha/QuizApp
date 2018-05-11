package com.example.manasatpc.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FourQuestionActivity extends AppCompatActivity {
    //define Intent for bring the Values in Activity Previous
    Intent intent;
    //Define String for store name student
    String showYourName;
    //define TextView for show name Student , result Correct and result UnCorrect
    TextView TVShowName, ETResultCorrect, ETResultUnCorrect;
    //Define Button
    Button BTEnd;

    //Define two variable fot Track result The Student
    int intentTrackResultCorrect;
    int intentTrackResultUnCorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_question);

        //call the method for define All Views in OnCreate method
        defineViews();

        //bring name Student ,variable mTrackResultCorrect and variable  mTrackResultUnCorrect
        // from ThridQuestionActivity and Show it name Student , intentTrackResultCorrect and intentTrackResultUnCorrect
        intent = getIntent();
        showYourName = intent.getStringExtra("yourName");
        intentTrackResultCorrect = intent.getIntExtra("mTrackResultCorrect", 0);
        intentTrackResultUnCorrect = intent.getIntExtra("mTrackResultUnCorrect", 1);

        TVShowName.setText(showYourName);
        ETResultCorrect.setText(intentTrackResultCorrect + "");
        ETResultUnCorrect.setText(intentTrackResultUnCorrect + "");

        //when press on Button Next

        BTEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //For Close The App
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        //Disable Back Button

    }

    private void defineViews() {
        //method for define All views used in the Activity
        TVShowName = (TextView) findViewById(R.id.TVShowName);
        ETResultCorrect = (TextView) findViewById(R.id.ETResultCorrect);
        ETResultUnCorrect = (TextView) findViewById(R.id.ETResultUnCorrect);
        BTEnd = (Button) findViewById(R.id.BTEnd);

    }

}

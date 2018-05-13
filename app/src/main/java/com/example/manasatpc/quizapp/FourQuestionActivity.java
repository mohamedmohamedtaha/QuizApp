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
    TextView tv_show_your_name, et_result_correct, et_result_un_correct;
    //Define Button
    Button bt_end;

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
        showYourName = intent.getStringExtra(getString(R.string.your_name));
        intentTrackResultCorrect = intent.getIntExtra(getString(R.string.m_track_result_correct), 0);
        intentTrackResultUnCorrect = intent.getIntExtra(getString(R.string.m_track_result_un_correct), 1);

        tv_show_your_name.setText(showYourName);
        et_result_correct.setText(intentTrackResultCorrect + "");
        et_result_un_correct.setText(intentTrackResultUnCorrect + "");

        //when press on Button Next

        bt_end.setOnClickListener(new View.OnClickListener() {
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
        tv_show_your_name = (TextView) findViewById(R.id.tv_show_your_name);
        et_result_correct = (TextView) findViewById(R.id.et_result_correct);
        et_result_un_correct = (TextView) findViewById(R.id.et_result_un_correct);
        bt_end = (Button) findViewById(R.id.bt_end);

    }

}

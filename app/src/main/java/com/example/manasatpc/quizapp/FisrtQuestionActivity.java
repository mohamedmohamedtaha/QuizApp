package com.example.manasatpc.quizapp;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class FisrtQuestionActivity extends AppCompatActivity {
    //Define two variable fot Track result The Student
    public static int mTrackResultCorrect;
    public static int mTrackResultUnCorrect;
    //Define RadioButton for Answers the first Question
    RadioButton RBOne, RBTwo, RBThree;
    //Define Button for move The SecondActivity
    Button BTNext;
    //Define TextView for show Name Student
    TextView ETShowYourName;
    //Define Intent for bring Name Student from MainActivity
    Intent intent;
    //Define String for store Name Student in it
    String showYourName;
    //Define CheckBox for Answers the Second Question
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fisrt_question);

        //Initialize variables in every time Student open the App
        mTrackResultCorrect = 0;
        mTrackResultUnCorrect = 0;


        //call the method for define All Views in OnCreate method
        defineViews();

        //bring name Student from MainActivity and Show it in ETShowYourName
        intent = getIntent();
        showYourName = intent.getStringExtra("yourName");
        ETShowYourName.setText(showYourName);

        //when press on Button Next
        BTNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //If statement for test Answer The first Question
                if (RBOne.isChecked()) {
                    //If RBone is Checked Add 1 and store it in the Variable mTrackResultCorrect
                    mTrackResultCorrect++;

                } else {
                    //else  Add 1 and store it in the Variable mTrackResultUnCorrect

                    mTrackResultUnCorrect++;
                }

                //If statement for test Answer The Second Question
                //If checkBox1 is Checked  , checkBox2 is Checked,checkBox3 is UnChecked and checkBox4 is UnChecked
                // Add 1 and store it in the Variable mTrackResultCorrect

                if (checkBox1.isChecked() && checkBox2.isChecked() && !checkBox3.isChecked() && !checkBox4.isChecked()) {
                    mTrackResultCorrect++;

                } else {
                    //else  Add 1 and store it in the Variable mTrackResultUnCorrect

                    mTrackResultUnCorrect++;
                }

                // Open SecondQuestionActivity and bring with it YourName ,variable mTrackResultCorrect
                // and Variable mTrackResultUnCorrect
                Intent intent = new Intent(FisrtQuestionActivity.this, SecondQuestionActivity.class);
                intent.putExtra("yourName", showYourName);
                intent.putExtra("mTrackResultCorrect", mTrackResultCorrect);
                intent.putExtra("mTrackResultUnCorrect", mTrackResultUnCorrect);
                startActivity(intent);

                // For close the Activity after Start SecondQuestionActivity
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
        //and connect them with XML file


        ETShowYourName = (TextView) findViewById(R.id.ETShowYourName);

        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);

        RBOne = (RadioButton) findViewById(R.id.RBOne);
        RBTwo = (RadioButton) findViewById(R.id.RBTwo);
        RBThree = (RadioButton) findViewById(R.id.RBThree);

        BTNext = (Button) findViewById(R.id.BTNext);
    }
}

















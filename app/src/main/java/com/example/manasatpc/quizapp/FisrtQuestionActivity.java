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
    RadioButton rb_one;
    //Define Button for move The SecondActivity
    Button bt_next;
    //Define TextView for show Name Student
    TextView tv_show_your_name;
    //Define Intent for bring Name Student from MainActivity
    Intent intent;
    //Define String for store Name Student in it
    String showYourName;
    //Define CheckBox for Answers the Second Question
    CheckBox check_box_one, check_box_two, check_box_three, check_box_four;

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
        showYourName = intent.getStringExtra(getString(R.string.your_name));
        tv_show_your_name.setText(showYourName);

        //when press on Button Next
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //If statement for test Answer The first Question
                if (rb_one.isChecked()) {
                    //If RBone is Checked Add 1 and store it in the Variable mTrackResultCorrect
                    mTrackResultCorrect++;

                } else {
                    //else  Add 1 and store it in the Variable mTrackResultUnCorrect

                    mTrackResultUnCorrect++;
                }

                //If statement for test Answer The Second Question
                //If checkBox1 is Checked  , checkBox2 is Checked,checkBox3 is UnChecked and checkBox4 is UnChecked
                // Add 1 and store it in the Variable mTrackResultCorrect

                if (check_box_one.isChecked() && check_box_two.isChecked() && !check_box_three.isChecked() && !check_box_four.isChecked()) {
                    mTrackResultCorrect++;

                } else {
                    //else  Add 1 and store it in the Variable mTrackResultUnCorrect

                    mTrackResultUnCorrect++;
                }

                // Open SecondQuestionActivity and bring with it YourName ,variable mTrackResultCorrect
                // and Variable mTrackResultUnCorrect
                Intent intent = new Intent(FisrtQuestionActivity.this, SecondQuestionActivity.class);
                intent.putExtra(getString(R.string.your_name), showYourName);
                intent.putExtra(getString(R.string.m_track_result_correct), mTrackResultCorrect);
                intent.putExtra(getString(R.string.m_track_result_un_correct), mTrackResultUnCorrect);
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


        tv_show_your_name = (TextView) findViewById(R.id.tv_show_your_name);

        check_box_one = (CheckBox) findViewById(R.id.check_box_one);
        check_box_two = (CheckBox) findViewById(R.id.check_box_two);
        check_box_three = (CheckBox) findViewById(R.id.check_box_three);
        check_box_four = (CheckBox) findViewById(R.id.check_box_four);

        rb_one = (RadioButton) findViewById(R.id.rb_one);

        bt_next = (Button) findViewById(R.id.bt_next);
    }
}

















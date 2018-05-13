package com.example.manasatpc.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class SecondQuestionActivity extends AppCompatActivity {
    //Define two variable fot Track result The Student
    public static int mTrackResultCorrect;
    public static int mTrackResultUnCorrect;
    //Define RadioButton for Answers the first Question
    RadioButton rb_three;
    //Define Button for move The ThirdActivity
    Button bt_next;
    //Define TextView for show Name Student
    TextView tv_show_your_name;
    //Define Intent for bring Name Student from FirstActivity and variables Result Student
    Intent intent;
    //Define String for store Name Student in it
    String showYourName;
    //Define CheckBox for Answers the Second Question
    CheckBox check_box_one, check_box_two, check_box_three, check_box_four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);

        //call the method for define All Views in OnCreate method
        defineViews();

        //bring name Student ,variable mTrackResultCorrect and variable  mTrackResultUnCorrect
        // from FisrtQuestionActivity and Show it name Student only in ETShowYourName
        intent = getIntent();
        showYourName = intent.getStringExtra(getString(R.string.your_name));
        mTrackResultCorrect = intent.getIntExtra(getString(R.string.m_track_result_correct), 0);
        mTrackResultUnCorrect = intent.getIntExtra(getString(R.string.m_track_result_un_correct), 1);

        tv_show_your_name.setText(showYourName);


        //when press on Button Next
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //If statement for test Answer The first Question
                if (rb_three.isChecked()) {
                    //If RBThree is Checked Add 1 and store it in the Variable mTrackResultCorrect

                    mTrackResultCorrect++;

                } else {
                    //else  Add 1 and store it in the Variable mTrackResultUnCorrect

                    mTrackResultUnCorrect++;
                }
                //If statement for test Answer The Second Question
                //If checkBox1 is Checked  , checkBox2 is Checked,checkBox3 is Checked and checkBox4 is Checked
                // Add 1 and store it in the Variable mTrackResultCorrect

                if (check_box_one.isChecked() && check_box_two.isChecked() && check_box_three.isChecked() && check_box_four.isChecked()) {
                    mTrackResultCorrect++;

                } else {
                    //else  Add 1 and store it in the Variable mTrackResultUnCorrect
                    mTrackResultUnCorrect++;
                }
                // Open ThirdQuestionActivity and bring with it YourName ,variable mTrackResultCorrect
                // and Variable mTrackResultUnCorrect
                Intent intent = new Intent(SecondQuestionActivity.this, ThirdQuestionActivity.class);
                intent.putExtra(getString(R.string.your_name), showYourName);
                intent.putExtra(getString(R.string.m_track_result_correct), mTrackResultCorrect);
                intent.putExtra(getString(R.string.m_track_result_un_correct), mTrackResultUnCorrect);
                startActivity(intent);

                // For close the Activity after Start ThirdQuestionActivity
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


        rb_three = (RadioButton) findViewById(R.id.rb_three);

        bt_next = (Button) findViewById(R.id.bt_next);
    }


}

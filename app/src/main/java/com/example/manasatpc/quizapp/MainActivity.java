package com.example.manasatpc.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //Define Button  for Start Quiz and EditText for Enter Name Student
    Button bt_start_quiz;
    EditText et_enter_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //define EditText and Button and connect them with XML file
        et_enter_name = (EditText) findViewById(R.id.et_enter_name);
        bt_start_quiz = (Button) findViewById(R.id.bt_start_quiz);

        //when Click on the Button Go for Start Quiz
        bt_start_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // variable String for store ETEnterName EditText
                String yourName = et_enter_name.getText().toString().trim();
                //If statement for test Is EditText empty or No
                if (yourName.isEmpty()) {
                    et_enter_name.setError(getString(R.string.enter_name));
                    return;
                } else {
                    //If EditText not Empty Start The Quiz
                    Intent startQuiz = new Intent(MainActivity.this, FisrtQuestionActivity.class);
                    startQuiz.putExtra(getString(R.string.your_name), yourName);
                    startActivity(startQuiz);

                    // For close the Activity after Start FisrtQuestionActivity
                    finish();

                }

            }
        });
    }
}

package com.example.manasatpc.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //Define Button  for Start Quiz and EditText for Enter Name Student
    Button BTStartQuiz;
    EditText ETEnterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //define EditText and Button and connect them with XML file
        ETEnterName = (EditText) findViewById(R.id.ETEnterName);
        BTStartQuiz = (Button) findViewById(R.id.BTStartQuiz);

        //when Click on the Button Go for Start Quiz
        BTStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // variable String for store ETEnterName EditText
                String yourName = ETEnterName.getText().toString().trim();
                //If statement for test Is EditText empty or No
                if (yourName.isEmpty()) {
                    ETEnterName.setError("Enter Your Name");
                    return;
                } else {
                    //If EditText not Empty Start The Quiz
                    Intent startQuiz = new Intent(MainActivity.this, FisrtQuestionActivity.class);
                    startQuiz.putExtra("yourName", yourName);
                    startActivity(startQuiz);

                    // For close the Activity after Start FisrtQuestionActivity
                    finish();

                }

            }
        });
    }
}

package com.example.android.mentalhealthquiz;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* displays calculated score in a toast after user clicks submit button*/
    public void showScoreAndExitApp(View v) {
        //gets user score as a percentage after invoking the calculateScore method
        double score = calculateScore();
        //gets decimalformat object for formatting calculated score to one decimal place
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        //converts score to one decimal place
        String formattedScore = decimalFormat.format(score);
        //displays users score as a toast
        if (score<50) {
            Toast.makeText(this, "You scored " + formattedScore + "%", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "You passed with a score of " + formattedScore + "%", Toast.LENGTH_LONG).show();
        }
    }

    //calculates score from the responses of the user
    private double calculateScore() {
        //initializes the score variable which is eventually returned
        double score = 0;
        //gets the radiobutton that contains the correct option of the first question
        RadioButton depAnswerRadiobutton = (RadioButton) findViewById(R.id.dep_yes_radio_button);
        //gets the radiobutton that contains the correct option for the second question
        RadioButton anxietyAnswerRadiobutton = (RadioButton) findViewById(R.id.anxiety_yes_radio_button);
        //gets the radiobutton that contains the correct option for the third question
        RadioButton depAnswerRadiobutton2 = (RadioButton) findViewById(R.id.dep_yes_radio_button2);
        //gets the edittext view
        EditText hallucinationEditText = (EditText) findViewById(R.id.hallucination_edit_text);
        //gets the first checkbox that contains one of the correct options for the fourth question
        CheckBox sleepCheckboxRightOption1 = (CheckBox) findViewById(R.id.sleep_checkbox1);
        //gets the second checkbox that contains one of the correct options for the fourth question
        CheckBox sleepCheckboxRightOption2 = (CheckBox) findViewById(R.id.sleep_checkbox2);
        //gets the first checkbox that contains one of the wrong options for the fourth question
        CheckBox sleepCheckboxWrongOption1 = (CheckBox) findViewById(R.id.sleep_checkbox3);
        //gets the second checkbox that contains one of the wrong options for the fourth question
        CheckBox sleepCheckboxWrongOption2 = (CheckBox) findViewById(R.id.sleep_checkbox4);
        if (depAnswerRadiobutton.isChecked()) {
            score++;
        }
        if (anxietyAnswerRadiobutton.isChecked()) {
            score++;
        }
        if (depAnswerRadiobutton2.isChecked()) {
            score++;
        }
        //gets user input from the edittext field
        String hallucinationQuestionResponse = hallucinationEditText.getText().toString().trim();
        //correct input for the question
        String hallucinationQuestionAnswer = "hallucination";
        if (hallucinationQuestionResponse.equalsIgnoreCase(hallucinationQuestionAnswer)) {
            score++;
        }
        if (sleepCheckboxRightOption1.isChecked()) {
            score++;
        }
        if (sleepCheckboxRightOption2.isChecked()) {
            score++;
        }
        if (sleepCheckboxWrongOption1.isChecked()) {
            //negative mark for selecting wrong checkbox
            score--;
        }
        if (sleepCheckboxWrongOption2.isChecked()) {
            //negative mark for selecting wrong checkbox
            score--;
        }
        //converts the score to a percentage over 6
        return (score / 6.0) * 100;
    }
}

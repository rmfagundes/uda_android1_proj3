package com.example.android.quizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Checks the responses and returns the value as a Toast.
     */
    public void checkAnswers(View view) {
        int points = 0;

        // Question 1
        if (((RadioGroup)findViewById(R.id.radio_group_q1)).getCheckedRadioButtonId() == R.id.radio_q1_houston) {
            points++;
        }

        // Question 2
        if (((EditText)findViewById(R.id.response_q2_text)).getText().toString().equals("Lady Gaga")) {
            points++;
        }

        // Question 3
        if (((Switch)findViewById(R.id.response_q3_switch)).isChecked()) {
            points++;
        }

        // Question 4
        if (((CheckBox)findViewById(R.id.check_q4_jacob_tamme)).isChecked()
                && ((CheckBox)findViewById(R.id.check_q4_ron_gronkowsky)).isChecked()) {
            points++;
        }

        // Question 5
        String resp5 = ((EditText)findViewById(R.id.response_q5_text)).getText().toString();
        if ((resp5.equals("") ? 0 : Integer.valueOf(resp5)) == 50) {
            points++;
        }

        // Toast
        String message;
        if (points < 3) {
            message = String.format(getString(R.string.total_points_low), points);
        } else {
            message = String.format(getString(R.string.total_points_high), points);
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}

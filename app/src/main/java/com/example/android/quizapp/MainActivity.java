package com.example.android.quizapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.quizapp.R.id.checkbox_1A;
import static com.example.android.quizapp.R.id.checkbox_1B;
import static com.example.android.quizapp.R.id.checkbox_1C;
import static com.example.android.quizapp.R.id.checkbox_1D;
import static com.example.android.quizapp.R.id.checkbox_2A;
import static com.example.android.quizapp.R.id.checkbox_2B;
import static com.example.android.quizapp.R.id.checkbox_2C;
import static com.example.android.quizapp.R.id.checkbox_2D;
import static com.example.android.quizapp.R.id.checkbox_3A;
import static com.example.android.quizapp.R.id.checkbox_3B;
import static com.example.android.quizapp.R.id.checkbox_3C;
import static com.example.android.quizapp.R.id.checkbox_3D;
import static com.example.android.quizapp.R.id.checkbox_4A;
import static com.example.android.quizapp.R.id.checkbox_4B;
import static com.example.android.quizapp.R.id.checkbox_4C;
import static com.example.android.quizapp.R.id.checkbox_4D;
import static com.example.android.quizapp.R.id.score_Text;
import static com.example.android.quizapp.R.string.scoreText;

public class MainActivity extends AppCompatActivity {

    //    boolean ans1A = true;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * This prevents the keybord from showing up on app start
         */
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    /**
     * THis method checks the given name by user and. Called when "Let's begin" button is clicked
     */
    public void submitName(View view) {
        EditText getName = (EditText) findViewById(R.id.name);
        String name = getName.getText().toString();

        Resources res = getResources();
        String welcome = res.getString(R.string.welcome, name);
        String entr = res.getString(R.string.entr, name);
        String scoreT = res.getString(scoreText, name);
        displayName(welcome, entr, scoreT);
    }

    /**
     * THis method checks the answers
     */
    public void checkScore(View view) {
        CheckBox q1A = (CheckBox) findViewById(checkbox_1A),
                q1B = (CheckBox) findViewById(checkbox_1B),
                q1C = (CheckBox) findViewById(checkbox_1C),
                q1D = (CheckBox) findViewById(checkbox_1D),
                q2A = (CheckBox) findViewById(checkbox_2A),
                q2B = (CheckBox) findViewById(checkbox_2B),
                q2C = (CheckBox) findViewById(checkbox_2C),
                q2D = (CheckBox) findViewById(checkbox_2D),
                q3A = (CheckBox) findViewById(checkbox_3A),
                q3B = (CheckBox) findViewById(checkbox_3B),
                q3C = (CheckBox) findViewById(checkbox_3C),
                q3D = (CheckBox) findViewById(checkbox_3D),
                q4A = (CheckBox) findViewById(checkbox_4A),
                q4B = (CheckBox) findViewById(checkbox_4B),
                q4C = (CheckBox) findViewById(checkbox_4C),
                q4D = (CheckBox) findViewById(checkbox_4D);
        RadioButton q5 = (RadioButton) findViewById(R.id.radio_button_1A),
                q6 = (RadioButton) findViewById(R.id.radio_button_2B),
                q7 = (RadioButton) findViewById(R.id.radio_button_3B);

        boolean a1 = q1A.isChecked(),
                a2 = q1B.isChecked(),
                a3 = q1C.isChecked(),
                a4 = q1D.isChecked(),
                a5 = q2A.isChecked(),
                a6 = q2B.isChecked(),
                a7 = q2C.isChecked(),
                a8 = q2D.isChecked(),
                a9 = q3A.isChecked(),
                a10 = q3B.isChecked(),
                a11 = q3C.isChecked(),
                a12 = q3D.isChecked(),
                a13 = q4A.isChecked(),
                a14 = q4B.isChecked(),
                a15 = q4C.isChecked(),
                a16 = q4D.isChecked(),
                a17 = q5.isChecked(),
                a18 = q6.isChecked(),
                a19 = q7.isChecked();

        Log.v("MainActivity", "score " + a17);
        boolean[] array = new boolean[]{a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19};
        boolean[] correct = new boolean[]
                {false, true, false, true,
                        true, false, true, false,
                        true, true, true, true,
                        true, true, false, false,
                        true, true, true
                };
        for (int i = 0; i < 19; i++) {
            if (array[i] == correct[i] && array[i]) {
                score += 1;
            }
            if (array[i] != correct[i] && array[i]) {
                score -= 1;
            }
        }

        EditText getName = (EditText) findViewById(R.id.name);
        String name = getName.getText().toString();
        Resources res = getResources();
        String scoretext = res.getString(scoreText, name);
        displayScore(scoretext, score);
        Toast.makeText(this, scoretext + " " + score, Toast.LENGTH_LONG).show();
        score = 0;
    }

    /**
     * This method changes selected strings by adding user given name.
     */
    private void displayName(String welcome, String entr, String scoreT) {
        TextView welcomeTextView = (TextView) findViewById(R.id.welcome);
        welcomeTextView.setText(welcome);
        TextView entrTextView = (TextView) findViewById(R.id.entr);
        entrTextView.setText(entr);
        TextView scoreTextView = (TextView) findViewById(score_Text);
        scoreTextView.setText(scoreT);
    }

    /**
     * This method displayes the score.
     */
    private void displayScore(String scoretext, int score) {
        TextView scoreText = (TextView) findViewById(R.id.score_Text);
        scoreText.setText(scoretext + " " + score);
    }
}

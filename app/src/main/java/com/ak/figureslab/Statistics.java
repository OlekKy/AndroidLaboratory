package com.ak.figureslab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Statistics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics_layout);

        TextView numberOfCircles = findViewById(R.id.textView19);
        int nr  = MainActivity.countFigures();
        numberOfCircles.setText(""+nr);

    }
}

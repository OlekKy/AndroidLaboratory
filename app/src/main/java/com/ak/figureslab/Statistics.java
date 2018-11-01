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
        int nrOfCircles  = MainActivity.countCircles();
        numberOfCircles.setText(""+nrOfCircles);

        TextView numberOfSquares = findViewById(R.id.textView22);
        int nrOfSquares  = MainActivity.countSquares();
        numberOfSquares.setText(""+nrOfSquares);

        TextView numberOfTriangles = findViewById(R.id.textView23);
        int nrOfTriangles  = MainActivity.countTriangles();
        numberOfTriangles.setText(""+nrOfTriangles);

        TextView fieldOfCircles = findViewById(R.id.textView20);
        double fOC = MainActivity.fieldOfAllCircles();
        String cirFields = String.format("%.3f", fOC);
        fieldOfCircles.setText(cirFields);

        TextView fieldOfSquares = findViewById(R.id.textView24);
        double fOS = MainActivity.fieldOfAllSquares();
        String sqaFields = String.format("%.3f", fOS);
        fieldOfSquares.setText(sqaFields);

        TextView fieldOfTriangles = findViewById(R.id.textView25);
        double fOT = MainActivity.fieldOfAllTriangles();
        String traFields = String.format("%.3f", fOT);
        fieldOfTriangles.setText(traFields);
//
        TextView paramsOfCircles = findViewById(R.id.textView21);
        double pOC = MainActivity.paramsOfAllCircles();
        String cirPar = String.format("%.3f", pOC);
        paramsOfCircles.setText(cirPar);

        TextView paramsOfSquares = findViewById(R.id.textView26);
        double pOS = MainActivity.paramsOfAllSquares();
        String sqaPar = String.format("%.3f", pOS);
        paramsOfSquares.setText(sqaPar);

        TextView paramsOfTriangles = findViewById(R.id.textView27);
        double pOT = MainActivity.paramsOfAllTriangles();
        String traPar = String.format("%.3f", pOT);
        paramsOfTriangles.setText(traPar);
    }
}

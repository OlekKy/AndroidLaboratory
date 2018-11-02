package com.ak.figureslab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);

        final EditText editFiguresNr = findViewById(R.id.editText2);
        final EditText editFiguresMin = findViewById(R.id.editText4);
        final EditText editFiguresMax = findViewById(R.id.editText5);

        Button generateFigures = findViewById(R.id.button);
        generateFigures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.valueOf(editFiguresNr.getText().toString());
                float min = Float.valueOf(editFiguresMin.getText().toString());
                float max = Float.valueOf(editFiguresMax.getText().toString());
                if(( x > 0 ) & ( x < 200 ) & ( max >= min ) & ( min > 0.1 ) & ( min < 10 ) & (max > 0.1 ) & ( max < 10)){
                    MainActivity.showTable(MainActivity.generateFigures(x,min,max));
                    finish();
                } else Toast.makeText(v.getContext(), " PODAJ POPRAWNE WARTOSCI!", Toast.LENGTH_LONG).show();

            }
        });
    }
}

package com.ak.figureslab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);

        EditText editFiguresNr = findViewById(R.id.editText2);
       // editFiguresNr.addTextChangedListener();


        Button generateFigures = findViewById(R.id.button);
        generateFigures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(Settings.this, MainActivity.class);
                startActivity(k);
            }
        });
    }
}

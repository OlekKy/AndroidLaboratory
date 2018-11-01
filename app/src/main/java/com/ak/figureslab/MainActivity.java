package com.ak.figureslab;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.ViewGroup.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static LinkedList<Figure> figureList;
    TableLayout mainLayout;
    TableRow tableRow;
    private boolean state = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_lay);

        mainLayout = findViewById(R.id.tl);

        figureList = generateFigures(100);
        showTable(figureList);

        Button goSettings = findViewById(R.id.button4);
        goSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(MainActivity.this, Settings.class);
                startActivity(k);
            }
        });

        Button goStats = findViewById(R.id.button5);
        goStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stats = new Intent(MainActivity.this, Statistics.class);
                //startActivity(stats);
                startActivityForResult(stats, 2);
            }
        });

        Button nameSort = findViewById(R.id.button1);
        nameSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinkedList<Figure> sortedList;

                if (state){
                    Collections.sort(figureList, new Comparator<Figure>() {
                        @Override
                        public int compare(Figure o1, Figure o2) {

                            return String.valueOf(o1.name()).compareTo(o2.name());
                        }
                    });
                    sortedList = figureList;
                    showTable(sortedList);
                    mainLayout.invalidate();
                    state = false;
                } else {
                    Collections.sort(figureList, new Comparator<Figure>() {
                        @Override
                        public int compare(Figure o1, Figure o2) {

                            return String.valueOf(o2.name()).compareTo(o1.name());
                        }
                    });
                    sortedList = figureList;
                    showTable(sortedList);
                    mainLayout.invalidate();
                    state = true;
                }
            }
        });

        Button fieldSort = findViewById(R.id.button2);
        fieldSort.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                LinkedList<Figure> sortedList;

                if (state){
                    Collections.sort(figureList, new Comparator<Figure>() {
                        @Override
                        public int compare(Figure o1, Figure o2) {

                            return Double.valueOf(o1.field()).compareTo(o2.field());
                        }
                    });
                    sortedList = figureList;
                    showTable(sortedList);
                    mainLayout.invalidate();
                    state = false;
                } else {
                    Collections.sort(figureList, new Comparator<Figure>() {
                        @Override
                        public int compare(Figure o1, Figure o2) {

                            return Double.valueOf(o2.field()).compareTo(o1.field());
                        }
                    });
                    sortedList = figureList;
                    showTable(sortedList);
                    mainLayout.invalidate();
                    state = true;
                }

            }
        });

        Button paramSort = findViewById(R.id.button3);
        paramSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinkedList<Figure> sortedList;

                if (state){
                    Collections.sort(figureList, new Comparator<Figure>() {
                        @Override
                        public int compare(Figure o1, Figure o2) {

                            return Double.valueOf(o1.lengthParam()).compareTo(o2.lengthParam());
                        }
                    });
                    sortedList = figureList;
                    showTable(sortedList);
                    mainLayout.invalidate();
                    state = false;
                } else {
                    Collections.sort(figureList, new Comparator<Figure>() {
                        @Override
                        public int compare(Figure o1, Figure o2) {

                            return Double.valueOf(o2.lengthParam()).compareTo(o1.lengthParam());
                        }
                    });
                    sortedList = figureList;
                    showTable(sortedList);
                    mainLayout.invalidate();
                    state = true;
                }
            }
        });
    }


    public void showTable(LinkedList<Figure> figList) {
        mainLayout.removeAllViews();

        for (int i = 0; i < figList.size(); i++) {
            tableRow = new TableRow(this); // WORKING

            tableRow.setLayoutParams(new LayoutParams(
                    LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

            if (figList.get(i).type() == R.drawable.square) {
                Square square = (Square) figList.get(i);

                ImageView imgView = new ImageView(this);

                imgView.setImageResource(R.drawable.square);
                tableRow.addView(imgView);

                TextView txtView1 = new TextView(this);
                String fieldValue = String.format("                   %.3f            ", square.field());
                txtView1.setText(fieldValue);
                tableRow.addView(txtView1);

                TextView txtView2 = new TextView(this);
                String attrValue = String.format("Przekatna \n %.3f", square.lengthParam());
                txtView2.setText(attrValue);
                tableRow.addView(txtView2);


                //mainLayout.addView(tableRow);

            } else if (figList.get(i).type() == R.drawable.triangle) {
                Triangle triangle = (Triangle) figList.get(i);

                ImageView imgView = new ImageView(this);
                imgView.setImageResource(R.drawable.triangle);
                tableRow.addView(imgView);

                TextView txtView1 = new TextView(this);
                String fieldValue = String.format("                   %.3f            ", triangle.field());
                txtView1.setText(fieldValue);
                tableRow.addView(txtView1);

                TextView txtView2 = new TextView(this);
                String attrValue = String.format("Wysokosc \n %.3f", triangle.lengthParam());
                txtView2.setText(attrValue);
                tableRow.addView(txtView2);

                //mainLayout.addView(tableRow);
            } else {
                Circle circle = (Circle) figList.get(i);
                ImageView imgView = new ImageView(this);
                imgView.setImageResource(R.drawable.circle);
                tableRow.addView(imgView);

                TextView txtView1 = new TextView(this);
                String fieldValue = String.format("                   %.3f            ", circle.field());
                txtView1.setText(fieldValue);
                tableRow.addView(txtView1);

                TextView txtView2 = new TextView(this);
                String attrValue = String.format("Srednica \n %.3f", circle.lengthParam());
                txtView2.setText(attrValue);
                tableRow.addView(txtView2);

                //mainLayout.addView(tableRow);
            }
            mainLayout.addView(tableRow);

        }
    }

    public LinkedList<Figure> generateFigures(int a){
        a=100;
        Random generator = new Random();
        float[][] los = new float[a][2];

        for(int i = 0; i < a; i++){
            los[i][0] = generator.nextInt(3);
            los[i][1] = generator.nextFloat();
        }

        LinkedList<Figure> figures = new LinkedList<>();

        for(int i = 0; i < a; i++){
            if (los[i][0]==0) {
                //figures[i]= new Square(los[i][1]);
                figures.add(new Square(los[i][1]));
            }
            else if (los[i][0]==1) {
                figures.add(new Triangle(los[i][1]));
            }
            else {
                figures.add(new Circle(los[i][1]));
            }
        }
        return figures;
    }

    public static int countCircles(){
        int number = 0;
        for (int i = 0 ; i < figureList.size() ; i++ ) {
            if (figureList.get(i).name() == "KOLO"){
                number++;
            }
        }
        return number;
    }
    public static int countSquares(){
        int number = 0;
        for (int i = 0 ; i < figureList.size() ; i++ ) {
            if (figureList.get(i).name() == "KWADRAT"){
                number++;
            }
        }
        return number;
    }
    public static int countTriangles(){
        int number = 0;
        for (int i = 0 ; i < figureList.size() ; i++ ) {
            if (figureList.get(i).name() == "TROJKAT"){
                number++;
            }
        }
        return number;
    }
    public static double fieldOfAllCircles(){
        double number = 0;
        for (int i = 0 ; i < figureList.size() ; i++){
            if (figureList.get(i).name() == "KOLO"){
                number = number + figureList.get(i).field();
            }
        }
        return number;
    }
    public static double fieldOfAllSquares(){
        double number = 0;
        for (int i = 0 ; i < figureList.size() ; i++){
            if (figureList.get(i).name() == "KWADRAT"){
                number = number + figureList.get(i).field();
            }
        }
        return number;
    }
    public static double fieldOfAllTriangles(){
        double number = 0;
        for (int i = 0 ; i < figureList.size() ; i++){
            if (figureList.get(i).name() == "TROJKAT"){
                number = number + figureList.get(i).field();
            }
        }
        return number;
    }
    public static double paramsOfAllCircles(){
        double number = 0;
        for (int i = 0 ; i < figureList.size() ; i++){
            if (figureList.get(i).name() == "KOLO"){
                number = number + figureList.get(i).lengthParam();
            }
        }
        return number;
    }
    public static double paramsOfAllSquares(){
        double number = 0;
        for (int i = 0 ; i < figureList.size() ; i++){
            if (figureList.get(i).name() == "KWADRAT"){
                number = number + figureList.get(i).lengthParam();
            }
        }
        return number;
    }

    public static double paramsOfAllTriangles(){
        double number = 0;
        for (int i = 0 ; i < figureList.size() ; i++){
            if (figureList.get(i).name() == "TROJKAT"){
                number = number + figureList.get(i).lengthParam();
            }
        }
        return number;
    }

}

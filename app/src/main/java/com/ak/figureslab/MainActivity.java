package com.ak.figureslab;

import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupMenu;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static LinkedList<Figure> figureList;
   // public static ArrayList<Figure> figureList2;
    public static LinkedList<TableRow> rowsList;

    public static TableLayout mainLayout;
    public static TableRow tableRow;
    private boolean state = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_lay);

        mainLayout = findViewById(R.id.tl);
        mainLayout.setColumnStretchable(0,true);
        mainLayout.setColumnStretchable(1,true);
        mainLayout.setColumnStretchable(2,true);

        figureList = generateFigures(100,0,1);
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
                startActivity(stats);
            }
        });

        Button clearList = findViewById(R.id.button6);
        clearList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                figureList = generateFigures(100, 0, 1);
                showTable(figureList);
            }
        });

        Button addRandomFigure = findViewById(R.id.button7);
        addRandomFigure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random generator = new Random();
                float[][] newFigure = new float[2][2];
                newFigure[1][0] = generator.nextInt(3);
                newFigure[1][1] = generator.nextFloat();
                if (newFigure[1][0]==0) {

                    figureList.add(0, new Square(newFigure[1][1]));
                }
                else if (newFigure[1][0]==1) {
                    figureList.add(0, new Triangle(newFigure[1][1]));
                }
                else {
                    figureList.add(0, new Circle(newFigure[1][1]));
                }
                showTable(figureList);
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


    public static void showTable(final LinkedList<Figure> figList) {
        mainLayout.removeAllViews();
        rowsList = new LinkedList<>();
        for (int i = 0; i < figList.size(); i++) {
            tableRow = new TableRow(mainLayout.getContext());

            tableRow.setLayoutParams(new LayoutParams(
                    LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

            if (figList.get(i).type() == R.drawable.square) {
                Square square = (Square) figList.get(i);

                ImageView imgView = new ImageView(mainLayout.getContext());

                imgView.setImageResource(R.drawable.square);
                tableRow.addView(imgView);

                TextView txtView1 = new TextView(mainLayout.getContext());
                txtView1.setGravity(Gravity.CENTER);

                String fieldValue = String.format("%.3f", square.field());
                txtView1.setText(fieldValue);
                tableRow.addView(txtView1);

                TextView txtView2 = new TextView(mainLayout.getContext());
                txtView2.setGravity(Gravity.CENTER);
                String attrValue = String.format("Przekatna \n %.3f", square.lengthParam());
                txtView2.setText(attrValue);
                tableRow.addView(txtView2);

            } else if (figList.get(i).type() == R.drawable.triangle) {
                Triangle triangle = (Triangle) figList.get(i);

                ImageView imgView = new ImageView(mainLayout.getContext());
                imgView.setImageResource(R.drawable.triangle);
                tableRow.addView(imgView);

                TextView txtView1 = new TextView(mainLayout.getContext());
                txtView1.setGravity(Gravity.CENTER);

                String fieldValue = String.format("%.3f", triangle.field());
                txtView1.setText(fieldValue);
                tableRow.addView(txtView1);

                TextView txtView2 = new TextView(mainLayout.getContext());
                txtView2.setGravity(Gravity.CENTER);
                String attrValue = String.format("Wysokosc \n %.3f", triangle.lengthParam());
                txtView2.setText(attrValue);
                tableRow.addView(txtView2);

            } else {
                Circle circle = (Circle) figList.get(i);
                ImageView imgView = new ImageView(mainLayout.getContext());
                imgView.setImageResource(R.drawable.circle);
                tableRow.addView(imgView);

                TextView txtView1 = new TextView(mainLayout.getContext());
                txtView1.setGravity(Gravity.CENTER);

                String fieldValue = String.format("%.3f", circle.field());
                txtView1.setText(fieldValue);
                tableRow.addView(txtView1);

                TextView txtView2 = new TextView(mainLayout.getContext());
                txtView2.setGravity(Gravity.CENTER);
                String attrValue = String.format("Srednica \n %.3f", circle.lengthParam());
                txtView2.setText(attrValue);
                tableRow.addView(txtView2);
                //mainLayout.addView(tableRow);
            }
            rowsList.add(tableRow);
            mainLayout.addView(tableRow);
        }

        for ( int y = 0 ; y < rowsList.size() ; y++){
            final int finalY = y;
            rowsList.get(y).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int z = 0 ; z < rowsList.size(); z ++){
                        rowsList.get(z).setBackgroundColor(0);
                    }
                    rowsList.get(finalY).setBackgroundColor(-256);
                }
            });

            rowsList.get(y).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    for (int z = 0 ; z < rowsList.size(); z ++){
                        rowsList.get(z).setBackgroundColor(0);
                    }
                    rowsList.get(finalY).setBackgroundColor(-256);
                    PopupMenu popupMenu = new PopupMenu(mainLayout.getContext(), v);
                    popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            if (item.getTitle().equals("Duplikuj")){
                                figureList.add(finalY+1, figureList.get(finalY));
                                showTable(figureList);
                                //Toast.makeText(mainLayout.getContext(), "Duplicate" +figureList.get(finalY).field(), Toast.LENGTH_LONG).show();
                            } else if (item.getTitle().equals("Usuń")){
                                figureList.remove(finalY);
                                showTable(figureList);
                                //Toast.makeText(mainLayout.getContext(), "Deleted", Toast.LENGTH_LONG).show();
                            }
                            return true;
                        }
                    });

                    popupMenu.show();
                    return true;
                }
            });
        }
    }

    public static LinkedList<Figure> generateFigures(int a, float min, float max){
        Random generator = new Random();
        float[][] los = new float[a][2];

        for(int i = 0; i < a; i++){
            los[i][0] = generator.nextInt(3);
            los[i][1] = min + generator.nextFloat() * (max - min) ;
        }

        LinkedList<Figure> figures = new LinkedList<>();

        for(int i = 0; i < a; i++){
            if (los[i][0]==0) {
                figures.add(new Square(los[i][1]));
            }
            else if (los[i][0]==1) {
                figures.add(new Triangle(los[i][1]));
            }
            else {
                figures.add(new Circle(los[i][1]));
            }
        }
        figureList = figures;
        return figures;
    }

    public static int countCircles(){
        int number = 0;
        for (int i = 0 ; i < figureList.size() ; i++ ) {
            if (figureList.get(i).name().equals("KOLO")){
                number++;
            }
        }
        return number;
    }
    public static int countSquares(){
        int number = 0;
        for (int i = 0 ; i < figureList.size() ; i++ ) {
            if (figureList.get(i).name().equals("KWADRAT")){
                number++;
            }
        }
        return number;
    }
    public static int countTriangles(){
        int number = 0;
        for (int i = 0 ; i < figureList.size() ; i++ ) {
            if (figureList.get(i).name().equals("TROJKAT")){
                number++;
            }
        }
        return number;
    }
    public static double fieldOfAllCircles(){
        double number = 0;
        for (int i = 0 ; i < figureList.size() ; i++){
            if (figureList.get(i).name().equals("KOLO")){
                number = number + figureList.get(i).field();
            }
        }
        return number;
    }
    public static double fieldOfAllSquares(){
        double number = 0;
        for (int i = 0 ; i < figureList.size() ; i++){
            if (figureList.get(i).name().equals("KWADRAT")){
                number = number + figureList.get(i).field();
            }
        }
        return number;
    }
    public static double fieldOfAllTriangles(){
        double number = 0;
        for (int i = 0 ; i < figureList.size() ; i++){
            if (figureList.get(i).name().equals("TROJKAT")){
                number = number + figureList.get(i).field();
            }
        }
        return number;
    }
    public static double paramsOfAllCircles(){
        double number = 0;
        for (int i = 0 ; i < figureList.size() ; i++){
            if (figureList.get(i).name().equals("KOLO")){
                number = number + figureList.get(i).lengthParam();
            }
        }
        return number;
    }
    public static double paramsOfAllSquares(){
        double number = 0;
        for (int i = 0 ; i < figureList.size() ; i++){
            if (figureList.get(i).name().equals("KWADRAT")){
                number = number + figureList.get(i).lengthParam();
            }
        }
        return number;
    }
    public static double paramsOfAllTriangles(){
        double number = 0;
        for (int i = 0 ; i < figureList.size() ; i++){
            if (figureList.get(i).name().equals("TROJKAT")){
                number = number + figureList.get(i).lengthParam();
            }
        }
        return number;
    }

}

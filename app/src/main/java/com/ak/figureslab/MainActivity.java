package com.ak.figureslab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.ViewGroup.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_lay);

        TableLayout mainLayout = findViewById(R.id.tl);

        Figure[] figures = generateFigures();
        int numberElements = figures.length;


        for (int i = 0; i < numberElements; i++) {
            TableRow tableRow = new TableRow(this); // WORKING
           // TableRow tableRow =  mainLayout.findViewById(R.id.single_row); // TEST

           // LayoutInflater inflater = getLayoutInflater();
            //tableRow = rl.findViewById(R.id.tabRow);
            //View myLayout = inflater.inflate(R.layout.row, tableRow, false);

            tableRow.setLayoutParams(new LayoutParams(
                    LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));

            if (figures[i].type() == R.drawable.square){
                Square square = (Square) figures[i];

                ImageView imgView = new ImageView(this);
                imgView.setImageResource(R.drawable.square);
                tableRow.addView(imgView);

//                TableRow.LayoutParams layoutParams;
//                layoutParams = (TableRow.LayoutParams) imgView.getLayoutParams();
//                layoutParams.span = 5;
//                imgView.setLayoutParams(layoutParams);

                TextView txtView1 = new TextView(this);
                String fieldValue = String.format("%.3f ",square.field(square.getSide()));
                txtView1.setText(fieldValue);
                tableRow.addView(txtView1);

                TextView txtView2 = new TextView(this);
                String attrValue = String.format("Przekatna \n %.3f", square.lengthParam());
                txtView2.setText(attrValue);
                tableRow.addView(txtView2);

//                TableRow.LayoutParams layoutParams2;
//                layoutParams2 = (TableRow.LayoutParams) txtView1.getLayoutParams();
//                layoutParams2.span = 2;
//                txtView1.setLayoutParams(layoutParams2);

                mainLayout.addView(tableRow);

            }
            else if (figures[i].type() == R.drawable.triangle){
                Triangle triangle = (Triangle) figures[i];

                ImageView imgView = new ImageView(this);
                imgView.setImageResource(R.drawable.triangle);
                tableRow.addView(imgView);

                TextView txtView1 = new TextView(this);
                String fieldValue = String.format("%.3f ",triangle.field(triangle.getBase()));
                txtView1.setText(fieldValue);
                tableRow.addView(txtView1);

                TextView txtView2 = new TextView(this);
                String attrValue = String.format("Wysokosc \n %.3f", triangle.lengthParam());
                txtView2.setText(attrValue);
                tableRow.addView(txtView2);

                mainLayout.addView(tableRow);
            }
            else {
                Circle circle = (Circle) figures[i];
                ImageView imgView = new ImageView(this);
                imgView.setImageResource(R.drawable.circle);
                tableRow.addView(imgView);

                TextView txtView1 = new TextView(this);
                String fieldValue = String.format("%.3f ",circle.field(circle.getRadius()));
                txtView1.setText(fieldValue);
                tableRow.addView(txtView1);

                TextView txtView2 = new TextView(this);
                String attrValue = String.format("Srednica \n %.3f", circle.lengthParam());
                txtView2.setText(attrValue);
                tableRow.addView(txtView2);

                mainLayout.addView(tableRow);
            }

//            TextView text_view = new TextView(this);
//            text_view.setWidth(400);
//            text_view.setText("TEKST : " + i);
//            tableRow.addView(text_view);
//            ImageView imgView = new ImageView(this);
//            imgView.setImageResource(R.drawable.square);
//            tableRow.addView(imgView);
//            mainLayout.addView(tableRow);
            //ImageView imgView = myLayout.findViewById(R.id.imageView);
            //imgView.setImageResource(R.drawable.square);
            //tableRow.addView(myLayout);


        }

    }

    public Figure[] generateFigures(){
        int a=100;

        Random generator = new Random();
        float[][] los = new float[a][2];

        for(int i = 0; i < a; i++){
            los[i][0] = generator.nextInt(3);
            los[i][1] = generator.nextFloat();
        }

        Figure[] figures = new Figure[a];
        for(int i = 0; i < a; i++){
            if (los[i][0]==0) {
                figures[i]= new Square(los[i][1]);
            }
            else if (los[i][0]==1) {
                figures[i]= new Triangle(los[i][1]);
            }
            else {
                figures[i]= new Circle(los[i][1]);
            }
        }

        return figures;
    }
}

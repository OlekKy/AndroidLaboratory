package com.ak.figureslab;

import java.util.Random;

public class MainClass {
    public static void main(String[] args) {

        int n = 10;
        Random generator = new Random();

        Figure[] figures = new Figure[n];
        double sumOfSquares = 0;
        double sumOfTriangles = 0;
        double sumOfCircles = 0;
        for(int i = 0; i < n ; i++ ){

            float x = generator.nextFloat();
            if (x < 0.333f) {
                figures[i] = new Square(x);
                figures[i].setLinearDimension(x);
                sumOfSquares =  sumOfSquares + figures[i].field();
            }
            if (x > 0.333f && x < 0.666f){
                figures[i] = new Circle(x);
                figures[i].setLinearDimension(x);
                sumOfCircles = sumOfCircles + figures[i].field();
            }
            if (x > 0.666f) {
                figures[i] = new Triangle(x);
                figures[i].setLinearDimension(x);
                sumOfTriangles = sumOfTriangles + figures[i].field();
            }
        }


        for(int i = 0; i < n ; i++ ){
            System.out.format("%-7s o polu %.3f i %-10s %.3f i jednostce podstawowej: %.3f",
                    figures[i].name(), figures[i].field(),
                    figures[i].parameter(), figures[i].lengthParam(), figures[i].getLinearDimension() );
            System.out.println();
        }
        System.out.println("Kwadraty: " + sumOfSquares + "\n" + "Kola: " + sumOfCircles + "\n" + "Trojkaty: " + sumOfTriangles);
    }
}

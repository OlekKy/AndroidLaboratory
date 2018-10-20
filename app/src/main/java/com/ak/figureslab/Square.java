package com.ak.figureslab;

import static java.lang.Math.*;

public class Square extends Figure {

    private float side;

    public float getSide() {
        return side;
    }

    public void setSide(float side) {
        this.side = side;
    }

    public Square(float side) {
        this.side = side;
    }

    @Override
    public double field(float a) {
        return pow(a,2);
    }

    @Override
    public String name() {
        return "KWADRAT";
    }

    @Override
    public String parameter() {
        return "przekatnej";
    }

    @Override
    public double lengthParam() {
        return side*sqrt(2);
    }

    @Override
    public int type() {
        return R.drawable.square;
    }
}

package com.ak.figureslab;

import static java.lang.Math.*;

public class Triangle extends Figure {

    private float base;

    public float getBase() {
        return base;
    }
    public void setBase(float base) {
        this.base = base;
    }
    public Triangle(float base) {
        this.base = base;
    }
    @Override
    public double field() {
        return (pow(base,2) * sqrt(3)) /4;
    }

    @Override
    public String name() {
        return "TROJKAT";
    }

    @Override
    public String parameter() {
        return "wysokosci";
    }

    @Override
    public double lengthParam() {
        return (base*sqrt(3))/2;
    }

    @Override
    public int type() {
        return R.drawable.triangle;
    }
}

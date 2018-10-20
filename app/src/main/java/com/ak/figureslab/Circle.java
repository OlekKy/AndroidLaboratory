package com.ak.figureslab;

import static java.lang.Math.*;

public class Circle extends Figure {

    private float radius;

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    public double field(float r) {
        return PI*pow(r,2);
    }

    @Override
    public String name() {
        return "KOLO";
    }

    @Override
    public String parameter() {
        return "srednicy";
    }

    @Override
    public double lengthParam() {
        return 2*radius;
    }

    @Override
    public int type() {
        return R.drawable.circle;
    }
}

package com.ak.figureslab;

public abstract class Figure {

    private String figureName;
    private String figureParameter;
    private float linearDimension;

    public String getFigureName() {
        return figureName;
    }
    public void setFigureName(String figureName) {
        this.figureName = figureName;
    }
    public String getFigureParameter() {
        return figureParameter;
    }
    public void setFigureParameter(String figureParameter) {
        this.figureParameter = figureParameter;
    }
    public float getLinearDimension() {
        return linearDimension;
    }
    public void setLinearDimension(float linearDimension) {
        this.linearDimension = linearDimension;
    }

    public abstract double field();

    public abstract String name();
    public abstract String parameter();
    public abstract double lengthParam();

    public abstract int type();
}

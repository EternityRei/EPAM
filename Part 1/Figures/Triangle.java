package com.epam.rd.autotasks.figures;

class Triangle extends Figure{

    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }


    @Override
    public double area() {
        double x1 = this.a.getX(), y1 = this.a.getY();
        double x2 = this.b.getX(), y2 = this.b.getY();
        double x3 = this.c.getX(), y3 = this.c.getY();
        double square = Math.abs((x2 - x1)*(y3 - y1) - (x3 - x1) * (y2 - y1)) / 2;
        return square;
    }

    @Override
    public String pointsToString() {
        return "(" + this.a.getX() + "," + this.a.getY() + ")"
                + "(" + this.b.getX() + "," + this.b.getY() + ")"
                + "(" + this.c.getX() + "," + this.c.getY() + ")";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + "]";
    }

    @Override
    public Point leftmostPoint() {
        double min = Math.min(Math.min(a.getX(), b.getX()), c.getX());
        if(min == a.getX())
            return a;
        else if(min == b.getX())
            return b;
        else
            return c;
    }


}

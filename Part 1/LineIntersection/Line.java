package com.epam.rd.autotasks.intersection;

public class Line extends Point{
    private double k;
    private double b;

    Line(Point a, Point b) {
        if (a.equals(b))
            return;
        double A = a.getY() - b.getY();
        double B = b.getX() - a.getX();
        if (B == 0)
            return;
        double C = a.getX() * b.getY() - b.getX() * a.getY();
        this.k = - A / B;
        this.b = - C / B;
    }

    Line(int k, int b) {
        this.k = k;
        this.b = b;
    }
    public double getK() {
        return k;
    }

    public double getB() {
        return b;
    }

    public Point intersection(Line other) {
        //уравнение прямой: y = kx + b
        if (getK() == other.getK())
            return null;
        int x  = (int) ((other.getB() - getB()) / (getK() - other.getK()));
        int y = (int) (getK() * x + getB());
        return new Point(x, y);


    }

}

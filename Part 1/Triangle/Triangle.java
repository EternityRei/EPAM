package com.epam.rd.autotasks.triangle;

class Triangle {
    private Point a;
    private Point b;
    private Point c;
    double length1,length2,length3;

    public Triangle(Point a, Point b, Point c) {
        if (a == null || b == null || c == null)
            throw new RuntimeException();
        if ((a.getX()-b.getX())*(c.getY()-b.getY())-(a.getY()-b.getY())*(c.getX()-b.getX())==0)
            throw new RuntimeException();
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public double area() {
        double x1 = this.a.getX(), y1 = this.a.getY();
        double x2 = this.b.getX(), y2 = this.b.getY();
        double x3 = this.c.getX(), y3 = this.c.getY();
        double square = Math.abs((x2 - x1)*(y3 - y1) - (x3 - x1) * (y2 - y1)) / 2;
        return square;
    }

    public Point centroid(){
        double xc = (((a.getX()+b.getX()+c.getX())/3));
        double yc = (((a.getY()+b.getY()+c.getY())/3));
        return new Point(xc, yc);
    }

}

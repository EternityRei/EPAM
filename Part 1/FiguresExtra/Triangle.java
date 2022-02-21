package com.epam.rd.autotasks.figures;

class Triangle extends Figure{

    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;

        if (a == null || b == null || c == null)
            throw new IllegalArgumentException();
        if ((a.getX()-b.getX())*(c.getY()-b.getY())-(a.getY()-b.getY())*(c.getX()-b.getX())==0)
            throw new IllegalArgumentException();
    }


    @Override
    public Point centroid() {
        double xc = (((a.getX()+b.getX()+c.getX())/3));
        double yc = (((a.getY()+b.getY()+c.getY())/3));
        return new Point(xc, yc);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if(figure instanceof Triangle) return true;
        return false;
    }
}

package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {

    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {
        double x1 = this.a.getX(), y1 = this.a.getY();
        double x2 = this.b.getX(), y2 = this.b.getY();
        double x3 = this.c.getX(), y3 = this.c.getY();
        double x4 = this.d.getX(), y4 = this.d.getY();
        double square = ((Math.abs((x2 - x1)*(y3 - y1) - (x3 - x1) * (y2 - y1)) / 2)
                + (Math.abs((x4 - x1)*(y3 - y1) - (x3 - x1) * (y4 - y1)) / 2));
        return square;
    }

    @Override
    public String pointsToString() {
        return "(" + this.a.getX() + "," + this.a.getY() + ")"
                + "(" + this.b.getX() + "," + this.b.getY() + ")"
                + "(" + this.c.getX() + "," + this.c.getY() + ")"
                + "(" + this.d.getX() + "," + this.d.getY() + ")";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + "]";
    }

    @Override
    public Point leftmostPoint() {
        if(this.a.getX() < this.b.getX() && this.a.getX() < this.c.getX() && this.a.getX() < this.d.getX())
            return this.a;
        else if(this.b.getX() < this.a.getX() && this.b.getX() < this.c.getX() && this.b.getX() < this.d.getX())
            return this.b;
        else if (this.c.getX() < this.a.getX() && this.c.getX() < this.b.getX() && this.c.getX() < this.d.getX())
            return this.c;
        else return this.d;
    }
}

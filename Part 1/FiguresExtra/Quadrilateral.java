package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {

    private double k;
    private double f;

    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        if (a == null || b == null || c == null || d == null)
            throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        if ((a.getX() - b.getX()) * (c.getY() - b.getY()) - (a.getY() - b.getY()) * (c.getX() - b.getX()) == 0)
            throw new IllegalArgumentException();

        double x1 = this.a.getX(), y1 = this.a.getY();
        double x2 = this.b.getX(), y2 = this.b.getY();
        double x3 = this.c.getX(), y3 = this.c.getY();
        double x4 = this.d.getX(), y4 = this.d.getY();

        if(isConvex(x1,x2,x3,x4,y1,y2,y3,y4))
            throw new IllegalArgumentException();

    }


    @Override
    public Point centroid() {

        //центроид АВС т.O
        double xabc = (((a.getX() + b.getX() + c.getX()) / 3));
        double yabc = (((a.getY() + b.getY() + c.getY()) / 3));

        //центроид ADC т.Q
        double xadc = (((a.getX() + d.getX() + c.getX()) / 3));
        double yadc = (((a.getY() + d.getY() + c.getY()) / 3));

        //центроид ABD т.H
        double xabd = (((a.getX() + b.getX() + d.getX()) / 3));
        double yabd = (((a.getY() + b.getY() + d.getY()) / 3));

        //центроид DBC т.K
        double xdbc = (((d.getX() + b.getX() + c.getX()) / 3));
        double ydbc = (((d.getY() + b.getY() + c.getY()) / 3));


        double d = (ydbc - yabd) * (xadc - xabc) - (xdbc - xabd) * (yadc - yabc);
        if(d == 0) return null;

        double ua = ((xdbc - xabd) * (yabc - yabd) - (ydbc - yabd) * (xabc - xabd))/ d;

        double x = xabc + ua * (xadc - xabc);
        double y = yabc + ua * (yadc - yabc);

        return new Point(x,y);

    }


    @Override
    public boolean isTheSame(Figure figure) {
        if(figure instanceof Quadrilateral) return true;
        return false;
    }

    public double square(double x1, double x2, double x3, double x4, double y1, double y2, double y3, double y4){
        double squareABC = Math.abs(((x2 - x1)*(y3 - y1) - (x3 - x1) * (y2 - y1)) / 2);
        double squareADC = Math.abs(((x4 - x1)*(y3 - y1) - (x3 - x1) * (y4 - y1)) / 2);
        double squareABD = Math.abs(((x2 - x1)*(y4 - y1) - (x4 - x1) * (y2 - y1)) / 2);
        double squareDBC = Math.abs(((x2 - x4)*(y3 - y4) - (x3 - x4) * (y2 - y4)) / 2);

        double square = squareABC + squareADC + squareDBC + squareABD;
        return square;
    }

    public boolean isConvex(double x1, double x2, double x3, double x4, double y1, double y2, double y3, double y4){
        double squareABC = Math.abs(((x2 - x1)*(y3 - y1) - (x3 - x1) * (y2 - y1)) / 2);
        double squareADC = Math.abs(((x4 - x1)*(y3 - y1) - (x3 - x1) * (y4 - y1)) / 2);
        double squareABD = Math.abs(((x2 - x1)*(y4 - y1) - (x4 - x1) * (y2 - y1)) / 2);
        double squareDBC = Math.abs(((x2 - x4)*(y3 - y4) - (x3 - x4) * (y2 - y4)) / 2);

        if(squareABC + squareADC == squareABD + squareDBC) return false;
        else return true;
    }

    public boolean plain(double x1, double x2, double x3, double x4, double y1, double y2, double y3, double y4){
        if(x1 == x2 || x1 == x3 || x1 == x4 || x2 == x3 || x2 == x4 || x3 == x4
                || y1 == y2 || y1 == y3 || y1 == y4 || y2 == y3 || y2 == y4| y3 == y4) return true;
        else return false;
    }
}

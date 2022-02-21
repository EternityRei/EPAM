package com.epam.rd.autotasks.segments;

class Segment {
    private Point start;
    private Point end;

    public Segment(Point start, Point end) {
        if (start == null || end == null)
            throw new IllegalArgumentException();
        if (start.equals(end))
            throw new IllegalArgumentException();
        this.start = start;
        this.end = end;
    }

    double length() {
        double xDistanceSquare = Math.pow(start.getX() - end.getX(), 2);
        double yDistanceSquare = Math.pow(start.getY() - end.getY(), 2);
        return Math.sqrt(xDistanceSquare + yDistanceSquare);
    }

    Point middle() {
        return new Point( (start.getX() + end.getX()) / 2,
                (start.getY() + end.getY()) / 2 );
    }

    Point intersection(Segment another) {
        double y12 = this.end.getY(), y11 = this.start.getY(), x12 = this.end.getX(), x11 = this.start.getX();
        double y22 = another.end.getY(), y21 = another.start.getY(), x22 = another.end.getX(), x21 = another.start.getX();
        double k1 = (y12 - y11) / (x12 - x11);
        double k2 = (y22 - y21) / (x22 - x21);
        double d1 = (x12 * y11 - x11 * y12) / (x12 - x11);
        double d2 = (x22 * y21 - x21 * y22) / (x22 - x21);
        double d = (x11 - x12) * (y21 - y22) - (y11 - y12) * (x21  - x22);
        if (d == 0)
            return null;

        double v1x = this.start.getY() - this.start.getX(); // вектор AB
        double v1y = this.end.getY() - this.start.getY();
        double v2x = another.start.getX() - this.start.getX(); // вектор AC
        double v2y = another.start.getY() - this.start.getY();
        double v3x = another.end.getX() - this.start.getX(); // вектор AD
        double v3y = another.end.getY() - this.start.getY();
        double v4x = another.end.getX() - another.start.getX(); // вектор CD
        double v4y = another.end.getY() - another.start.getY();
        double v5x = this.end.getX() - another.start.getX(); // вектор CB
        double v5y = this.end.getY() - another.start.getY();
        double v6x = this.start.getX() - another.start.getX(); // вектор CA
        double v6y = this.start.getY() - another.start.getY();

        double xi = ((x21   - x22) * (x11  * y12 - y11 * x12) - (x11 - x12) * (x21  * y22 - y21  * x22)) / d;
        double yi = ((y21  - y22) * (x11  * y12 - y11 * x12) - (y11 - y12) * (x21  * y22 - y21  * x22)) / d;


        double coord1 = v1x * v2y - v1y * v2x; // [AB, AC]
        double coord2 = v1x * v3y - v1y * v3x; // [AB, AD]
        double coord3 = v4x * v5y - v4y * v5x; // [CD, CB]
        double coord4 = v4x * v6y - v4y * v6x; // [CD, CA]

        if(coord1 * coord2 <= 0 && coord3 * coord4 <= 0)
            return new Point(xi, yi);
        else
            return null;
    }

}



package com.epam.rd.autotasks.figures;

import java.util.Locale;

class Circle extends Figure{

    private double radius;
    private Point o;

    public Circle(Point o, double radius){
        this.o = o;
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public String pointsToString() {
        return String.format(Locale.ROOT, "(%.1f,%.1f)",
                o.getX(),o.getY());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + radius +"]";
    }

    @Override
    public Point leftmostPoint() {
        return new Point(o.getX()-radius, o.getY());
    }
}

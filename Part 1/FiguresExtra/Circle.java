package com.epam.rd.autotasks.figures;

class Circle extends Figure{

    private double radius;
    private Point o;

    public Circle(Point o, double radius){
        this.o = o;
        this.radius = radius;
        double square = Math.PI * this.radius * this.radius;
        if(square == 0 || this.radius < 0 || this.o == null) throw new IllegalArgumentException();
    }

    @Override
    public Point centroid() {
        return this.o;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if(figure instanceof Circle) return true;
        return false;
    }
}

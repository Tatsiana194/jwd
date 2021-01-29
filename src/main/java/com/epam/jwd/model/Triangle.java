package com.epam.jwd.model;

public class Triangle extends Figure {
    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Triangle(FigureType figureType) {
        super(figureType);
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public boolean isFigure(Triangle triangle) {
        if (triangle.pointA == triangle.pointB | triangle.pointB == triangle.pointC | triangle.pointA == triangle.pointC) {
            return false;
        }
        return true;
    }

    public static boolean isValidTriangle(Triangle triangle) {
        Point a = triangle.getPointA();
        Point b = triangle.getPointB();
        Point c = triangle.getPointC();

        //formula for calculating a line by coordinates
        if (((c.getX() - a.getX()) / (b.getX() - a.getX())) == ((c.getY() - a.getY()) / (b.getX() - a.getY()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                ", x=" + pointA +
                ", y=" + pointB +
                ", z=" + pointC +
                '}';
    }
}

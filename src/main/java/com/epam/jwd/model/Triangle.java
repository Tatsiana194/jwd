package com.epam.jwd.model;

import com.epam.jwd.strategy.FigurePropertiesStrategy;
import com.epam.jwd.strategy.TriangleStrategy;

public class Triangle extends Figure {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private FigurePropertiesStrategy figurePropertiesStrategy = TriangleStrategy.INSTANCE;

    public Triangle() {
    }

    @Override
    public Point[] getPoints() {
        return new Point[]{pointA, pointB, pointC};
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

    public int countArea(Triangle triangle) {
        return figurePropertiesStrategy.countArea(triangle);
    }

    public int countPerimeter(Triangle triangle) {
        return figurePropertiesStrategy.countPerimeter(triangle);
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

        //the area of triangle is | ((x1-x3)*(y2-y3)-(x2-x3)*(y1-y3)/2 |
        int areaTriangle = Math.abs((a.getX() - c.getX()) * (b.getY() - c.getY()) - (b.getX() - c.getX()) * (a.getY() - c.getY()) / 2);

        //if the area of triangle is zero, then the triangle does not exist
        if (areaTriangle == 0) {
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

package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.Triangle;

public enum TriangleStrategy implements FigurePropertiesStrategy {
    INSTANCE;
    private Triangle triangle;

    private TriangleStrategy(){}

    @Override
    public int countArea(Figure figure) {
        this.triangle = (Triangle) figure;
        Point a = triangle.getPointA();
        Point b = triangle.getPointB();
        Point c = triangle.getPointC();

        //the area of triangle is | ((x1-x3)*(y2-y3)-(x2-x3)*(y1-y3)/2 |
        int areaTriangle = Math.abs((a.getX() - c.getX()) * (b.getY() - c.getY()) - (b.getX() - c.getX()) * (a.getY() - c.getY()) / 2);
        return areaTriangle;
    }

    @Override
    public int countPerimeter(Figure figure) {
        this.triangle = (Triangle) figure;
        Point a = triangle.getPointA();
        Point b = triangle.getPointB();
        Point c = triangle.getPointC();

        //segment length by coordinates = sqrt( (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) )
        int ac = (int) Math.sqrt(Math.pow(2, (a.getX() - c.getX())) + Math.pow(2, (a.getY() - c.getY())));
        int ab = (int) Math.sqrt(Math.pow(2, (a.getX() - b.getX())) + Math.pow(2, (a.getY() - b.getY())));
        int cb = (int) Math.sqrt(Math.pow(2, (c.getX() - b.getX())) + Math.pow(2, (c.getY() - b.getY())));

        //the perimeter of the triangle is AC+AB+CB
        int areaTriangle = ac + ab + cb;
        return areaTriangle;
    }
}

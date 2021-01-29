package com.epam.jwd.model;

public class Line extends Figure {
    private Point pointA;
    private Point pointB;

    public Line(FigureType figureType, Point pointA, Point pointB) {
        super(figureType);
        this.pointA = pointA;
        this.pointB = pointB;
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

    public boolean isFigure(Line line) {
        if (line.pointA == line.pointB) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Line{" +
                "pointA=" + pointA +
                ", pointB=" + pointB +
                '}';
    }
}

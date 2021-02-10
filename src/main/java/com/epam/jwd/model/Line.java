package com.epam.jwd.model;

public class Line extends Figure {
    private Point pointA;
    private Point pointB;

    public Line() {
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
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
    public Point[] getPoints() {
        return new Point[]{pointA, pointB};
    }

    @Override
    public String toString() {
        return "Line{" +
                "pointA=" + pointA +
                ", pointB=" + pointB +
                '}';
    }
}

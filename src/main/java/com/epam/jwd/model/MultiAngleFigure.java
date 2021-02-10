package com.epam.jwd.model;

public class MultiAngleFigure extends Figure {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;
    private Point pointE;
    private Point pointF;

    @Override
    public Point[] getPoints() {
        return new Point[]{pointA, pointB, pointC, pointD, pointE, pointF};
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public void setPointD(Point pointD) {
        this.pointD = pointD;
    }

    public void setPointE(Point pointE) {
        this.pointE = pointE;
    }

    public void setPointF(Point pointF) {
        this.pointF = pointF;
    }

    @Override
    public String toString() {
        return "MultiAngleFigure{" +
                "pointA=" + pointA +
                ", pointB=" + pointB +
                ", pointC=" + pointC +
                ", pointD=" + pointD +
                ", pointE=" + pointE +
                ", pointF=" + pointF +
                '}';
    }
}

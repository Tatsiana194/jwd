package com.epam.jwd.model;

import com.sun.jdi.IntegerValue;
import org.apache.log4j.Level;

public class Square extends Figure {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    public Square(FigureType figureType) {
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

    public Point getPointD() {
        return pointD;
    }

    public void setPointD(Point pointD) {
        this.pointD = pointD;
    }

    public boolean isFigure(Square square) {
        if (square.pointA == square.pointB | square.pointB == square.pointC | square.pointC == square.pointD | square.pointD == square.pointA | square.pointA == square.pointC | square.pointB == square.pointD) {
            return false;
        }
        return true;
    }

    public boolean isValidSquare(Square square) {
        Point a = square.getPointA();
        Point b = square.getPointB();
        Point c = square.getPointC();
        Point d = square.getPointD();

        //center of square is the intersection point of its diagonals
        int xCentralAC = (a.getX() + c.getX()) / 2;
        int yCentralAC = (a.getY() + c.getY()) / 2;
        int xCentralBD = (b.getX() + d.getY()) / 2;
        int yCentralBD = (b.getY() + d.getY()) / 2;
        if (xCentralAC != xCentralBD | yCentralAC != yCentralBD) {
            return false;
        }

        //and diagonals of square must be equal
        int sizeAC = (int) Math.sqrt(Math.pow(a.getX() - c.getY(), 2) + Math.pow(a.getY() - c.getY(), 2));
        int sizeBD = (int) Math.sqrt(Math.pow(b.getX() - d.getY(), 2) + Math.pow(b.getY() - d.getY(), 2));
        ;
        if (sizeAC != sizeBD) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Square{" +
                "x=" + pointA +
                ", y=" + pointB +
                ", q=" + pointC +
                ", z=" + pointD +
                '}';
    }
}

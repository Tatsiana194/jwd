package com.epam.jwd;

import com.epam.jwd.model.*;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Random;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);
    private static Point[] points = new Point[4];
    private static Line[] lines = new Line[2];
    private static Triangle[] triangles = new Triangle[2];
    private static Square[] squares = new Square[1];

    public static void main(String[] args) {
        showPoints(creatorPointArray());
        showLines(creatorLinesArray(points));
        showTriangles(creatorTrianglesArray(points));
        showSquares(creatorSquaresArray(points));
    }

    private static Point[] creatorPointArray() {
        Point point;

        for (int i = 0; i < points.length; i++) {
            point = new Point(new Random().nextInt(), new Random().nextInt());
            points[i] = point;
        }
        return points;
    }

    static private Line[] creatorLinesArray(Point[] points) {
        Line line;
        for (int i = 0; i < lines.length; i++) {
            line = new Line(FigureType.LINE, points[i], points[i + 1]);
            lines[i] = line;
        }
        return lines;
    }

    static private Triangle[] creatorTrianglesArray(Point[] points) {
        Triangle triangle = new Triangle(FigureType.TRIANGLE);
        for (int i = 0; i < triangles.length; i++) {
            triangle.setPointA(points[i]);
            triangle.setPointB(points[i + 1]);
            triangle.setPointC(points[i + 2]);
            triangles[i] = triangle;
        }
        return triangles;
    }

    static private Square[] creatorSquaresArray(Point[] points) {
        Square square = new Square(FigureType.SQUARE);
        for (int i = 0; i < squares.length; i++) {
            square.setPointA(points[i]);
            square.setPointB(points[i + 1]);
            square.setPointC(points[i + 2]);
            square.setPointD(points[i + 3]);
            squares[i] = square;
        }
        return squares;
    }

    static private void showPoints(Point[] points) {
        int i = 0;
        do {
            logger.log(Level.INFO, points[i].toString());
            i++;
        } while (i < points.length);
    }

    static private void showLines(Line[] lines) {
        for (int i = 0; i < lines.length; i++) {
            if (!lines[i].isFigure(lines[i])) {
                logger.log(Level.ERROR, lines[i].toString() + " is not a figure " + lines[i].getClass().getSimpleName());
                break;
            }
            logger.log(Level.INFO, lines[i].toString());
        }
    }

    static private void showTriangles(Triangle[] triangles) {
        for (int i = 0; i < triangles.length; i++) {
            if (!triangles[i].isFigure(triangles[i])) {
                logger.log(Level.ERROR, triangles[i].toString() + " is not a figure " + triangles[i].getClass().getSimpleName());
                break;
            }
            if (!triangles[i].isValidTriangle(triangles[i])) {
                logger.log(Level.ERROR, triangles[i].getClass().getSimpleName() + " cannot exist");
                break;
            }
            logger.log(Level.INFO, triangles[i].toString());
        }
    }

    static private void showSquares(Square[] squares) {
        for (int i = 0; i < squares.length; i++) {
            if (!squares[i].isFigure(squares[i])) {
                logger.log(Level.ERROR, Object.class.getSimpleName() + " is not a figure");
                break;
            }
            if (!squares[i].isValidSquare(squares[i])) {
                logger.log(Level.ERROR, Object.class.getSimpleName() + " is not a square");
                break;
            }
            logger.log(Level.INFO, squares[i].toString());
        }
    }
}
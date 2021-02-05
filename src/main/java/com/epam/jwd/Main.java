package com.epam.jwd;

import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.*;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);
    private static Point[] points = new Point[6];
    private static Line[] lines = new Line[2];
    private static Triangle[] triangles = new Triangle[2];
    private static Square[] squares = new Square[1];
    private static MultiAngleFigure[] multiAngleFigures = new MultiAngleFigure[5];
    private static FigureFactory figureFactory = FigureFactory.getInstance();

    public static void main(String[] args) {
        showPoints(creatorPointArray());
        showLines(creatorLinesArray());
        showTriangles(creatorTrianglesArray());
        showSquares(creatorSquaresArray());
        showMultiAngleFigure(creatorMultiAnglesArray());
    }

    private static Point[] creatorPointArray() {
        Point point;
        for (int i = 0; i < points.length; i++) {
            point = new Point((int) (-100 + Math.random() * 200), (int) (-100+ Math.random()*200));
            points[i] = point;
        }
        return points;
    }

    private static Line[] creatorLinesArray() {
        for (int i = 0; i < lines.length; i++) {
            points = creatorPointArray();
            lines[i] = (Line) figureFactory.getFigure(FigureType.LINE, points);
        }
        return lines;
    }

    private static Triangle[] creatorTrianglesArray() {
        for (int i = 0; i < triangles.length; i++) {
            points = creatorPointArray();
            triangles[i] = (Triangle) figureFactory.getFigure(FigureType.TRIANGLE, points);
        }
        return triangles;
    }

    private static Square[] creatorSquaresArray() {
        for (int i = 0; i < squares.length; i++) {
            points = creatorPointArray();
            squares[i] = (Square) figureFactory.getFigure(FigureType.SQUARE, points);
        }
        return squares;
    }

    private static MultiAngleFigure[] creatorMultiAnglesArray() {
        for (int i = 0; i < multiAngleFigures.length; i++) {
            points = creatorPointArray();
            multiAngleFigures[i] = (MultiAngleFigure) figureFactory.getFigure(FigureType.MULTIANGLE, points);
        }
        return multiAngleFigures;
    }

    private static void showPoints(Point[] points) {
        int i = 0;
        do {
            logger.log(Level.INFO, points[i].toString());
            i++;
        } while (i < points.length);
    }

    private static void showLines(Line[] lines) {
        for (int i = 0; i < lines.length; i++) {
            if (!lines[i].isFigure(lines[i])) {
                logger.log(Level.ERROR, lines[i].toString() + " is not a figure " + lines[i].getClass().getSimpleName());
                break;
            }
            logger.log(Level.INFO, lines[i].toString());
        }
    }

    private static void showTriangles(Triangle[] triangles) {
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
            logger.log(Level.INFO, "Area of Triangle is " + triangles[i].countArea(triangles[i]));
            logger.log(Level.INFO, "Perimeter of Triangle is " + triangles[i].countPerimeter(triangles[i]));
        }
    }

    private static void showSquares(Square[] squares) {
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
            logger.log(Level.INFO, "Area of Square is " + squares[i].countArea(squares[i]));
            logger.log(Level.INFO, "Perimeter of Square is " + squares[i].countPerimeter(squares[i]));
        }
    }

    private static void showMultiAngleFigure(MultiAngleFigure[] multiAngleFigures) {
        for (int i = 0; i < multiAngleFigures.length; i++) {
            logger.log(Level.INFO, "This is multiAngleFigure number " + i + " : " + multiAngleFigures[i].toString());
        }
    }
}
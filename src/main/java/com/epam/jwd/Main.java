package com.epam.jwd;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.ApplicationContext;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.factory.impl.ConcreteApplicationContext;
import com.epam.jwd.model.*;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);
    private static Point[] points = new Point[6];
    private static Line[] lines = new Line[2];
    private static Triangle[] triangles = new Triangle[2];
    private static Square[] squares = new Square[1];
    private static MultiAngleFigure[] multiAngleFigures = new MultiAngleFigure[5];
    private static ApplicationContext applicationContext = ConcreteApplicationContext.getInstance();
    private static FigureFactory figureFactory = applicationContext.getFigureFactory();

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
            point = new Point((int) (-100 + Math.random() * 200), (int) (-100 + Math.random() * 200));
            points[i] = point;
        }
        return points;
    }

    private static Line[] creatorLinesArray() {
        for (int i = 0; i < lines.length; i++) {
            points = creatorPointArray();
            try {
                lines[i] = (Line) figureFactory.createFigure(FigureType.LINE, points);
            } catch (FigureException e) {
                logger.log(Level.INFO, "Something went wrong while creating the line");
                logger.log(Level.ERROR, e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                logger.log(Level.ERROR, e.getMessage());
                e.printStackTrace();
            }
        }
        return lines;
    }

    private static Triangle[] creatorTrianglesArray() {
        for (int i = 0; i < triangles.length; i++) {
            points = creatorPointArray();
            try {
                triangles[i] = (Triangle) figureFactory.createFigure(FigureType.TRIANGLE, points);
            } catch (FigureException e) {
                logger.log(Level.ERROR, "Something went wrong while creating the triangle");
                logger.log(Level.ERROR, e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                logger.log(Level.ERROR, e.getMessage());
                e.printStackTrace();
            }
        }
        return triangles;
    }

    private static Square[] creatorSquaresArray() {
        for (int i = 0; i < squares.length; i++) {
            points = creatorPointArray();
            try {
                squares[i] = (Square) figureFactory.createFigure(FigureType.SQUARE, points);
            } catch (FigureException e) {
                logger.log(Level.ERROR, "Something went wrong while creating the square");
                logger.log(Level.ERROR, e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                logger.log(Level.ERROR, e.getMessage());
                e.printStackTrace();
            }
        }
        return squares;
    }

    private static MultiAngleFigure[] creatorMultiAnglesArray() {
        for (int i = 0; i < multiAngleFigures.length; i++) {
            points = creatorPointArray();
            try {
                multiAngleFigures[i] = (MultiAngleFigure) figureFactory.createFigure(FigureType.MULTIANGLE, points);
            } catch (FigureException e) {
                logger.log(Level.ERROR, "Something went wrong while creating the multiAngleFigure");
                logger.log(Level.ERROR, e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                logger.log(Level.ERROR, e.getMessage());
                e.printStackTrace();
            }
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
        for (Line line : lines) {
            if (!line.isFigure(line)) {
                logger.log(Level.ERROR, line.toString() + " is not a figure " + line.getClass().getSimpleName());
                break;
            }
            logger.log(Level.INFO, line.toString());
        }
    }

    private static void showTriangles(Triangle[] triangles) {
        for (Triangle triangle : triangles) {
            if (!triangle.isFigure(triangle)) {
                logger.log(Level.ERROR, triangle.toString() + " is not a figure " + triangle.getClass().getSimpleName());
                break;
            }
            if (!triangle.isValidTriangle(triangle)) {
                logger.log(Level.ERROR, triangle.getClass().getSimpleName() + " cannot exist");
                break;
            }
            logger.log(Level.INFO, triangle.toString());
            logger.log(Level.INFO, "Area of Triangle is " + triangle.countArea(triangle));
            logger.log(Level.INFO, "Perimeter of Triangle is " + triangle.countPerimeter(triangle));
        }
    }

    private static void showSquares(Square[] squares) {
        Arrays.stream(squares)
                .filter(square -> square.isFigure(square))
                .forEach(square -> logger.log(Level.ERROR, square.getFigureType() + " is not a figure"));
        Arrays.stream(squares)
                .filter(square -> square.isValidSquare(square))
                .forEach(square -> logger.log(Level.ERROR, square.getFigureType() + " is not a square"));
        Arrays.stream(squares)
                .filter(square -> !square.isFigure(square))
                .filter(square -> !square.isValidSquare(square))
                .peek(square -> logger.log(Level.INFO, "Area of Square is " + square.countArea(square)))
                .forEach(square -> logger.log(Level.INFO, "Perimeter of Square is " + square.countPerimeter(square)));
    }

    private static void showMultiAngleFigure(MultiAngleFigure[] multiAngleFigures) {
        for (MultiAngleFigure multiAngleFigure : multiAngleFigures) {
            logger.log(Level.INFO, "This is multiAngleFigure number : " + multiAngleFigure.toString());
        }
    }
}
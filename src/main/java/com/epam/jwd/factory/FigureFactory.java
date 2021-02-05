package com.epam.jwd.factory;

import com.epam.jwd.model.*;

public class FigureFactory {
    private static FigureFactory instance;

    private FigureFactory() {
    }

    public static FigureFactory getInstance() {
        if (instance == null) {
            instance = new FigureFactory();
        }
        return instance;
    }

    public Figure getFigure(FigureType figureType, Point[] points) {
        Figure figure = null;
        switch (figureType) {
            case LINE -> {
                Line line = Line.getInstance();
                line.setPointA(points[0]);
                line.setPointB(points[1]);
                figure = line;
            }
            case TRIANGLE -> {
                Triangle triangle = Triangle.getInstance();
                triangle.setPointA(points[0]);
                triangle.setPointB(points[1]);
                triangle.setPointC(points[2]);
                figure = triangle;
            }
            case SQUARE -> {
                Square square = Square.getInstance();
                square.setPointA(points[0]);
                square.setPointB(points[1]);
                square.setPointC(points[2]);
                square.setPointD(points[3]);
                figure = square;
            }
            case MULTIANGLE -> {
                MultiAngleFigure multiAngleFigure = new MultiAngleFigure();
                int numberPoints = 4 + (int) (Math.random() * 3);
                switch (numberPoints) {
                    case 4 -> {
                        multiAngleFigure.setPointA(points[0]);
                        multiAngleFigure.setPointB(points[1]);
                        multiAngleFigure.setPointC(points[2]);
                        multiAngleFigure.setPointD(points[3]);
                    }
                    case 5 -> {
                        multiAngleFigure.setPointA(points[0]);
                        multiAngleFigure.setPointB(points[1]);
                        multiAngleFigure.setPointC(points[2]);
                        multiAngleFigure.setPointD(points[3]);
                        multiAngleFigure.setPointE(points[4]);
                    }
                    case 6 -> {
                        multiAngleFigure.setPointA(points[0]);
                        multiAngleFigure.setPointB(points[1]);
                        multiAngleFigure.setPointC(points[2]);
                        multiAngleFigure.setPointD(points[3]);
                        multiAngleFigure.setPointE(points[4]);
                        multiAngleFigure.setPointF(points[5]);
                    }
                }
                figure = multiAngleFigure;
            }
        }
        return figure;
    }
}

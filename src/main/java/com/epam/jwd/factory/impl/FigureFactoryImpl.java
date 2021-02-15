package com.epam.jwd.factory.impl;

import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.*;

public class FigureFactoryImpl implements FigureFactory {
    private static FigureFactoryImpl instance;
    Figure figure;

    private FigureFactoryImpl() {
    }

    public static FigureFactoryImpl getInstance() {
        if (instance == null) {
            instance = new FigureFactoryImpl();
        }
        return instance;
    }

    public Figure createFigure(FigureType figureType, Point[] points) throws FigureNotExistException {
        switch (figureType) {
            case LINE -> {
                Line line = new Line();
                line.setPointA(points[0]);
                line.setPointB(points[1]);
                figure = line;
            }
            case TRIANGLE -> {
                Triangle triangle = new Triangle();
                triangle.setPointA(points[0]);
                triangle.setPointB(points[1]);
                triangle.setPointC(points[2]);
                figure = triangle;
            }
            case SQUARE -> {
                Square square = new Square();
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

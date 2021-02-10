package com.epam.jwd.factory;

import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

public abstract class FigureFactoryDecorator implements FigureFactory {
    private FigureFactory figureFactory;

    public FigureFactoryDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure createFigure(FigureType figureType, Point[] points) throws FigureNotExistException, Exception {
        return figureFactory.createFigure(figureType, points);
    }
}

package com.epam.jwd.factory;

import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

public interface FigureFactory {
    Figure createFigure(FigureType figureType, Point[] points) throws FigureNotExistException;

    Figure getFigure();
}

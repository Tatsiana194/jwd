package com.epam.jwd.model;

import com.epam.jwd.strategy.FigurePropertiesStrategy;

public abstract class Figure {
    private static int id;
    private FigureType figureType;
    private FigurePropertiesStrategy figurePropertiesStrategy;
    private Point[] points;

    public Figure(FigureType figureType, FigurePropertiesStrategy figurePropertiesStrategy) {
        this.figureType = figureType;
        this.figurePropertiesStrategy = figurePropertiesStrategy;
        id++;
    }

    public Figure() {
    }

    public Point[] getPoints() {
        return points;
    }

    public FigureType getFigureType() {
        return figureType;
    }
}

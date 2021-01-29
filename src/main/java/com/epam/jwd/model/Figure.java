package com.epam.jwd.model;

public abstract class Figure {
    private static int id;

    private FigureType figureType;

    public Figure(FigureType figureType) {
        this.figureType = figureType;
        id++;
    }
}

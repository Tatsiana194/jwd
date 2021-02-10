package com.epam.jwd.model;

import com.epam.jwd.strategy.FigurePropertiesStrategy;

public class Figure {
    private static int id;
    private FigureType figureType;
    private FigurePropertiesStrategy figurePropertiesStrategy;

    public Figure(FigureType figureType, FigurePropertiesStrategy figurePropertiesStrategy) {
        this.figureType = figureType;
        this.figurePropertiesStrategy = figurePropertiesStrategy;
        id++;
    }

    public Figure() {
    }
}

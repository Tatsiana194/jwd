package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;

public interface FigurePropertiesStrategy {
    int countArea(Figure figure);
    int countPerimeter(Figure figure);
}

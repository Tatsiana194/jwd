package com.epam.jwd.factory.impl;

import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.factory.FigureFactoryDecorator;
import com.epam.jwd.factory.PostProcessor;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class PostProcessorDecorator extends FigureFactoryDecorator implements PostProcessor {
    private Logger logger = LogManager.getLogger(PostProcessorDecorator.class);
    private List<Figure> figures = ConcreteApplicationContext.getInstance().getFigureCache();
    private Figure figure;

    public PostProcessorDecorator(FigureFactory figureFactory) {
        super(figureFactory);
    }

    @Override
    public Figure postProcess() {
        figures.add(figure);
        figures.forEach(figure1 -> logger.log(Level.INFO, figure1));
        return figure;
    }

    @Override
    public Figure createFigure(FigureType figureType, Point[] points) throws FigureNotExistException, Exception {
        this.figure = super.createFigure(figureType, points);
        postProcess();
        return figure;
    }
}

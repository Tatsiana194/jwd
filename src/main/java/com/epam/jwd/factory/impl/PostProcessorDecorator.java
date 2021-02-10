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
    private Figure figure;
    private ConcreteApplicationContext concreteApplicationContext = ConcreteApplicationContext.getInstance();

    public PostProcessorDecorator(FigureFactory figureFactory) {
        super(figureFactory);
    }

    @Override
    public Figure postProcess() {
        List<Figure> figures = concreteApplicationContext.getFigureCache();
        figures.add(figure);
        logger.log(Level.INFO, "In postProcess. sout figureCache ");
        figures.stream().forEach(System.out::println);
        return figure;
    }

    @Override
    public Figure createFigure(FigureType figureType, Point[] points) throws FigureNotExistException {
        this.figure = super.createFigure(figureType, points);
        postProcess();
        return figure;
    }
}

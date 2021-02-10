package com.epam.jwd.factory.impl;

import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.factory.FigureFactoryDecorator;
import com.epam.jwd.factory.PreProcessor;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class PreProcessorDecorator extends FigureFactoryDecorator implements PreProcessor {
    private Logger logger = LogManager.getLogger(PreProcessorDecorator.class);
    Figure figure;
    private ConcreteApplicationContext concreteApplicationContext = ConcreteApplicationContext.getInstance();

    public PreProcessorDecorator(FigureFactory figureFactory) {
        super(figureFactory);
    }

    @Override
    public void preProcess() throws Exception {
        Point[] points = figure.getPoints();
        List<Figure> figures = concreteApplicationContext.getFigureCache();
        logger.log(Level.INFO, "In preProcessor. sout figureCache ");
        for (Figure figureInCache : figures) {
            if (figureInCache.equals(figure)) {
                new Exception();
            }
        }
        logger.log(Level.INFO, "in preProcessor, sout points ");
        Arrays.stream(points).forEach(System.out::println);
    }

    @Override
    public Figure createFigure(FigureType figureType, Point[] points) throws FigureNotExistException, Exception {
        this.figure = super.createFigure(figureType, points);
        preProcess();
        return figure;
    }
}

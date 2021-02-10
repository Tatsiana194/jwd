package com.epam.jwd.factory.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.factory.FigureFactoryDecorator;
import com.epam.jwd.factory.PostProcessor;
import com.epam.jwd.model.Figure;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class PostProcessorDecorator extends FigureFactoryDecorator implements PostProcessor {
    private Logger logger = LogManager.getLogger(PostProcessorDecorator.class);

    public PostProcessorDecorator(FigureFactory figureFactory) {
        super(figureFactory);
        logger.log(Level.INFO, "In postProcess" + figureFactory.getClass());
    }

    @Override
    public Figure postProcess(Figure figure) throws FigureException {
        logger.log(Level.INFO, "In postProcess. Figure was created successful");
        return figure;
    }

    @Override
    public Figure getFigure() {
        return null;
    }
}

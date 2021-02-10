package com.epam.jwd.factory.impl;

import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.factory.FigureFactoryDecorator;
import com.epam.jwd.factory.PreProcessor;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class PreProcessorDecorator extends FigureFactoryDecorator implements PreProcessor {
    private Logger logger = LogManager.getLogger(PreProcessorDecorator.class);

    public PreProcessorDecorator(FigureFactory figureFactory) {
        super(figureFactory);
        logger.log(Level.INFO, "in preProcessor + figureFactory " + figureFactory.getFigure());
    }

    @Override
    public void PreProcess(Point[] points) throws Exception {
        logger.log(Level.INFO, "in preProcessor");
    }

    @Override
    public Figure getFigure() {
        return null;
    }
}

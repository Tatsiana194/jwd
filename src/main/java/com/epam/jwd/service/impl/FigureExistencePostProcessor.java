package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.service.FigurePostProcessor;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class FigureExistencePostProcessor implements FigurePostProcessor, AutoCloseable {
    private Logger logger = LogManager.getLogger(FigureExistencePostProcessor.class);

    @Override
    public void figureProcess(Figure figure) throws FigureException {
        logger.log(Level.INFO, figure);
        logger.log(Level.INFO, "figure was created successfully");
    }

    @Override
    public void close() throws Exception {
        logger.log(Level.INFO, "In method close()");
    }
}

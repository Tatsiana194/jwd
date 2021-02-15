package com.epam.jwd.factory.impl;

import com.epam.jwd.factory.ApplicationContext;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;

import java.util.ArrayList;
import java.util.List;

public class ConcreteApplicationContext implements ApplicationContext {
    private static ConcreteApplicationContext instance;
    private FigureFactory figureFactory = FigureFactoryImpl.getInstance();
    private List<Figure> figureCache = new ArrayList<>();

    private ConcreteApplicationContext() {
    }

    public static ConcreteApplicationContext getInstance() {
        if (instance == null) {
            instance = new ConcreteApplicationContext();
        }
        return instance;
    }

    public List<Figure> getFigureCache() {
        return figureCache;
    }

    @Override
    public FigureFactory getFigureFactory() {
        return new PostProcessorDecorator(new FigureExistencePostProcessor(new PreProcessorDecorator(figureFactory)));
    }
}

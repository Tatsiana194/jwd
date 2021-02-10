package com.epam.jwd.factory.impl;

import com.epam.jwd.factory.ApplicationContext;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;

public class ConcreteApplicationContext implements ApplicationContext {
    private static ConcreteApplicationContext instance;

    private ConcreteApplicationContext() {
    }

    public static ConcreteApplicationContext getInstance() {
        if (instance == null) {
            instance = new ConcreteApplicationContext();
        }
        return instance;
    }

    @Override
    public FigureFactory createFigureFactory() {
        return new PostProcessorDecorator(new FigureExistencePostProcessor(new PreProcessorDecorator(new FigureFactoryImpl())));
    }
}

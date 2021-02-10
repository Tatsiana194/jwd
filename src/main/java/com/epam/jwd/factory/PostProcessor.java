package com.epam.jwd.factory;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;

public interface PostProcessor {
    Figure postProcess() throws FigureException;
}

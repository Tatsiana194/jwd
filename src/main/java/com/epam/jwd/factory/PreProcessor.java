package com.epam.jwd.factory;

import com.epam.jwd.model.Point;

public interface PreProcessor {
    void PreProcess(Point[] points) throws Exception;
}

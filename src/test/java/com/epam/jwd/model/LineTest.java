package com.epam.jwd.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LineTest {
    private static Point pointA;
    private static Point pointB;
    private static Line line;

    @BeforeAll
    public static void setUp() {
        pointA = new Point(1, 1);
        pointB = new Point(1, 3);
        line = new Line();
        line.setPointA(pointA);
        line.setPointB(pointB);
    }

    @Test
    public void isFigureTest() {
        assertTrue(line.isFigure(line));
    }
}

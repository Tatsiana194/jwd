package com.epam.jwd.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TriangleTest {
    private static Point pointA;
    private static Point pointB;
    private static Point pointC;
    private static Triangle triangle;

    @BeforeAll
    public static void setUp() {
        pointA = new Point(1, 1);
        pointB = new Point(1, 3);
        pointC = new Point(3, 1);
        triangle = new Triangle();
        triangle.setPointA(pointA);
        triangle.setPointB(pointB);
        triangle.setPointC(pointC);
    }

    @Test
    public void countAreaTeat() {
        int area = triangle.countArea(triangle);
        assertEquals(4, area);
    }

    @Test
    public void countPerimeterTest() {
        int perimeter = triangle.countPerimeter(triangle);
        assertEquals(4, perimeter);
    }

    @Test
    public void isFigureTest() {
        assertTrue(triangle.isFigure(triangle));
    }

    @Test
    public void isValidTriangleTest() {
        assertTrue(triangle.isValidTriangle(triangle));
    }
}

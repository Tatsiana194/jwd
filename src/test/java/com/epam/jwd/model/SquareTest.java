package com.epam.jwd.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SquareTest {
    private static Point pointA;
    private static Point pointB;
    private static Point pointC;
    private static Point pointD;
    private static Square square;

    @BeforeAll
    public static void setUp() {
        pointA = new Point(1, 1);
        pointB = new Point(1, 3);
        pointC = new Point(3, 1);
        pointD = new Point(3, 3);
        square = new Square();
        square.setPointA(pointA);
        square.setPointB(pointB);
        square.setPointC(pointC);
        square.setPointD(pointD);
    }

    @Test
    public void countAreaTest() {
        int area = square.countArea(square);
        assertEquals(2, area);
    }

    @Test
    public void countPerimeterTest() {
        int perimeter = square.countPerimeter(square);
        assertEquals(6, perimeter);
    }

    @Test
    public void isFigureTest() {
        assertTrue(square.isFigure(square));
    }

    @Test
    public void isValidSquareTest() {
        assertTrue(square.isValidSquare(square));
    }
}

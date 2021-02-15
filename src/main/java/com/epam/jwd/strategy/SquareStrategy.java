package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.Square;

public class SquareStrategy implements FigurePropertiesStrategy {
    private Square square;
    private static final SquareStrategy instance = new SquareStrategy();

    private SquareStrategy() {
    }

    public static SquareStrategy getInstance() {
        return instance;
    }

    public int countArea(Figure figure) {
        this.square = (Square) figure;
        Point a = square.getPointA();
        Point b = square.getPointB();

        //segment length by coordinates = sqrt( (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) )
        int ab = (int) Math.sqrt(Math.pow(2, (a.getX() - b.getX())) + Math.pow(2, (a.getY() - b.getY())));

        //the area of the square is AB*2
        int areaSquare = ab * 2;
        return areaSquare;
    }

    @Override
    public int countPerimeter(Figure figure) {
        this.square = (Square) figure;
        Point a = square.getPointA();
        Point b = square.getPointB();
        Point c = square.getPointC();
        Point d = square.getPointD();

        //segment length by coordinates = sqrt( (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) )
        int ab = (int) Math.sqrt(Math.pow(2, (a.getX() - b.getX())) + Math.pow(2, (a.getY() - b.getY())));
        int bc = (int) Math.sqrt(Math.pow(2, (b.getX() - c.getX())) + Math.pow(2, (b.getY() - c.getY())));
        int cd = (int) Math.sqrt(Math.pow(2, (c.getX() - d.getX())) + Math.pow(2, (c.getY() - d.getY())));
        int da = (int) Math.sqrt(Math.pow(2, (d.getX() - a.getX())) + Math.pow(2, (d.getY() - a.getY())));

        //the perimeter of the square is AB+BC+CD+DA
        int perimeterSquare = ab + bc + cd + da;
        return perimeterSquare;
    }
}

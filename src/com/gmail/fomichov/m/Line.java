package com.gmail.fomichov.m;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class Line {
    private Point p1;
    private Point p2;
    private javafx.scene.shape.Line lineFx;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double calcLength() {
        return p1.calcLenght(p2);
    }

    private Point getPointOnLine(float percent) {
        Point directionPoint = p1.minusPoints(p2);
        directionPoint = directionPoint.normalize();
        double tempLenght = percent * p1.calcLenght(p2);
        directionPoint = directionPoint.plusMultiply(tempLenght);
        return p1.plusPoints(directionPoint);
    }

    public javafx.scene.shape.Line[] getAxis() {
        javafx.scene.shape.Line[] lineAxis = new javafx.scene.shape.Line[2];
        lineAxis[0] = new javafx.scene.shape.Line(Main.WIDTH_SCREEN / 2, 0, Main.WIDTH_SCREEN / 2, Main.HEIGHT_SCREEN);
        lineAxis[1] = new javafx.scene.shape.Line(0, Main.HEIGHT_SCREEN / 2, Main.WIDTH_SCREEN, Main.HEIGHT_SCREEN / 2);
        return lineAxis;
    }

    private double getRealX(double x) {
        return Main.WIDTH_SCREEN / 2 + x;
    }

    private double getRealY(double y) {
        return Main.HEIGHT_SCREEN / 2 - y;
    }

    public void draw(Pane root) {
        lineFx = new javafx.scene.shape.Line(getRealX(p1.getX()), getRealY(p1.getY()), getRealX(p2.getX()), getRealY(p2.getY()));
        Circle circle = new Circle(getRealX(getPointOnLine((float) 0.9).getX()), getRealY(getPointOnLine((float) 0.9).getY()), 5);
        System.out.println(circle);
        root.getChildren().addAll(lineFx, circle);
    }


}

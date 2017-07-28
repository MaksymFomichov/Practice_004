package com.gmail.fomichov.m;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class Line {
    private Point p1;
    private Point p2;
    private javafx.scene.shape.Line lineFx;
    private javafx.scene.shape.Line normalizeVector;
    private Circle findPoint;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    // получаем длину отрезка
    public double calcLength() {
        return p1.calcLenght(p2);
    }

    // получаем точку на отрезке по заданому проуенту
    private Point getPointOnLine(float percent) {
        Point directionPoint = p1.minusPoints(p2);
        directionPoint = directionPoint.normalize();
        double tempLength = percent * p1.calcLenght(p2);
        directionPoint = directionPoint.multiplyPoints(tempLength);
        return p1.plusPoints(directionPoint);
    }

    // получаем точку направления единичного вектора
    private Point getPointNormalize() {
        Point directionPoint = p1.minusPoints(p2);
        return directionPoint.normalize();
    }

    // рисуем наш отрезок и единичный вектор (для видимости на графике увеличил его длину на 100 пикселей) для сравнения
    public void draw(Pane root, float percent) {
        HelpDraw helpDraw = new HelpDraw();
        // рисуем наш отрезок
        lineFx = new javafx.scene.shape.Line(
                helpDraw.getRealX(p1.getX()), helpDraw.getRealY(p1.getY()), // start
                helpDraw.getRealX(p2.getX()), helpDraw.getRealY(p2.getY())); // end
        // рисуем заданную точку на отрезке
        findPoint = new Circle(helpDraw.getRealX(getPointOnLine(percent).getX()), helpDraw.getRealY(getPointOnLine(percent).getY()), 5);
        // рисуем единичный вектор
        normalizeVector = new javafx.scene.shape.Line(
                helpDraw.getRealX(Point.ZERO.getX()), helpDraw.getRealY(Point.ZERO.getY()), // start
                helpDraw.getRealX(getPointNormalize().multiplyPoints(100).getX()), helpDraw.getRealY(getPointNormalize().multiplyPoints(100).getY())); // end
        root.getChildren().addAll(lineFx, findPoint, normalizeVector);
    }

    public void clear(Pane root) {
        root.getChildren().removeAll(lineFx, findPoint, normalizeVector);
    }


}

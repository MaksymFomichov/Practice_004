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
        return p1.calcLength(p2);
    }

    // получаем точку на отрезке по заданому проценту
    public Point getPointOnLine(float percent) {
        Point directionPoint = p1.minusPoints(p2);
        directionPoint = directionPoint.normalize();
        double tempLength = percent * p1.calcLength(p2);
        directionPoint = directionPoint.multiplyPoints(tempLength);
        return p1.plusPoints(directionPoint);
    }

    // получаем точку направления единичного вектора
    private Point getPointNormalize() {
        Point directionPoint = p1.minusPoints(p2);
        return directionPoint.normalize();
    }

    // рисуем линию
    public void draw(Pane root) {
        HelpDraw hD = new HelpDraw();
        lineFx = new javafx.scene.shape.Line(
                hD.getX(p1.getX()), hD.getY(p1.getY()), // start
                hD.getX(p2.getX()), hD.getY(p2.getY())); // end
        root.getChildren().addAll(lineFx);
        System.out.println(lineFx);
    }

    // стираем линию
    public void clear(Pane root) {
        root.getChildren().removeAll(lineFx);
    }

    // рисуем наш отрезок и единичный вектор (для видимости на графике увеличил его длину на 100 пикселей) для сравнения
    public void drawVector(Pane root, float percent) {
        HelpDraw hD = new HelpDraw();
        // рисуем наш отрезок
        lineFx = new javafx.scene.shape.Line(
                hD.getX(p1.getX()), hD.getY(p1.getY()), // start
                hD.getX(p2.getX()), hD.getY(p2.getY())); // end
        // рисуем заданную точку на отрезке
        findPoint = new Circle(hD.getX(getPointOnLine(percent).getX()), hD.getY(getPointOnLine(percent).getY()), 5);
        // рисуем единичный вектор
        normalizeVector = new javafx.scene.shape.Line(
                hD.getX(Point.ZERO.getX()), hD.getY(Point.ZERO.getY()), // start
                hD.getX(getPointNormalize().multiplyPoints(100).getX()), hD.getY(getPointNormalize().multiplyPoints(100).getY())); // end
        root.getChildren().addAll(lineFx, findPoint, normalizeVector);
    }

    public void clearVector(Pane root) {
        root.getChildren().removeAll(lineFx, findPoint, normalizeVector);
    }


}

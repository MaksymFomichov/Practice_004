package com.gmail.fomichov.m;

import javafx.scene.layout.Pane;

public class Fractal {
    private int depth;
    private float percentOffset;
    private Triangle triangle;
    private Point point1;
    private Point point2;
    private Point point3;

    public Fractal(int depth, float percentOffset, Point point1, Point point2, Point point3) {
        this.depth = depth;
        this.percentOffset = percentOffset;
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    // отрисовывает одну итерацию фрактала и вызывает себя рекурсивно до тех пор пока не нарисует все итерации
    private void draw(int currentDepth, Triangle triangle, Pane root) {
        if (currentDepth > 0) {
            Triangle temp = new Triangle(triangle.getLine1().getPointOnLine(percentOffset), triangle.getLine2().getPointOnLine(percentOffset), triangle.getLine3().getPointOnLine(percentOffset));
            temp.draw(root);
            draw(currentDepth - 1, temp, root);
        }

    }

    // отрисовывает весь фрактал
    public void draw(Pane root) {
        triangle = new Triangle(point1, point2, point3);
        draw(depth, triangle, root);
        triangle.draw(root);
    }

    // очищает с экрана данный фрактал
    public void clear() {

    }
}

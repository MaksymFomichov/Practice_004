package com.gmail.fomichov.m;

import javafx.scene.paint.Color;

public class HelpDraw {

    // рисуем оси
    public javafx.scene.shape.Line[] getAxis() {
        javafx.scene.shape.Line[] lineAxis = new javafx.scene.shape.Line[2];
        lineAxis[0] = new javafx.scene.shape.Line(Main.WIDTH_SCREEN / 2, 0, Main.WIDTH_SCREEN / 2, Main.HEIGHT_SCREEN);
        lineAxis[1] = new javafx.scene.shape.Line(0, Main.HEIGHT_SCREEN / 2, Main.WIDTH_SCREEN, Main.HEIGHT_SCREEN / 2);
        lineAxis[0].setStroke(Color.GRAY);
        lineAxis[1].setStroke(Color.GRAY);
        return lineAxis;
    }

    // пересчет координаты X
    public double getX(double x) {
        if (x < 0) {
            return Main.WIDTH_SCREEN / 2 - (x * -1);
        } else if (x > 0) {
            return Main.WIDTH_SCREEN / 2 + x;
        } else {
            return Main.WIDTH_SCREEN / 2;
        }
    }

    // пересчет координаты Y
    public double getY(double y) {
        if (y < 0) {
            return Main.HEIGHT_SCREEN / 2 + (y * -1);
        } else if (y > 0) {
            return Main.HEIGHT_SCREEN / 2 - y;
        } else {
            return Main.HEIGHT_SCREEN / 2;
        }
    }

    public double randomPointX() {
        double minimum = (Main.WIDTH_SCREEN / 2 - 50) * -1;
        double maximum = minimum * 2 * -1;
        double result = minimum + (Math.random() * maximum);
        System.out.println(result);
        return result;
    }

    public double randomPointY() {
        double minimum = (Main.HEIGHT_SCREEN / 2 - 50) * -1;
        double maximum = minimum * 2 * -1;
        double result = minimum + (Math.random() * maximum);
        System.out.println(result);
        return result;
    }
}

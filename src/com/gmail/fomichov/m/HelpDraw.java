package com.gmail.fomichov.m;

public class HelpDraw {

    // рисуем оси
    public javafx.scene.shape.Line[] getAxis() {
        javafx.scene.shape.Line[] lineAxis = new javafx.scene.shape.Line[2];
        lineAxis[0] = new javafx.scene.shape.Line(Main.WIDTH_SCREEN / 2, 0, Main.WIDTH_SCREEN / 2, Main.HEIGHT_SCREEN);
        lineAxis[1] = new javafx.scene.shape.Line(0, Main.HEIGHT_SCREEN / 2, Main.WIDTH_SCREEN, Main.HEIGHT_SCREEN / 2);
        return lineAxis;
    }

    // пересчет координаты X
    public double getRealX(double x) {
        return Main.WIDTH_SCREEN / 2 + x;
    }

    // пересчет координаты Y
    public double getRealY(double y) {
        return Main.HEIGHT_SCREEN / 2 - y;
    }
}

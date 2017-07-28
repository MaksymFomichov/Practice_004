package fractal;

import javafx.scene.layout.Pane;

public class Triangle {
    private Line line1;
    private Line line2;
    private Line line3;

    public Triangle(Point point1, Point point2, Point point3) {
        line1 = new Line(point1, point2);
        line2 = new Line(point2, point3);
        line3 = new Line(point3, point1);
    }

    // отрисовывает весь треугольник
    public void draw(Pane root) {
        line1.draw(root);
        line2.draw(root);
        line3.draw(root);
    }

    public Line getLine1() {
        return line1;
    }

    public Line getLine2() {
        return line2;
    }

    public Line getLine3() {
        return line3;
    }

    // стирает себя (треугольник)
    public void clear(Pane root) {
        line1.clear(root);
        line2.clear(root);
        line3.clear(root);
    }
}

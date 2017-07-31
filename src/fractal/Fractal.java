package fractal;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Fractal {
    private int depth;
    private float percentOffset;
    private Triangle triangle;
    private ArrayList<Triangle> triangles = new ArrayList<>();

    public Fractal(int depth, float percentOffset, Triangle triangle) {
        this.depth = depth;
        this.percentOffset = percentOffset;
        this.triangle = triangle;
    }

    // отрисовывает одну итерацию фрактала и вызывает себя рекурсивно до тех пор пока не нарисует все итерации
    private void draw(int currentDepth, Triangle triangle) {
        if (currentDepth > 0) {
            Triangle temp = new Triangle(triangle.getLine1().getPointOnLine(percentOffset), triangle.getLine2().getPointOnLine(percentOffset), triangle.getLine3().getPointOnLine(percentOffset));
            triangles.add(temp);
            draw(currentDepth - 1, temp);
        }
    }

    // отрисовывает весь фрактал
    public void draw(Pane root) {
        triangles.add(triangle);
        draw(depth, triangle);
        for (int i = 0; i < triangles.size(); i++) {
            triangles.get(i).draw(root);
        }
    }

    // очищает с экрана данный фрактал
    public void clear(Pane root) {
        for (int i = 0; i < triangles.size(); i++) {
            triangles.get(i).clear(root);
        }

    }
}

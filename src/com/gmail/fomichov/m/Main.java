package com.gmail.fomichov.m;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static final int WIDTH_SCREEN = 500;
    public static final int HEIGHT_SCREEN = 500;
    private HelpDraw hD = new HelpDraw();
    private Pane root = new Pane();
    private Button btnDrawTriangle = new Button();
    private Button btnClearTriangle = new Button();
    private Triangle triangle;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(WIDTH_SCREEN);
        primaryStage.setHeight(HEIGHT_SCREEN);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("График функции");

        Point aa = new Point(hD.randomPointX(), hD.randomPointY());
        Point bb = new Point(hD.randomPointX(), hD.randomPointY());
        Line line = new Line(aa, bb);
        line.drawVector(root, (float) 0.7);

        btnDrawTriangle.setTranslateX(10);
        btnDrawTriangle.setTranslateY(10);
        btnDrawTriangle.setText("Нарисовать треугольник");
        btnClearTriangle.setTranslateX(10);
        btnClearTriangle.setTranslateY(40);
        btnClearTriangle.setText("Стереть треугольник");

        drawScreen();
        primaryStage.show();

        // рисуем рандомный треугольник
        btnDrawTriangle.setOnMouseClicked(event -> {
            Point a = new Point(hD.randomPointX(), hD.randomPointY());
            Point b = new Point(hD.randomPointX(), hD.randomPointY());
            Point c = new Point(hD.randomPointX(), hD.randomPointY());
            //triangle = new Triangle(a, b, c);
            Fractal fractal = new Fractal(10, (float) 0.2,a, b, c);
            fractal.draw(root);
            root.getChildren().clear(); // чистим экран от старых изображений
            fractal.draw(root);
            drawScreen();
        });

        // стираем рандомный треугольник
        btnClearTriangle.setOnMouseClicked(event -> {
            triangle.clear(root);
        });
    }

    // отрисовываем элементы экрана
    private void drawScreen() {
        root.getChildren().addAll(hD.getAxis());
        root.getChildren().addAll(btnDrawTriangle, btnClearTriangle);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package com.gmail.fomichov.m;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static final int WIDTH_SCREEN = 800;
    public static final int HEIGHT_SCREEN = 800;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(WIDTH_SCREEN);
        primaryStage.setHeight(HEIGHT_SCREEN);

        Point a = new Point(80, 50);
        Point b = new Point(-200, 200);
        Pane root = new Pane();

        HelpDraw helpDraw = new HelpDraw();
        Line line = new Line(a, b);
        line.draw(root, (float) 0.7);

        // рисуем оси
        root.getChildren().addAll(helpDraw.getAxis());

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("График функции");
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}

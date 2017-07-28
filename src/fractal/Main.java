package fractal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    public static final int WIDTH_SCREEN = 500;
    public static final int HEIGHT_SCREEN = 500;
    private HelpDraw hD = new HelpDraw();
    private Pane root = new Pane();
    private Button btnDrawTriangle = new Button();
    private Button btnClearTriangle = new Button();
    private Text textDepth = new Text();
    private Text textOffset = new Text();
    private TextField fieldDepth = new TextField();
    private TextField fieldOffset = new TextField();
    private Fractal fractal;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(WIDTH_SCREEN);
        primaryStage.setHeight(HEIGHT_SCREEN);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("График функции");

        // первоначальный показ линии с искомой точкой и единичного вектора
        Point aa = new Point(hD.randomPointX(), hD.randomPointY());
        Point bb = new Point(hD.randomPointX(), hD.randomPointY());
        Line line = new Line(aa, bb);
        line.drawVector(root, (float) 0.7);

        textDepth.setTranslateX(10);
        textDepth.setTranslateY(15);
        textDepth.setText("Глубина фрактала");
        fieldDepth.setTranslateX(10);
        fieldDepth.setTranslateY(20);
        fieldDepth.setText("25");

        textOffset.setTranslateX(10);
        textOffset.setTranslateY(65);
        textOffset.setText("Отступ фрактала");
        fieldOffset.setTranslateX(10);
        fieldOffset.setTranslateY(70);
        fieldOffset.setText("0.2");

        btnDrawTriangle.setTranslateX(10);
        btnDrawTriangle.setTranslateY(110);
        btnDrawTriangle.setText("Нарисовать фрактал");
        btnClearTriangle.setTranslateX(10);
        btnClearTriangle.setTranslateY(140);
        btnClearTriangle.setText("Стереть фрактал");

        drawScreen();
        primaryStage.show();

        // рисуем рандомный треугольник
        btnDrawTriangle.setOnMouseClicked(event -> {
            Point point1 = new Point(hD.randomPointX(), hD.randomPointY());
            Point point2 = new Point(hD.randomPointX(), hD.randomPointY());
            Point point3 = new Point(hD.randomPointX(), hD.randomPointY());
            int depth = Integer.parseInt(fieldDepth.getText());
            float offset = Float.parseFloat(fieldOffset.getText());
            fractal = new Fractal(depth, offset, point1, point2, point3);
            fractal.draw(root);
            root.getChildren().clear(); // чистим экран от старых изображений
            fractal.draw(root);
            drawScreen();
        });

        // стираем рандомный треугольник
        btnClearTriangle.setOnMouseClicked(event -> {
            fractal.clear(root);
        });
    }

    // отрисовываем элементы экрана
    private void drawScreen() {
        root.getChildren().addAll(hD.getAxis());
        root.getChildren().addAll(btnDrawTriangle, btnClearTriangle, textDepth, textOffset, fieldDepth, fieldOffset);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

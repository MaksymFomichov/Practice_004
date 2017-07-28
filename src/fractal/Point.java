package fractal;

public class Point {
    private double x;
    private double y;
    public static Point ZERO = new Point(0, 0);

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double calcLength(Point point) {
        double result = Math.sqrt((Math.pow(point.x - x, 2) + Math.pow(point.y - y, 2)));
        return result;
    }

    public double calcLength() {
        return calcLength(ZERO);
    }

    public Point normalize() {
        return new Point(x / calcLength(), y / calcLength());
    }

    public Point minusPoints(Point point) {
        return new Point(point.x - x, point.y - y);
    }

    public Point plusPoints(Point point) {
        return new Point(point.x + x, point.y + y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point multiplyPoints(double lenght) {
        return new Point(x * lenght, y * lenght);
    }

}


package PointInRectangle;

public class Point {
    private final int X;
    private final int Y;

    public Point(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public static Point createPoint(int X, int Y){
        return new Point(X,Y);
    }


    public boolean isGreaterThanOrEquals(Point point) {

        return X >= point.X && Y >= point.Y;
    }

    public boolean isLessThanOrEqual(Point point) {

        return X <= point.X && Y <= point.Y;
    }
}

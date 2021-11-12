package PointInRectangle;

public class Rectangle {
    private final Point bottomLeft;
    private final Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean isInside(Point p) {

        return  p.isGreaterThanOrEquals(bottomLeft)
                && p.isLessThanOrEqual(topRight);
    }
}

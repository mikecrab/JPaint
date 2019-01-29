package shape;

import shape.interfaces.IPoint;

public class Point implements IPoint {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.y;
    }

    public double getY() {
        return this.y;
    }
}

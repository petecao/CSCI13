package src;

import api.PointInterface;

public class Point implements PointInterface {
    private final double x;
    private final double y;

    /**
     * Constructor making point (x,y)
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Default constructor for point (0,0)
     */
    public Point() {
        this(0.0,0.0);
    }

    /**
     * Getter for x
     * @return x
     */
    @Override
    public double getX() {
        return x;
    }

    /**
     * Getter for y
     * @return y
     */
    @Override
    public double getY() {
        return y;
    }

    /**
     * Calculate the distance between this point and point P
     *
     * @param p another point
     * @return the distance between this point and point P
     */
    @Override
    public double distance(Point p) {
        double deltaX = x - p.getX(); // delta x = x-x1
        double deltaY = y - p.getY(); // delta y = y-y1
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY,2)); //distance = sqrt((delta x)^2 + (delta y)^2)
    }

    /**
     *
     * @return the string "(x,y)"
     */
    @Override
    public String toString() {
        return("(" + x +"," + y + ")");
    }
}

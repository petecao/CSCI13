package src;

/**
 * Point class containing double X and Y
 */
public class PointDouble extends PointAbstract<Double> {
    private final double x;
    private final double y;

    /**
     * Constructor
     */
    public PointDouble(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double getX() {
        return x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double getY() {
        return y;
    }

    /**
     * Calculate the distance between this point and point P
     *
     * @param p another point
     * @return the distance between this point and point P
     */
    @Override
    public Double distance(Point<Double> p) {
        return Math.abs(Math.sqrt((Math.pow(p.getX() - x, 2.0)) + (Math.pow(p.getY() - y, 2.0))));
    }
}
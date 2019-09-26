package src;

/**
 * Point class containing Float X and Y
 */
public class PointFloat extends PointAbstract<Float> {
    private final Float x;
    private final Float y;

    /**
     * Constructor
     */
    public PointFloat(Float x, Float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Float getX() {
        return x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Float getY() {
        return y;
    }

    /**
     * Calculate the distance between this point and point P
     *
     * @param p another point
     * @return the distance between this point and point P
     */
    @Override
    public Float distance(Point<Float> p) {
        return Math.abs((float)Math.sqrt((Math.pow(p.getX() - x, 2.0)) + (Math.pow(p.getY() - y, 2.0))));
    }
}
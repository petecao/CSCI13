package src;

/**
 * Point abstract class
 *
 * @param <T> numeric type
 */
public abstract class PointAbstract<T extends Number> implements Point<T> {

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    }
}

package src;

/**
 * Point interface
 *
 * @param <T> numeric type for point
 */
public interface Point<T extends Number> {

    /**
     * @return the point X value
     */
    T getX();

    /**
     * @return the point Y value
     */
    T getY();

    /**
     * @param p point
     * @return the distance between this and Point p
     */
    T distance(Point<T> p);
}

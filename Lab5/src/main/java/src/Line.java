package src;

import java.util.List;

/**
 * Line interface
 *
 * @param <T> numeric type
 */
public interface Line<T extends Number> extends List<Point<T>> {

    /**
     * @return the length of the line
     */
    T length();
}


package src;

import java.util.ArrayList;

/**
 * Line class, a container for points
 */
public class LineDouble extends ArrayList<Point<Double>> implements Line<Double> {

    /**
     * @return the length of the line
     */
    public Double length() {
        Double sum = 0.0;

        for (int index = 0; index < size() - 1; ++index) {
            sum += get(index).distance(get(index + 1));
        }
        return sum;
    }
}

package src;

import java.util.ArrayList;

/**
 * Line class, a container for points
 */
public class LineFloat extends ArrayList<Point<Float>> implements Line<Float> {

    /**
     * @return the length of the line
     */
    public Float length() {
        Float sum = 0.0f;

        for (int index = 0; index < size() - 1; ++index) {
            sum += get(index).distance(get(index + 1));
        }
        return sum;
    }
}

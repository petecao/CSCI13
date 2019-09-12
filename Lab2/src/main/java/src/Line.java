package src;

import java.util.ArrayList;
import java.util.List;

/**
 * Line class, a container for points
 */
public class Line {

    private final List<Point> myLine;

    /**
     * Line constructor to make a list of points
     */
    public Line() {
        myLine = new ArrayList<>();
    }

    /**
     * Add a point to the line
     *
     * @param p point to add
     */
    public void add(Point p) {
        myLine.add(p);
    }

    /**
     * Clear the contents of the line
     */
    public void clear() {
        myLine.clear();
    }

    /**
     * @return the length of the line
     */
    public double length() {
        double length = 0;
        for (int i = 0; i < myLine.size() - 1; i++) {
            length += myLine.get(i).distance(myLine.get(i+1));
        }
        return length;
    }

    /**
     * @return the size of the line
     */
    public int size() {
        return myLine.size();
    }
}

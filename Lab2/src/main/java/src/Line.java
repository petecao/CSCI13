package src;

import java.util.ArrayList;
import java.util.List;

/**
 * Line class, a container for points
 */
public class Line implements api.LineInterface {

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
    @Override
    public void add(Point p) {
        myLine.add(p);
    }

    /**
     * Clear the contents of the line
     */
    @Override
    public void clear() {
        myLine.clear();
    }

    /**
     * @return the length of the line
     */
    @Override
    public double length() {
        double length = 0;
        for (int i = 0; i < myLine.size() - 1; i++) { //iterates through the list and gets the distance between 2 consecutive points and adds it up, keeping a running sum
            length += myLine.get(i).distance(myLine.get(i+1));
        }
        return length;
    }

    /**
     * @return the size of the line
     */
    @Override
    public int size() {
        return myLine.size();
    }


}

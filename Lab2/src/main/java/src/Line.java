package src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Line class, a container for points
 */
public class Line implements Iterable {

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
        for (int i = 0; i < myLine.size() - 1; i++) { //iterates through the list and gets the distance between 2 consecutive points and adds it up, keeping a running sum
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

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator iterator() {
        return new LineIterator();
    }

    private class LineIterator implements Iterator<Point> {
        private List<Point> iteratorList;
        private int currentSize;
        private int iteratorIndex;

        LineIterator() {
            this.iteratorList = Line.this.myLine;
            currentSize = Line.this.myLine.size();
            iteratorIndex = 0;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasNext() {
            return (iteratorIndex < currentSize);
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public Point next() {
            if (this.hasNext()) {
                return iteratorList.get(iteratorIndex++);
            }
            throw new NoSuchElementException();
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public void remove() {
            throw new NoSuchElementException();
        }
    }
}

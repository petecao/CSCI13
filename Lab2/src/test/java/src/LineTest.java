package src;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Line testing
 */
public class LineTest {

    /**
     * Testing length() with only one point in the list
     */
    @Test
    public void lengthOnePoint() {
        Line line = new Line();
        line.add(new Point(1.5,2.5));
        assertEquals("testing length()", 0D, line.length(), 0.0);
    }

    /**
     * Testing length() with more than one point in the list
     */
    @Test
    public void lengthSixPoints() {
        Line line = new Line();
        line.add(new Point(1.5,2.5));
        line.add(new Point(0.0,2.5));
        line.add(new Point(0.0,0.0));
        line.add(new Point(3.0,4.0));
        line.add(new Point(8.0,-8.0));
        line.add(new Point(-8,-8));
        assertEquals("testing length()", 38.0D, line.length(), 0.0);
    }

    /**
     * Testing add(Point p) method
     */
    @Test
    public void add() {
        Line line = new Line();
        line.add(new Point(1.5,2.5));
        assertEquals("testing add()", 1, line.size(), 0.0); //showing that if a point is added, length increases to 1
    }

    /**
     * Testing size() method
     */
    @Test
    public void size() {
        Line line = new Line();
        line.add(new Point(1.5,2.5));
        line.add(new Point(0.0,2.5));
        line.add(new Point(0.0,0.0));
        line.add(new Point(3.0,4.0));
        line.add(new Point(8.0,-8.0));
        line.add(new Point(-8,-8));
        assertEquals("testing size()", 6D, line.size(), 0.0);
    }

    /**
     * Testing clear() method
     */
    @Test
    public void clear() {
        Line line = new Line();
        line.add(new Point(1.5,2.5));
        line.add(new Point(0.0,2.5));
        line.add(new Point(0.0,0.0));
        line.add(new Point(3.0,4.0));
        line.add(new Point(8.0,-8.0));
        line.add(new Point(-8,-8));
        line.clear();
        assertEquals("testing clear()", 0D, line.size(), 0.0);
    }

    /**
     * Testing iterator() method
     */
    @Test
    public void iteratorEmpty() {
        Line line = new Line();
        Iterator iterator = line.iterator();

        assertFalse("iterator empty", iterator.hasNext());
    }

    /**
     * Testing iterator() method
     */
    @Test
    public void iteratorOne() {
        Line line = new Line();
        Point p = new Point();
        line.add(p);
        Iterator iterator = line.iterator();

        assertTrue("iterator one", iterator.hasNext());
    }

    /**
     * Testing iterator() method
     */
    @Test
    public void iteratorNext() {
        Line line = new Line();
        Point p = new Point();
        line.add(p);
        Iterator iterator = line.iterator();

        assertEquals("iterator next", p,  iterator.next());
    }

    /**
     * Testing iterator() method
     */
    @Test
    public void iterator() {
        Line line = new Line();
        line.add(new Point(1.5,2.5));
        line.add(new Point(0.0,2.5));
        line.add(new Point(0.0,0.0));
        line.add(new Point(3.0,4.0));
        line.add(new Point(8.0,-8.0));
        line.add(new Point(-8,-8));
    }
}

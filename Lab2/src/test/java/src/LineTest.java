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
     * Beginning of week 4, worked on week 4 with Aman
     */

    /**
     * Testing iterator.hasNext() method on an empty line
     */
    @Test
    public void iteratorEmpty() {
        Line line = new Line();
        Iterator iterator = line.iterator();

        assertFalse("iterator empty", iterator.hasNext());
    }

    /**
     * Testing iterator.hasNext() method with one point
     *
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
     * Testing iterator.hasNext() method at the end of iteration
     */
    @Test
    public void iteratorEndofList() {
        Line line = new Line();
        Point p = new Point();
        line.add(p);
        Iterator iterator = line.iterator();
        assertEquals("iterator next", p,  iterator.next());
        assertFalse("no more items", iterator.hasNext());


    }

    /**
     * Testing iterator() method with 1 point
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
     * Testing iterator.next() method with 6 points
     */
    @Test
    public void iterator() {
        Line line = new Line();
        Point point1 = new Point(1.5,2.5);
        Point point2 = new Point(0.0,2.5);
        Point point3 = new Point(0.0,0.0);
        Point point4 = new Point(3.0,4.0);
        Point point5 = new Point(8.0,-8.0);
        Point point6 = new Point(-8,-8);
        line.add(point1);
        line.add(point2);
        line.add(point3);
        line.add(point4);
        line.add(point5);
        line.add(point6);
        Iterator iterator = line.iterator();
        assertEquals("iterator next", point1,  iterator.next());
        assertEquals("iterator next", point2,  iterator.next());
        assertEquals("iterator next", point3,  iterator.next());
        assertEquals("iterator next", point4,  iterator.next());
        assertEquals("iterator next", point5,  iterator.next());
        assertEquals("iterator next", point6,  iterator.next());


    }
}

package src;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Point testing
 */
public class PointTest {

    /**
     * Test the getX() method for an arbitrary point
     */
    @Test
    public void getXRandomPoint() {
        Point point = new Point(-3.0,4.0);
        assertEquals("testing getX()", -3.0D, point.getX(), 0.0);
    }

    /**
     * Test the getX() method for the default constructor
     */
    @Test
    public void getXDefault() {
        Point point = new Point();
        assertEquals("testing getX()", 0.0D, point.getX(), 0.0);
    }

    /**
     * Test the getY() method for an arbitrary point
     */
    @Test
    public void getYRandomPoint() {
        Point point = new Point(-3.0,4.0);
        assertEquals("testing getY()", 4.0D, point.getY(), 0.0);
    }

    /**
     * Test the getY() method for the default constructor
     */
    @Test
    public void getYDefault() {
        Point point = new Point();
        assertEquals("testing getY()", 0.0D, point.getY(), 0.0);
    }

    /**
     * Test the Distance(point) method with the default as a non-parameter
     */
    @Test
    public void distanceDefaultOutside() {
        Point point = new Point();
        assertEquals("testing distance()", 5.0D, point.distance(new Point(-3.0, 4.0)), 0.0);
    }

    /**
     * Test the Distance(point) method with the default as a parameter
     */
    @Test
    public void distanceDefaultParameter() {
        Point point = new Point(-3.0, 4.0);
        assertEquals("testing distance()", 5.0D, point.distance(new Point()), 0.0);
    }

    /**
     * Test the Distance(point) method with 2 Different Points
     */
    @Test
    public void distanceDifferentPoints() {
        Point point = new Point(-3.0, 4.0);
        assertEquals("testing distance()", 5.0D, point.distance(new Point(-7.0, 1.0)), 0.0);
    }

    /**
     * Test the Distance(point) method with the Same Point
     */
    @Test
    public void distanceSamePoint() {
        Point point = new Point(-3.0, 4.0);
        assertEquals("testing distance()", 0.0D, point.distance(new Point(-3.0, 4.0)), 0.0);
    }
}

package src;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Point testing
 */
public class PointDoubleTest {

    /**
     * Test the getX() method
     */
    @Test
    public void getX() {
        Point<Double> point = new PointDouble(0.0, 0.0);
        assertEquals("testing getX()", 0.0D, point.getX(), 0.0);

        assertSame("Testing same", point, point);
    }

    /**
     * Test the getY() method
     */
    @Test
    public void getY() {
        Point<Double> point = new PointDouble(0.0, 0.0);
        assertEquals("testing getY()", 0.0D, point.getY(), 0.0);
    }

    /**
     * Test outputting the point
     */
    @Test
    public void outputLine() {
        Point<Double> point = new PointDouble(0.0, 0.0);

        assertEquals("testing toString() == (0.0, 0.0)", "(0.0, 0.0)", point.toString());
    }
}

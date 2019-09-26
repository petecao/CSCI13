package src;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Point testing
 */
public class PointFloatTest {

    /**
     * Test the getX() methof
     */
    @Test
    public void getX() {
        Point<Float> point = new PointFloat(0.0f, 0.0f);
        assertEquals("testing getX()", 0.0f, point.getX(), 0.0);

        assertSame("Testing same", point, point);
    }

    /**
     * Test the getY() methof
     */
    @Test
    public void getY() {
        Point<Float> point = new PointFloat(0.0f, 0.0f);
        assertEquals("testing getY()", 0.0f, point.getY(), 0.0);
    }

    /**
     * Test outputting the point
     */
    @Test
    public void outputLine() {
        Point<Float> point = new PointFloat(0.0f, 0.0f);

        assertEquals("testing toString() == (0.0, 0.0)", "(0.0, 0.0)", point.toString());
    }
}

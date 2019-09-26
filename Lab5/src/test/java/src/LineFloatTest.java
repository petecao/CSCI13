package src;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LineFloatTest {

    /**
     * Test adding to the line
     */
    @Test
    public void addLine() {
        Line<Float> line = new LineFloat();

        assertEquals("testing size() == 0", 0, line.size());
        assertEquals("testing length() == 0.0", 0.0, line.length(), 0.0);

        line.add(new PointFloat(0.0f, 0.0f));
        assertEquals("testing size() == 1", 1, line.size());
        assertEquals("testing length() == 0.0", 0.0, line.length(), 0.0);

        line.add(new PointFloat(1.0f, 0.0f));
        assertEquals("testing size() == 2", 2, line.size());

        assertEquals("testing length() == 1", 1.0, line.length(), 0.0);
    }


    /**
     * Test removing from the line
     */
    @Test
    public void removeLine() {
        Line<Float> line = new LineFloat();

        assertEquals("testing size() == 0", 0, line.size());
        assertEquals("testing length() == 0.0", 0.0, line.length(), 0.0);

        line.add(new PointFloat(0.0f, 0.0f));
        assertEquals("testing size() == 1", 1, line.size());
        assertEquals("testing length() == 0.0", 0.0, line.length(), 0.0);

        PointFloat point = new PointFloat(1.0f, 0.0f);
        line.add(point);
        assertEquals("testing size() == 2", 2, line.size());

        assertEquals("testing length() == 1", 1.0, line.length(), 0.0);

        line.remove(point);
        assertEquals("testing size() == 1", 1, line.size());
        assertEquals("testing length() == 0.0", 0.0, line.length(), 0.0);
    }

    /**
     * Test outputting the line
     */
    @Test
    public void outputLine() {
        Line<Float> line = new LineFloat();

        assertEquals("testing size() == 0", 0, line.size());
        assertEquals("testing length() == 0.0", 0.0, line.length(), 0.0);

        line.add(new PointFloat(0.0f, 0.0f));
        assertEquals("testing size() == 1", 1, line.size());
        assertEquals("testing length() == 0.0", 0.0, line.length(), 0.0);

        line.add(new PointFloat(1.0f, 0.0f));
        assertEquals("testing size() == 2", 2, line.size());

        assertEquals("testing length() == 1", 1.0, line.length(), 0.0);

        assertEquals("testing toString() == [(0.0, 0.0), (1.0, 0.0)]", "[(0.0, 0.0), (1.0, 0.0)]", line.toString());
    }
}

package src;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LineDoubleTest {

    /**
     * Test adding to the line
     */
    @Test
    public void addLine() {
        Line<Double> line = new LineDouble();

        assertEquals("testing size() == 0", 0, line.size());
        assertEquals("testing length() == 0.0", 0.0, line.length(), 0.0);

        line.add(new PointDouble(0.0, 0.0));
        assertEquals("testing size() == 1", 1, line.size());
        assertEquals("testing length() == 0.0", 0.0, line.length(), 0.0);

        line.add(new PointDouble(1.0, 0.0));
        assertEquals("testing size() == 2", 2, line.size());

        assertEquals("testing length() == 1", 1.0, line.length(), 0.0);
    }


    /**
     * Test removing from the line
     */
    @Test
    public void removeLine() {
        Line<Double> line = new LineDouble();

        assertEquals("testing size() == 0", 0, line.size());
        assertEquals("testing length() == 0.0", 0.0, line.length(), 0.0);

        line.add(new PointDouble(0.0, 0.0));
        assertEquals("testing size() == 1", 1, line.size());
        assertEquals("testing length() == 0.0", 0.0, line.length(), 0.0);

        PointDouble point = new PointDouble(1.0, 0.0);
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
        Line<Double> line = new LineDouble();

        assertEquals("testing size() == 0", 0, line.size());
        assertEquals("testing length() == 0.0", 0.0, line.length(), 0.0);

        line.add(new PointDouble(0.0, 0.0));
        assertEquals("testing size() == 1", 1, line.size());
        assertEquals("testing length() == 0.0", 0.0, line.length(), 0.0);

        line.add(new PointDouble(1.0, 0.0));
        assertEquals("testing size() == 2", 2, line.size());

        assertEquals("testing length() == 1", 1.0, line.length(), 0.0);

        assertEquals("testing toString() == [(0.0, 0.0), (1.0, 0.0)]", "[(0.0, 0.0), (1.0, 0.0)]", line.toString());
    }
}

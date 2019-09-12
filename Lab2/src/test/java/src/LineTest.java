package src;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LineTest {
    @Test
    public void length() {
        Line line = new Line();
        line.add(new Point(1.5,2.5));
        assertEquals("testing length()", 0D, line.length(), 0.0);
    }
}

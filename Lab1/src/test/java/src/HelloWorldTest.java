package src;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * HelloWorld testing
 */
public class HelloWorldTest {
    /**
     * Tests to see if "Hello World" is returned
     */
    @Test
    public void HelloWorld() {
        assertEquals("Testing HelloWorld class", "Hello World", HelloWorld.helloWorld());
    }
}

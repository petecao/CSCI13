package infix;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Evaluating Postfix
 */
public class PostfixTest {
    @Test
    public void testConvertToPostfix() {
        Double results = postfix.Postfix.eval("2 3 + 4 5 / *");
        assertEquals("Test 1", 4D, results, 0.0);

        results = postfix.Postfix.eval("2.45 3.65 +");
        assertEquals("Test 2", 6.1D, results, 0.0);

        // from https://en.wikipedia.org/wiki/Reverse_Polish_notation
        results = postfix.Postfix.eval("15 7 1 1 + - / 3 * 2 1 1 + + -");
        assertEquals("Test 3", 5.0D, results, 0.0);

        //from https://en.wikipedia.org/wiki/Reverse_Polish_notation
        results = postfix.Postfix.eval(" 1 2 + 4 * 5 + 3 -");
        assertEquals("Test 4", 14D, results, 0.0);

        //from https://en.wikipedia.org/wiki/Reverse_Polish_notation
        results = postfix.Postfix.eval(" 1.0 2 + 4 * 5.0 + 3 -");
        assertEquals("Test 4", 14D, results, 0.0);
    }
}

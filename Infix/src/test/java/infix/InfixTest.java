package infix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Infix to postfix tests
 */
public class InfixTest {
    @Test
    public void testConvertToPostfix() {
        String results = InfixToPostfix.convertToPostfix("(2 + 3) * (4 / 5)");
        assertEquals("Test 1", "2 3 + 4 5 / *", results);

        results = InfixToPostfix.convertToPostfix("(2.45 + 3.65)");
        assertEquals("Test 1", "2.45 3.65 +", results);
    }
}

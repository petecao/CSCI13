package infix;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class PostfixTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    /**
     * Simple add test for Postfix evaluation
     */
    @Test
    public void addTest() throws PostfixException {
        assertEquals("add test", 5.0, Postfix.eval("2 3 +"), 0.0);
    }

    /**
     * Simple subtract test for Postfix evaluation
     */
    @Test
    public void subtractTest() throws PostfixException {
        assertEquals("subtract test", -1.0, Postfix.eval("2 3 -"), 0.0);
    }

    /**
     * Bad add test with an extra operator
     */
    @Test
    public void badAddTest() throws PostfixException {
        exception.expect(PostfixException.class);
        assertEquals("bad add test", 5.0, Postfix.eval("2 3 + +"), 0.0);
    }

    /**
     * Bad test with an missing operator
     */
    @Test
    public void missingOperatorTest() throws PostfixException {
        exception.expect(PostfixException.class);
        assertEquals("missing operator test", 5.0, Postfix.eval("2 3"), 0.0);
    }

    /**
     * Bad test with an empty operator
     * @throws PostfixException
     */
    @Test
    public void emptyExpressionTest() throws PostfixException {
        exception.expect(PostfixException.class);
        assertEquals("empty expression test", 5.0, Postfix.eval(""), 0.0);
    }

    /**
     * Bad test with dividing by infinity
     * @throws PostfixException
     */
    @Test
    public void zeroDivisionTest() throws PostfixException {
        exception.expect(PostfixException.class);
        assertEquals("dividing by zero", 5.0, Postfix.eval("3 0 /"), 0.0);
    }

    /**
     * Bad test with letter as operator
     */
    @Test
    public void nonOperatorTest() throws PostfixException {
        exception.expect(PostfixException.class);
        assertEquals("expression is a letter", 5.0, Postfix.eval("a"), 0.0);
    }

    /**
     * Bad test with invalid operator
     */
    @Test
    public void InvalidOperatorTest() throws PostfixException {
        exception.expect(PostfixException.class);
        assertEquals("expression is invalid", 5.0, Postfix.eval("5 3 )"), 0.0);
    }

    /**
     * Bad test with not enough operands
     */
    @Test
    public void tooLittleOperandsTest() throws PostfixException {
        exception.expect(PostfixException.class);
        assertEquals("not enough operands", 5.0, Postfix.eval("5 +"), 0.0);
    }

    /**
     * Bad test with not enough operands
     */
    @Test
    public void tooManyOperandsTest() throws PostfixException {
        exception.expect(PostfixException.class);
        assertEquals("to many operands", 5.0, Postfix.eval("5 4 6 +"), 0.0);
    }

}
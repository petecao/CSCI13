package postfix;

import java.nio.channels.ConnectionPendingException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * Postfix evaluator
 */
public class Postfix {

    /**
     * Private constructor
     */
    private Postfix() {
        // empty constructor
    }

    /**
     * @param expression postfix String
     * @return result of expression
     */
    public static double eval(String expression) {

        Deque<Double> operandStack = new ArrayDeque<>();

        StringTokenizer postfixParser = new StringTokenizer(expression, "+-*/^() ", true);


        /*
         * Process the tokens.
         */
        while (postfixParser.hasMoreTokens()) {

            /*
             * Get the next token and get the first character of the token
             */
            String token = postfixParser.nextToken().trim();

            /*
             * If we have a token after trimming off all the white space then
             * evaluate
             */
            if (token.length() > 0) {
                switch (token) {
                    case "+":
                        double rhsAdd = operandStack.pop();
                        double lhsAdd = operandStack.pop();
                        operandStack.push(lhsAdd + rhsAdd);
                        break;
                    case "-":
                        double rhsSubtract = operandStack.pop();
                        double lhsSubtract = operandStack.pop();
                        operandStack.push(lhsSubtract - rhsSubtract);
                        break;
                    case "*":
                        double rhsMultiply = operandStack.pop();
                        double lhsMultiply = operandStack.pop();
                        operandStack.push(lhsMultiply * rhsMultiply);
                        break;
                    case "/":
                        double rhsDivide = operandStack.pop();
                        double lhsDivide = operandStack.pop();
                        operandStack.push(lhsDivide / rhsDivide);
                        break;
                    default:
                        operandStack.push(Double.valueOf(token));
                        break;
                }
            }
        }
        return operandStack.pop();
    }
}
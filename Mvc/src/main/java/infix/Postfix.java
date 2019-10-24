package infix;

import java.nio.channels.ConnectionPendingException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
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
    public static double eval(String expression) throws PostfixException {
        if (expression.isEmpty()) {
            throw new PostfixException("The expression is empty");
        }
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
                try {
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
                            if (rhsDivide == 0) {
                                throw new PostfixException("YOU SHALT NOT DIVIDE BY ZERO");
                            }
                            double lhsDivide = operandStack.pop();
                            operandStack.push(lhsDivide / rhsDivide);
                            break;
                        default:
                            operandStack.push(Double.valueOf(token));
                            break;
                    }
                } catch (NoSuchElementException e) {
                    throw new PostfixException("Invalid expression " + expression);
                } catch (NumberFormatException e) {
                    throw new PostfixException("Invalid operator in " + expression);
                }
            }
        }
        if (operandStack.size() != 1) {
            throw new PostfixException("Invalid expression " + expression);
        }
        return operandStack.pop();
    }
}
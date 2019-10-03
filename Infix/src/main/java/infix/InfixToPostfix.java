package infix;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * Convert an infix expression into a postfix expression. The possible operators
 * are +, -, *, /, and ^. The operands are numeric constants.
 */
public class InfixToPostfix {

    /**
     * Private constructor
     */
    private InfixToPostfix() {
        // empty constructor
    }

    /**
     * Return true if op1 has lower precedence than op2, where op1 is an
     * operator on the left and op2 is an operator on the right.
     *
     * @param op1 left operator
     * @param op2 right operator
     * @return true if op1 has lower precedence than op2
     */
    private static boolean lowerPrecedence(String op1, String op2) {
        switch (op1) {
            case "+":
            case "-":
                return !(op2.equals("+") || op2.equals("-"));

            case "*":
            case "/":
                return op2.equals("^") || op2.equals("(");

            case "^":
                return op2.equals("(");

            case "(":
                return true;

            default: // (should not happen)
                return false;
        }
    }

    /**
     * Convert the infix string into postfix
     *
     * @param infix infix string
     * @return postfix string
     */
    public static String convertToPostfix(String infix) {
        Deque<String> operatorStack = new ArrayDeque<>();

        StringTokenizer infixParser = new StringTokenizer(infix, "+-*/^() ", true);

        StringBuilder postfixBuffer = new StringBuilder();

        /*
         * Process the tokens.
         */
        while (infixParser.hasMoreTokens()) {

            /*
             * Get the next token and get the first character of the token
             */
            String token = infixParser.nextToken().trim();

            /*
             * If we have a token after trimming off all the white space then
             * evaluate
             */
            if (token.length() > 0) {
                System.out.println(token);
                switch (token) {
                    case "(":
                        operatorStack.push(token);
                        break;

                    case ")":
                        while (!Objects.requireNonNull(operatorStack.peek()).equals("(")) {
                            postfixBuffer.append(" ").append(operatorStack.pop());
                        }
                        operatorStack.pop();
                        break;

                    case "+":
                    case "-":
                    case "/":
                    case "*":
                        /*
                         * The operator on the top of the stack does not have
                         * lower precedence than the current token, so it goes
                         * before this one.
                         */
                        while (!operatorStack.isEmpty() && !lowerPrecedence(operatorStack.peek(), token)) {
                            postfixBuffer.append(" ").append(operatorStack.pop());
                        }
                        operatorStack.push(token);
                        break;

                    default:
                        /*
                         * We found an operand
                         */
                        postfixBuffer.append(" ").append(token);
                        break;
                }
            }
        }

        /*
         * Output the remaining operators on the stack
         */
        while (!operatorStack.isEmpty()) {
            postfixBuffer.append(" ").append(operatorStack.pop());
        }

        /*
         * Return our string as postfix
         */
        return postfixBuffer.toString().trim();
    }
}

package gui;

import infix.InfixToPostfix;
import infix.Postfix;
import infix.PostfixException;
import sun.java2d.Disposer;

/**
 * Controller class. The controller class creates the required models and controls the
 * action between the models and the view.
 */
class Controller {
    private final StringBuilder expressionBuilder;

    /**
     * Constructor
     * <p>
     * The constructor instantiates any required model
     */
    Controller() {
        expressionBuilder = new StringBuilder();
    }

    /**
     * Perform evaluation
     */
    void evaluate() {
        String expression = expressionBuilder.toString();
        clearExpression();
        String result;
        try {
            result = Double.toString(Postfix.eval(InfixToPostfix.convertToPostfix(expression)));
        } catch (PostfixException e) {
            result = e.getMessage();
        }
        expressionBuilder.append(result);
    }

    /**
     * Add to the expression builder
     *
     * @param value string to add, should be a single character
     */
    void addToExpression(String value) {
        expressionBuilder.append(value);
    }

    /**
     * @return current expression
     */
    String getExpression() {
        return expressionBuilder.toString();
    }

    /**
     * Clear expression
     */
    void clearExpression() {
        expressionBuilder.setLength(0);
    }
}

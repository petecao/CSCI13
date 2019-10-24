package gui;

import infix.InfixToPostfix;
import infix.Postfix;
import infix.PostfixException;

/**
 * Controller class. The controller class creates the required models and controls the
 * action between the models and the view.
 */
class Controller {
    private View view;

    /**
     * Constructor
     * <p>
     * The constructor instantiates any required model
     */
    Controller() {
        // empty for now
    }

    /**
     * Perform evaluation
     */
    void evaluate(String expression) throws PostfixException {

        view.setOutputTextField(Double.toString(Postfix.eval(InfixToPostfix.convertToPostfix(expression))));
    }

    /**
     * Set the view
     *
     * @param view our gui view
     */
    void setView(View view) {
        this.view = view;
    }
}

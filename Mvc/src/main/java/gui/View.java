package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * View class. This class creates and manages the view.
 */
class View {
    private final TextField textInputOutputField;
    private final Controller controller;
    private Scene scene;

    /**
     * Constructor
     */
    View(Controller controller) {
        this.controller = controller;

        // create a panel for our button, text fields, and texts
        VBox panel = new VBox();
        panel.setAlignment(Pos.CENTER);

        // read only text field
        Text sceneTitle = new Text("Calculator");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        panel.getChildren().add(sceneTitle);

        // input/output text field
        textInputOutputField = new TextField();
        textInputOutputField.setEditable(false);
        textInputOutputField.setText("");
        textInputOutputField.setMaxWidth(100);
        panel.getChildren().add(textInputOutputField);

        GridPane buttonGrid = new GridPane();

        addButton("1", buttonGrid, 0, 0);
        addButton("2", buttonGrid, 1, 0);
        addButton("3", buttonGrid, 2, 0);
        addButton("4", buttonGrid, 0, 1);
        addButton("5", buttonGrid, 1, 1);
        addButton("6", buttonGrid, 2, 1);
        addButton("7", buttonGrid, 0, 2);
        addButton("8", buttonGrid, 1, 2);
        addButton("9", buttonGrid, 2, 2);
        addButton("0", buttonGrid, 0, 3);
        addButton("+", buttonGrid, 3, 0);
        addButton("-", buttonGrid, 3, 1);
        addButton("*", buttonGrid, 3, 2);
        addButton("/", buttonGrid, 3, 3);
        addButton("(", buttonGrid, 4, 0);
        addButton(")", buttonGrid, 4, 1);
        addButton("C", buttonGrid, 1, 3, event -> {
            controller.clearExpression();
            textInputOutputField.setText(controller.getExpression());
        });
        addButton("=", buttonGrid, 2, 3, event -> {
            controller.evaluate();
            textInputOutputField.setText(controller.getExpression());
        });

        panel.getChildren().add(buttonGrid);

        scene = new Scene(panel, 300, 250);
    }

    /**
     * Add a button that adds to the expression
     *
     * @param label      button label
     * @param buttonGrid grid of buttons
     * @param column     column
     * @param row        row
     */
    private void addButton(String label, GridPane buttonGrid, int column, int row) {
        Button button = new Button(label);
        button.setOnAction(event -> {
            controller.addToExpression(label);
            textInputOutputField.setText(controller.getExpression());
        });
        buttonGrid.add(button, column, row);
    }

    /**
     * Add a button with a custom lambda
     *
     * @param label      button label
     * @param buttonGrid grid of buttons
     * @param column     column
     * @param row        row
     * @param value      action
     */
    private void addButton(String label, GridPane buttonGrid, int column, int row, EventHandler<ActionEvent> value) {
        Button button = new Button(label);
        button.setOnAction(value);
        buttonGrid.add(button, column, row);
    }

    /**
     * Get the scene for this view
     *
     * @return scene for this view
     */
    Scene getScene() {
        return scene;
    }
}

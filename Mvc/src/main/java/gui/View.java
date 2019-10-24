package gui;


import infix.PostfixException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * View class. This class creates and manages the view.
 */
class View {
    private final TextField textInputField;
    private final TextField textOutputField;
    private Scene scene;

    /**
     * Constructor
     */
    View(Controller controller) {
        // create a panel for our button, text fields, and texts
        VBox panel = new VBox();
        panel.setAlignment(Pos.CENTER);

        // read only text field
        Text sceneTitle = new Text("Calculator");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        panel.getChildren().add(sceneTitle);

        // input text field
        textInputField = new TextField();
        textInputField.setText("");
        textInputField.setMaxWidth(300);
        textInputField.setOnAction(event -> {
            try {
                controller.evaluate(textInputField.getText());
            } catch (PostfixException e) {
                setOutputTextField(e.getMessage());
            }
        });
        panel.getChildren().add(textInputField);

        // output text field
        textOutputField = new TextField();
        textOutputField.setText("");
        textOutputField.setMaxWidth(300);
        panel.getChildren().add(textOutputField);

        Button button = new Button("Clear");
        button.setOnAction(event -> {
            textInputField.setText("");
            textOutputField.setText("");
        });
        panel.getChildren().add(button);

        scene = new Scene(panel, 300, 250);
    }

    /**
     * Get the scene for this view
     *
     * @return scene for this view
     */
    Scene getScene() {
        return scene;
    }

    /**
     * Set the output text field
     *
     * @param text text
     */
    void setOutputTextField(String text) {
        textOutputField.setText(text);
    }
}

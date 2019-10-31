package gui;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class
 */
public class Main extends Application {

    /**
     * Main. Create a controller and view then launch the application
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // launch the view
        Application.launch(args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(Stage primaryStage) {
        // we need a controller
        Controller controller = new Controller();

        // we need a view and need to tell the controller about the new view
        View view = new View(controller);

        // get the scene and display
        primaryStage.setScene(view.getScene());
        primaryStage.show();
    }
}

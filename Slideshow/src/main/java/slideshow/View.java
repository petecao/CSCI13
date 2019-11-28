package slideshow;

import javafx.scene.Scene;

/**
 * Created by williamhooper on 11/30/16.
 */
public class View {
    private final Controller controller;
    private Scene scene;

    /**
     * Constructor
     */
    public View(Controller controller) {
        this.controller = controller;
    }

    /**
     * Get the scene for this view
     *
     * @return scene to this view
     */
    public Scene getScene() {
        return scene;
    }
}
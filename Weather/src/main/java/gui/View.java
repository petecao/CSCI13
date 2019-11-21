package gui;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import weather.Weather;
import weather.WeatherRecord;

import java.util.Arrays;
import java.util.List;

/**
 * View class. This class creates and manages the view.
 */
public class View {
    private final TextField textInputField;
    private Scene scene;
    private TableView<WeatherRecord> tableView;

    /**
     * Constructor
     */
    public View(Controller controller) {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Weather");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        textInputField = new TextField();
        textInputField.setText("");
        textInputField.setOnAction(event -> {
            // this is executed when the user presses return/enter
            controller.getWeatherData(textInputField.getText());
        });






        // table view
        tableView = new TableView<>();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tableView.setRowFactory(tv -> new TableRow<WeatherRecord>() {
            private Tooltip tooltip = new Tooltip();
            @Override
            public void updateItem(WeatherRecord rowToolTip, boolean empty) {
                super.updateItem(rowToolTip, empty);
                if (rowToolTip == null) {
                    setTooltip(null);
                } else {
                    tooltip.setText(rowToolTip.getText());
                    setTooltip(tooltip);
                }
            }
        });


        /*
         * Setup each of the columns in our table
         */
        TableColumn<WeatherRecord, String> periodCol = new TableColumn<>("Period");
        periodCol.setCellValueFactory(new PropertyValueFactory<>("period"));
        periodCol.setStyle("-fx-alignment: CENTER;");

        // need to add the remaining columns
        TableColumn<WeatherRecord, String> tempCol = new TableColumn<>("Temp");
        tempCol.setCellValueFactory(new PropertyValueFactory<>("temp"));
        tempCol.setStyle("-fx-alignment: CENTER;");

        TableColumn<WeatherRecord, String> weatherCol = new TableColumn<>("Weather");
        weatherCol.setCellValueFactory(new PropertyValueFactory<>("weather"));
        weatherCol.setStyle("-fx-alignment: CENTER;");


        TableColumn<WeatherRecord, ImageView> iconCol = new TableColumn<>("Icon");
        iconCol.setCellValueFactory((TableColumn.CellDataFeatures<WeatherRecord,
                ImageView> cell) -> {
            String iconLink = cell.getValue().getIconLink();
            Image iconImage = new Image(iconLink.replace("http://", "https://"));
            return new SimpleObjectProperty<>(new ImageView(iconImage));
        });

        tableView.getColumns().addAll(Arrays.asList(periodCol, tempCol, weatherCol, iconCol));

        Button resetButton = new Button("Reset");
        resetButton.setOnAction(event -> {
            tableView.getItems().clear();
            textInputField.clear();
            textInputField.setDisable(false);
            textInputField.setStyle("-fx-text-inner-color: black;");

        });

        Button refreshButton = new Button("Refresh Data");
        refreshButton.setOnAction(event -> {
            controller.getWeatherData(textInputField.getText());
        });


        vBox.getChildren().addAll(sceneTitle, textInputField, tableView, resetButton, refreshButton);

        scene = new Scene(vBox, 400, 400);
    }

    /**
     * Show an alert
     */
    public void showAlert() {

        // this is called when we need to display an alert with an error message
        textInputField.setDisable(true);
        textInputField.setStyle("-fx-text-inner-color: red;");
        textInputField.setText("Invalid input. Please reset and try again.");

        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.ERROR);
        a.setContentText("Invalid input. Please reset and try again.");
        a.show();

    }

    /**
     * Set the table's data
     *
     * @param weatherData weather data list
     */
    public void setWeatherData(List<WeatherRecord> weatherData) {
        tableView.getItems().setAll(FXCollections.observableArrayList(weatherData));
        textInputField.setDisable(true);
        textInputField.setStyle("-fx-text-inner-color: green;");
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

package gui;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import weather.Weather;
import weather.WeatherRecord;
import weather.GovermentWeather;

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
            Weather weather = new GovermentWeather();
            weather.refreshData(textInputField.getText());
            setWeatherData(weather.getWeatherData());
        });

        // table view
        tableView = new TableView<>();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tableView.setRowFactory(tv -> new TableRow<>());

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

        TableColumn<WeatherRecord, String> textCol = new TableColumn<>("Text");
        textCol.setCellValueFactory(new PropertyValueFactory<>("text"));
        textCol.setStyle("-fx-alignment: CENTER;");

        TableColumn<WeatherRecord, String> iconLinkCol = new TableColumn<>("iconLink");
        iconLinkCol.setCellValueFactory(new PropertyValueFactory<>("iconLink"));
        iconLinkCol.setStyle("-fx-alignment: CENTER;");

        tableView.getColumns().addAll(Arrays.asList(periodCol, tempCol, weatherCol, textCol, iconLinkCol));

        Button resetButton = new Button("Reset");
        resetButton.setOnAction(event -> {
            tableView.getItems().clear();
            textInputField.clear();
        });
        vBox.getChildren().addAll(sceneTitle, textInputField, tableView, resetButton);

        scene = new Scene(vBox, 400, 400);
    }

    /**
     * Show an alert
     */
    public void showAlert() {

        // this is called when we need to display an alert with an error message

    }

    /**
     * Set the table's data
     *
     * @param weatherData weather data list
     */
    public void setWeatherData(List<WeatherRecord> weatherData) {
        tableView.getItems().setAll(FXCollections.observableArrayList(weatherData));
        textInputField.setDisable(false);
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

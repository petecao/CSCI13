package gui;

import javafx.application.Platform;
import weather.GovermentWeather;
import weather.Weather;

/**
 * Controller class. The controller class creates the required models and
 * connects the view with any model that needs a listener.
 */
public class Controller implements Weather.Listener {
    private View view;
    private Weather weather;

    /**
     * Constructor
     * <p>
     * The constructor instantiates any required model class
     */
    public Controller() {
        weather = new GovermentWeather();
        weather.addListener(this);
    }

    /**
     * Get the weather data for a zipcode
     *
     * @param zipcode zipcode
     */
    public void getWeatherData(String zipcode) {
        Runnable thread = () -> weather.refreshData(zipcode);
        thread.run();
    }

    /**
     * Set the view for this controller. 
     *
     * @param view view
     */
    public void setView(View view) {
        this.view = view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void errorWeatherList() {

        // this is a weather listener and called when weather encounters an error refreshing the data
        view.showAlert();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void modifiedWeatherList() {
        // this is a weather listener and called when the weather succeeded in refreshing the data
        view.setWeatherData(weather.getWeatherData());
    }
}

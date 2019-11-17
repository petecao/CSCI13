package weather;

import java.io.IOException;
import java.util.List;

/**
 * Weather interface
 */
public interface Weather {
    /**
     * Refresh the weather data. The weather data is retrieved from the URL:
     *
     * @param zipCode zip code
     */
    void refreshData(String zipCode);

    /**
     * Get the current zip code
     *
     * @return current zip code
     */
    String getZipCode();

    /**
     * Get the weather data
     *
     * @return weather data
     */
    List<WeatherRecord> getWeatherData();

    /**
     * Adds a listener to be notified when weather data is available
     *
     * @param listener The listener to add
     */
    void addListener(Listener listener);

    /**
     * Removes a listener from being notified when weather data is available
     *
     * @param listener The listener to remove
     */
    void removeListener(Listener listener);

    /**
     * Custom listener that is notified weather list modified
     */
    interface Listener {
        /**
         * Called whenever the weather list encounters an error
         */
        void errorWeatherList();

        /**
         * Called whenever the weather list is modified
         */
        void modifiedWeatherList();
    }
}

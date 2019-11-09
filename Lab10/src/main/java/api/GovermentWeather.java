package api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GovermentWeather implements Weather {
    private final List<WeatherRecord> weatherData;
    private String zipCode;
    private final CopyOnWriteArrayList<Listener> listeners = new CopyOnWriteArrayList<>();

    /**
     * Constructor
     */
    public GovermentWeather() {
        weatherData = new ArrayList<>();
    }

    /**
     * @inheritDoc
     */
    @Override
    public void refreshData(String zipCode) throws IOException {

        // example url: https://forecast.weather.gov/MapClick.php?lat=44.9055&lon=-122.8107&FcstType=json

        weatherData.clear();

        LocationFactory locationFactory = NominatimLocationFactory.getInstance();
        Location location = locationFactory.getLocation(zipCode);

        String json = getWeatherJson(location);

        JsonElement jsonRoot = getJsonElement(json);

        JsonArray periods = jsonRoot.getAsJsonObject().get("time").getAsJsonObject().get("startPeriodName").getAsJsonArray();
        for (JsonElement element : periods) {
            WeatherRecord weatherRecord = new WeatherRecord();
            weatherRecord.setPeriod(element.getAsString());
            weatherData.add(weatherRecord);
        }

        JsonArray temperatures = jsonRoot.getAsJsonObject().get("data").getAsJsonObject().get("temperature").getAsJsonArray();
        int index = 0;
        for (JsonElement element : temperatures) {
            weatherData.get(index).setTemp(element.getAsString());
            index++;
        }

        JsonArray weather = jsonRoot.getAsJsonObject().get("data").getAsJsonObject().get("weather").getAsJsonArray();
        index = 0;
        for (JsonElement element : weather) {
            weatherData.get(index).setWeather(element.getAsString());
            index++;
        }

        JsonArray tempLabel = jsonRoot.getAsJsonObject().get("time").getAsJsonObject().get("tempLabel").getAsJsonArray();
        index = 0;
        for (JsonElement element : tempLabel) {
            weatherData.get(index).setTempLabel(element.getAsString());
            index++;
        }


    }

    /**
     * @inheritDoc
     */
    @Override
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @inheritDoc
     */
    @Override
    public List<WeatherRecord> getWeatherData() {
        return weatherData;
    }

    /**
     * @inheritDoc
     */
    public void addListener(Listener listener) {
        synchronized (listeners) {
            if (!listeners.contains(listener)) {
                listeners.add(listener);
            }
        }
    }


    /**
     * @inheritDoc
     */
    @Override
    public void removeListener(Listener listener) {
        synchronized (listeners) {
            listeners.remove(listener);
        }
    }

    /**
     * Read the json returned by the URL and append into a single string
     *
     * @param location location
     * @return Json string
     * @throws IOException if an error occurs
     */
    private String getWeatherJson(Location location) throws IOException {
        StringBuilder json = new StringBuilder();

        URL url = new URL("https://forecast.weather.gov/MapClick.php?lat=" + location.getLatitude()
                + "&lon=" + location.getLongitude() + "&FcstType=json");
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line;
            while ((line = rd.readLine()) != null) {
                json.append(line);
            }
        }
        return json.toString().trim();
    }

    /**
     * Create a json parser and check for a valid response
     *
     * @param json json string
     * @return the top level json element
     * @throws IOException if an error occurs
     */
    private JsonElement getJsonElement(String json) throws IOException {
        JsonParser parser = new JsonParser();
        return parser.parse(json);
    }
}

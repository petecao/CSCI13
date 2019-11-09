package api;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Nominatim Location Factory class for looking up location information based on a zipcode
 */
public class NominatimLocationFactory implements LocationFactory {

    private static LocationFactory locationFactory = null;

    /**
     * Private constructor
     */
    private NominatimLocationFactory() {
        // empty constructor
    }

    /**
     * @return singleton instance
     */
    public static LocationFactory getInstance() {
        if (locationFactory == null) {
            locationFactory = new NominatimLocationFactory();
        }
        return locationFactory;
    }

    /**
     * Create a json parser and check for a valid response
     *
     * @param json json string
     * @return the top level json element
     * @throws IOException if an error occurs
     */
    private static JsonElement getJsonElement(String json) throws IOException {
        JsonParser parser = new JsonParser();
        JsonElement jseRoot = parser.parse(json);
        if (jseRoot.getAsJsonArray().size() == 0) {
            throw new IOException("Empty location data");
        }
        return jseRoot;
    }

    /**
     * Read the json returned by the URL and append into a single string
     *
     * @param zipCode zip code
     * @return Json string
     * @throws IOException if an error occurs
     */
    private static String getLocationJson(String zipCode) throws IOException {
        StringBuilder json = new StringBuilder();

        String urlString = URLEncoder.encode(zipCode, "UTF-8");
        URL url = new URL("https://nominatim.openstreetmap.org/search?postalcode=" + urlString + "&country=usa&format=json");
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line;
            while ((line = rd.readLine()) != null) {
                json.append(line);
            }
        }
        return json.toString().trim();
    }

    /**
     * Get the latitude and longitude for a zipcode
     *
     * @param zipCode zipcode
     * @return a Location object
     * @throws IOException if unable to get the location
     */
    public Location getLocation(String zipCode) throws IOException {

        String json = getLocationJson(zipCode);

        JsonElement jseRoot = getJsonElement(json);

        double lat = jseRoot.getAsJsonArray().get(0).getAsJsonObject().get("lat").getAsDouble();
        double lon = jseRoot.getAsJsonArray().get(0).getAsJsonObject().get("lon").getAsDouble();
        String cityState = jseRoot.getAsJsonArray().get(0).getAsJsonObject().get("display_name").getAsString();

        return new Location(lat, lon, zipCode, cityState);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NominatimLocationFactory clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }
}

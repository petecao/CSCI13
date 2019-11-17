package weather;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Google Location Factory class for looking up location information based on a zipcode
 */
public class GoogleLocationFactory implements LocationFactory {
    private static GoogleLocationFactory locationFactory = null;

    /**
     * Private constructor
     */
    private GoogleLocationFactory() {
        // empty constructor
    }

    /**
     * @return singleton instance
     */
    public static LocationFactory getInstance() {
        if (locationFactory == null) {
            locationFactory = new GoogleLocationFactory();
        }
        return locationFactory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Location getLocation(String zipCode) throws IOException {

        String json = getLocationJson(zipCode);

        JsonElement jseRoot = getJsonElement(json);

        double lat = jseRoot.getAsJsonObject().get("results").getAsJsonArray().get(0).getAsJsonObject().get("geometry")
                .getAsJsonObject().get("location").getAsJsonObject().get("lat").getAsDouble();

        double lng = jseRoot.getAsJsonObject().get("results").getAsJsonArray().get(0).getAsJsonObject().get("geometry")
                .getAsJsonObject().get("location").getAsJsonObject().get("lng").getAsDouble();

        return new Location(lat, lng, zipCode);
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
        JsonElement jseRoot = parser.parse(json);
        String status = jseRoot.getAsJsonObject().get("status").getAsString();
        if (!status.contentEquals("OK")) {
            throw new IOException("Invalid URL, " + status);
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
    private String getLocationJson(String zipCode) throws IOException {
        StringBuilder json = new StringBuilder();

        String urlString = URLEncoder.encode(zipCode, "UTF-8");
        URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?address=" + urlString);
        try (InputStream is = url.openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = rd.readLine()) != null) {
                json.append(line);
            }
        }
        return json.toString().trim();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GoogleLocationFactory clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }
}

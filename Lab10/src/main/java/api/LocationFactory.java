package api;

import java.io.IOException;

/**
 * Location factory interface
 */
public interface LocationFactory {
    /**
     * Get the latitude and longitude for a zipcode
     *
     * @param zipCode zipcode
     * @return a Location object
     * @throws IOException if unable to get the location
     */
    Location getLocation(String zipCode) throws IOException;
}

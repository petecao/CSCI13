package weather;

/**
 * Location class
 */
public class Location {
    private double latitude;
    private double longitude;
    private String zipcode;

    /**
     * Constructor
     *
     * @param lat     latitude
     * @param lng     longitude
     * @param zipCode zipcode
     */
    public Location(double lat, double lng, String zipCode) {

        this.latitude = lat;
        this.longitude = lng;
        this.zipcode = zipCode;
    }

    /**
     * Get the latitude
     *
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Get the longitude
     *
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Get the zip code
     *
     * @return sipcode
     */
    public String getZipcode() {
        return zipcode;
    }

}

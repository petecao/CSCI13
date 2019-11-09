package api;

/**
 * Location class
 */
public class Location {
    private double latitude;
    private double longitude;
    private String zipcode;
    private String cityState;

    /**
     * Constructor
     *
     * @param lat     latitude
     * @param lng     longitude
     * @param zipCode zipcode
     */
    public Location(double lat, double lng, String zipCode, String cityState) {

        this.latitude = lat;
        this.longitude = lng;
        this.zipcode = zipCode;
        this.cityState = cityState;
    }

    public Location(double lat, double lng, String zipCode) {

        this.latitude = lat;
        this.longitude = lng;
        this.zipcode = zipCode;
        this.cityState = null;
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
     * @return zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * Gets the location
     *
     * @return cityState
     */
    public String getCityState() {
        return cityState;
    }

}

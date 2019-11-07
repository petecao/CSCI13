package api;

/**
 * Weather record that holds a line for the table view
 */
public class WeatherRecord {
    private String period;
    private String temp;
    private String weather;
    private String text;
    private String iconLink;

    /**
     * Default constructor
     */
    public WeatherRecord() {
        this.period = null;
        this.temp = null;
        this.weather = null;
        this.text = null;
        this.iconLink = null;
    }

    /**
     * Constructor
     *
     * @param period   period names
     * @param temp     temperature
     * @param weather  weather
     * @param text     text description
     * @param iconLink icon link URL
     */
    public WeatherRecord(String period, String temp, String weather, String text, String iconLink) {
        this.period = period;
        this.temp = temp;
        this.weather = weather;
        this.text = text;
        this.iconLink = iconLink;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconLink() {
        return iconLink;
    }

    public void setIconLink(String iconLink) {
        this.iconLink = iconLink;
    }
}

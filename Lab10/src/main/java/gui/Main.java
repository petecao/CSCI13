package gui;

import api.*;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        LocationFactory locationFactory = NominatimLocationFactory.getInstance();

        try {
            Location location = locationFactory.getLocation("95650");

            System.out.println("lat = " + location.getLatitude());
            System.out.println("lon = " + location.getLongitude());

        } catch (IOException e) {
            e.printStackTrace();
        }

        Weather weather = new GovermentWeather();

        try {
            weather.refreshData("95650");

            List<WeatherRecord> weatherData = weather.getWeatherData();

            for (WeatherRecord entry : weatherData) {

                System.out.println("Period = " + entry.getPeriod());
                System.out.println("temp = " + entry.getTemp());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

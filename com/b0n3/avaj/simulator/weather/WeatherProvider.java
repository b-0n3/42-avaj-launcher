package com.b0n3.avaj.simulator.weather;

import com.b0n3.avaj.simulator.aircraft.Coordinates;
import com.b0n3.avaj.simulator.exceptions.InvalidWeatherTypeException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherProvider {


    private static WeatherProvider weatherProvider;
    private final String[] weather;

    private WeatherProvider()
    {
        weather = WeatherType.valuesToString();
    }

    public static WeatherProvider getProvider()
    {
        if (WeatherProvider.weatherProvider == null)
            WeatherProvider.weatherProvider = new WeatherProvider();
        return WeatherProvider.weatherProvider;
    }
    public String getCurrentWeather(Coordinates coordinates)
    {
        int pos = coordinates.getHeight() / 25 + coordinates.getLatitude() / 45 +  coordinates.getLongitude() / 45;
        pos =  pos%4;
        return weather[pos];
    }

}

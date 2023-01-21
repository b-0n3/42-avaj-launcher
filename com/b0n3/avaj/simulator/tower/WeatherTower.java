package com.b0n3.avaj.simulator.tower;

import com.b0n3.avaj.simulator.aircraft.Coordinates;
import com.b0n3.avaj.simulator.weather.WeatherProvider;

public class WeatherTower extends Tower{

    public String getWeather(Coordinates coordinates)
    {
       return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather()
    {
        this.conditionsChanged();
    }
}

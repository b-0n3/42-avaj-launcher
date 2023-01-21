package com.b0n3.avaj.simulator.weather;

import com.b0n3.avaj.simulator.exceptions.InvalidWeatherTypeException;

import java.util.Arrays;

public enum WeatherType {
    RAIN("RAIN"),
    FOG("FOG"),
    SUN("SUN"),
    SNOW("SNOW");

    String name;
    WeatherType(String value)
    {
        this.name = value;
    }

    String getName()
    {
        return name;
    }

    public static WeatherType getTypeByValue(String value)
    {
        return
                Arrays.stream(WeatherType.values())
                        .filter(t -> t.getName().equals(value))
                        .findFirst()
                        .orElseThrow(() -> new InvalidWeatherTypeException(value));
    }
    public static  String [] valuesToString()
    {
        return Arrays.stream(WeatherType.values()).map(WeatherType::getName).toArray(String[]::new);
    }
}

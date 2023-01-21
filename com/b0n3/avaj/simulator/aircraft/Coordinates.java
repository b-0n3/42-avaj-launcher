package com.b0n3.avaj.simulator.aircraft;

import com.b0n3.avaj.simulator.weather.WeatherType;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
        assert  height >= 0 && height<=100;
    }

    public int getHeight() {
        return height;
    }
    public int getLatitude() {
        return latitude;
    }
    public int getLongitude() {
        return longitude;
    }


    public void setLongitude(int longitude)
    {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude)
    {
        this.latitude = latitude;
    }

    public void setHeight(int height)
    {
        this.height = height;
        if (this.height > 100)
            this.height = 100;
    }
}

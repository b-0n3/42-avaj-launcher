package com.b0n3.avaj.simulator.flayable;

import com.b0n3.avaj.simulator.aircraft.Aircraft;
import com.b0n3.avaj.simulator.aircraft.Coordinates;
import com.b0n3.avaj.simulator.logger.Logger;
import com.b0n3.avaj.simulator.tower.WeatherTower;
import com.b0n3.avaj.simulator.weather.WeatherType;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;


    public JetPlane(String name, Coordinates coordinates)
    {
        super(name ,coordinates);
    }

    @Override
    public void updateConditions() {
        WeatherType type = WeatherType.getTypeByValue(weatherTower.getWeather(this.coordinates));
        switch (type)
        {
            case SUN -> {
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
            }
            case RAIN -> {
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
            }
            case FOG ->{
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
            }

            case SNOW -> {
                this.coordinates.setHeight(this.coordinates.getHeight() - 7);
            }
        }
        try {
            if (coordinates.getHeight() <= 0)
            {
                Logger.log(String.format("%s Landing", this));
                this.weatherTower.unregister(this);
                return;
            }
            Logger.log(String.format("%s: %s\n", this, MessageProvider.generateMessage(type)));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
    @Override
    public String toString()
    {
        return String.format("JetPlane#%s(%d)", this.name, this.id);
    }
}

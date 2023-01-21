package com.b0n3.avaj.simulator.flayable;

import com.b0n3.avaj.simulator.tower.WeatherTower;

public interface Flyable {
     void updateConditions();
     void registerTower(WeatherTower weatherTower);
}

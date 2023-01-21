package com.b0n3.avaj.simulator.aircraft;

import com.b0n3.avaj.simulator.flayable.Baloon;
import com.b0n3.avaj.simulator.flayable.Flyable;
import com.b0n3.avaj.simulator.flayable.Helicopter;
import com.b0n3.avaj.simulator.flayable.JetPlane;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        var start = LocalDateTime.now().getNano();
        var types = List.of(Baloon.class, JetPlane.class, Helicopter.class);
        return types.stream()
                .filter((c) -> c.getSimpleName().equals(type))
                 .findFirst()
                .flatMap(clazz-> {
                    try {
                        var constructor = clazz.getConstructor(String.class, Coordinates.class);
                        return Optional.of ((Flyable) constructor.newInstance(name, new Coordinates(longitude, latitude, height)));
//
                    }catch (Exception e)
                    {
                       return Optional.empty();
                    }
                }).orElseThrow(() ->new IllegalAccessError("invalid type"));
    }
}

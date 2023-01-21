package com.b0n3.avaj.simulator.flayable;

import com.b0n3.avaj.simulator.weather.WeatherType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageProvider {

    private static final Map<WeatherType, List<String>>  messages ;

    static {
        messages = Map.of(
                WeatherType.SUN,
                List.of("This is hot.",
                        "This is hot."),
                WeatherType.FOG,
                List.of("Let's enjoy the good weather and take some pics.",
                        "OMG! Winter is coming!"),
                WeatherType.RAIN,
                List.of("Damn you rain!",
                        "It's raining. Better watch out for lightings."
                        ),
                WeatherType.SNOW,
                List.of("My rotor is going to freeze!",
                        "It's snowing. We're gonna crash.")
        );
    }

    public static String generateMessage(WeatherType weatherType)
    {
        var l =  messages.get(weatherType);
        return l.get((int) (Math.random() * l.size()));

    }
}

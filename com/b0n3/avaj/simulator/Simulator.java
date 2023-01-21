package com.b0n3.avaj.simulator;

import com.b0n3.avaj.simulator.aircraft.Aircraft;
import com.b0n3.avaj.simulator.aircraft.AircraftFactory;
import com.b0n3.avaj.simulator.exceptions.InvalidArgumentsExceptions;
import com.b0n3.avaj.simulator.flayable.Flyable;
import com.b0n3.avaj.simulator.logger.Logger;
import com.b0n3.avaj.simulator.tower.WeatherTower;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class Simulator {

    public static void main(String[] args) throws IOException {
        int numberOfSumilation;
        List<String> senarios;
        if (args.length != 1) {
            throw  new InvalidArgumentsExceptions("Invalid number of arguments");
        }

      try {
          senarios = readAllLines(args[0]);
          if (senarios.size() < 2)
              throw new IllegalArgumentException("invalid file");
      }catch (Exception e)
      {
          throw e;
      }

      numberOfSumilation = Integer.parseInt(senarios.get(0));
      WeatherTower weatherTower = new WeatherTower();
      senarios.forEach(s -> lineToAirCraft(weatherTower, s));
      for (int i =1 ; i < numberOfSumilation; i++)
          weatherTower.changeWeather();
        Logger.close();
    }

    private static List<String> readAllLines(String fileName) throws IOException {
        var file = new File(fileName);

        return Files.readAllLines(file.toPath());
    }

    private static void lineToAirCraft(WeatherTower weatherTower, String line)
    {
        String[] params = line.split(" ");
        System.out.println(Arrays.toString(params));
        if (params.length ==  5) {
            Flyable flyable =AircraftFactory.newAircraft(params[0],
                    params[1],
                    Integer.parseInt(params[2]),
                    Integer.parseInt(params[3]),
                    Integer.parseInt(params[4]));
            flyable.registerTower(weatherTower);

        }
    }
}

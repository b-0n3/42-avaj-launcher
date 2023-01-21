package com.b0n3.avaj.simulator.exceptions;

public class InvalidWeatherTypeException extends IllegalArgumentException{
    public InvalidWeatherTypeException(String message)
    {
        super(message);
    }
}

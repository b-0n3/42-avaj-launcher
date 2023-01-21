package com.b0n3.avaj.simulator.aircraft;

public class Aircraft {
    private static long idCounter = 0;

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;

        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId() {
        return ++idCounter;
    }
}


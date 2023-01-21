package com.b0n3.avaj.simulator.tower;

import com.b0n3.avaj.simulator.flayable.Flyable;
import com.b0n3.avaj.simulator.logger.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Tower {

    public List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable)
    {
        this.observers.add(flyable);
        try {
            Logger.log(String.format("Tower says: %s registered to weather tower.\n", flyable));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void unregister(Flyable flyable)
    {
        this.observers.remove(flyable);
        try {
            Logger.log(String.format("Tower says: %s unregistered from weather tower.\n", flyable));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    protected void conditionsChanged()
    {
       for (int i = 0 ; i< observers.size(); i++)
           observers.get(i).updateConditions();
    }
}

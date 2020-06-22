package com.example.seriestest;

import java.util.ArrayList;
import java.util.List;

public class Shows {
    private final String name;
    private final double duration;
    private List<String> actorsNames= new ArrayList<>();

    public String getName() {
        return name;
    }

    public double getDuration() {
        return duration;
    }

    public List<String> getActorsNames() {
        return actorsNames;
    }

    public Shows(String name, double duration) {
        this.name = name;
        this.duration = duration;
    }

    public void setActorsNames(List<String> actorsNames) {
        this.actorsNames = actorsNames;
    }

    public boolean  addActor(String actorName)
    {
        if(actorsNames.contains(actorName))
        {
            System.out.println("The actor is already in the list");
            return false;
        }
        actorsNames.add(actorName);
        return true;
    }
}

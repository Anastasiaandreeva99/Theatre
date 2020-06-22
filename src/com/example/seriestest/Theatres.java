package com.example.seriestest;

import java.util.ArrayList;
import java.util.List;

public class Theatres {
    private List<Theatre> theatres = new ArrayList<>();

    public Theatres() {
    }

    public Theatres(List<Theatre> theaters) {
        this.theatres = theaters;
    }

    public void addTheatre(Theatre theatre) {
        theatres.add(theatre);
    }

    public List<Theatre> getTheatres() {
        return theatres;
    }

    public Theatre getTheatre(String name) {
        for (Theatre theatre : theatres) {
            if (name.equalsIgnoreCase(theatre.getTheatreName()))
                return theatre;
        }
        return null;
    }
}
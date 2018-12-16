package com.example.midterm;

import java.util.ArrayList;

//starting code

public class TemperatureAlert implements Subject{
    private int temperature;
    private ArrayList<Observer> observerList = null;

    TemperatureAlert() {
        observerList = new ArrayList<Observer>();

    }

    @Override
    public void notifyObservers() {
        for (Observer o:observerList) {
            o.update(this.temperature);
        }
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void unregister(Observer o) {
        observerList.remove(o);

    }

    @Override
    public void register(Observer o) {
        observerList.add(o);

    }

}


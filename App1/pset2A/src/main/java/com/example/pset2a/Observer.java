package com.example.pset2a;

import java.util.ArrayList;

interface Observer{
    void update(double airPollutionIndex);
}

class Subscriber implements Observer{
    private Subject subject;
    private String observerId;
    public static String outputMessage = "";

    public Subscriber(String observerId, Subject subject){
        this.subject=subject;
        this.observerId = observerId;
        this.subject.register(this);		// register itself
    }

    @Override
    public void update(double airPollutionIndex) {
        String s = this.observerId + " received notification: " + airPollutionIndex;
        System.out.println(s);
        outputMessage += (s + " ");
    }
}

interface Subject{
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers();
}

//TODO: modify AirPollutionAlert to implement interface Subject, under Observer design pattern
class AirPollutionAlert implements Subject{
    private double airPollutionIndex;
    private ArrayList<Observer> observerList = null;
    public void setAirPollutionIndex(double airPollutionIndex) {
        this.airPollutionIndex = airPollutionIndex;
        if(this.airPollutionIndex > 100) {
            notifyObservers();
        }

    }

    @Override
    public void register(Observer o) {
        observerList.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o:observerList) {
            o.update(airPollutionIndex);
        }
    }

    AirPollutionAlert() {
        this.observerList = new ArrayList<>();
    }
}

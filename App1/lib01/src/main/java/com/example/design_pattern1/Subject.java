package com.example.design_pattern1;


public interface Subject {
    void register(Observer o);
    void unregister(Observer o);

    void notifyObservers();

}

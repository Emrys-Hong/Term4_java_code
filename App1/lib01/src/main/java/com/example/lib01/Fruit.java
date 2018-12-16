package com.example.lib01;

public abstract class Fruit {
    public void shape() {
        System.out.println("Fruit have no shape");
    }

    public abstract void weight();
}

class Apple extends Fruit {
    public void shape() {
        System.out.println("Apple's shape is heart shape");
    }

    public void weight(){
        System.out.println("the apple have no weight");
    }
}

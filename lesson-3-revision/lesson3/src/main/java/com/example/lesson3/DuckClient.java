package com.example.lesson3;

import java.util.ArrayList;

public class DuckClient {
    static ArrayList<Duck> myducks;

    public static void main(String[] args) {
        myducks = new ArrayList<Duck>();
        Turkey myNewTurkey = new myTurkey();
        myducks.add(new TurkeyAdapter(myNewTurkey));
        makeDucksFlyQuack();
    }

    public static void makeDucksFlyQuack() {
        for (Duck duck: myducks) {
            duck.fly();
            duck.quack();
        }
    }
}

interface Duck {
    void fly();
    void quack();
}

interface Turkey {
    void gogle();
    void fly();
}

class myTurkey implements Turkey {
    @Override
    public void fly() {
        System.out.println("Turkey gogles");
    }

    @Override
    public void gogle() {
        System.out.println("Turkey fly");
    }
}

class TurkeyAdapter implements Duck {
    Turkey turkey;

    TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }
    @Override
    public void fly() {
        turkey.fly();
    }

    @Override
    public void quack() {
        turkey.gogle();
    }
}
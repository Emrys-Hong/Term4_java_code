package com.example.pset2a;

public class Octagon implements Comparable<Octagon>{
    private double side;
    public Octagon(double side){
        this.side = side;
    }
    public double getSide() {
        return side*5;
    }
    @Override
    public int compareTo(Octagon o) {
        if(this.getSide() > o.getSide()) {
            return 1;
        } else if(this.getSide() == o.getSide()) {
            return 0;
        } else {
            return -1;
        }
    }

}
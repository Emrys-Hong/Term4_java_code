package com.example.exercise;


public class Octagon implements Comparable<Octagon>{
    private double side;


    public static void main(String[] args) {
        System.out.println( (new Octagon(5)).getSide());
    }
    public Octagon(double side){
        this.side = side;
    }
    public double getSide() {
        return side;
    }
    public Octagon(){
        this(3);
    }
    @Override
    public int compareTo(Octagon o){
        if(this.side > o.side){
            return 1;
        }else if(this.side == o.side){
            return 0;
        }else{
            return -1;
        }
    }

}
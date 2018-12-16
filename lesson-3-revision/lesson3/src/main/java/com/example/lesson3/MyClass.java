package com.example.lesson3;

public class MyClass {
    public static void main(String[] args) {
        int i = new Pond.Duck().quak;
        int j = Pond.Duck.honk;
        Double a = Double.valueOf("");
    }
}

class Pond{
    static int n1 = 1;
    int n2 = 2;
    void methodA() {
        System.out.println("A");
    }

    static class Duck {
        int quak = 1111;
        static int honk = 2222;

    }
}

class Pond1{
    private double size;
    private Pond1() {

    }

    private static Pond1 createPond1() {
        return new Pond1();
    }
}
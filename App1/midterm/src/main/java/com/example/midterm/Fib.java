package com.example.midterm;

public class Fib {

    public static void main(String[] args) {
        System.out.println(recurFib(3));
        System.out.println(recurFib(5));
        System.out.println(recurFib(10));
    }

    public static int recurFib(int idx) {
        //TODO
        if (idx<=2) {
            return 1;
        } if (idx==3) {
            return 2;
        }
        int a = 1;
        int b = 1;
        for (int i=2; i<=idx; i++) {
            int c = a;
            a = a + b;
            b = c;
        }
        return b;
    }
}

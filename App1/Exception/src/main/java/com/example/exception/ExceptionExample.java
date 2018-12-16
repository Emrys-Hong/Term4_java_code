package com.example.exception;

public class ExceptionExample {
    public static void main (String[] args) {
        try {
            double a = quotient(5, 0);
        } catch (ArithmeticException ex){
            ex.printStackTrace();
        }
    }

    public static double quotient(double a, double b) throws ArithmeticException{
        if (b==0) {
            throw new ArithmeticException("b is zero");
        }
        return a/b;

    }
}
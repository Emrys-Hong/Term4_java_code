package com.example.andriod1;

public class SomeClassExample3 {
    interface MyInterface {
        void printSomething ();
    }
    int a;
    SomeClassExample3(){
        a = 10 ;
    }
    public void display (MyInterface myInterface){
        myInterface.printSomething();
    }
}
package com.example.andriod1;

public class OuterClass {
    int a;
    OuterClass(){ a = 10 ; }
    void outerPrintA (){ System.out.println(a); }
    class InnerClass {
        int c;
        InnerClass(){ c = 100 ; }
        void innerPrintA (){ System.out.println(a); }
        OuterClass giveBackOuter (){ return OuterClass. this ; }
    }
}

package com.example.andriod1;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class TestClass {
    public static void main (String[] args){
        //Instantiate OuterClass
        OuterClass outerClass = new OuterClass();
        //Instantiate the InnerClass
        OuterClass.InnerClass innerClass = outerClass.new
                InnerClass();
        //Show that InnerClass can access variables in OuterClass
        innerClass.innerPrintA();
        //Show that InnerClass stores a reference to OuterClass
        OuterClass outerClass1 = innerClass.giveBackOuter();
        System.out.println(outerClass == outerClass1);
    }
}

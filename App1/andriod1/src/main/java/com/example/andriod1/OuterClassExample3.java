package com.example.andriod1;

public class OuterClassExample3 {

    SomeClassExample3 someClassExample3;
    OuterClassExample3(){
        someClassExample3 = new SomeClassExample3();
    }
    public void callMe (){
        someClassExample3.display( new InnerClass());
    }
    class InnerClass implements SomeClassExample3 . MyInterface {
        @Override
        public void printSomething (){
            System.out.println( "Hello" );
        }
    }
}

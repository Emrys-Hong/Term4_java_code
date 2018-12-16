package com.example.pset2a;

//**SEE BELOW** Add in the code for the interfaces below
public class TestClass {

    public static void main(String[] args) {
        C2 x = new C2();

        System.out.println(x instanceof I1);
        System.out.println(x instanceof I2);
        System.out.println(x instanceof I3);
        System.out.println(x instanceof I4);
        System.out.println(x instanceof I5);
        System.out.println(x instanceof C1);

        C3 y = new C3();

        System.out.println(y instanceof I1);
        System.out.println(y instanceof I2);
        System.out.println(y instanceof I3);
        System.out.println(y instanceof I4);
        System.out.println(y instanceof I5);

    }
}

// Modify from here onwards ....
// Add and modify the code for interfaces and classes according to the question

interface I1{
    int p1();
}

interface I2{
    int p2();
}

interface I3{
    int p3();
}

interface I4 extends I1, I2, I3{
    int p4();
}

interface I5 extends I3{
    int p5();
}

abstract class C1 implements I4 {
    public abstract int p1();
}

class C2 extends C1 implements I5 {
    @Override
    public int p2() {
        return 0;
    }

    @Override
    public int p3() {
        return 0;
    }

    @Override
    public int p4() {
        return 0;
    }

    @Override
    public int p5() {
        return 0;
    }

    @Override
    public int p1() {
        return 0;
    }
}

class C3 implements I5 {

    @Override
    public int p3() {
        return 0;
    }

    @Override
    public int p5() {
        return 0;
    }
}



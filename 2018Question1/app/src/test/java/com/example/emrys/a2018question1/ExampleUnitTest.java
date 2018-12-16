package com.example.emrys.a2018question1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    double delta = 1e-10;
    @Test
    public void checkcalculation(){
        Bond.BondBuilder bondBuilder = new Bond.BondBuilder();
        Bond bond2 = bondBuilder
                .setDuration(4)
                .setFaceValue(1000)
                .setSellingPrice(900)
                .setInterestPayment(10).createBond();
        assertEquals( 0.0374,
                bond2.calculateYTM(),
                delta);
    }


    @Test(expected=IllegalArgumentException.class)
    public void checkerror() {
        Bond.BondBuilder bondBuilder = new Bond.BondBuilder();
        Bond bond2 = bondBuilder
                .setDuration(-1)
                .setFaceValue(-1)
                .setSellingPrice(900)
                .setInterestPayment(10).createBond();
    }


}
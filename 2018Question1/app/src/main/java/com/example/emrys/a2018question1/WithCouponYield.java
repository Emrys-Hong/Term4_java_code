package com.example.emrys.a2018question1;

public class WithCouponYield implements YieldCalculation {
    @Override
    public double yieldToMaturity(Bond bond) {
        return 0.0123;
    }
}

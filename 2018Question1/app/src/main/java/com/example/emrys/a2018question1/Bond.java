package com.example.emrys.a2018question1;

public class Bond {

    private double sellingPrice;
    private double faceValue;
    private double interestPayment;
    private double duration;

    private YieldCalculation yieldCalculation;

    Bond(BondBuilder bondBuilder) throws IllegalArgumentException{
        if (sellingPrice<= 0 | faceValue <=0 | interestPayment < 0| duration <=0 ) throw new IllegalArgumentException();
        this.sellingPrice = bondBuilder.sellingPrice;
        this.faceValue = bondBuilder.faceValue;
        this.interestPayment = bondBuilder.interestPayment;
        this.duration = bondBuilder.duration;
    }

    static class BondBuilder {
        private double sellingPrice = 1000;
        private double faceValue = 1000;
        private double interestPayment = 10;
        private double duration = 1;

        BondBuilder () {

        }
        public Bond createBond() {
            return new Bond(this);
        }

        public BondBuilder setDuration(double duration) {
            this.duration = duration;
            return this;
        }

        public BondBuilder setFaceValue(double faceValue) {
            this.faceValue = faceValue;
            return this;
        }

        public BondBuilder setInterestPayment(double interestPayment) {
            this.interestPayment = interestPayment;
            return this;
        }

        public BondBuilder setSellingPrice(double sellingPrice) {
            this.sellingPrice = sellingPrice;
            return this;
        }
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public double getFaceValue() {
        return faceValue;
    }

    public double getInterestPayment() {
        return interestPayment;
    }

    public void setYieldCalculator(YieldCalculation yieldCalculation) {
        this.yieldCalculation = yieldCalculation;
    }

    public double getDuration() {
        return duration;

    }

    double calculateYTM() {
        return yieldCalculation.yieldToMaturity(this);
    }
}

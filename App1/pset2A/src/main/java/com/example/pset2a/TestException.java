package com.example.pset2a;


public class TestException {
    public static void main(String[] args) {
        String[] in = {"hello", "good night", "good morning"};

        String ret = tstException(2, in);

        System.out.println(ret);

        ret = tstException(-1, in);

        System.out.println(ret);
    }


    public static String tstException(int idx, String[] y) {
        // implement using try-catch
        try {
            return y[idx];
        } catch (Exception ex1) {
            return "Out of Bounds";
        }

    }
}

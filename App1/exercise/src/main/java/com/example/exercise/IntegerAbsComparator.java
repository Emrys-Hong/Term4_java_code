package com.example.exercise;

import java.util.Comparator;

public class IntegerAbsComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b){
        int a1 = Math.abs(a);
        int b1 = Math.abs(b);
        if(a1>b1){
            return 1;
        }else if(a1==b1){
            return 0;
        }else{
            return -1;
        }
    }
}

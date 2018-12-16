package com.example.midterm;

import java.util.*;

public class TestStronglyConnected1 {
    public static void main (String[] args){
        int nodecount=4;
        int linkcount=3;
        ArrayList<Integer> listOfLink = new ArrayList<Integer> ( Arrays.asList(0,1,  1,2,  2,3));
        System.out.println(StronglyConnected.testStronglyConnected(nodecount, linkcount, listOfLink));
    }
}

package com.example.exercise;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Rectangle> l = new ArrayList<>();
        l.add(new Rectangle(10, 10));
        l.add(new Rectangle(2,2));
        l.add(new Rectangle(3, 3));

        Collections.sort(l);
        System.out.println(l);

        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(-20);
        l1.add(-3);
        l1.add(10);
        Collections.sort(l1, new IntegerAbsComparator());
        System.out.println(l1);
    }
}

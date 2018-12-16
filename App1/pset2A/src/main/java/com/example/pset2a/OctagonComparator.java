package com.example.pset2a;

import java.util.Comparator;

public class OctagonComparator implements Comparator<Octagon> {

    //then implement the method(s) in the interface
    public int compare(Octagon o1, Octagon o2) {
        if(o1.getSide() > o2.getSide()) {
            return 1;
        } else if (o1.getSide() == o2.getSide()) {
            return 0;
        } else {
            return -1;
        }
    }

}

package com.example.exercise;

import java.util.Comparator;

public class ComparatorOctagon implements Comparator<Octagon> {
    @Override
    public int compare(Octagon a, Octagon b){
        if(a.getSide() > b.getSide()){
            return 1;
        }else if(a.getSide() == b.getSide()){
            return 0;
        }else{
            return -1;
        }
    }
}

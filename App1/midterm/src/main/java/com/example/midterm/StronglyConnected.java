package com.example.midterm;

import java.util.ArrayList;
import java.util.List;

//starting code

public class StronglyConnected {


    static boolean testStronglyConnected(int nodecount, int linkcount, ArrayList<Integer> l) {
        //todo: implement the method
        int node = l.get(0);
        ArrayList<Integer> fakel = (ArrayList)l.clone();
        for (int o=0; o>=l.size()-1; o++) {
            fakel.add(l.get(o));
        }
        ArrayList<Integer> stack = new ArrayList<>();

        if (oneTest(node, fakel, stack, nodecount) == true) {

            ArrayList<Integer> newl = new ArrayList<Integer>();
            ArrayList<Integer> newStack = new ArrayList<>();
            for (int o=l.size()-1; o>=0; o--) {
                newl.add(l.get(o));
            }
            if (oneTest(node, l, newStack, nodecount) == true) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    static boolean oneTest(int node, ArrayList<Integer> l, ArrayList<Integer> stack, int nodecount) {
        if (stack.size() == nodecount) {
            return true;
        } else {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i=0; i<l.size()-1; i++) {
                if (l.get(i) == node) {
                    temp.add(l.get(i+1));
                }
            }

            for (int next: temp) {
                stack.add(next);
                int index = l.indexOf(next);
                l.remove(index-1);
                l.remove(index-1);
                if (oneTest(next, l, stack, nodecount) == true) {
                    return true;
                }
            }

            return false;
        }

    }
}



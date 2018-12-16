package com.example.pset2a;
import java.util.*;
public class Test{
    public static void main(String[] args) {
//        Palindrome p = new Palindrome();
//        char[] c = {'a', 'b', 'c', 'b','a'};
//        System.out.println(Arrays.copyOfRange(c, 1, c.length));
//        System.out.println(Palindrome.isPalindrome(c));
//        Permutation per = new Permutation("");
//        per.permute();
//        System.out.println(per.getA());
//        ArrayList<Integer> al = new ArrayList<>();
//        al.add(1);
//        al.add(2);
//        al.add(3);
//        al.add(4);
//        System.out.println(al.get(al.size()-1));

        final int [][] grid0 = {
                {0,0,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,0},
                {1,1,1,0,1},
                {0,0,0,0,0}
        };

        ArrayList<Point> path = new ArrayList<>();

        boolean success = GetPath.getPath(4,4,path, grid0);

        System.out.println(success);
        if (success)
            System.out.println(path);
        path.clear();


        final int [][] grid = {
                {0,1,0},
                {0,1,0},
                {1,0,0}
        };

        success = GetPath.getPath(2,2,path, grid);

        System.out.println(success);
        if (success)
            System.out.println(path);
        path.clear();

        int[] a = new int[2];
        int[] b = a.clone();
        a[0] = 1;
        a[1] = 1;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

}

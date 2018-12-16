package com.example.lib01;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println(isAllCharacterUnique("abcdefghijklmnopqrstuvwxyzABC@"));
    }

    public static boolean isAllCharacterUnique(String sIn) {
        //todo: add your implementation
        boolean[] duplicate = new boolean[65536];
        for(char c: sIn.toCharArray()){
            if (duplicate[c]) {
                return false;
            }

            duplicate[c] = true;

        }
        return true;
    }
}

package com.sq._laboratory; // Created by SquorpikkoR on 05.01.2017.

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println(isThatPalindrom("Aba!ba"));

    }

    public static boolean isThatPalindrom(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        String sReversive = sb.reverse().toString();
        return s.equals(sReversive);
    }


}

package com.sq._java_basic_course.is_that_palindrom; // Created by SquorpikkoR on 25.01.2017.

public class Main {

    public static void main(String[] args) throws Exception {
        String text = "Aba!ba";
        System.out.println(isThatPalindrom(text));
    }

    private static boolean isThatPalindrom(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        String sReversive = sb.reverse().toString();
        return s.equals(sReversive);
    }


}


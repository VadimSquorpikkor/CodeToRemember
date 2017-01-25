package com.sq.DoublePlusDouble; // Created by SquorpikkoR on 25.01.2017.

public class Main {

    public static void main(String[] args) throws Exception {
        double a = 0.1;////Вместо проверки a + b = c, так как с double такое не прокатит
        double b = 0.3;////т. к. для double 0.1 + 0.1 + ... + 0.1 != 1 (!)
        double c = 0.4;
        if (Math.abs(c - (a + b)) < 0.0001) System.out.println(true);
        else System.out.println("false");
    }
}

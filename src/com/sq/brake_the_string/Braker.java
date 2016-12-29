package com.sq.brake_the_string;

 // Created by SquorpikkoR on 23.12.2016.

public class Braker {
    void brakeTheLine(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            if (str.charAt(i) == '3') {
                System.out.println("hhh");

            }
        }
    }
}

package com.sq._java_basic_course.factorial; // Created by SquorpikkoR on 25.01.2017.

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {

        int N = 44;
        System.out.println(factorial(N));

    }

    private static BigInteger factorial(int N) {
        BigInteger bg = new BigInteger("1");
        for (int i = 1; i < N; i++) {
            bg = bg.multiply(BigInteger.valueOf(i + 1));
        }
        return bg;
    }

}
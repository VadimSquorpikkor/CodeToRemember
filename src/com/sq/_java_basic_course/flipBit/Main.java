package com.sq._java_basic_course.flipBit; // Created by SquorpikkoR on 05.02.2017.

public class Main {

    public static void main(String[] args) {
        System.out.println(flipBit(1000001, 101));
    }

    public static int flipBit(int value, int bitIndex) {////Такое решение прошло
        return value^(1<<(bitIndex-1));

    }

    /*public static int flipBit(int value, int bitIndex) {
        System.out.println("Пришло: " + value);
        System.out.println("Индекс: " + bitIndex);
        String s = String.valueOf(value);
        int res = Integer.parseInt(s, 2);
        System.out.println("в 10-ой: "+res);
        ///////////////////////////////////////////////////////////
        int temp = res;
        for (int i = 0; i < bitIndex-1; i++) {
            temp/=2;
        }
        //if((res/(Math.pow(2, bitIndex-1)))%2==0)res+=Math.pow(2, bitIndex-1);
        if((temp)%2==0)  res+=Math.pow(2, bitIndex-1);
        else res-=Math.pow(2, bitIndex-1);
        System.out.println("flipped: "+res);
        //return (int)Math.pow(2, 5);
        s = Integer.toBinaryString(res);
        return Integer.parseInt(s);
    }*/
}

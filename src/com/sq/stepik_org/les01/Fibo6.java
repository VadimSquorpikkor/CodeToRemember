package com.sq.stepik_org.les01; // Created by SquorpikkoR on 11.01.2017.

//НЕ ПРОХОДИТ TEST#15

//region TASK DESCRIPTION
        /*огромное число Фибоначчи по модулю
        Даны целые числа 1≤n≤10_18
        и 2≤m≤10_5, необходимо найти остаток от деления n-го числа Фибоначчи на m

        Sample Input:
        10 2

        Sample Output:
        1*/
        //endregion

import java.util.Scanner;

public class Fibo6 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long temp = scanner.nextLong();
        int n;
        if(temp>150023){    //15063
            n = (int) (temp - (((temp/150000) - 1)*150000));
            if (n > 150023) {
                n = n - 150000;
            }
        }else{
            n = (int) temp;
        }
        //System.out.println(temp + " -- " + n);
        //n = temp;
        int m = scanner.nextInt();

        int a = 0;
        int b = 1;

        int res = 0;
        if (n == 0) {
            res = 0;
        }
        if (n == 1) {
            res = 1;
        }
        for (int i = 2; i <= n; i++) {
            //if (a%100000==81961&&b%100000==37881) {
            /*if (a%100000==10946&&b%100000==17711) {
                System.out.println("Период на номере" + i + ", -- " + a + ", -- " + b);
            }*/
            //res = (a + b)%100000;
            res = (a + b)%m;
            //System.out.println("№ - " + i + ", -- " + res);
            a = b;
            b = res;
        }

        //System.out.println(res);
        System.out.println(res%m);
    }
}




















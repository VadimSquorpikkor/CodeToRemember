package com.sq.stepik_org.les01; // Created by Stepik.org (скопипастено 11.01.2017.

        /*огромное число Фибоначчи по модулю
        Даны целые числа 1≤n≤10_18
        и 2≤m≤10_5, необходимо найти остаток от деления n-го числа Фибоначчи на m

        Sample Input:
        10 2

        Sample Output:
        1*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibo5 {

    public static void main(String[] args) {

        List<Integer> cache = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        long temp = scanner.nextLong();
        long MODE = 1000000;
        int n = (int) (temp%MODE);
        int m = scanner.nextInt();

        cache.add(0);
        cache.add(1);

        int res;
        for (int i = cache.size(); i <= n; i++) {
            res = (cache.get(i - 1) + cache.get(i - 2))%1000000;
            cache.add(res);
        }
    System.out.println(cache.get(n)%m);
    }
}

package com.sq.stepik_org.les01; // Created by SquorpikkoR on 06.01.2017.

import java.math.BigInteger;
import java.util.Scanner;

/*Задача на программирование повышенной сложности: огромное число Фибоначчи по модулю

        Даны целые числа 1≤n≤1018
        и 2≤m≤105, необходимо найти остаток от деления n-го числа Фибоначчи на m

        Sample Input: 10 2
        Sample Output: 1
*/
public class Fibo3 {
                public static void main(String[] args) {
                        Scanner scanner = new Scanner(System.in);
                        int m = scanner.nextInt();
                        int n = scanner.nextInt();
                        BigInteger fibo = new BigInteger("0");
                        BigInteger first = new BigInteger("1");
                        BigInteger second = new BigInteger("1");
                        BigInteger result = new BigInteger("0");

                        if (n == 1) {
                                fibo = first;
                        } else if (n == 2) {
                                fibo = second;
                        } else {
                                for (int i = 2; i < n; i++) {
                                        fibo = (first.add(second));
                                        first = second;
                                        second = fibo;
                                }
                                //System.out.println(fibo);//Отображение самого числа, закоменчено, потому как не нужно по условию задачи
                        }
                        result = fibo.mod(BigInteger.valueOf(m));
                        System.out.println(result);
                }
}

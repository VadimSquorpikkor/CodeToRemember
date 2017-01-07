package com.sq.stepik_org.les01; // Created by SquorpikkoR on 06.01.2017.

import java.util.Scanner;

public class Fibo4 {

    /*Задача на программирование повышенной сложности: огромное число Фибоначчи по модулю

            Даны целые числа 1≤n≤1018
            и 2≤m≤105, необходимо найти остаток от деления n-го числа Фибоначчи на m

            Sample Input: 10 2
            Sample Output: 1
    */
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int fibo = 0;
            int first = 1;
            int second = 1;
            int result;

            if ((n == 1)||(n == 2)){
                fibo = 1;
            } else {
                for (int i = 2; i < n; i++) {
                    fibo = (second + first)%1000;
                    first = second;
                    second = fibo;
                }
                //System.out.println(fibo);//Отображение самого числа, закоменчено, потому как не нужно по условию задачи
            }
            result = fibo%m;
            System.out.println(result);
        }
}




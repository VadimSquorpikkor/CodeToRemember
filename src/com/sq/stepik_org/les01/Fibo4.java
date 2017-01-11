package com.sq.stepik_org.les01; // Created by SquorpikkoR on 06.01.2017.

import java.util.Scanner;

public class Fibo4 {//Не прошел проверку!!!!!!!!!

    /*Задача на программирование повышенной сложности: огромное число Фибоначчи по модулю

            Даны целые числа 1≤n≤10_18
            и 2≤m≤10_5, необходимо найти остаток от деления n-го числа Фибоначчи на m

            Sample Input: 10 2
            Sample Output: 1
    */
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            long n = scanner.nextLong();
            int m = scanner.nextInt();
            long fibo = 0;
            long first = 1;
            long second = 1;
            long result;

            if ((n == 1)||(n == 2)){
                fibo = 1;
            } else {
                for (long i = 2; i < n; i++) {
                    fibo = (second + first)%m;
                    //fibo = second + first;
                    first = second;
                    second = fibo;
                }
                //System.out.println(fibo);//Отображение самого числа, закоменчено, потому как не нужно по условию задачи
            }
            result = fibo;
            System.out.println(result);
        }
}




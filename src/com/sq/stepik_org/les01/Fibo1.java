package com.sq.stepik_org.les01; // Created by SquorpikkoR on 06.01.2017.

/*Задача на программирование: небольшое число Фибоначчи

Дано целое число 1≤n≤40
, необходимо вычислить n-е число Фибоначчи (напомним,
что F0=0, F1=1 и Fn=Fn−1+Fn−2 при n≥2).

Sample Input: 3
Sample Output: 2*/

import java.util.Scanner;

public class Fibo1 {
    //Этот алгоритм использует массив для подсчета -- он быстрый но тратит память,
    // считает в int'ах поэтому использовать для небольших чисел (до 2 миллиардов в ответе).
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fiboSize = scanner.nextInt() + 1;
        int[] fiboAr = new int[fiboSize];
        fiboAr[0] = 0;
        if(fiboSize>1){//Проверка чтоб можно было вычислять если n-е число = 1
            fiboAr[1] = 1;
        }
        if(fiboSize>2){//Проверка чтоб можно было вычислять если n-е число = 2
            for (int i = 2; i < fiboSize; i++) {
            fiboAr[i] = fiboAr[i - 1] + fiboAr[i - 2];
            }
        }
        System.out.println(fiboAr[fiboSize - 1]);
    }
}

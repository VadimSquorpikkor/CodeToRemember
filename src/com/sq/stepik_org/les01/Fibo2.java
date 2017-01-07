package com.sq.stepik_org.les01; // Created by SquorpikkoR on 06.01.2017.

import java.util.Scanner;

/*Задача на программирование: последняя цифра большого числа Фибоначчи

        Дано число 1≤n≤10_7, необходимо найти последнюю цифру n-го числа Фибоначчи.

        Как мы помним, числа Фибоначчи растут очень быстро, поэтому при их вычислении нужно быть аккуратным
        с переполнением. В данной задаче, впрочем, этой проблемы можно избежать, поскольку нас интересует
        только последняя цифра числа Фибоначчи: если 0≤a,b≤9
        — последние цифры чисел Fi и Fi+1 соответственно, то (a+b)mod10 — последняя цифра числа Fi+2

        Sample Input: 132941
        Sample Output: 1
*/
public class Fibo2 {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                int fiboSize = scanner.nextInt();
                int first = 0;
                int second = 1;
                int result = 0;
                if (fiboSize == 1) {
                        System.out.println(first);
                } else if (fiboSize == 2) {
                        System.out.println(second);
                } else {
                        for (int i = 2; i < fiboSize; i++) {
                                result = (first + second)%10;
                                first = second;
                                second = result;
                        }
                        System.out.println(result);
                }

        }


}

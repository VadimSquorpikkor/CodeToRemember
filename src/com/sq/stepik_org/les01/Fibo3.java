package com.sq.stepik_org.les01; // Created by SquorpikkoR on 06.01.2017.

import java.math.BigInteger;
import java.util.Scanner;

/*Задача на программирование повышенной сложности: огромное число Фибоначчи по модулю

        Даны целые числа 1≤n≤10_18
        и 2≤m≤10_5, необходимо найти остаток от деления n-го числа Фибоначчи на m

        Sample Input: 10 2
        Sample Output: 1
*/
public class Fibo3 {//Не прошел проверку!!!!!!!!!
        /*Failed test #7. Run time error:
        Exception in thread "main" java.util.InputMismatchException: For input string: "99999999999999999"
        at java.util.Scanner.nextInt(Scanner.java:2166)
        at java.util.Scanner.nextInt(Scanner.java:2119)
        at Main.main(Main.java:8)*/      //8-я строчка НЕ ТА ЧТО В ЭТОМ КОДЕ
                public static void main(String[] args) {
                        Scanner scanner = new Scanner(System.in);
                        long n = scanner.nextLong();      //А ЭТА
                        int m = scanner.nextInt();
                        BigInteger fibo = new BigInteger("0");
                        BigInteger first = new BigInteger("1");
                        BigInteger second = new BigInteger("1");

                        BigInteger one = new BigInteger("1");

                        BigInteger result = new BigInteger("0");

                        if (n == 0) {
                                fibo = BigInteger.valueOf(0);
                        } else if (n == 1) {
                                fibo = first;
                        } else if (n == 2) {
                                fibo = second;
                        } else {
                                for (long i = 2; i < n; i++) {
                                        if (first.mod(BigInteger.valueOf(10)).equals(one)) {
                                                System.out.println("Период на номере" + i);
                                        }
                                        fibo = (first.add(second));
                                        first = second;
                                        second = fibo;
                                }
                                //System.out.println(fibo);//Отображение самого числа, закоменчено, потому как не нужно по условию задачи
                        }
                        result = fibo.mod(BigInteger.valueOf(m));
                        System.out.println(result);
                        //System.out.println(fibo);
                }
}

package com.sq.stepik_org.les04; // Created by SquorpikkoR on 07.01.2017.

        /*По данному числу 1≤n≤10_9 найдите максимальное число k,
        для которого n можно представить как сумму k различных натуральных
        слагаемых.
        Выведите в первой строке число k, во второй — k слагаемых.

         Sample Input 1:
         4

         Sample Output 1:
         2
         1 3

         Sample Input 2:
         6

         Sample Output 2:
         3
         1 2 3 */

import java.util.Scanner;

public class SumSlag {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        //int n = 4;

        int i = 0;
        int j = 0;
        int sum = n;
        int[] list = new int[n];
        do {
            //sum = sum + i;
            i= i+1;
            if (((sum - i) > i)||(sum - i == 0)) {
                list[j] = i;
                sum = sum - i;
                j++;
            }
        } while (sum - i > 0);

        System.out.println(j);
        for (int k = 0; k < j - 1; k++) {
            System.out.print(list[k] + " ");
        }
        System.out.println(list[j - 1]);

    }
}

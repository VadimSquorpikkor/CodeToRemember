package com.sq.stepik_org.les08; // Created by SquorpikkoR on 13.01.2017.

import java.util.Scanner;

/*лестница
        Даны число 1≤n≤10_2 ступенек лестницы и целые числа −10_4≤a1,…,an≤10_4,
        которыми помечены ступеньки. Найдите максимальную сумму, которую можно
        получить, идя по лестнице снизу вверх (от нулевой до n-й ступеньки),
        каждый раз поднимаясь на одну или две ступеньки.

        Sample Input 1:
        2
        1 2

        Sample Output 1:
        3

        Sample Input 2:
        2
        2 -1

        Sample Output 2:
        1

        Sample Input 3:
        3
        -1 2 1

        Sample Output 3:
        3
*/
public class Stairway_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] stairList = new int[n];

        int count = 0;

        for (int i = 0; i < stairList.length; i++) {
            stairList[i] = scanner.nextInt();
        }

        for (int j = 0; j < stairList.length; j++) {
            if (stairList[j] >= 0) {
                count += stairList[j];
            } else if (stairList.length - j > 1 && stairList[j + 1] >= 0) {

            } else if (stairList.length - j > 1 && stairList[j + 1] < 0 && stairList[j] < stairList[j + 1]) {
                count += stairList[j + 1];
            } else if (stairList.length - j > 1 && stairList[j + 1] < 0 && stairList[j] > stairList[j + 1]) {
                count += stairList[j];
                j++;
            } else if (stairList.length - j == 1) {
                count += stairList[j];
            }

            }

        System.out.println(count);

    }
}

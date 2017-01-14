package com.sq.stepik_org.les08; // Created by SquorpikkoR on 10.01.2017.

        /*рюкзак

        Первая строка входа содержит целые числа 1≤W≤10_4
        и 1≤n≤300 — вместимость рюкзака и число золотых слитков.
        Следующая строка содержит n целых чисел 0≤w1,…,wn≤10_5
        , задающих веса слитков. Найдите максимальный вес золота,
        который можно унести в рюкзаке.

        Sample Input:
        10 3
        1 4 8

        Sample Output:
        9*/

import java.util.Scanner;

public class Bag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bagWeight = scanner.nextInt();
        int goldQuantity = scanner.nextInt();

        int[] goldWeightArray = new int[goldQuantity];
        for (int i = 0; i < goldQuantity; i++) {
            goldWeightArray[i] = scanner.nextInt();
        }

        int result = 0;
        int i = goldWeightArray.length;

        while ((result <= bagWeight)&&(i>0)) {
            i--;
            if (!((result + goldWeightArray[i]) > bagWeight)) {
                result += goldWeightArray[i];
                i--;
            }
        }

        System.out.println(result);
    }
}

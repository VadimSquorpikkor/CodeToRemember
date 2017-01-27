package com.sq._java_basic_course.merge_array; // Created by SquorpikkoR on 05.01.2017.

import java.util.Arrays;

/*
Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел в
один отсортированный в том же порядке массив. Массивы могут быть любой длины, в том числе нулевой.

Предполагается, что вы реализуете алгоритм слияния, имеющий линейную сложность:
он будет идти по двум исходным массивам и сразу формировать отсортированный результирующий массив.
Так, чтобы сортировка полученного массива при помощи Arrays.sort() уже не требовалась.
К сожалению, автоматически это не проверить, так что это остается на вашей совести :)

Пример
Если на вход подаются массивы {0, 2, 2} и {1, 3},
то на выходе должен получиться массив {0, 1, 2, 2, 3}
*/

public class Main {

    public static void main(String[] args) throws Exception {
        mergeArrays(new int[]{1, 2, 3}, new int[]{1, 4, 7});
        System.out.println(Arrays.toString(mergeArrays(new int[]{1, 2, 3, 8}, new int[]{1, 4, 7})));
    }

    private static int[] mergeArrays(int[] a1, int[] a2) {
        int[] res = new int[a1.length + a2.length];
        int a1Count = 0;
        int a2Count = 0;
        for (int i = 0; i < res.length; i++) {
            if (a2Count >= a2.length || a1Count < a1.length && a1[a1Count] < a2[a2Count]){
                res[i] = a1[a1Count];
                a1Count++;
            }
            else {
                res[i] = a2[a2Count];
                a2Count++;
            }

        }
        return res; // your implementation here
    }


}


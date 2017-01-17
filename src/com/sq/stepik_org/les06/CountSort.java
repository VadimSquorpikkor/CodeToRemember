package com.sq.stepik_org.les06; // Created by SquorpikkoR on 16.01.2017.

/*сортировка подсчётом

        Первая строка содержит число 1≤n≤10_4, вторая — n
        натуральных чисел, не превышающих 10. Выведите упорядоченную по
        неубыванию последовательность этих чисел.

        Sample Input:
        5
        2 3 9 2 9

        Sample Output:
        2 2 3 9 9*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class CountSort {
    public static void main(String[] args) throws FileNotFoundException {
        String file = "src/com/sq/stepik_org/les06/csort_data.txt";
        InputStream stream = new FileInputStream(file);
        Scanner scanner = new Scanner(stream);
        /////Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] countArray = new int[11];
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            countArray[array[i]]++;
        }
        int[] sortedArray = new int[n];
        int k = 0;
        int p = 0;
        for (int i = 0; i < 10; i++) {
                while (p < countArray[i]) {
                    sortedArray[k]=i;
                    p++;
                    k++;
                }
                p=0;
        }
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
    }

}
















package com.sq.stepik_org.les06; // Created by SquorpikkoR on 09.01.2017.

/*      двоичный поиск

        В первой строке даны целое число 1≤n≤10_5
        и массив A[1…n] из n различных натуральных чисел, не превышающих 10_9,
        в порядке возрастания, во второй — целое число 1≤k≤10_5 и k
        натуральных чисел b1,…,bk, не превышающих 10_9.
        Для каждого i от 1 до k необходимо вывести индекс 1≤j≤n, для
        которого A[j]=bi, или −1, если такого j нет.

        Sample Input:
        5 1 5 8 12 13
        5 8 1 23 1 11

        Sample Output:
        3 1 -1 1 -1*/

import java.util.Scanner;

public class BinarySearch {
    int[] findIndex(){
        Scanner scanner = new Scanner(System.in);

        //размер отсортированного массива
        int n = scanner.nextInt();
        //сам отсортированный массива
        int[] a=new int[n];
        for (int i = 1; i <= n; i++) {
            a[i-1] = scanner.nextInt();
        }

        //размер массива индексов
        int k = scanner.nextInt();
        int[] result=new int[k];
        for (int i = 0; i < k; i++) {
            int value = scanner.nextInt();
            //тут реализуйте бинарный поиск индекса

            int lowEnd = 0;
            int hiEnd = n - 1;


            result[i]=findTheValue(lowEnd, hiEnd, value, a);
        }
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }


    int findTheValue(int lowEnd, int hiEnd, int value, int[] a) {
        int catcher;
        while (true) {
            catcher = (lowEnd + hiEnd)/2;
            if (a[catcher] == value) return catcher+1;
            if (lowEnd >= hiEnd) return -1;
            if (a[catcher] > value) {
                hiEnd = catcher - 1;
            } else {
                lowEnd = catcher + 1;
            }
        }
    }

    public static void main(String[] args){
        BinarySearch instance = new BinarySearch();
        int[] result=instance.findIndex();
        for (int index:result){
            System.out.print(index+" ");
        }

    }
}

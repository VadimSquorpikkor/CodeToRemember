package com.sq.stepik_org.les06; // Created by SquorpikkoR on 15.01.2017.

/////Алгоритм рабочий , но нужно доделать, в нем слишком много массивов. Доработка по ссылке:
/////https://stepik.org/lesson/%D0%9F%D1%80%D0%B0%D0%BA%D1%82%D0%B8%D0%BA%D0%B0-%D0%BD%D0%B0-Java-%D0%A7%D0%B8%D1%81%D0%BB%D0%BE-%D0%B8%D0%BD%D0%B2%D0%B5%D1%80%D1%81%D0%B8%D0%B9-17691/step/6?course=%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC%D1%8B-%D1%82%D0%B5%D0%BE%D1%80%D0%B8%D1%8F-%D0%B8-%D0%BF%D1%80%D0%B0%D0%BA%D1%82%D0%B8%D0%BA%D0%B0-%D0%9C%D0%B5%D1%82%D0%BE%D0%B4%D1%8B&unit=4501

import java.util.Scanner;

public class MergeSort_Best {

    private int[] merge(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int[] res = new int[a.length + b.length];
        for (int k = 0; k < res.length; k++) {
            if (j >= b.length || (i < a.length && a[i] < b[j])) {
                res[k] = a[i];
                i++;
            } else {
                res[k] = b[j];
                j++;
            }
        }

        return res;
    }

    private int[] mergeSort(int[] a) {
        if (a.length == 1) {
            return a;
        }
        int n = a.length;
        int m = n / 2;
        int[] left = new int[m];
        int[] right = new int[n - m];
        System.arraycopy(a, 0, left, 0, m);
        System.arraycopy(a, m, right, 0, n - m);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 1; i <= n; i++) {
            a[i - 1] = scanner.nextInt();
        }
        int[] sortedA = mergeSort(a);
        for (int aSortedA : sortedA) {
            System.out.print(aSortedA + " ");
        }
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(new MergeSort_Best().merge(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8, 10})));//Проверка merge()
        new MergeSort_Best().run();
    }

}
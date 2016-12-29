package com.sq.sort; // Created by SquorpikkoR on 27.12.2016.

public class MyArray {
    public static void main(String[] args) {
        int[] ar = createRandomizedArray(10, 10);
        displayArray(ar);
        sortArray(new InsertionSort(), ar);
        displayArray(ar);
    }

    static void sortArray(SortMethod method, int[] mas) {
        method.sort(mas);
    }

    static int[] createRandomizedArray(int length, int max) {
        int[] mas = new int[length];
        for (int j = 0; j<length;  j++) {
            mas[j] = (int)(Math.random()*max);
            //j = (int)(Math.random()*max);
        }
        return mas;
    }

    static void displayArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

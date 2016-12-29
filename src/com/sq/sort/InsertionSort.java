package com.sq.sort; // Created by SquorpikkoR on 27.12.2016.

public class InsertionSort extends SortMethod{

    @Override
    void sort(int[] array) {
        int j;
        int temp;
        for (int i = 1; i < array.length; i++) {//начинается со второго элемента
            j = i - 1;
            while (j >= 0 && array[j] > array[j + 1]) {
                temp = array[j + 1];
                array[j + 1] = array[j];
                array[j] = temp;
                j = j - 1;
            }
        }
    }
}

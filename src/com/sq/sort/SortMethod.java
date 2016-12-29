package com.sq.sort; // Created by SquorpikkoR on 28.12.2016.

public abstract class SortMethod {
    void sort(int[] mas) {
    }

    void swap (int first, int second) {
        int tmp = first;
        first = second;
        second = tmp;
    }
}

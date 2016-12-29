package com.sq.sort; // Created by SquorpikkoR on 28.12.2016.

public class SortToCheck extends SortMethod {
    @Override
    void sort(int[] mas) {
        mas[0] = 777;
        swap(mas[1], mas[2]);
    }
}

package com.sq._java_basic_course.symmetricDifference; // Created by SquorpikkoR on 26.01.2017.

////////////////////////ВСЯ МОЩЬ ДЖЕНЕРИКОВ!!!!!!!!!!!!!!!!!!

/*
Реализуйте метод, вычисляющий симметрическую разность двух множеств.
Метод должен возвращать результат в виде нового множества.
Изменять переданные в него множества не допускается.
Пример
Симметрическая разность множеств {1, 2, 3} и {0, 1, 2} равна {0, 3}.
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main{
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,7,5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(2,3,4));
        Set<Integer> set3 = symmetricDifference(set1, set2);
        for (int i : set3) {
            System.out.print(i + " ");
        }

        System.out.println();

        Set<String> set4 = new HashSet<>(Arrays.asList("e", "w", "a"));
        Set<String> set5 = new HashSet<>(Arrays.asList("r", "w", "f", "u"));
        Set<String> set6 = symmetricDifference(set4, set5);
        for (String s : set6) {
            System.out.print(s + " ");
        }
    }

    private static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> newSet = new HashSet<>();
        newSet.addAll(set1);
        for (T item : set2) {
            if (newSet.contains(item))
                newSet.remove(item);
            else newSet.add(item);
        }
        return newSet;
    }
}

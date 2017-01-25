package com.sq.java_rush; // Created by SquorpikkoR on 21.01.2017.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Srednee
{
    public static void main(String[] args)   throws Exception
    {
        //Универсальный алгоритм для любого кол-ва чисел
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = 3;// По-правильному значение n должно задаваться через BufferedReader, но так прога не пройдет тест на javaRush

        for (int i = 0; i < 3; i++)
        {
            list.add(Integer.parseInt(reader.readLine()));
        }
        Collections.sort(list);

        System.out.println(list.get(n/2));
    }
}


package com.sq.stepik_org.les04; // Created by SquorpikkoR on 08.01.2017.

/////////////НЕ ПРОХОДИТ ТЕСТ

//region TASK DESCRIPTION
        /*непрерывный рюкзак


        Первая строка содержит количество предметов 1≤n≤103
        и вместимость рюкзака 0≤W≤2⋅10_6. Каждая из следующих n строк задаёт стоимость 0≤ci≤2⋅10_6
        и объём 0<wi≤2⋅10_6 предмета (n, W, ci, wi — целые числа).
        Выведите максимальную стоимость частей предметов
        (от каждого предмета можно отделить любую часть, стоимость и объём при этом
        пропорционально уменьшатся), помещающихся в данный рюкзак, с точностью
        не менее трёх знаков после запятой.

        Sample Input:
        3 50
        60 20
        100 50
        120 30

        Sample Output:
        180.000*/
        //endregion

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GreedyKnapsack {
    private class Item implements Comparable<Item> {
        int cost;
        int weight;

        Item(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "cost=" + cost +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Item o) {

            return 0;
        }
    }

    double calc() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();      //сколько предметов в файле
        int W = input.nextInt();      //какой вес у рюкзака
        Item[] items = new Item[n];   //получим список предметов
        for (int i = 0; i < n; i++) { //создавая каждый конструктором
            items[i] = new Item(input.nextInt(), input.nextInt());
        }

        double result = 0;

        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return (o1.cost/o1.weight)<(o2.cost/o2.weight)?1:(o1.cost/o1.weight)==(o2.cost/o2.weight)?0:-1;
            }
        });

        int i = 0;
        int totalWeight = 0;

        while (i<items.length) {

            if (totalWeight + items[i].weight > W) {
                double delta = (W - totalWeight);
                result += (double)items[i].cost / (double)items[i].weight * delta;
                i=items.length;
            } else {
                totalWeight += items[i].weight;
                result += items[i].cost;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        double costFinal=new GreedyKnapsack().calc();
        System.out.printf("%.3f", costFinal);
    }
}

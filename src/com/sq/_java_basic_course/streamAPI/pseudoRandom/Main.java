package com.sq._java_basic_course.streamAPI.pseudoRandom; // Created by SquorpikkoR on 30.01.2017.

/*Напишите метод, возвращающий стрим псевдослучайных целых чисел. Алгоритм генерации чисел следующий:
Берется какое-то начальное неотрицательное число (оно будет передаваться в ваш метод проверяющей системой).
Первый элемент последовательности устанавливается равным этому числу.
Следующие элементы вычисляются по рекуррентной формуле Rn+1=mid((Rn)^2),
где mid — это функция, выделяющая второй, третий и четвертый разряд переданного числа.
Например, mid(123456)=345

Алгоритм, конечно, дурацкий и не выдерживающий никакой критики, но для практики работы со стримами сойдет :)
Пример
pseudoRandomStream(13) должен вернуть стрим, состоящий из следующих чисел:
13, 16, 25, 62, 384, 745, 502, 200, 0, ... (дальше бесконечное количество нулей)*/

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        pseudoRandomStream(13).forEach(System.out::println);
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> mid(n));
                //.limit(10); // your implementation here
    }

    public static int mid(int i) {
        return (i*i)/10%1000;

    }
    /*public static int mid(int i) {
        String s = String.valueOf(i);
        //System.out.println(s);
        char a;
        char b;
        char c;
        String res = "";
        if (s.length() >= 2) {
            a = s.charAt(1);
            res+=a;
        }
        if (s.length() >= 3) {
            b = s.charAt(2);
            res+=b;
        }
        if (s.length() >= 4) {
            c = s.charAt(3);
            res+=c;
        }
        if(s.length()<2)res = "0";
        int k = Integer.parseInt(res);

        return k*k;
    }*/
}

















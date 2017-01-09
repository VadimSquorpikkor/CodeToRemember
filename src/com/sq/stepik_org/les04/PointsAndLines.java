package com.sq.stepik_org.les04; // Created by SquorpikkoR on 07.01.2017.

import java.util.*;

/////////////НЕ ПРОХОДИТ ТЕСТ

//region TASK_DESCRIPTION
        /*По данным n отрезкам необходимо найти множество точек минимального размера,
        для которого каждый из отрезков содержит хотя бы одну из точек.
        В первой строке дано число 1≤n≤100 отрезков. Каждая из последующих n строк
        содержит по два числа 0≤l≤r≤10_9, задающих начало и конец отрезка.
        Выведите оптимальное число m точек и сами m
        точек. Если таких множеств точек несколько, выведите любое из них.

        Sample Input 1:
        3
        1 3
        2 5
        3 6

        Sample Output 1:
        1
        3

        Sample Input 2:
        4
        4 7
        1 3
        2 5
        5 6

        Sample Output 2:
        2
        3 6*/
        //endregion

public class PointsAndLines{

    static class Event  implements Comparable<Event>{
        int start;
        int stop;

        Event (int start, int stop) {
            this.start = start;
            this.stop = stop;
        }

        @Override
        public int compareTo(Event e) {
            return Integer.compare(start, e.start);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Event> eventList = new ArrayList<>(n);//создаю лист отрезков кол-вом n и сразу же с параметрами
        for (int i = 0; i < n; i++) {
            eventList.add(new Event(scanner.nextInt(), scanner.nextInt()));
        }
        Collections.sort(eventList);
        /*for (Event e : eventList) {//для проверки сортировки
            System.out.println(e.start + " " + e.stop);
        }*/
        //eventList.get(0).stop
        int k=0;//перебираем отрезки
        int i=1;//
        int pointCount = 0;
        int[] pointList = new int[n];
        int point;
        int a;
        while (k<n) {
            a = eventList.get(k).stop;
            //while ((i+k<n)&&(eventList.get(k).stop >= eventList.get(k + i).start)) {
            while ((i+k<n)&&(a >= eventList.get(k + i).start)) {
                if (eventList.get(k).stop > eventList.get(k + i).stop) {
                    a = eventList.get(k+i).stop;
                }
                i++;
            }
            //point = eventList.get(k).stop;//не видит случаев когда к-ый отрезок заканчивается ПОЗЖЕ к+i -го
            //point = eventList.get(k+i-1).start;
            point = a;
            pointList[pointCount] = point;
            pointCount++;
            k = k + i;
            i = 1;
        }
        System.out.println(pointCount);
        for (int j = 0; j < pointCount; j++) {
            System.out.print(pointList[j] + " ");
        }
    }
}



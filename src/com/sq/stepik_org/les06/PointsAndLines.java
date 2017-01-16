package com.sq.stepik_org.les06; // Created by SquorpikkoR on 15.01.2017.


///////////Не работает с отрицательными числами

// Created by SquorpikkoR on 19.12.2016.

/*      точки и отрезки

        В первой строке задано два целых числа 1≤n≤50000 и 1≤m≤50000 —
        количество отрезков и точек на прямой, соответственно. Следующие
        n строк содержат по два целых числа ai и bi (ai≤bi) — координаты
        концов отрезков. Последняя строка содержит m целых чисел — координаты
        точек. Все координаты не превышают 10_8 по модулю. Точка считается
        принадлежащей отрезку, если она находится внутри него или на границе.
        Для каждой точки в порядке появления во вводе выведите, скольким
        отрезкам она принадлежит.

        Sample Input:
        2 3
        0 5
        7 10
        1 6 11

        Sample Output:
        1 0 0*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class PointsAndLines {

    private int biggestEnd = 0;
    private Segment[] segments;
    private int[] pointArray;

    private void initializeFromInput() throws FileNotFoundException {
        //Scanner scanner = new Scanner(System.in);
        String file = "src/com/sq/stepik_org/les06/point_data.txt";
        InputStream stream = new FileInputStream(file);
        Scanner scanner = new Scanner(stream);

        int lineCount = scanner.nextInt();
        int pointCount = scanner.nextInt();

        segments = new Segment[lineCount];
        for (int i = 0; i < lineCount; i++) {
            segments[i] = new Segment(scanner.nextInt(), scanner.nextInt());
            if (segments[i].getStop() > biggestEnd) {
                biggestEnd = segments[i].getStop();
            }
        }
        biggestEnd++;

        pointArray = new int[pointCount];
        for (int i = 0; i < pointCount; i++) {
            pointArray[i] = scanner.nextInt();
            if (pointArray[i] >= biggestEnd) {
                biggestEnd = pointArray[i]+1;
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        PointsAndLines m = new PointsAndLines();
        m.initializeFromInput();
        int[] result = m.pointSummator(m.pointArray, m.arrayToPutSegmentsIn(m.segments));
        for (int i = 0; i < m.pointArray.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private int[] arrayToPutSegmentsIn(Segment[] segments) {//Все сегменты без сортировки в одну "стопку"
        int[] array = new int[biggestEnd];
        for (Segment segment : segments) {
            for (int i = segment.getStart(); i <= segment.getStop() ; i++) {
                array[i]++;
            }
        }
        return array;
    }

    private int[] pointSummator(int[] points, int[] array) {//Здесь просто возврашаю значение "стопки" по индексу
        int[] result = new int[points.length];       //равному "времени" точки
        for (int i = 0; i < points.length; i++) {
            result[i] = array[points[i]];
        }
        return result;
    }
}

class Segment {
    private int start;
    private int stop;

    Segment(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }

    int getStart() {
        return start;
    }

    int getStop() {
        return stop;
    }
}


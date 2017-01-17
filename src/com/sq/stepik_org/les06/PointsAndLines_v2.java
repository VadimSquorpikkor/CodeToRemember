package com.sq.stepik_org.les06; // Created by SquorpikkoR on 15.01.2017.

////////Улучшенный вариант первой версии -- массив заменен на HashMap,
//////// в key которого можно записывать отрицательные, убрана зависимость
//////// длины массива arrayToPutSegmentIn от длины массива точек -- если
//////// нужного кея не находит, то возвращает 0.
////////Не проходит проверку по времени

//region TASK
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
//endregion

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PointsAndLines_v2 {

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
        }

        pointArray = new int[pointCount];
        for (int i = 0; i < pointCount; i++) {
            pointArray[i] = scanner.nextInt();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        PointsAndLines_v2 m = new PointsAndLines_v2();
        m.initializeFromInput();
      int[] result = m.pointSummator(m.pointArray, m.arrayToPutSegmentsIn(m.segments));
        for (int i = 0; i < m.pointArray.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        long finish = System.currentTimeMillis();
        System.out.println(finish - start + " ms");
    }

    private Map<Integer, Integer> arrayToPutSegmentsIn(Segment[] segmArray) {
        Map<Integer, Integer> arrayList = new HashMap<>();
        for (Segment segment : segmArray) {
            for (int i = segment.getStart(); i <= segment.getStop() ; i++) {
                if (arrayList.containsKey(i)) {
                    arrayList.put(i, arrayList.get(i) + 1);
                } else {
                    arrayList.put(i, 1);
                }
            }

        }
        return arrayList;
    }

    private int[] pointSummator(int[] points, Map<Integer, Integer> array) {//Здесь просто возврашаю значение "стопки" по индексу
        int[] result = new int[points.length];       //равному "времени" точки
        for (int i = 0; i < points.length; i++) {
            if (array.containsKey(points[i])) {
                result[i] = array.get(points[i]);
            } else {
                result[i] = 0;
            }
        }
        return result;
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


}




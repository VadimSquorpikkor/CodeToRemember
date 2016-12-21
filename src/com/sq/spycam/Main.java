package com.sq.spycam;

 // Created by SquorpikkoR on 19.12.2016.

public class Main {
    public static void main(String[] args) {
        Segment[] segments = new Segment[3];
            segments[0] = new Segment(2,3);//потом сделать под Scanner
            segments[1] = new Segment(0,5);
            segments[2] = new Segment(7,10);

            int[] points = {1,6,11};

            Main m = new Main();
            int[] result = m.pointSummator(points, m.arrayToPutSegmentsIn(segments));
        for (int i = 0; i < points.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    int[] arrayToPutSegmentsIn(Segment[] segments) {//Все сегменты без сортировки в одну "стопку"
        int[] array = {0,0,0,0,0,0,0,0,0,0,0,0};//потом добавить длину по
        //length, и через foreach
        //заполнение 0-ми
        for (Segment segment : segments) {
            for (int i = segment.getStart(); i <= segment.getStop() ; i++) {
                array[i]++;
            }
        }
        return array;
    }

    int[] pointSummator(int[] points, int[] array) {//Здесь просто возврашаю значение "стопки" по индексу
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

    public Segment(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }

    public int getStart() {
        return start;
    }

    public int getStop() {
        return stop;
    }
}


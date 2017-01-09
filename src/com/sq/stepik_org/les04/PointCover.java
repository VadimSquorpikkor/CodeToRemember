package com.sq.stepik_org.les04; // Created by SquorpikkoR on 07.01.2017.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PointCover {

        double start;
        double end;
        int count;

        public static void main(String[] args) {
            PointCover instance=new PointCover();
            double[] events=new double[]{1, 1.1, 1.6, 2.2, 2.4, 2.7, 3.9, 8.1, 9.1, 5.5, 3.7};
            List<Double> starts=instance.calcStartTimes(events,1); //рассчитаем моменты старта, с длинной сеанса 1
            System.out.println(starts);                            //покажем моменты старта
        }
        List<Double> calcStartTimes(double[] events, double workDuration){
            List<Double> result;
            result = new ArrayList<>();
            int i=0;
            Arrays.sort(events);

            start = events[0];
            end=start+1;
            count = 1;
            printStep();
            result.add(start);

            for (double d : events) {
                if (d > end) {
                    start=d;
                    end=start+1;
                    count++;
                    printStep();
                    result.add(start);
                }
            }

            return result;                        //вернем итог
        }

        void printStep() {
            System.out.println("step" + count + ": start - " + start + " ,end - " + (start+1));
        }
    }



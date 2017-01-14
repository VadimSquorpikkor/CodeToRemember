package com.sq.stepik_org.les06; // Created by SquorpikkoR on 13.01.2017.

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class MergeSort {

    static int count = 0;
    static int n = 0;

    int[] getMergeSort() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        //размер массива
        n = scanner.nextInt();
        //сам массива
        int[] a=new int[n];
        for (int i = 1; i <= n; i++) {
            a[i-1] = scanner.nextInt();
        }
        return mergeSort(a, 0, a.length-1);
    }

    int[] merge(int[] a, int start, int middle, int end) {
        //int count = 0;
        int endOfA = middle;
        int[] temp = new int[end - start + 1];//[end - start+1]

        for (int k = start; k<=end; k++) {
            if (middle>end||(start<endOfA)&&a[start] <= a[middle]) {
                temp[k] = a[start];
                start++;

            } else {
                temp[k] = a[middle];
                middle++;
                //count++;
            }
        }
        return temp;
    }

    int[] mergeSort(int[] a, int start, int end) {
        if (end - start <= 1) {
            return a;
        }
        int middle = (start + end) / 2;
            /*if ((end-middle <= 1)&&(middle-start <= 1)) {//middle???
                return a;
            }*/
        mergeSort(a, start, middle);
        mergeSort(a, middle+1, end);

        a = merge(a, start, middle+1, end);
        return a;
    }



    public static void main(String[] args) throws FileNotFoundException {
        //int count = 0;
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "com/sq/stepik_org/les06/dataMerge.txt");
        MergeSort instance = new MergeSort();
        //long startTime = System.currentTimeMillis();
        int[] result=instance.getMergeSort();
        //long finishTime = System.currentTimeMillis();
        for (int index:result){
            System.out.print(index + " ");
        }
        System.out.println();
        System.out.println(count);
    }


}


package com.sq.merge_sort;

/**
 * Created by SquorpikkoR on 18.12.2016.
 */
public class Sort {
    public static void main(String[] args) {
        int[] a = {4,5,1,2,3};
        Sort s = new Sort();
        for(int i:s.mergeSort(a, 0 , 4)){
            System.out.println(i);
        }
        /*for(int i:s.merge(a,0,2,4)){
            System.out.println(i);
        }*/
        //System.out.println(s.merge(a, 0,2,4));
    }

    int[] merge(int[] a, int start, int middle, int end) {
        int endOfA = middle;
        int[] temp = new int[end - start+1];//[end - start+1]

        for (int k = start; k<=end; k++) {
            if (middle>end||(start<endOfA)&&a[start] <= a[middle]) {//((a[start] <= a[middle] && start<=endOfA) || middle>=end)
                temp[k] = a[start];
                start++;
            } else {
                temp[k] = a[middle];
                middle++;
            }
        }
        /*for (int num : a) {
            a[num] = temp[num];
        }*/
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
}

package com.sq.stepik_org.les06; // Created by SquorpikkoR on 17.01.2017.

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class CountSort_v2 {
    public static void main(String[] args) throws FileNotFoundException {
        String file = "src/com/sq/stepik_org/les06/csort_data.txt";
        InputStream stream = new FileInputStream(file);
        Scanner scanner = new Scanner(stream);
        /////Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int M = 11;
        int[] B = new int[M];
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
            B[A[i]]++;
        }

        for (int i = 1; i < M; i++) {
            B[i] = B[i] + B[i - 1];
        }

        int[] C = new int[n];

        for (int j = n-1; j >= 0; j--) {
            C[B[A[j]]-1] = A[j];
            B[A[j]] = B[A[j]] - 1;
        }

        for (int num : C) {
            System.out.print(num + " ");
        }
    }

}

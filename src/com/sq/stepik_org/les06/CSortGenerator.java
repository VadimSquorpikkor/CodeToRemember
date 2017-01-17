package com.sq.stepik_org.les06; // Created by SquorpikkoR on 17.01.2017.

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class CSortGenerator {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("src/com/sq/stepik_org/les06/csort_data.txt");
        int n = 10;
        writer.println(n);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            writer.print((random.nextInt(9)+1) + " ");
        }
        writer.close();
        System.out.println("Ok");

    }
}
